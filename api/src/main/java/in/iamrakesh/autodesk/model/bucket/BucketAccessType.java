package in.iamrakesh.autodesk.model.bucket;

import java.util.*;

/**
 * BucketAccessType
 */
public enum BucketAccessType
{
  //~ Enum constants -------------------------------------------------------------------------------

  FULL("full"), READ("read");

  //~ Instance Variables ---------------------------------------------------------------------------

  private final String value;

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new BucketAccess object.
   *
   * @param aValue DOCUMENT ME!
   */
  BucketAccessType(String aValue)
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
  public static BucketAccessType fromName(String aValue)
  {
    for (BucketAccessType accessType : BucketAccessType.values())
    {
      if (Objects.equals(accessType.getValue(), aValue))
      {
        return accessType;
      }
    }
    return null;
  }


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getValue()
  {
    return this.value;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String toString()
  {
    return value;
  }
}
