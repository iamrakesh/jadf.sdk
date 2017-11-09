package in.iamrakesh.autodesk.model.conversion.impl;

import java.util.*;

import in.iamrakesh.autodesk.model.conversion.*;

/**
 * AdfAdvancedConvertJob
 */
public final class AdfAdvancedConvertJob implements IAdfAdvancedConvertJob
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private AdfExportFileStructure exportFileStructure;
  private List<String> objectIds;
  private String modelGuid;

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param aObjectId the objectIds to set
   */
  public void addObjectId(String aObjectId)
  {
    if (this.objectIds == null)
    {
      this.objectIds = new ArrayList<>();
    }

    this.objectIds.add(aObjectId);
  }


  /**
   * {@inheritDoc}
   */
  @Override public AdfExportFileStructure getExportFileStructure()
  {
    return this.exportFileStructure;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getModelGuid()
  {
    return this.modelGuid;
  }


  /**
   * {@inheritDoc}
   */
  @Override public List<String> getObjectIds()
  {
    if (this.objectIds == null)
    {
      return Collections.emptyList();
    }
    return this.objectIds;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aExportFileStructure the exportFileStructure to set
   */
  public void setExportFileStructure(AdfExportFileStructure aExportFileStructure)
  {
    this.exportFileStructure = aExportFileStructure;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aModelGuid the modelGuid to set
   */
  public void setModelGuid(String aModelGuid)
  {
    this.modelGuid = aModelGuid;
  }
}
