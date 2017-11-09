package in.iamrakesh.autodesk.client;

import in.iamrakesh.autodesk.client.io.*;
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
 * Marker interface for context using which one can make AutoDesk Forge API calls.
 */
public interface IAdfContext
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * method to authenticate with AutoDesk Forge API server, using the given {@link IAdfCredentials}.
   *
   * @return session object {@link IAdfRestSession}
   *
   * @throws AdfRestException When authentication fails
   */
  public IAdfRestSession authenticate() throws AdfRestException;


  /**
   * method to request for conversion for the given URN
   *
   * @param  aUrn       URN for which conversion job need to be created
   * @param  aXAdsForce boolean value for the <i>x-ads-force</i> request header
   *
   * @return conversion job status information {@link IAdfJobStatusInfo}
   *
   * @throws AdfRestException when convert API call fails
   */
  public IAdfJobStatusInfo convertSVF(String aUrn, boolean aXAdsForce) throws AdfRestException;


  /**
   * method to make API call to create bucket using the given {@link IAdfBaseBucket} information.
   *
   * @param  aBucketInfo {@link IAdfBaseBucket} bucket information which needs to be created
   * @param  aAdsRegion  String region to be used for the bucket
   *
   * @return {@link IAdfBucket} bucket information
   *
   * @throws AdfRestException when create bucket API call fails
   */
  public IAdfBucket createBucket(IAdfBaseBucket aBucketInfo, String aAdsRegion) throws AdfRestException;


  /**
   * method to create {@link IFileData}, for the given 'file name', which is a wrapper object
   * abstracting details about actual file system (local/S3/WebDAV)
   *
   * @param  aFileName File name
   *
   * @return {@link IFileData} object containing file information
   */
  public IFileData createFileData(String aFileName);


  /**
   * method to create {@link IFileData}, for the given 'file name' and 'parent folder', which is a
   * wrapper object abstracting details about actual file system (local/S3/WebDAV)
   *
   * @param  aFolder   Parent folder name
   * @param  aFileName File name
   *
   * @return {@link IFileData} object containing file information
   */
  public IFileData createFileData(String aFolder, String aFileName);


  /**
   * method to make API call to delete bucket identified by the given 'bucket key'.
   *
   * @param  aBucketKey String bucket key
   *
   * @throws AdfRestException When delete bucket api call fails
   */
  public void deleteBucket(String aBucketKey) throws AdfRestException;


  /**
   * method to make API call to delete manifest, identified by the given 'manifest URN'.
   *
   * @param  aUrn String manifest URN
   *
   * @return {@link IAdfJobStatusInfo} contains information about delete manifest status
   *
   * @throws AdfRestException When delete manifest api call fails
   */
  public IAdfJobStatusInfo deleteManifest(String aUrn) throws AdfRestException;


  /**
   * method to download complete bubble identified by the given URN and save to the given directory,
   * which can be loaded into viewer.
   *
   * @param  aUrn   String bubble URN
   * @param  aToDir String directory to which bubble needs to be saved
   *
   * @return
   *
   * @throws AdfRestException When download bubble API call fails
   */
  public CompletableFuture<List<IAdfFileDownloadStatus>> downloadSVF(String aUrn, String aToDir) throws AdfRestException;


  /**
   * method to download complete bubble identified by the given URN, represented by {@link
   * IAdfBubbleNode}, and save to the given directory, which can be loaded into viewer.
   *
   * @param aUrn      String bubble URN
   * @param aManifest {@link IAdfBubbleNode} bubble manifest
   * @param aToDir    String directory to which bubble needs to be saved
   */
  public void downloadSVF(String aUrn, IAdfBubbleNode aManifest, String aToDir);


  /**
   * method returns {@link IAdfRestSession}, if one is created already, NULL otherwise.
   *
   * @return {@link IAdfRestSession} AutoDesk Forge REST session, can be NULL
   *
   * @see    IAdfContext#authenticate()
   */
  public IAdfRestSession getAdfSession();


  /**
   * method to request for manifest information identified by the given URN.
   *
   * @param  aUrn String manifest URN
   *
   * @return {@link IAdfManifest} manifest information
   *
   * @throws AdfRestException When get manifest API call fails
   */
  public IAdfManifest getManifest(String aUrn) throws AdfRestException;


  /**
   * method to write bytes provided by given {@code InputStream}, into the given directory/file
   * represented by {@link IFileData}.
   *
   * @param  aInputStream {@link InputStream} which provides bytes to be written to given
   *                      directory/file
   * @param  aData        {@link IFileData} object containing information about target
   *                      directory/file to which given stream need to be written.
   *
   * @return long number of bytes written
   *
   * @throws IOException When save/write operation fails
   */
  public long put(InputStream aInputStream, IFileData aData) throws IOException;


  /**
   * method to remove given folder/directory.
   *
   * @param  aFolder folder/directory to be removed
   *
   * @throws IOException when remove directory fails
   */
  public void remove(String aFolder) throws IOException;


  /**
   * method to remove given file, which is available under given directory.
   *
   * @param  aFolder   Parent directory in which the given file exists
   * @param  aFileName File name which needs to be removed
   *
   * @throws IOException when remove file fails
   */
  public void remove(String aFolder, String aFileName) throws IOException;


  /**
   * method to upload given file represented by {@link IFileData}, to a bucket represented by {@link
   * IAdfBaseBucket}.
   *
   * @param  aFileData   {@link IFileData} file information which needs to be uploaded to the given
   *                     bucket
   * @param  aBucketInfo {@link IAdfBaseBucket} bucket information to which given file need to be
   *                     uploaded
   *
   * @return {@link IAdfObjectInfo} information about the uploaded file.
   *
   * @throws AdfRestException When upload API call fails
   */
  public IAdfObjectInfo upload(IFileData aFileData, IAdfBaseBucket aBucketInfo) throws AdfRestException;
}
