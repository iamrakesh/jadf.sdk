package in.rakesh.autodesk.model.bubble.impl;

/**
 * model class holding information about thumbnail file item that can be downloaded.
 */
public class AdfThumbnailDownloadItem extends AdfDownloadItem
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private final String derivativeUrn;
  private final String guid;

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new AdfThumbnailDownloadItem object.
   *
   * @param aName          file name
   * @param aFileUrn       file URN
   * @param aLocalPath     local path to save file to
   * @param aMime          aThumbnail
   * @param aGuid          guid to download
   * @param aDerivativeUrn derivativeUrn
   */
  public AdfThumbnailDownloadItem(String aName, String aFileUrn, String aLocalPath, String aMime, String aGuid, String aDerivativeUrn)
  {
    super(aName, aFileUrn, aLocalPath, aMime);
    this.guid = aGuid;
    this.derivativeUrn = aDerivativeUrn;
  }

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * method returns derivative URN, which will be used to download thumbnail item
   *
   * @return derivative URN
   */
  public final String getDerivativeUrn()
  {
    return derivativeUrn;
  }


  /**
   * method returns derivative item GUID
   *
   * @return guid
   */
  public final String getGuid()
  {
    return guid;
  }
}
