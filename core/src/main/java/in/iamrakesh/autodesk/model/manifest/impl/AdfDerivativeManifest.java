package in.iamrakesh.autodesk.model.manifest.impl;

import java.util.*;

import in.iamrakesh.autodesk.model.manifest.*;

/**
 * AdfDerivativeManifest
 */
public class AdfDerivativeManifest implements IAdfDerivativeManifest
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private List<IAdfDerivativeAsset> assets;
  private String name;

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  public List<IAdfDerivativeAsset> getAssets()
  {
    if (this.assets == null)
    {
      return Collections.emptyList();
    }
    return this.assets;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getName()
  {
    return name;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aAssets the assets to set
   */
  public void setAssets(List<IAdfDerivativeAsset> aAssets)
  {
    this.assets = aAssets;
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
   * {@inheritDoc}
   */
  @Override public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{ ") //
      .append("name: '").append(this.name) //
      .append("', assets: [");
    for (IAdfDerivativeAsset asset : this.getAssets())
    {
      sb.append(asset.getUri()).append(", ");
    }
    sb.append("]") //
      .append("}");
    return sb.toString();
  }
}
