package in.rakesh.autodesk.client.json;

import java.io.*;

/**
 * marker interface providing method to (de)serialize JSON and provide abstraction from actual
 * library that is being used.
 */
public interface IJsonSerializer
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * method to convert given JSON string into the given type of object
   *
   * @param  aJson  JSON string that needs to be converted
   * @param  aClass Type of the object represented by the given JSON string
   *
   * @return T object parsed from the given JSON string
   */
  public <T> T fromJson(String aJson, Class<T> aClass);


  /**
   * method to convert JSON string provided by the given {@code Reader} in to the give type of
   * object.
   *
   * @param  aJsonReader {@code Reader} providing JSON string
   * @param  aClass      Type of the object represented by the JSOn string
   *
   * @return object parsed from the JSON string
   */
  public <T> T fromJson(Reader aJsonReader, Class<T> aClass);


  /**
   * method to convert given object into JSON string.
   *
   * @param  aObj Object that needs to converted to JSON string
   *
   * @return String JSON string
   */
  public String toJson(Object aObj);
}
