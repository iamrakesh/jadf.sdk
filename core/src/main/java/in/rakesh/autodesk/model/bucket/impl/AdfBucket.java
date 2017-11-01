package in.rakesh.autodesk.model.bucket.impl;

import in.rakesh.autodesk.model.bucket.*;

/**
 * IAdfBucket
 */
public class AdfBucket extends AdfBaseBucket implements IAdfBucket
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private String bucketOwner;

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public String getBucketOwner()
  {
    return bucketOwner;
  }


  /**
   * DOCUMENT ME!
   *
   * @param bucketOwner the bucketOwner to set
   */
  public void setBucketOwner(String bucketOwner)
  {
    this.bucketOwner = bucketOwner;
  }
}
