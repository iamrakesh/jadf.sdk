package in.rakesh.autodesk.client.rest.request;

import in.rakesh.autodesk.client.rest.entity.*;
import in.rakesh.autodesk.client.rest.model.*;

import javax.ws.rs.client.*;

import java.util.*;

/**
 * Marker interface to hold REST request information
 */
public interface IAdfRestRequest<T>
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * method return 'true' if the current HTTP request method allows request body, 'false' otherwise
   *
   * @return boolean
   */
  public boolean allowsRequestBody();


  /**
   * method returns request body data
   *
   * @return T request body data
   */
  public T getBodyData();


  /**
   * method returns {@link IAdfRestEntityBuilder} which will be used to create REST {@link Entity}.
   *
   * @return {@link IAdfRestEntityBuilder}
   */
  public IAdfRestEntityBuilder<T> getEntityBuilder();


  /**
   * method returns {@code Set<INameValue<String>>} containing name/value pairs to be set as request
   * headers.
   *
   * @return Set request header
   */
  public Set<INameValue<String>> getHeaders();


  /**
   * method returns {@link AdfRequestMethod} to be used for this HTTP request
   *
   * @return {@link AdfRequestMethod} request method
   */
  public AdfRequestMethod getMethod();


  /**
   * method to set HTTP request method for the current request
   *
   * @param aMethod {@link AdfRequestMethod} request method
   */
  public void setMethod(AdfRequestMethod aMethod);
}
