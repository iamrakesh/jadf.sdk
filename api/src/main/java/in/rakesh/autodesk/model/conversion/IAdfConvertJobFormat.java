package in.rakesh.autodesk.model.conversion;

import in.rakesh.autodesk.model.*;

import java.util.*;

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
