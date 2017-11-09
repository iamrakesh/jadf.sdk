package in.iamrakesh.autodesk.model.bubble.impl;

import java.util.*;

import in.iamrakesh.autodesk.model.*;
import in.iamrakesh.autodesk.model.bubble.*;

/**
 * AdfBubbleNode
 */
public class AdfBubbleNode implements IAdfBubbleNode
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private boolean hasThumbnail;

  private FileType type;

  private List<IAdfBubbleNode> children;

  private String guid;
  private String intermediateFile;
  private String mime;
  private String name;
  private String urn;

  private ViewType role;

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public List<IAdfBubbleNode> getChildren()
  {
    if (this.children == null)
    {
      return Collections.emptyList();
    }
    return children;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getGuid()
  {
    return guid;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getIntermediateFile()
  {
    return intermediateFile;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getMime()
  {
    return mime;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getName()
  {
    return name;
  }


  /**
   * {@inheritDoc}
   */
  @Override public ViewType getRole()
  {
    return role;
  }


  /**
   * {@inheritDoc}
   */
  @Override public FileType getType()
  {
    return type;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getUrn()
  {
    return urn;
  }


  /**
   * {@inheritDoc}
   */
  @Override public boolean hasThumbnail()
  {
    return hasThumbnail;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aChildren the children to set
   */
  public void setChildren(List<IAdfBubbleNode> aChildren)
  {
    this.children = aChildren;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aGuid the guid to set
   */
  public void setGuid(String aGuid)
  {
    this.guid = aGuid;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aHasThumbnail the hasThumbnail to set
   */
  public void setHasThumbnail(boolean aHasThumbnail)
  {
    this.hasThumbnail = aHasThumbnail;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aIntermediateFile the intermediateFile to set
   */
  public void setIntermediateFile(String aIntermediateFile)
  {
    this.intermediateFile = aIntermediateFile;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aMime the mime to set
   */
  public void setMime(String aMime)
  {
    this.mime = aMime;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aName the name to set
   */
  public void setName(String aName)
  {
    this.name = aName;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aRole the role to set
   */
  public void setRole(ViewType aRole)
  {
    this.role = aRole;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aType the type to set
   */
  public void setType(FileType aType)
  {
    this.type = aType;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aUrn the urn to set
   */
  public void setUrn(String aUrn)
  {
    this.urn = aUrn;
  }
}
