package in.rakesh.autodesk.model.bucket;

import java.util.*;

/**
 * BucketPolicyType
 */
public enum BucketPolicyType
{
  //~ Enum constants -------------------------------------------------------------------------------

  TRANSIENT("transient"), TEMPORARY("temporary"), PERSISTENT("persistent");

  //~ Instance Variables ---------------------------------------------------------------------------

  private final String value;

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new BucketPolicy object.
   *
   * @param aValue DOCUMENT ME!
   */
  BucketPolicyType(String aValue)
  {
    this.value = aValue;
  }

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  aValue DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public static BucketPolicyType fromName(String aValue)
  {
    for (BucketPolicyType policyType : BucketPolicyType.values())
    {
      if (Objects.equals(policyType.getValue(), aValue))
      {
        return policyType;
      }
    }
    return null;
  }


  /**
   * DOCUMENT ME!
   *
   * @return
   */
  public String getValue()
  {
    return value;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String toString()
  {
    return value;
  }
}
