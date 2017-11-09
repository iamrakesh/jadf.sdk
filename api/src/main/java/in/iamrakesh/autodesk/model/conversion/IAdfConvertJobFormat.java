package in.iamrakesh.autodesk.model.conversion;

import java.util.*;

import in.iamrakesh.autodesk.model.*;

/**
 * IAdfConvertJobFormat
 */
public interface IAdfConvertJobFormat
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public IAdfAdvancedConvertJob getAdvanced();


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public FileType getType();


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public List<ViewType> getViews();
}
