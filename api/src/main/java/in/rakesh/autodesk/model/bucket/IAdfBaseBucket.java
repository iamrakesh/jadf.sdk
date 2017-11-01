package in.rakesh.autodesk.model.bucket;

import java.util.*;

/**
 * IAdfBaseBucket
 */
public interface IAdfBaseBucket
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public List<IAdfBucketAccess> getAccess();


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getBucketKey();


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getObjectName();


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public BucketPolicyType getPolicy();
}
