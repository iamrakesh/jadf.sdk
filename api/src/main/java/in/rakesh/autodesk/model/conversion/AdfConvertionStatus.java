package in.rakesh.autodesk.model.conversion;

import java.util.*;

/**
 * AdfConvertionStatus
 */
public enum AdfConvertionStatus
{
  //~ Enum constants -------------------------------------------------------------------------------

  COMPLETE("complete");

  //~ Instance Variables ---------------------------------------------------------------------------

  private final String value;

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new ConvertionStatus object.
   *
   * @param aValue DOCUMENT ME!
   */
  AdfConvertionStatus(String aValue)
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
  public static AdfConvertionStatus fromName(String aValue)
  {
    for (AdfConvertionStatus status : AdfConvertionStatus.values())
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
   * @return the value
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
    return this.value;
  }
}
