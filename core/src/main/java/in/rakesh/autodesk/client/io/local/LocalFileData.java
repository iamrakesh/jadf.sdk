package in.rakesh.autodesk.client.io.local;

import in.rakesh.autodesk.client.io.*;

import java.io.*;
import java.nio.file.*;

/**
 * {@link IFileData} implementation to deal with local file system.
 */
public class LocalFileData implements IFileData
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private final File file;

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new LocalFileData object.
   *
   * @param aFile File
   */
  public LocalFileData(File aFile)
  {
    assert aFile != null : "File object can not be NULL";
    this.file = aFile;
  }

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  public final InputStream getInputStream() throws FileNotFoundException
  {
    return new FileInputStream(this.file);
  }


  /**
   * {@inheritDoc}
   */
  public final long getLength()
  {
    return this.file.length();
  }


  /**
   * {@inheritDoc}
   */
  @Override public long writeFrom(InputStream aStream) throws IOException
  {
    Path filePath = this.getPath();

    // make sure all directories are created
    Files.createDirectories(filePath);

    return Files.copy(aStream, filePath, StandardCopyOption.REPLACE_EXISTING);
  }


  /**
   * {@inheritDoc}
   */
  public void writeTo(OutputStream aOut) throws FileNotFoundException, IOException
  {
    byte[] data = new byte[1024];
    try(InputStream in = this.getInputStream())
    {
      while (in.read(data) != -1)
      {
        aOut.write(data);
      }
    }
  }


  /**
   * method returns {@code Path} of the file that is being represented by current object.
   *
   * @return Path of the file that is being represented by this object
   */
  final Path getPath()
  {
    return this.file.toPath();
  }
}
