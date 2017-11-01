package in.rakesh.autodesk.client.bucket.impl;

import in.rakesh.autodesk.client.*;
import in.rakesh.autodesk.client.bucket.*;
import in.rakesh.autodesk.client.rest.*;
import in.rakesh.autodesk.client.rest.auth.*;
import in.rakesh.autodesk.client.rest.model.*;
import in.rakesh.autodesk.client.rest.request.*;
import in.rakesh.autodesk.client.rest.request.impl.*;
import in.rakesh.autodesk.model.bucket.*;
import in.rakesh.autodesk.model.bucket.impl.*;

import org.slf4j.*;

import javax.ws.rs.core.Response.*;

/**
 * Client implementation to perform operations related to AutoDesk Forge buckets.
 */
public class AdfBucketClient extends AdfAbstractClient implements IAdfBucketClient
{
  //~ Static Variables & Initializers --------------------------------------------------------------

  private static final String CREATE_BUCKET_URI = "/oss/v2/buckets";
  private static final String DELETE_BUCKET_URI = CREATE_BUCKET_URI + "/{bucketKey}";

  private static final Logger LOG = LoggerFactory.getLogger(AdfBucketClient.class);

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new AdfBucketClient object.
   *
   * @param aRestClient {@link IAdfRestClient}
   */
  public AdfBucketClient(IAdfRestClient aRestClient)
  {
    super(aRestClient);
  }

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public IAdfBucket createBucket(IAdfBaseBucket aBucketInfo, String aAdsRegion) throws AdfRestException
  {
    IAdfRestClient restClient = this.getRestClient();
    if (!restClient.hasSession())
    {
      throw new AdfAuthorizationException(NO_SESSION_ERROR_MESSAGE);
    }

    if (LOG.isDebugEnabled())
    {
      LOG.debug("Making API call to create bucket with key '" + aBucketInfo.getBucketKey() + "'.");
    }

    AdfRestRequest<IAdfBaseBucket> request = new AdfRestRequest<>();
    request.addHeader(CONTENT_TYPE_JSON_HEADER);
    request.addHeader(ACCEPT_JSON_HEADER);

    AdfRequestBody<IAdfBaseBucket> body = new AdfRequestBody<>();
    body.setData(aBucketInfo);

    request.setBody(body);

    if (aAdsRegion != null)
    {
      request.addHeader(new NameValue<String>("x-ads-region", aAdsRegion));
    }

    IAdfRestResponse<AdfBucket> response = restClient.post(CREATE_BUCKET_URI, request, AdfBucket.class);

    Status responseStatus = response.getStatus();
    if (responseStatus == Status.OK)
    {
      if (LOG.isDebugEnabled())
      {
        LOG.debug("Successfully created bucket with key '" + aBucketInfo.getBucketKey() + "'.");
      }
      return response.getData();
    }

    if (LOG.isDebugEnabled())
    {
      LOG.debug("Failed created bucket with key '" + aBucketInfo.getBucketKey() + "'.\n" + response);
    }
    throw new AdfRestException("Bucket creation api call failed - " + response);
  }


  /**
   * {@inheritDoc}
   */
  public void deleteBucket(String aBucketKey) throws AdfRestException
  {
    assert aBucketKey != null : "Bucket key to delete cannot be NULL.";

    IAdfRestClient restClient = this.getRestClient();
    if (restClient.hasSession())
    {
      throw new AdfAuthorizationException(NO_SESSION_ERROR_MESSAGE);
    }

    if (LOG.isDebugEnabled())
    {
      LOG.debug("Making API call to delete bucket with key '" + aBucketKey + "'.");
    }

    AdfRestRequest<Void> request = new AdfRestRequest<>();
    request.addHeader(ACCEPT_JSON_HEADER);

    String deleteBucketUri = DELETE_BUCKET_URI.replace("{bucketKey}", aBucketKey);

    IAdfRestResponse<String> response = restClient.delete(deleteBucketUri, request, String.class);

    Status responseStatus = response.getStatus();
    if (responseStatus != Status.OK)
    {
      if (LOG.isDebugEnabled())
      {
        LOG.debug("Failed delete bucket with key '" + aBucketKey + "'.\n" + response);
      }

      throw new AdfRestException("Bucket delete api call failed - " + response);
    }

    if (LOG.isDebugEnabled())
    {
      LOG.debug("Successfully deleted bucket with key '" + aBucketKey + "'.");
    }
  }
}
