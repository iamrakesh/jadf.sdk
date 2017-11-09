package in.iamrakesh.autodesk.client.io;

import java.io.*;

/**
 * marker interface providing methods to perform file IO related operations, and provide abstraction
 * from actual file system (Eg. local/S3/WebDAV) that is being used.
 */
public interface IFileSystem
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * method creates wrapper {@link IFileData} object for the given file name.
   *
   * @param  aFileName String file name
   *
   * @return {@link IFileData} file data object
   */
  public IFileData createFileData(String aFileName);


  /**
   * method creates wrapper {@link IFileData} object for the given parent folder and file name
   *
   * @param  aFolder   String parent folder name
   * @param  aFileName String file name
   *
   * @return {@link IFileData} file data object
   */
  public IFileData createFileData(String aFolder, String aFileName);


  /**
   * method writes data provided by given {@code InputStream} into the given {@code IFileData}.
   *
   * @param  aInputStream InputStream providing content that needs to be written
   * @param  aData        IFileData target file information to which data need to be written
   *
   * @return long number of bytes written
   *
   * @throws IOException
   */
  public long put(InputStream aInputStream, IFileData aData) throws IOException;


  /**
   * method to remove given folder
   *
   * @param  aFolder String folder name
   *
   * @throws IOException
   */
  public void remove(String aFolder) throws IOException;


  /**
   * method to remove given file under the given folder.
   *
   * @param  aFolder   String parent folder name
   * @param  aFileName String file name
   *
   * @throws IOException
   */
  public void remove(String aFolder, String aFileName) throws IOException;
}
