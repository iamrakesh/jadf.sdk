package in.rakesh.autodesk.model.bubble;

import java.util.*;

/**
 * marker interface for derivative item model, which hold information of files that needs to be
 * download.
 */
public interface IAdfDerivativeItem
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * method to add file name to the collection holding all files that needs to be downloaded.
   *
   * @param aFile file name
   */
  public void addFileName(String aFile);


  /**
   * method returns base path of the derivative item
   *
   * @return String base path of derivative item
   */
  public String getBasePath();


  /**
   * method returns {@code List} collection of files
   *
   * @return List collection of files
   */
  public List<IAdfDownloadItem> getFiles();


  /**
   * method returns collection of file names (only)
   *
   * @return List collection of file names
   */
  public List<String> getFilesNames();


  /**
   * method returns derivative item GUID
   *
   * @return String derivative item GUID
   */
  public String getGuid();


  /**
   * method returns local path for the files, where they need to be downloaded to
   *
   * @return String local path
   */
  public String getLocalPath();


  /**
   * method returns MIME property of the derivative item
   *
   * @return String mime property of the derivative item
   */
  public String getMime();


  /**
   * method returns name of the derivative item
   *
   * @return String derivative item name
   */
  public String getName();


  /**
   * method return root file name of the derivative item
   *
   * @return String root file name
   */
  public String getRootFileName();


  /**
   * method returns derivative item URN
   *
   * @return String derivative item URN
   */
  public String getUrn();
}
