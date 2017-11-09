package in.iamrakesh.autodesk.model.manifest;

import java.util.*;

import in.iamrakesh.autodesk.model.*;

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
