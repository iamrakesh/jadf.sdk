package in.rakesh.autodesk.model.bucket.impl;

import in.rakesh.autodesk.model.bucket.*;

import java.util.*;

/**
 * AdfBaseBucket
 */
public class AdfBaseBucket implements IAdfBaseBucket
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private BucketPolicyType policy;

  private List<IAdfBucketAccess> access;

  private String bucketKey;

  private String objectName;

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new AdfBaseBucket object.
   */
  public AdfBaseBucket()
  {
    // for GSON (de)serialization
  }


  /**
   * Creates a new AdfBaseBucket object.
   *
   * @param aBucketKey DOCUMENT ME!
   */
  public AdfBaseBucket(String aBucketKey)
  {
    this.bucketKey = aBucketKey;
  }


  /**
   * Creates a new AdfBucketInfo object.
   *
   * @param aBucketKey  DOCUMENT ME!
   * @param aObjectName DOCUMENT ME!
   */
  public AdfBaseBucket(String aBucketKey, String aObjectName)
  {
    this.bucketKey = aBucketKey;
    this.objectName = aObjectName;
  }

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param aAccess DOCUMENT ME!
   */
  public void addAccess(IAdfBucketAccess aAccess)
  {
    assert aAccess != null : "IAdfBucketAccess can not be NULL";

    if (this.access == null)
    {
      this.access = new ArrayList<>();
    }
    this.access.add(aAccess);
  }


  /**
   * {@inheritDoc}
   */
  @Override public List<IAdfBucketAccess> getAccess()
  {
    if (this.access == null)
    {
      return Collections.emptyList();
    }
    return access;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getBucketKey()
  {
    return this.bucketKey;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getObjectName()
  {
    return this.objectName;
  }


  /**
   * {@inheritDoc}
   */
  @Override public BucketPolicyType getPolicy()
  {
    return policy;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aAccess the access to set
   */
  public void setAccess(List<IAdfBucketAccess> aAccess)
  {
    this.access = aAccess;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aBucketKey the bucketKey to set
   */
  public void setBucketKey(String aBucketKey)
  {
    this.bucketKey = aBucketKey;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aObjectName the objectName to set
   */
  public void setObjectName(String aObjectName)
  {
    this.objectName = aObjectName;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aPolicy the policy to set
   */
  public void setPolicy(BucketPolicyType aPolicy)
  {
    this.policy = aPolicy;
  }
}
