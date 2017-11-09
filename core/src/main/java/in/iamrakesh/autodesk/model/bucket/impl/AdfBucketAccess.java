package in.iamrakesh.autodesk.model.bucket.impl;

import in.iamrakesh.autodesk.model.bucket.*;

/**
 * AdfBucketAccess
 */
public class AdfBucketAccess implements IAdfBucketAccess
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private BucketAccessType access;
  private String authId;

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public BucketAccessType getAccess()
  {
    return access;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getAuthId()
  {
    return authId;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aAccess the access to set
   */
  public void setAccess(BucketAccessType aAccess)
  {
    this.access = aAccess;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aAuthId the authId to set
   */
  public void setAuthId(String aAuthId)
  {
    this.authId = aAuthId;
  }
}
