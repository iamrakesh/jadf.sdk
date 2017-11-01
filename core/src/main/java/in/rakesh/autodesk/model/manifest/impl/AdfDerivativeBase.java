package in.rakesh.autodesk.model.manifest.impl;

import in.rakesh.autodesk.model.*;
import in.rakesh.autodesk.model.manifest.*;

/**
 * AdfDerivativeBase
 */
public abstract class AdfDerivativeBase implements IAdfDerivativeBase
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private boolean hasThumbnail;

  private FileType type;

  private Status status;

  private String progress;

  //~ Methods --------------------------------------------------------------------------------------

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
  @Override public Status getStatus()
  {
    return status;
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
  @Override public boolean hasThumbnail()
  {
    return hasThumbnail;
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
   * @param aStatus the status to set
   */
  public void setStatus(Status aStatus)
  {
    this.status = aStatus;
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
}
