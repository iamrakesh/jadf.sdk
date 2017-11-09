package in.iamrakesh.autodesk.client.bucket;

import in.iamrakesh.autodesk.client.rest.*;
import in.iamrakesh.autodesk.model.bucket.*;

/**
 * Marker interface with methods to perform operations related to AutoDesk Forge buckets.
 */
public interface IAdfBucketClient
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * method to create AutoDesk Forge bucket using the given {@link IAdfBaseBucket} and region
   * information.
   *
   * @param  aBucketInfo Bucket information
   * @param  aAdsRegion  Region of the bucket
   *
   * @return {@link IAdfBucket} information about the created bucket
   *
   * @throws AdfRestException When create bucket API call fails
   */
  public IAdfBucket createBucket(IAdfBaseBucket aBucketInfo, String aAdsRegion) throws AdfRestException;


  /**
   * method to delete AutoDesk Forge bucket identified by the given bucket key.
   *
   * @param  aBucketKey Unique key of the bucket
   *
   * @throws AdfRestException When delete bucket API call fails
   */
  public void deleteBucket(String aBucketKey) throws AdfRestException;
}
