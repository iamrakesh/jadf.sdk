package in.rakesh.autodesk.client.derivative.impl;

import in.rakesh.autodesk.client.*;
import in.rakesh.autodesk.client.derivative.*;
import in.rakesh.autodesk.client.derivative.bubble.*;
import in.rakesh.autodesk.client.io.*;
import in.rakesh.autodesk.client.json.*;
import in.rakesh.autodesk.client.rest.*;
import in.rakesh.autodesk.client.rest.auth.*;
import in.rakesh.autodesk.client.rest.entity.impl.*;
import in.rakesh.autodesk.client.rest.model.*;
import in.rakesh.autodesk.client.rest.request.*;
import in.rakesh.autodesk.client.rest.request.impl.*;
import in.rakesh.autodesk.model.*;
import in.rakesh.autodesk.model.bubble.*;
import in.rakesh.autodesk.model.bubble.impl.*;
import in.rakesh.autodesk.model.bucket.*;
import in.rakesh.autodesk.model.conversion.*;
import in.rakesh.autodesk.model.conversion.impl.*;
import in.rakesh.autodesk.model.derivative.*;
import in.rakesh.autodesk.model.derivative.impl.*;
import in.rakesh.autodesk.model.manifest.*;
import in.rakesh.autodesk.model.manifest.impl.*;

import org.slf4j.*;

import javax.ws.rs.core.Response.Status;

import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * Client implementation to perform operations related to AutoDesk Forge derivatives.
 */
public class AdfDerivativesClient extends AdfAbstractClient implements IAdfDerivativesClient
{
  //~ Static Variables & Initializers --------------------------------------------------------------

  private static final String UPLOAD_URI = "/oss/v2/buckets/{bucketKey}/objects/{objectName}";

  private static final String GET_MANIFEST_URI = "/modelderivative/v2/designdata/{urn}/manifest";
  private static final String DERIVATIVE_SERVICE_GET_MANIFEST_URI = "/derivativeservice/v2/manifest/{urn}";

  private static final String CONVERT_JOB_URI = "/modelderivative/v2/designdata/job";

  private static final String DELETE_MANIFEST_URI = "/modelderivative/v2/designdata/{urn}/manifest";

  private static final String GET_DERIVATIVES_URI = "/derivativeservice/v2/derivatives/{urn}";

  private static final Logger LOG = LoggerFactory.getLogger(AdfDerivativesClient.class);

  private static final String GET_THUMBNAIL_URI = "/derivativeservice/v2/thumbnails/{urn}";

  //~ Instance Variables ---------------------------------------------------------------------------

  private final IFileSystem fileSystem;
  private final IJsonSerializer jsonSerializer;

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new AdfDerivativesClient object.
   *
   * @param aRestClient     {@link IAdfRestClient} client to make REST calls
   * @param aFileSystem     {@link IFileSystem} file system implementation to perform file IO
   * @param aJsonSerializer {@link IJsonSerializer} JSON serializer implementation
   */
  public AdfDerivativesClient(IAdfRestClient aRestClient, IFileSystem aFileSystem, IJsonSerializer aJsonSerializer)
  {
    super(aRestClient);

    this.fileSystem = aFileSystem;
    this.jsonSerializer = aJsonSerializer;
  }

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public IAdfJobStatusInfo convertSVF(String aUrn, boolean aXAdsForce) throws AdfRestException
  {
    IAdfRestClient restClient = this.getRestClient();
    if (!restClient.hasSession())
    {
      throw new AdfAuthorizationException(NO_SESSION_ERROR_MESSAGE);
    }

    if (LOG.isDebugEnabled())
    {
      LOG.debug("Requesting 'conversion to SVF' for the object identified by URN - " + aUrn);
    }
    String encodedUrn = Base64.getEncoder().encodeToString(aUrn.getBytes());

    AdfConvertJobInput input = new AdfConvertJobInput();
    input.setUrn(encodedUrn);

    AdfConvertJobFormat format = new AdfConvertJobFormat();
    format.setType(FileType.SVF);
    format.addView(ViewType._3D);

    AdfConvertJobOutput output = new AdfConvertJobOutput();
    output.addFormat(format);

    AdfConvertJob convertJob = new AdfConvertJob();
    convertJob.setInput(input);
    convertJob.setOutput(output);

    AdfRequestBody<AdfConvertJob> body = new AdfRequestBody<>();
    body.setData(convertJob);

    AdfRestRequest<AdfConvertJob> request = new AdfRestRequest<>();
    request.setBody(body);

    request.addHeader(new NameValue<String>("x-ads-force", String.valueOf(aXAdsForce)));
    request.addHeader(CONTENT_TYPE_JSON_HEADER);
    request.addHeader(ACCEPT_JSON_HEADER);

    IAdfRestResponse<AdfJobStatusInfo> adfResponse = restClient.post(CONVERT_JOB_URI, request, AdfJobStatusInfo.class);

    Status responseStatus = adfResponse.getStatus();
    if (responseStatus == Status.OK)
    {
      if (LOG.isDebugEnabled())
      {
        LOG.debug("Conversion to SVF request succeeded for the object identified by URN - " + aUrn);
      }
      return adfResponse.getData();
    }

    if (LOG.isDebugEnabled())
    {
      LOG.debug("Convert to SVF API call failed for the object identified by URN - " + aUrn + "\n" + adfResponse);
    }
    throw new AdfRestException("Convert to SVF api call failed - " + adfResponse, adfResponse);
  }


  /**
   * {@inheritDoc}
   */
  @Override public IAdfJobStatusInfo deleteManifest(String aUrn) throws AdfRestException
  {
    IAdfRestClient restClient = this.getRestClient();
    if (!restClient.hasSession())
    {
      throw new AdfAuthorizationException(NO_SESSION_ERROR_MESSAGE);
    }

    if (LOG.isDebugEnabled())
    {
      LOG.debug("Requesting 'delete manifest' for the URN - " + aUrn);
    }
    String encodedUrn = encode(aUrn);
    String deleteManifestUri = DELETE_MANIFEST_URI.replace("{urn}", encodedUrn);

    AdfRestRequest<Void> request = new AdfRestRequest<>();

    request.addHeader(CONTENT_TYPE_FORM_HEADER);
    request.addHeader(ACCEPT_JSON_HEADER);

    IAdfRestResponse<AdfJobStatusInfo> adfResponse = restClient.post(deleteManifestUri, request, AdfJobStatusInfo.class);

    Status responseStatus = adfResponse.getStatus();
    if (responseStatus == Status.OK)
    {
      if (LOG.isDebugEnabled())
      {
        LOG.debug("Delete manifest request successeeded for the URN - " + aUrn);
      }
      return adfResponse.getData();
    }

    if (LOG.isDebugEnabled())
    {
      LOG.debug("Delete manifest request failed for the URN - " + aUrn + "\n" + adfResponse);
    }
    throw new AdfRestException("Delete manifest api call failed - " + adfResponse);
  }


  /**
   * {@inheritDoc}
   */
  @Override public InputStream downloadDerivative(String aUrn) throws AdfRestException
  {
    IAdfRestClient restClient = this.getRestClient();
    if (!restClient.hasSession())
    {
      throw new AdfAuthorizationException(NO_SESSION_ERROR_MESSAGE);
    }

    if (LOG.isTraceEnabled())
    {
      LOG.trace("Downloading derivative for the URN - " + aUrn);
    }
    String encodedUrn = encode(aUrn);
    String manifestUri = GET_DERIVATIVES_URI.replace("{urn}", encodedUrn);

    AdfRestRequest<Void> request = new AdfRestRequest<>();
    request.addHeader(CONTENT_ENCODING);

    IAdfRestResponse<InputStream> adfResponse = restClient.get(manifestUri, request, InputStream.class);

    Status responseStatus = adfResponse.getStatus();
    if (responseStatus == Status.OK)
    {
      if (LOG.isTraceEnabled())
      {
        LOG.trace("Download derivative succeeded for the URN - " + aUrn);
      }
      return adfResponse.getData();
    }

    if (LOG.isDebugEnabled())
    {
      LOG.debug("Failed to download derivative for the URN - " + aUrn + "\n" + adfResponse);
    }
    throw new AdfRestException("REST call to get manifest info failed - " + adfResponse);
  }


  /**
   * {@inheritDoc}
   */
  @Override public CompletableFuture<List<IAdfFileDownloadStatus>> downloadSVF(String aUrn, String aToDir) throws AdfRestException
  {
    if (LOG.isDebugEnabled())
    {
      LOG.debug("Downloading manifest for URN - " + aUrn);
    }
    IAdfBubbleNode manifest = this.getBubbleManifest(aUrn);

    return this.downloadSVF(aUrn, manifest, aToDir);
  }


  /**
   * {@inheritDoc}
   */
  public CompletableFuture<List<IAdfFileDownloadStatus>> downloadSVF(String aUrn, IAdfBubbleNode aManifest, String aToDir)
  {
    assert aManifest != null : "Give manifest to download ADF bubble cannot be NULL.";

    return new AdfBubbleContext(this).download(aUrn, aManifest, aToDir);
  }


  /**
   * {@inheritDoc}
   */
  @Override public InputStream downloadThumbnail(String aUrn, String aGuid) throws AdfRestException
  {
    IAdfRestClient restClient = this.getRestClient();
    if (!restClient.hasSession())
    {
      throw new AdfAuthorizationException(NO_SESSION_ERROR_MESSAGE);
    }

    if (LOG.isTraceEnabled())
    {
      LOG.trace("Downloading thumbnail for the URN - " + aUrn);
    }
    String encodedUrn = encode(aUrn);
    String manifestUri = GET_THUMBNAIL_URI.replace("{urn}", encodedUrn);
    manifestUri += "?width=400&height=400&role=rendered";
    if (aGuid != null)
    {
      manifestUri += "&guid=" + aGuid;
    }

    AdfRestRequest<Void> request = new AdfRestRequest<>();
    request.addHeader(ACCEPT_OCTET_STREAM_HEADER);

    IAdfRestResponse<InputStream> adfResponse = restClient.get(manifestUri, request, InputStream.class);

    Status responseStatus = adfResponse.getStatus();
    if (responseStatus == Status.OK)
    {
      if (LOG.isTraceEnabled())
      {
        LOG.trace("Download thumbnail succeeded for the URN - " + aUrn);
      }
      return adfResponse.getData();
    }

    if (LOG.isDebugEnabled())
    {
      LOG.debug("Failed to download thumbnail for the URN - " + aUrn + "\n" + adfResponse);
    }
    throw new AdfRestException("REST call to download thumbnail failed - " + adfResponse);
  }


  /**
   * {@inheritDoc}
   */
  public IAdfBubbleNode getBubbleManifest(String aUrn) throws AdfRestException
  {
    return doGetManifest(DERIVATIVE_SERVICE_GET_MANIFEST_URI, aUrn, AdfBubbleNode.class);
  }


  /**
   * {@inheritDoc}
   */
  public final IFileSystem getFileSystem()
  {
    return fileSystem;
  }


  /**
   * {@inheritDoc}
   */
  @Override public final IJsonSerializer getJsonSerializer()
  {
    return this.jsonSerializer;
  }


  /**
   * {@inheritDoc}
   */
  @Override public IAdfManifest getManifest(String aUrn) throws AdfRestException
  {
    return this.doGetManifest(GET_MANIFEST_URI, aUrn, AdfManifest.class);
  }


  /**
   * {@inheritDoc}
   */
  @Override public IAdfObjectInfo upload(IFileData aFileData, IAdfBaseBucket aBucketInfo) throws AdfRestException
  {
    IAdfRestClient restClient = this.getRestClient();
    if (!restClient.hasSession())
    {
      throw new AdfAuthorizationException("No session, need authenticated session to upload file.");
    }

    if (aFileData.getLength() <= 0)
    {
      throw new IllegalArgumentException("Given file for upload is empty/invalid.");
    }

    if (LOG.isDebugEnabled())
    {
      LOG.debug("Uploading file " + aFileData + " into bucket - " + aBucketInfo.getBucketKey());
    }
    String bucketKey = encode(aBucketInfo.getBucketKey());
    String objectName = encode(aBucketInfo.getObjectName());

    String uploadUri = UPLOAD_URI.replace("{bucketKey}", bucketKey) //
                                 .replace("{objectName}", objectName);

    AdfRestRequest<IFileData> request = new AdfRestRequest<>();

    request.addHeader(CONTENT_TYPE_OCTET_STREAM_HEADER);
    request.addHeader(ACCEPT_JSON_HEADER);

    AdfRequestBody<IFileData> body = new AdfRequestBody<>();
    body.setData(aFileData);

    request.setEntityBuilder(new AdfStreamEntityBuilder());
    request.setBody(body);

    IAdfRestResponse<AdfObjectInfo> adfResponse = restClient.put(uploadUri, request, AdfObjectInfo.class);

    Status responseStatus = adfResponse.getStatus();
    if (responseStatus == Status.OK)
    {
      if (LOG.isDebugEnabled())
      {
        LOG.debug("Successfully uploaded file " + aFileData + " into bucket - " + aBucketInfo.getBucketKey());
      }
      return adfResponse.getData();
    }

    if (LOG.isDebugEnabled())
    {
      LOG.debug("Failed to upload file " + aFileData + " into bucket - " + aBucketInfo.getBucketKey() + "\n" + adfResponse);
    }
    throw new AdfRestException("Failed to upload file to autodesk develeoper api server - " + adfResponse);
  }


  /**
   * method to encode given value to be URL safe.
   *
   * @param  aValue Value to encode
   *
   * @return encoded URL safe value
   *
   * @throws IllegalArgumentException When encoding fails
   */
  private static String encode(String aValue)
  {
    try
    {
      return URLEncoder.encode(aValue, StandardCharsets.UTF_8.name());
    }
    catch (UnsupportedEncodingException e)
    {
      throw new IllegalArgumentException("Given value is not URL safe.", e);
    }
  }


  /**
   * DOCUMENT ME!
   *
   * @param  aUri   DOCUMENT ME!
   * @param  aUrn   DOCUMENT ME!
   * @param  aClass DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   *
   * @throws AdfRestException          DOCUMENT ME!
   * @throws AdfAuthorizationException DOCUMENT ME!
   */
  private <T> T doGetManifest(String aUri, String aUrn, Class<T> aClass) throws AdfRestException
  {
    IAdfRestClient restClient = this.getRestClient();
    if (!restClient.hasSession())
    {
      throw new AdfAuthorizationException(NO_SESSION_ERROR_MESSAGE);
    }

    if (LOG.isDebugEnabled())
    {
      LOG.debug("Requesting manifest for the URN - " + aUrn);
    }
    String encodedUrn = encode(aUrn);
    String manifestUri = aUri.replace("{urn}", encodedUrn);

    AdfRestRequest<Void> request = new AdfRestRequest<>();
    request.addHeader(ACCEPT_JSON_HEADER);

    IAdfRestResponse<T> adfResponse = restClient.get(manifestUri, request, aClass);

    Status responseStatus = adfResponse.getStatus();
    if (responseStatus == Status.OK)
    {
      if (LOG.isDebugEnabled())
      {
        LOG.debug("Get manifest succeeded for the URN - " + aUrn);
      }
      return adfResponse.getData();
    }

    if (LOG.isDebugEnabled())
    {
      LOG.debug("Get manifest failed for the URN - " + aUrn + "\n" + adfResponse);
    }
    throw new AdfRestException("REST call to get manifest info failed - " + adfResponse);
  }
}
