package in.rakesh.autodesk.client.rest.request;

/**
 * marker interface to abstract REST request body
 */
public interface IAdfRequestBody<T>
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * method returns data to be used as request body
   *
   * @return T REST request body
   */
  public T getData();
}
