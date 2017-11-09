package in.iamrakesh.autodesk.client.factory;

import java.lang.reflect.*;

import in.iamrakesh.autodesk.client.rest.*;

/**
 * AdfRestClientFactory
 */
public final class AdfRestClientFactory
{
  //~ Static Variables & Initializers --------------------------------------------------------------

  private static final AdfRestClientFactory INSTANCE = new AdfRestClientFactory();

  //~ Instance Variables ---------------------------------------------------------------------------

  private Class<? extends IAdfRestClient> clientClass;

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public static AdfRestClientFactory getInstance()
  {
    return INSTANCE;
  }


  /**
   * DOCUMENT ME!
   *
   * @param  aBaseUrl DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   *
   * @throws IllegalStateException DOCUMENT ME!
   */
  public IAdfRestClient create(String aBaseUrl)
  {
    if (this.clientClass == null)
    {
      throw new IllegalStateException("Rest client implementation class is not registered.");
    }

    try
    {
      Constructor<? extends IAdfRestClient> constructor = this.clientClass.getConstructor(String.class);
      return constructor.newInstance(aBaseUrl);
    }
    catch (NoSuchMethodException | SecurityException e)
    {
      throw new IllegalStateException("Rest client implementation class constructor could not be accessed.", e);
    }
    catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
    {
      throw new IllegalStateException("Rest client implementation class instance could not be created.", e);
    }
  }


  /**
   * DOCUMENT ME!
   *
   * @param aClientClass DOCUMENT ME!
   */
  public final void register(Class<? extends IAdfRestClient> aClientClass)
  {
    assert aClientClass != null : "Given client implementation class for factory registration cannot be NULL.";
    this.clientClass = aClientClass;
  }
}
