package in.iamrakesh.autodesk.client.impl;

import in.iamrakesh.autodesk.client.*;
import in.iamrakesh.autodesk.client.bucket.*;
import in.iamrakesh.autodesk.client.derivative.*;
import in.iamrakesh.autodesk.client.factory.*;
import in.iamrakesh.autodesk.client.io.*;
import in.iamrakesh.autodesk.client.json.*;
import in.iamrakesh.autodesk.client.rest.*;
import in.iamrakesh.autodesk.model.auth.*;
import in.iamrakesh.autodesk.model.bubble.*;
import in.iamrakesh.autodesk.model.bucket.*;
import in.iamrakesh.autodesk.model.conversion.*;
import in.iamrakesh.autodesk.model.derivative.*;
import in.iamrakesh.autodesk.model.manifest.*;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * Context implementation which allows AutoDesk Forge API calls. One can extend this class and
 * customize default implementation if needed.
 */
public class AdfContext implements IAdfContext
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private IAdfBucketClient bucketClient;

  private final IAdfConfig config;
  private final IAdfCredentials credentials;

  private IAdfDerivativesClient derivativesClient;

  private IAdfRestClient restClient;

  private IFileSystem fileSystem;

  private IJsonSerializer jsonSerializer;

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new AdfContext object.
   *
   * @param aConfig {@link IAdfConfig} configuration
   */
  public AdfContext(IAdfConfig aConfig)
  {
    this.config = aConfig;
    this.credentials = new AdfCredentials(aConfig.getClientId(), aConfig.getClientSecret(), aConfig.getScopes());
  }

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * factory method which creates and authenticates {@link IAdfContext}, before returning it. This
   * context instance can then be used to make Autodesk forge API calls.
   *
   * @param  aConfig {@code IAdfConfig} configuration
   *
   * @return {@link IAdfContext} context object with valid session
   *
   * @throws AdfRestException when authentication fails
   */
  public static IAdfContext create(IAdfConfig aConfig) throws AdfRestException
  {
    IAdfContext context = new AdfContext(aConfig);
    context.authenticate();
    return context;
  }


  /**
   * {@inheritDoc}
   */
  @Override public final IAdfRestSession authenticate() throws AdfRestException
  {
    return this.getRestClient().authenticate(this.credentials);
  }


  /**
   * {@inheritDoc}
   */
  @Override public final IAdfJobStatusInfo convertSVF(String aUrn, boolean aXAdsForce) throws AdfRestException
  {
    return this.getDerivativesClient().convertSVF(aUrn, aXAdsForce);
  }


  /**
   * {@inheritDoc}
   */
  @Override public final IAdfBucket createBucket(IAdfBaseBucket aBucketInfo, String aAdsRegion) throws AdfRestException
  {
    return this.getBucketClient().createBucket(aBucketInfo, aAdsRegion);
  }


  /**
   * {@inheritDoc}
   */
  @Override public final IFileData createFileData(String aFileName)
  {
    return this.getFileSystem().createFileData(aFileName);
  }


  /**
   * {@inheritDoc}
   */
  @Override public final IFileData createFileData(String aFolder, String aFileName)
  {
    return this.getFileSystem().createFileData(aFolder, aFileName);
  }


  /**
   * {@inheritDoc}
   */
  @Override public final void deleteBucket(String aBucketKey) throws AdfRestException
  {
    this.getBucketClient().deleteBucket(aBucketKey);
  }


  /**
   * {@inheritDoc}
   */
  @Override public final IAdfJobStatusInfo deleteManifest(String aUrn) throws AdfRestException
  {
    return this.getDerivativesClient().deleteManifest(aUrn);
  }


  /**
   * {@inheritDoc}
   */
  @Override public final CompletableFuture<List<IAdfFileDownloadStatus>> downloadSVF(String aUrn, String aToDir) throws AdfRestException
  {
    return this.getDerivativesClient().downloadSVF(aUrn, aToDir);
  }


  /**
   * {@inheritDoc}
   */
  @Override public final void downloadSVF(String aUrn, IAdfBubbleNode aManifest, String aToDir)
  {
    this.getDerivativesClient().downloadSVF(aUrn, aManifest, aToDir);
  }


  /**
   * {@inheritDoc}
   */
  @Override public final IAdfRestSession getAdfSession()
  {
    return getRestClient().getAdfSession();
  }


  /**
   * {@inheritDoc}
   */
  @Override public final IAdfManifest getManifest(String aUrn) throws AdfRestException
  {
    return this.getDerivativesClient().getManifest(aUrn);
  }


  /**
   * {@inheritDoc}
   */
  @Override public final long put(InputStream aInputStream, IFileData aData) throws IOException
  {
    return this.getFileSystem().put(aInputStream, aData);
  }


  /**
   * {@inheritDoc}
   */
  @Override public final void remove(String aFolder) throws IOException
  {
    this.getFileSystem().remove(aFolder);
  }


  /**
   * {@inheritDoc}
   */
  @Override public final void remove(String aFolder, String aFileName) throws IOException
  {
    this.getFileSystem().remove(aFolder, aFileName);
  }


  /**
   * {@inheritDoc}
   */
  @Override public final IAdfObjectInfo upload(IFileData aFileData, IAdfBaseBucket aBucketInfo) throws AdfRestException
  {
    return this.getDerivativesClient().upload(aFileData, aBucketInfo);
  }


  /**
   * method returns {@link IAdfBucketClient} implementation which allows API calls related to
   * AutoDesk buckets. Method will create one ({@code IAdfBucketClient}) if its not created already.
   *
   * @return {@code IAdfBucketClient} client object used to make API calls related to AutoDesk
   *         buckets.
   *
   * @see    AdfBucketClientFactory#register(Class)
   */
  protected final IAdfBucketClient getBucketClient()
  {
    if (this.bucketClient == null)
    {
      this.bucketClient = AdfBucketClientFactory.getInstance().create(this.getRestClient());
    }
    return this.bucketClient;
  }


  /**
   * method returns {@link IAdfDerivativesClient} implementation which allows API calls related to
   * AutoDesk derivatives. Method will create one ({@code IAdfDerivativesClient}) if its not created
   * already.
   *
   * @return {@code IAdfDerivativesClient} client object used to make API calls related to AutoDesk
   *         derivatives.
   *
   * @see    AdfDerivativeClientFactory#register(Class)
   */
  protected final IAdfDerivativesClient getDerivativesClient()
  {
    if (this.derivativesClient == null)
    {
      this.derivativesClient = AdfDerivativeClientFactory.getInstance().create(this.getRestClient(), this.getFileSystem());
    }
    return this.derivativesClient;
  }


  /**
   * method returns {@link IFileSystem} implementation which provides abstraction from which type of
   * file system used (local/S3/WebDAV). Method will create one ({@code IFileSystem}) if its not
   * created already.
   *
   * @return {@code IFileSystem} wrapper implementation which abstracts type of file system
   *         (local/S3/WebDAV)
   *
   * @see    AdfFileSystemFactory#register(Class)
   */
  protected final IFileSystem getFileSystem()
  {
    if (this.fileSystem == null)
    {
      this.fileSystem = AdfFileSystemFactory.getInstance().create(this.config);
    }
    return this.fileSystem;
  }


  /**
   * method returns {@link IJsonSerializer} implementation instance which allows JSON
   * (de)serialization. Method will create one ({@code IJsonSerializer}) if its not created already.
   *
   * @return {@link IJsonSerializer} wrapper implementation which allows JSON (de)serialization.
   *
   * @see    AdfJsonSerializerFactory#register(Class, Class)
   */
  protected final IJsonSerializer getJsonSerializer()
  {
    if (this.jsonSerializer == null)
    {
      this.jsonSerializer = AdfJsonSerializerFactory.getInstance().create();
    }
    return this.jsonSerializer;
  }


  /**
   * method returns {@link IAdfRestClient} implementation instance which allows REST calls. Method
   * will create one ({@code IAdfRestClient}) if its not created already.
   *
   * @return {@link IAdfRestClient} wrapper implementation which allows REST calls.
   */
  protected final IAdfRestClient getRestClient()
  {
    if (this.restClient == null)
    {
      this.restClient = AdfRestClientFactory.getInstance().create(this.config.getBaseUrl());
    }
    return this.restClient;
  }
}
