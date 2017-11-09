package in.iamrakesh.autodesk.model;

import java.util.*;

/**
 * enum used to represent file type attribute in manifest JSON
 */
public enum FileType
{
  //~ Enum constants -------------------------------------------------------------------------------

  STL("stl"), STEP("step"), IGES("iges"), OBJ("obj"), //
  SVF("svf"), THUMBNAIL("thumbnail"), GEOMETRY("geometry"), //
  RESOURCE("resource"), MANIFEST("manifest"), VIEW("view"), //
  DESIGN("design"), FOLDER("folder");

  //~ Instance Variables ---------------------------------------------------------------------------

  private final String value;

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new FileType object.
   *
   * @param aValue file type
   */
  FileType(String aValue)
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
  public static FileType fromName(String aValue)
  {
    for (FileType fileType : FileType.values())
    {
      if (Objects.equals(fileType.getValue(), aValue))
      {
        return fileType;
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
