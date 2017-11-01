package in.rakesh.autodesk.model.manifest;

import java.util.*;

/**
 * IManifest
 */
public interface IAdfManifest
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public List<IAdfDerivative> getDerivatives();


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
  public String getRegion();


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getStatus();


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getType();


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getUrn();


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean hasThumbnail();
}
