package in.iamrakesh.autodesk.model.bubble.impl;

import in.iamrakesh.autodesk.model.bubble.*;

/**
 * model class holding information about file item that can be downloaded.
 */
public class AdfDownloadItem implements IAdfDownloadItem
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private final String fileUrn;
  private final String localPath;

  private final String mime;
  private final String name;

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new AdfDownloadItem object.
   *
   * @param aName      file name
   * @param aFileUrn   file URN
   * @param aLocalPath local path to save file to
   * @param aMime      mime type of this download item
   */
  public AdfDownloadItem(String aName, String aFileUrn, String aLocalPath, String aMime)
  {
    this.name = aName;
    this.fileUrn = aFileUrn;
    this.localPath = aLocalPath;
    this.mime = aMime;
  }

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public String getFileUrn()
  {
    return this.fileUrn;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getLocalPath()
  {
    return this.localPath;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getName()
  {
    return this.name;
  }


  /**
   * {@inheritDoc}
   */
  @Override public boolean isThumbnail()
  {
    return "thumbnail".equals(this.mime);
  }
}
