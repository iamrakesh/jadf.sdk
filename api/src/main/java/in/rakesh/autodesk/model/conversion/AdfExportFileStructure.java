package in.rakesh.autodesk.model.conversion;

import java.util.*;

/**
 * AdfExportFileStructure
 */
public enum AdfExportFileStructure
{
  //~ Enum constants -------------------------------------------------------------------------------

  SINGLE("single"), MULTIPLE("multiple");

  //~ Instance Variables ---------------------------------------------------------------------------

  private final String value;

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new ExportFileStructure object.
   *
   * @param aValue DOCUMENT ME!
   */
  AdfExportFileStructure(String aValue)
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
  public static AdfExportFileStructure fromName(String aValue)
  {
    for (AdfExportFileStructure fileStructure : AdfExportFileStructure.values())
    {
      if (Objects.equals(fileStructure.getValue(), aValue))
      {
        return fileStructure;
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
