package in.rakesh.autodesk.model.bubble;

import in.rakesh.autodesk.model.*;

/**
 * marker interface to hold file download status
 */
public interface IAdfFileDownloadStatus
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * method returns file about which this download status is
   *
   * @return String file
   */
  public String getFile();


  /**
   * method returns download {@link Status} of the file.
   *
   * @return Status download status
   */
  public Status getStatus();
}
