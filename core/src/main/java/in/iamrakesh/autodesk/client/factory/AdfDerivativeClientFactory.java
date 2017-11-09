package in.iamrakesh.autodesk.client.factory;

import java.lang.reflect.*;

import in.iamrakesh.autodesk.client.derivative.*;
import in.iamrakesh.autodesk.client.io.*;
import in.iamrakesh.autodesk.client.rest.*;

/**
 * AdfDerivativeClientFactory
 */
public final class AdfDerivativeClientFactory
{
  //~ Static Variables & Initializers --------------------------------------------------------------

  private static final AdfDerivativeClientFactory INSTANCE = new AdfDerivativeClientFactory();

  //~ Instance Variables ---------------------------------------------------------------------------

  private Class<? extends IAdfDerivativesClient> clientClass;

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public static AdfDerivativeClientFactory getInstance()
  {
    return INSTANCE;
  }


  /**
   * DOCUMENT ME!
   *
   * @param  aRestClient
   * @param  aFileSystem
   *
   * @return DOCUMENT ME!
   *
   * @throws IllegalStateException DOCUMENT ME!
   */
  public IAdfDerivativesClient create(IAdfRestClient aRestClient, IFileSystem aFileSystem)
  {
    if (this.clientClass == null)
    {
      throw new IllegalStateException("Derivative client implementation class is not registered.");
    }

    try
    {
      Constructor<? extends IAdfDerivativesClient> constructor = this.clientClass.getConstructor(IAdfRestClient.class, IFileSystem.class);
      return constructor.newInstance(aRestClient, aFileSystem);
    }
    catch (NoSuchMethodException | SecurityException e)
    {
      throw new IllegalStateException("Derivative client implementation class constructor could not be accessed.", e);
    }
    catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
    {
      throw new IllegalStateException("Derivative client implementation class instance could not be created.", e);
    }
  }


  /**
   * DOCUMENT ME!
   *
   * @param aClientClass DOCUMENT ME!
   */
  public final void register(Class<? extends IAdfDerivativesClient> aClientClass)
  {
    assert aClientClass != null : "Given client implementation class for factory registration cannot be NULL.";
    this.clientClass = aClientClass;
  }
}
