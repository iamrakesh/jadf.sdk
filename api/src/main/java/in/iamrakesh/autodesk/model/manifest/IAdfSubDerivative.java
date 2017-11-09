package in.iamrakesh.autodesk.model.manifest;

import java.util.*;

import in.iamrakesh.autodesk.model.*;

/**
 * IAdfSubDerivative
 */
public interface IAdfSubDerivative
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public List<Message> getMessages();


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getMimeType();


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getModelGUID();


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
  public List<Integer> getObjectIds();


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
  public List<String> getResolution();


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public ViewType getRole();


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
  public String getUrn();


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean hasThumbnail();


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  List<IAdfSubDerivative> getChildren();


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  String getMessage();


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  IAdfDerivativeProperties getProperties();


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  String getViewableID();


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  List<Float> getViewbox();
}
