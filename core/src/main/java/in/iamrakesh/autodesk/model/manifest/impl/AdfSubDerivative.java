package in.iamrakesh.autodesk.model.manifest.impl;

import java.util.*;

import in.iamrakesh.autodesk.model.*;
import in.iamrakesh.autodesk.model.manifest.*;

/**
 * AdfSubDerivative
 */
public class AdfSubDerivative extends AdfDerivativeBase implements IAdfSubDerivative
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private IAdfDerivativeProperties properties;

  private List<IAdfSubDerivative> children;
  private List<Message> messages;

  private List<Integer> objectIds;
  private List<String> resolution;
  private List<Float> viewbox;

  private String message;

  private String mimeType;

  private String modelGUID;

  private String name;

  private String urn;
  private String viewableID;

  private ViewType role;

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public List<IAdfSubDerivative> getChildren()
  {
    if (children == null)
    {
      return Collections.<IAdfSubDerivative>emptyList();
    }
    return children;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getMessage()
  {
    return message;
  }


  /**
   * {@inheritDoc}
   */
  @Override public List<Message> getMessages()
  {
    return messages;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getMimeType()
  {
    return mimeType;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getModelGUID()
  {
    return modelGUID;
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
  @Override public List<Integer> getObjectIds()
  {
    return objectIds;
  }


  /**
   * {@inheritDoc}
   */
  @Override public IAdfDerivativeProperties getProperties()
  {
    return properties;
  }


  /**
   * {@inheritDoc}
   */
  @Override public List<String> getResolution()
  {
    return resolution;
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
  @Override public String getUrn()
  {
    return urn;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getViewableID()
  {
    return viewableID;
  }


  /**
   * {@inheritDoc}
   */
  @Override public List<Float> getViewbox()
  {
    return viewbox;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aChildren DOCUMENT ME!
   */
  public void setChildren(List<IAdfSubDerivative> aChildren)
  {
    this.children = aChildren;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aMessage the message to set
   */
  public void setMessage(String aMessage)
  {
    this.message = aMessage;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aMessages the messages to set
   */
  public void setMessages(List<Message> aMessages)
  {
    this.messages = aMessages;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aMimeType the mimeType to set
   */
  public void setMimeType(String aMimeType)
  {
    this.mimeType = aMimeType;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aModelGUID the modelGUID to set
   */
  public void setModelGUID(String aModelGUID)
  {
    this.modelGUID = aModelGUID;
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
   * @param aObjectIds the objectIds to set
   */
  public void setObjectIds(List<Integer> aObjectIds)
  {
    this.objectIds = aObjectIds;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aProperties DOCUMENT ME!
   */
  public void setProperties(IAdfDerivativeProperties aProperties)
  {
    this.properties = aProperties;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aResolution the resolution to set
   */
  public void setResolution(List<String> aResolution)
  {
    this.resolution = aResolution;
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
   * @param aUrn the urn to set
   */
  public void setUrn(String aUrn)
  {
    this.urn = aUrn;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aViewableID DOCUMENT ME!
   */
  public void setViewableID(String aViewableID)
  {
    this.viewableID = aViewableID;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aViewbox DOCUMENT ME!
   */
  public void setViewbox(List<Float> aViewbox)
  {
    this.viewbox = aViewbox;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String toString()
  {
    StringBuilder sb = new StringBuilder();

    sb.append("Type: ").append(this.getType()).append("\n");
    sb.append("Role: ").append(role).append("\n");
    sb.append("Name: ").append(name).append("\n");
    sb.append("Has Thumbnail: ").append(this.hasThumbnail()).append("\n");
    sb.append("Mime: ").append(mimeType).append("\n");
    sb.append("Urn: ").append(urn).append("\n");
    sb.append("Progress: ").append(this.getProgress()).append("\n");
    sb.append("Status: ").append(this.getStatus()).append("\n");
    sb.append("Resolution: ").append(resolution).append("\n");
    sb.append("Model GUID: ").append(modelGUID).append("\n");
    sb.append("ObjectIds: ").append(objectIds).append("\n");
    sb.append("Messages: ").append(messages).append("\n");
    sb.append("Viewable ID: ").append(viewableID).append("\n");
    sb.append("Children: ").append(children).append("\n");
    sb.append("Viewbox: ").append(viewbox).append("\n");
    sb.append("Properties : ").append(properties).append("\n");

    return sb.toString();
  }
}
