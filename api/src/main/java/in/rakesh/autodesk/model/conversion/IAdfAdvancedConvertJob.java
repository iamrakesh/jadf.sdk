package in.rakesh.autodesk.model.conversion;

import java.util.*;

/**
 * IAdfAdvancedConvertJob
 */
public interface IAdfAdvancedConvertJob
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public AdfExportFileStructure getExportFileStructure();


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getModelGuid();


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public List<String> getObjectIds();
}
