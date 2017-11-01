package in.rakesh.autodesk.model.manifest;

import in.rakesh.autodesk.model.*;

/**
 * IAdfDerivativeBase
 */
public interface IAdfDerivativeBase
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getProgress();


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public Status getStatus();


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
  public boolean hasThumbnail();
}
