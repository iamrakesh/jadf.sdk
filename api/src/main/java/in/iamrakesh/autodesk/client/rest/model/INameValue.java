package in.iamrakesh.autodesk.client.rest.model;

/**
 * Marker interface to hold name/value pairs.
 */
public interface INameValue<T>
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * method returns name from name/value pair
   *
   * @return name
   */
  public String getName();


  /**
   * method returns value from name/value pair
   *
   * @return value
   */
  public T getValue();
}
