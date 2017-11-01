package in.rakesh.autodesk.client.factory;

import in.rakesh.autodesk.client.*;
import in.rakesh.autodesk.client.io.*;

import java.lang.reflect.*;

/**
 * AdfFileSystemFactory
 */
public final class AdfFileSystemFactory
{
  //~ Static Variables & Initializers --------------------------------------------------------------

  private static final AdfFileSystemFactory INSTANCE = new AdfFileSystemFactory();

  //~ Instance Variables ---------------------------------------------------------------------------

  private Class<? extends IFileSystem> clazz;

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public static AdfFileSystemFactory getInstance()
  {
    return INSTANCE;
  }


  /**
   * DOCUMENT ME!
   *
   * @param  aConfig
   *
   * @return DOCUMENT ME!
   *
   * @throws IllegalStateException DOCUMENT ME!
   */
  public IFileSystem create(IAdfConfig aConfig)
  {
    if (this.clazz == null)
    {
      throw new IllegalStateException("File system implementation class is not registered.");
    }

    try
    {
      Constructor<? extends IFileSystem> constructor = this.clazz.getConstructor(IAdfConfig.class);
      return constructor.newInstance(aConfig);
    }
    catch (NoSuchMethodException | SecurityException e)
    {
      throw new IllegalStateException("File system implementation class constructor could not be accessed.", e);
    }
    catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
    {
      throw new IllegalStateException("File system implementation class instance could not be created.", e);
    }
  }


  /**
   * DOCUMENT ME!
   *
   * @param aClass DOCUMENT ME!
   */
  public final void register(Class<? extends IFileSystem> aClass)
  {
    assert aClass != null : "Given file system implementation class for factory registration cannot be NULL.";
    this.clazz = aClass;
  }
}
