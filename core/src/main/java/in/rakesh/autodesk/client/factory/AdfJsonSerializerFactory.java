package in.rakesh.autodesk.client.factory;

import in.rakesh.autodesk.client.json.*;
import in.rakesh.autodesk.client.rest.*;

/**
 * AdfJsonSerializerFactory
 */
public final class AdfJsonSerializerFactory
{
  //~ Static Variables & Initializers --------------------------------------------------------------

  private static final AdfJsonSerializerFactory INSTANCE = new AdfJsonSerializerFactory();

  //~ Instance Variables ---------------------------------------------------------------------------

  private Class<? extends IJsonSerializer> clazz;

  private Class<? extends IAdfRestBodyReaderWriter> restProviderClass;

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public static AdfJsonSerializerFactory getInstance()
  {
    return INSTANCE;
  }


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   *
   * @throws IllegalStateException DOCUMENT ME!
   */
  public IJsonSerializer create()
  {
    if (this.clazz == null)
    {
      throw new IllegalStateException("Json serializer implementation class is not registered.");
    }

    try
    {
      return this.clazz.newInstance();
    }
    catch (SecurityException e)
    {
      throw new IllegalStateException("Json serializer implementation class constructor could not be accessed.", e);
    }
    catch (InstantiationException | IllegalAccessException | IllegalArgumentException e)
    {
      throw new IllegalStateException("Json serializer implementation class instance could not be created.", e);
    }
  }


  /**
   * method returns {@code IAdfRestBodyReaderWriter} type, which will be registered and used for
   * REST API response body reading/writing
   *
   * @return {@code Class<? extends IAdfRestBodyReaderWriter>} REST body reader/writer
   */
  public final Class<? extends IAdfRestBodyReaderWriter> getRestProviderClass()
  {
    return this.restProviderClass;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aClass             DOCUMENT ME!
   * @param aRestProviderClass DOCUMENT ME!
   */
  public final void register(Class<? extends IJsonSerializer> aClass, Class<? extends IAdfRestBodyReaderWriter> aRestProviderClass)
  {
    assert aClass != null : "Given Json serializer implementation class for factory registration cannot be NULL.";
    assert aRestProviderClass != null : "Given REST body reader/writer (provider) class for factory registration cannot be NULL.";

    this.clazz = aClass;
    this.restProviderClass = aRestProviderClass;
  }
}
