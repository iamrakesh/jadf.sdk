package in.iamrakesh.autodesk.client.rest.request;

import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.*;

/**
 * Marker interface to hold HTTP response information
 */
public interface IAdfRestResponse<T>
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * method returns parsed response data
   *
   * @return T parsed response data can be NULL
   */
  public T getData();


  /**
   * method returns response body as string, which is read in case of HTTP error responses.
   *
   * @return String response body as string can be NULL
   */
  public String getErrorResponse();


  /**
   * method returns {@code MultivaluedMap<String, Object>} response headers
   *
   * @return MultivaluedMap response headers
   */
  public MultivaluedMap<String, Object> getHeaders();


  /**
   * method returns {@link Status} HTTP response status
   *
   * @return Status HTTP response status
   */
  public Status getStatus();
}
