package in.iamrakesh.autodesk.client.derivative;

import in.iamrakesh.autodesk.client.io.*;
import in.iamrakesh.autodesk.client.json.*;
import in.iamrakesh.autodesk.client.rest.*;
import in.iamrakesh.autodesk.model.bubble.*;
import in.iamrakesh.autodesk.model.bucket.*;
import in.iamrakesh.autodesk.model.conversion.*;
import in.iamrakesh.autodesk.model.derivative.*;
import in.iamrakesh.autodesk.model.manifest.*;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * Marker interface with method to perform operation related to AutoDesk Forge derivatives.
 */
public interface IAdfDerivativesClient
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * method to request for 'to SVF' conversion for the given URN
   *
   * @param  aUrn       Manifest Urn
   * @param  aXAdsForce 'x-ads-force' request header value
   *
   * @return {@link IAdfJobStatusInfo} convert to SVF status information
   *
   * @throws AdfRestException When convert to SVF API call fails
   */
  public IAdfJobStatusInfo convertSVF(String aUrn, boolean aXAdsForce) throws AdfRestException;


  /**
   * method to delete manifest for the given URN
   *
   * @param  aUrn Manifest URN
   *
   * @return {@link IAdfJobStatusInfo} delete manifest status information
   *
   * @throws AdfRestException When delete manifest API call fails
   */
  public IAdfJobStatusInfo deleteManifest(String aUrn) throws AdfRestException;


  /**
   * method to download derivative data for the given URN. Returned stream could be (un)compressed
   * bytes based on the derivative that is being requested.
   *
   * @param  aUrn Derivative URN
   *
   * @return {@code InputStream} containing derivative data (bytes, could be compressed based on the
   *         derivative that is being requested)
   *
   * @throws AdfRestException When download derivative API call fails
   */
  public InputStream downloadDerivative(String aUrn) throws AdfRestException;


  /**
   * method to download AutoDesk Forge bubble identified by the given URN and save to the given
   * directory
   *
   * @param  aUrn   Manifest URN
   * @param  aToDir Directory to which bubble needs to be saved
   *
   * @return CompletableFuture future which will complete with list of status' for each file of the
   *         bubble
   *
   * @throws AdfRestException When download bubble API call fails
   */
  public CompletableFuture<List<IAdfFileDownloadStatus>> downloadSVF(String aUrn, String aToDir) throws AdfRestException;


  /**
   * method to download AutoDesk Forge bubble using the given {@link IAdfManifest} information and
   * save to the given directory
   *
   * @param  aUrn      Manifest URN
   * @param  aManifest {@link IAdfBubbleNode} which will be used to download bubble
   * @param  aToDir    Directory to which bubble needs to be saved
   *
   * @return CompletableFuture future which will complete with list of status' for each file of the
   *         bubble
   */
  public CompletableFuture<List<IAdfFileDownloadStatus>> downloadSVF(String aUrn, IAdfBubbleNode aManifest, String aToDir);


  /**
   * method to download thumbnail item identified by given URN.
   *
   * @param  aFleUrn fileUrn URN of the thumbnail item
   * @param  aGuid   derivative GUID
   *
   * @return InputStream representing thumbnail
   *
   * @throws AdfRestException
   */
  public InputStream downloadThumbnail(String aFleUrn, String aGuid) throws AdfRestException;


  /**
   * DOCUMENT ME!
   *
   * @param  aUrn DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   *
   * @throws AdfRestException DOCUMENT ME!
   */
  public IAdfBubbleNode getBubbleManifest(String aUrn) throws AdfRestException;


  /**
   * method returns {@link IFileSystem} that needs to be used to save downloaded bubble to a
   * location.
   *
   * @return {@link IFileSystem}
   */
  public IFileSystem getFileSystem();


  /**
   * method returns {@link IJsonSerializer} which can be used for JSON serialization.
   *
   * @return {@link IJsonSerializer} JSON serializer
   */
  public IJsonSerializer getJsonSerializer();


  /**
   * method to get manifest information for the given URN.
   *
   * @param  aUrn Manifest URN
   *
   * @return {@link IAdfManifest}
   *
   * @throws AdfRestException When get manifest API call fails
   */
  public IAdfManifest getManifest(String aUrn) throws AdfRestException;


  /**
   * method to upload given {@link IFileData}, to the given {@link IAdfBaseBucket} bucket.
   *
   * @param  aFileData   {@link IFileData} file information wrapper object abstracting actual file
   *                     system that is being used.
   * @param  aBucketInfo {@link IAdfBaseBucket} AutoDesk Forge bucket information into which given
   *                     file need to be uploaded.
   *
   * @return {@link IAdfObjectInfo} Uploaded file/object information
   *
   * @throws AdfRestException When upload file API call fails.
   */
  public IAdfObjectInfo upload(IFileData aFileData, IAdfBaseBucket aBucketInfo) throws AdfRestException;
}
