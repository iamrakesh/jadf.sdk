package in.rakesh.autodesk.model.bubble;

/**
 * marker interface holding information about the file item that is to be downloaded.
 */
public interface IAdfDownloadItem
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * method returns file URN which can be used to download the file
   *
   * @return String file URN
   */
  public String getFileUrn();


  /**
   * method returns local path to which the file need to be saved to
   *
   * @return String local path where the file need to be saved to
   */
  public String getLocalPath();


  /**
   * method returns name of the file
   *
   * @return String file name
   */
  public String getName();


  /**
   * method returns 'true' if the download item is a thumbnail item, 'false' otherwise.
   *
   * @return 'true' if the item is thumbnail item, 'false' otherwise
   */
  public boolean isThumbnail();
}
