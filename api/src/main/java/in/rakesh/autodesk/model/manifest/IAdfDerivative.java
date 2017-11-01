package in.rakesh.autodesk.model.manifest;

import in.rakesh.autodesk.model.*;

import java.util.*;

/**
 * IManifestDerivative
 */
public interface IAdfDerivative
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public List<IAdfSubDerivative> getChildren();


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getName();


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public FileType getOutputType();


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
  public boolean hasThumbnail();
}
