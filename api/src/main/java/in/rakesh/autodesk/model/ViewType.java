package in.rakesh.autodesk.model;

import java.util.*;

/**
 * enum representing resource type property in manifest JSON
 */
public enum ViewType
{
  //~ Enum constants -------------------------------------------------------------------------------

  _2D("2d"), _3D("3d"), GRAPHICS("graphics"), MANIFEST("manifest"), THUMBNAIL("thumbnail"), //
  RAAS("raas"), PDF("pdf"), LEAFLET_ZIP("leaflet-zip"), PREVIEW("preview"), LOD("lod"), //
  PROPERTY_DB("Autodesk.CloudPlatform.PropertyDatabase"), //
  DESIGN_DESCRIPTION("Autodesk.CloudPlatform.DesignDescription"), //
  INDEXABLE_CONTENT("Autodesk.CloudPlatform.IndexableContent"), VIEWABLE("viewable");

  //~ Instance Variables ---------------------------------------------------------------------------

  private final String value;

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new ViewType object.
   *
   * @param aValue enum value
   */
  ViewType(String aValue)
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
  public static ViewType fromName(String aValue)
  {
    for (ViewType viewType : ViewType.values())
    {
      if (Objects.equals(viewType.getValue(), aValue))
      {
        return viewType;
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
