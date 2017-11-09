package in.iamrakesh.autodesk.client.io;

import java.io.*;

/**
 * marker interface to hold file information and provide abstract from actual file system (Eg.
 * Local, S3 or WebDAV) that is being used.
 */
public interface IFileData
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * method returns {@code InputStream} which provides byte of the file that is being represented by
   * this object.
   *
   * @return {@code InputStream}
   *
   * @throws FileNotFoundException
   */
  public InputStream getInputStream() throws FileNotFoundException;


  /**
   * method returns file size
   *
   * @return long file size
   */
  public long getLength();


  /**
   * method writes data provided by given {@code InputStream} into the given {@code IFileData}.
   *
   * @param  aStream {@code InputStream} providing content that needs to be written to the current
   *                 {@code IFileData}
   *
   * @return long number of bytes written
   *
   * @throws IOException
   */
  public long writeFrom(InputStream aStream) throws IOException;


  /**
   * method to write contents of the file that is being represented by this object into the given
   * {@code OutputStream}
   *
   * @param  aStream {@code OutputStream} to write the contents of the file that is represented by
   *                 this object
   *
   * @throws IOException
   */
  public void writeTo(OutputStream aStream) throws IOException;
}
