package in.iamrakesh.autodesk.model.manifest.impl;

import java.util.*;

import in.iamrakesh.autodesk.model.*;
import in.iamrakesh.autodesk.model.manifest.*;

/**
 * AdfDerivative
 */
public class AdfDerivative extends AdfDerivativeBase implements IAdfDerivative
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private List<IAdfSubDerivative> children;

  private String name;

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
  @Override public String getName()
  {
    return name;
  }


  /**
   * {@inheritDoc}
   */
  @Override public FileType getOutputType()
  {
    return this.getType();
  }


  /**
   * DOCUMENT ME!
   *
   * @param aChildren the children to set
   */
  public void setChildren(List<IAdfSubDerivative> aChildren)
  {
    this.children = aChildren;
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
   * @param aOutputType the outputType to set
   */
  public void setOutputType(FileType aOutputType)
  {
    this.setType(aOutputType);
  }


  /**
   * {@inheritDoc}
   */
  @Override public String toString()
  {
    StringBuilder sb = new StringBuilder();

    sb.append("Name: ").append(name).append("\n");
    sb.append("Has Thumbnail: ").append(this.hasThumbnail()).append("\n");
    sb.append("OutputType: ").append(this.getOutputType()).append("\n");
    sb.append("Progress: ").append(this.getProgress()).append("\n");
    sb.append("Status: ").append(this.getStatus()).append("\n");
    sb.append("Children: ").append(children).append("\n");

    return sb.toString();
  }
}
