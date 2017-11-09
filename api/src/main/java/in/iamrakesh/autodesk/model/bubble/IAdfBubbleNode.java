package in.iamrakesh.autodesk.model.bubble;

import java.util.*;

import in.iamrakesh.autodesk.model.*;

/**
 * IAdfBubbleNode
 */
public interface IAdfBubbleNode
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public List<IAdfBubbleNode> getChildren();


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getGuid();


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getIntermediateFile();


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getMime();


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
  public ViewType getRole();


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
}
