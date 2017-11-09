package in.iamrakesh.autodesk.model.manifest.impl;

import java.util.*;

import in.iamrakesh.autodesk.model.manifest.*;

/**
 * Manifest
 */
public class AdfManifest implements IAdfManifest
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private boolean hasThumbnail;

  private List<IAdfDerivative> derivatives;

  private String progress;

  private String region;

  private String status;

  private String type;
  private String urn;

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public List<IAdfDerivative> getDerivatives()
  {
    return derivatives;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getProgress()
  {
    return progress;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getRegion()
  {
    return region;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getStatus()
  {
    return status;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getType()
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
   * @param aDerivatives the derivatives to set
   */
  public void setDerivatives(List<IAdfDerivative> aDerivatives)
  {
    this.derivatives = aDerivatives;
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
   * @param aProgress the progress to set
   */
  public void setProgress(String aProgress)
  {
    this.progress = aProgress;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aRegion the region to set
   */
  public void setRegion(String aRegion)
  {
    this.region = aRegion;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aStatus the status to set
   */
  public void setStatus(String aStatus)
  {
    this.status = aStatus;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aType the type to set
   */
  public void setType(String aType)
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


  /**
   * {@inheritDoc}
   */
  @Override public String toString()
  {
    StringBuilder sb = new StringBuilder();

    sb.append("Urn: ").append(urn).append("\n");
    sb.append("Type: ").append(type).append("\n");
    sb.append("Progress: ").append(progress).append("\n");
    sb.append("Status: ").append(status).append("\n");
    sb.append("Has Thumbnail: ").append(hasThumbnail).append("\n");
    sb.append("Region: ").append(region).append("\n");
    sb.append("Derivatives: ").append(derivatives).append("\n");

    return sb.toString();
  }
}
