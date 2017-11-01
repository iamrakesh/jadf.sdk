package in.rakesh.autodesk.client.io.local;

import in.rakesh.autodesk.client.*;
import in.rakesh.autodesk.client.io.*;

import org.slf4j.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * {@code IFileSystem} implementation to perform IO operations on local file system
 */
public class LocalFileSystem implements IFileSystem
{
  //~ Static Variables & Initializers --------------------------------------------------------------

  private static final Logger LOG = LoggerFactory.getLogger(LocalFileSystem.class);

  //~ Instance Variables ---------------------------------------------------------------------------

  private File rootFolder;

  private String rootFolderStr;

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new LocalFileSystem object.
   *
   * @param aConfig {@code IAdfConfig} containing root directory and other required configuration
   */
  public LocalFileSystem(IAdfConfig aConfig)
  {
    assert aConfig != null : "File system configuration cannot be NULL.";
    this.initialize(aConfig);
  }

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  public IFileData createFileData(String aFileName)
  {
    return new LocalFileData(new File(this.rootFolder, aFileName));
  }


  /**
   * {@inheritDoc}
   */
  public IFileData createFileData(String aFolder, String aFileName)
  {
    return new LocalFileData(Paths.get(this.rootFolderStr, aFolder, aFileName).toFile());
  }


  /**
   * {@inheritDoc}
   */
  public long put(InputStream aInputStream, IFileData aData) throws IOException
  {
    return aData.writeFrom(aInputStream);
  }


  /**
   * {@inheritDoc}
   */
  public void remove(String aFolder) throws IOException
  {
    Path filePath = new File(this.rootFolder, aFolder).toPath();

    if (LOG.isDebugEnabled())
    {
      LOG.debug("Removing given '" + filePath + "' directory.");
    }

    Files.walk(filePath, FileVisitOption.FOLLOW_LINKS) //
         .sorted(Comparator.reverseOrder()) //
         .map(Path::toFile) //
         .forEach(File::delete);
  }


  /**
   * {@inheritDoc}
   */
  public void remove(String aFolder, String aFileName) throws IOException
  {
    Path filePath = Paths.get(this.rootFolderStr, aFolder, aFileName);

    if (LOG.isDebugEnabled())
    {
      LOG.debug("Removing given file '" + filePath + "'.");
    }

    Files.walk(filePath, FileVisitOption.FOLLOW_LINKS) //
         .sorted(Comparator.reverseOrder()) //
         .map(Path::toFile) //
         .forEach(File::delete);
  }


  /**
   * DOCUMENT ME!
   *
   * @param  aConfig DOCUMENT ME!
   *
   * @throws IllegalArgumentException DOCUMENT ME!
   */
  private void initialize(IAdfConfig aConfig)
  {
    String rootFolderValue = aConfig.getRootFolder();
    if ((rootFolderValue == null) || (rootFolderValue.trim().length() == 0))
    {
      throw new IllegalArgumentException("Invalid value configured for 'root.folder'.");
    }

    this.rootFolderStr = rootFolderValue;
    this.rootFolder = new File(rootFolderValue);
    if (this.rootFolder.exists())
    {
      return;
    }
    throw new IllegalArgumentException("Directory configured for 'root.folder' does not exists.");
  }
}
