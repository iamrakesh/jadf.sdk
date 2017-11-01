package in.rakesh.autodesk.client.factory;

import in.rakesh.autodesk.client.bucket.*;
import in.rakesh.autodesk.client.rest.*;

import java.lang.reflect.*;

/**
 * AdfBucketClientFactory
 */
public final class AdfBucketClientFactory
{
  //~ Static Variables & Initializers --------------------------------------------------------------

  private static final AdfBucketClientFactory INSTANCE = new AdfBucketClientFactory();

  //~ Instance Variables ---------------------------------------------------------------------------

  private Class<? extends IAdfBucketClient> clientClass;

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public static AdfBucketClientFactory getInstance()
  {
    return INSTANCE;
  }


  /**
   * DOCUMENT ME!
   *
   * @param  aRestClient
   *
   * @return DOCUMENT ME!
   *
   * @throws IllegalStateException DOCUMENT ME!
   */
  public IAdfBucketClient create(IAdfRestClient aRestClient)
  {
    if (this.clientClass == null)
    {
      throw new IllegalStateException("Bucket client implementation class is not registered.");
    }

    try
    {
      Constructor<? extends IAdfBucketClient> constructor = this.clientClass.getConstructor(IAdfRestClient.class);
      return constructor.newInstance(aRestClient);
    }
    catch (NoSuchMethodException | SecurityException e)
    {
      throw new IllegalStateException("Bucket client implementation class constructor could not be accessed.", e);
    }
    catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
    {
      throw new IllegalStateException("Bucket client implementation class instance could not be created.", e);
    }
  }


  /**
   * DOCUMENT ME!
   *
   * @param aClientClass DOCUMENT ME!
   */
  public final void register(Class<? extends IAdfBucketClient> aClientClass)
  {
    assert aClientClass != null : "Given client implementation class for factory registration cannot be NULL.";
    this.clientClass = aClientClass;
  }
}
