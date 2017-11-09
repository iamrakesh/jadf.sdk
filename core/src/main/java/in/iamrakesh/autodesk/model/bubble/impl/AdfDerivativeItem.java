package in.iamrakesh.autodesk.model.bubble.impl;

import java.nio.file.*;
import java.util.*;

import in.iamrakesh.autodesk.model.bubble.*;

/**
 * model class holding information about a derivative item
 */
public class AdfDerivativeItem implements IAdfDerivativeItem
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private List<String> fileNames;

  private List<IAdfDownloadItem> files;

  private String basePath;
  private String guid;
  private String localPath;
  private String mime;

  private String name;
  private String rootFileName;
  private String urn;

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public void addFileName(String aFileName)
  {
    if (this.fileNames == null)
    {
      this.fileNames = new ArrayList<>();
    }
    this.fileNames.add(aFileName);
    this.addFile(aFileName);
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getBasePath()
  {
    return basePath;
  }


  /**
   * {@inheritDoc}
   */
  @Override public List<IAdfDownloadItem> getFiles()
  {
    if (this.files == null)
    {
      return Collections.emptyList();
    }
    return this.files;
  }


  /**
   * {@inheritDoc}
   */
  @Override public List<String> getFilesNames()
  {
    if (this.fileNames == null)
    {
      return Collections.emptyList();
    }
    return fileNames;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getGuid()
  {
    return guid;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getLocalPath()
  {
    return localPath;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getMime()
  {
    return mime;
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
  @Override public String getRootFileName()
  {
    return rootFileName;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getUrn()
  {
    return urn;
  }


  /**
   * method to set base path of the derivative item
   *
   * @param aBasePath the basePath to set
   */
  public void setBasePath(String aBasePath)
  {
    this.basePath = aBasePath;
  }


  /**
   * method to set derivative files
   *
   * @param aFiles the files to set
   */
  public void setFiles(List<String> aFiles)
  {
    this.fileNames = aFiles;
  }


  /**
   * method to set derivative item GUID
   *
   * @param aGuid the guid to set
   */
  public void setGuid(String aGuid)
  {
    this.guid = aGuid;
  }


  /**
   * method to set local path to which files of this derivative item need to be saved to.
   *
   * @param aLocalPath the localPath to set
   */
  public void setLocalPath(String aLocalPath)
  {
    this.localPath = aLocalPath;
  }


  /**
   * method to set MIME property of the derivative item
   *
   * @param aMime the mime to set
   */
  public void setMime(String aMime)
  {
    this.mime = aMime;
  }


  /**
   * method to set name of the derivative item
   *
   * @param aName the name to set
   */
  public void setName(String aName)
  {
    this.name = aName;
  }


  /**
   * method to set derivative item root file name
   *
   * @param aRootFileName the rootFileName to set
   */
  public void setRootFileName(String aRootFileName)
  {
    this.rootFileName = aRootFileName;
  }


  /**
   * method to set derivative item URN
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
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{ ") //
      .append("mime: '").append(this.getMime()) //
      .append("', urn: '").append(this.getUrn()) //
      .append("', guid: '").append(this.getGuid()) //
      .append("', localPath: '").append(this.getLocalPath()) //
      .append("', rootFileName: '").append(this.getRootFileName()) //
      .append("', files: [");
    for (String fileName : this.getFilesNames())
    {
      sb.append(fileName).append(", ");
    }
    sb.append("]") //
      .append("}");
    return sb.toString();
  }


  /**
   * method to add file name to the collection holding all file names of this derivative item.
   *
   * @param aFileName file name
   */
  private void addFile(String aFileName)
  {
    String fileUrn = this.basePath;
    if (!fileUrn.endsWith("/"))
    {
      fileUrn += "/";
    }
    fileUrn += aFileName;

    String fileLocalPath = Paths.get(this.localPath, aFileName).toString();

    if (this.files == null)
    {
      this.files = new ArrayList<>();
    }

    if ("thumbnail".equals(this.getMime()))
    {
      this.files.add(new AdfThumbnailDownloadItem(aFileName, fileUrn, fileLocalPath, this.getMime(), this.getGuid(), this.getUrn()));
      return;
    }

    this.files.add(new AdfDownloadItem(aFileName, fileUrn, fileLocalPath, this.getMime()));
  }
}
