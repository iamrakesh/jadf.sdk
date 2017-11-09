package in.iamrakesh.autodesk.model;

import java.util.*;

/**
 * enum to represent status property of manifest json and download status.
 */
public enum Status
{
  //~ Enum constants -------------------------------------------------------------------------------

  PENDING("pending"), INPROGRESS("inprogress"), SUCCESS("success"), FAILED("failed"), //
  TIMEOUT("timeout"), PARTIALSUCCESS("partialsuccess");

  //~ Instance Variables ---------------------------------------------------------------------------

  private final String value;

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new Status object.
   *
   * @param aValue enum value
   */
  Status(String aValue)
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
  public static Status fromName(String aValue)
  {
    for (Status status : Status.values())
    {
      if (Objects.equals(status.getValue(), aValue))
      {
        return status;
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
    return this.value;
  }
}
