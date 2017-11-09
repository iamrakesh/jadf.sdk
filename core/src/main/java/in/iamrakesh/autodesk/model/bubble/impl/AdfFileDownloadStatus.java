package in.iamrakesh.autodesk.model.bubble.impl;

import in.iamrakesh.autodesk.model.*;
import in.iamrakesh.autodesk.model.bubble.*;

/**
 * model class implementation holding download status of a file.
 */
public final class AdfFileDownloadStatus implements IAdfFileDownloadStatus
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private final Status status;

  private final String file;

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new AdfFileDownloadStatus object.
   *
   * @param aFile   file for the status is stored
   * @param aStatus download status
   */
  public AdfFileDownloadStatus(String aFile, Status aStatus)
  {
    this.file = aFile;
    this.status = aStatus;
  }

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public String getFile()
  {
    return this.file;
  }


  /**
   * {@inheritDoc}
   */
  @Override public Status getStatus()
  {
    return this.status;
  }
}
