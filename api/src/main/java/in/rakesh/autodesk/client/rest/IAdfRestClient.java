package in.rakesh.autodesk.client.rest;

import in.rakesh.autodesk.client.rest.auth.*;
import in.rakesh.autodesk.client.rest.request.*;
import in.rakesh.autodesk.model.auth.*;

/**
 * Marker interface to REST API call client.
 */
public interface IAdfRestClient
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * method to authenticate client before making other API calls which request valid session.
   *
   * @param  aCredentials {@link IAdfCredentials} to be used for authentication
   *
   * @return {@link IAdfRestSession} session upon successful authentication
   *
   * @throws AdfRestException When authentication fails
   */
  public IAdfRestSession authenticate(IAdfCredentials aCredentials) throws AdfRestException;


  /**
   * method to make HTTP DELETE call using the given information
   *
   * @param  aUri          URI to which HTTP call need to be made
   * @param  aRequest      {@link IAdfRestRequest} containing request information
   * @param  aResponseType response type Class
   *
   * @return {@link IAdfRestRequest} containing response data
   *
   * @throws AdfRestException When HTTP DELETE request fails
   */
  public <T, R> IAdfRestResponse<R> delete(String aUri, IAdfRestRequest<T> aRequest, Class<R> aResponseType) throws AdfRestException;


  /**
   * method to make HTTP GET request using the given information
   *
   * @param  aUri          URI to which HTTP call need to be made
   * @param  aRequest      {@link IAdfRestRequest} containing request information
   * @param  aResponseType response type Class
   *
   * @return {@link IAdfRestRequest} containing response data
   *
   * @throws AdfRestException When HTTP GET request fails
   */
  public <T, R> IAdfRestResponse<R> get(String aUri, IAdfRestRequest<T> aRequest, Class<R> aResponseType) throws AdfRestException;


  /**
   * method returns {@link IAdfRestSession}, can be NULL, if not authenticated already.
   *
   * @return {@link IAdfRestSession} can be NULL, if not authenticated
   */
  public IAdfRestSession getAdfSession();


  /**
   * method returns {@link IAdfAuthenticator} to be used for authentication.
   *
   * @return {@link IAdfAuthenticator}
   */
  public IAdfAuthenticator getAuthenticator();


  /**
   * method returns 'true' if there is valid session available already, 'false' otherwise.
   *
   * @return boolean
   */
  public boolean hasSession();


  /**
   * method to make HTTP PUT call using the given information
   *
   * @param  aUri          URI to which HTTP call need to be made
   * @param  aRequest      {@link IAdfRestRequest} containing request information
   * @param  aResponseType response type Class
   *
   * @return {@link IAdfRestRequest} containing response data
   *
   * @throws AdfRestException When HTTP PUT request fails
   */
  public <T, R> IAdfRestResponse<R> patch(String aUri, IAdfRestRequest<T> aRequest, Class<R> aResponseType) throws AdfRestException;


  /**
   * method to make HTTP POST call using the given information
   *
   * @param  aUri          URI to which HTTP call need to be made
   * @param  aRequest      {@link IAdfRestRequest} containing request information
   * @param  aResponseType response type Class
   *
   * @return {@link IAdfRestRequest} containing response data
   *
   * @throws AdfRestException When HTTP POST request fails
   */
  public <T, R> IAdfRestResponse<R> post(String aUri, IAdfRestRequest<T> aRequest, Class<R> aResponseType) throws AdfRestException;


  /**
   * method to make HTTP PUT call using the given information
   *
   * @param  aUri          URI to which HTTP call need to be made
   * @param  aRequest      {@link IAdfRestRequest} containing request information
   * @param  aResponseType response type Class
   *
   * @return {@link IAdfRestRequest} containing response data
   *
   * @throws AdfRestException When HTTP PUT request fails
   */
  public <T, R> IAdfRestResponse<R> put(String aUri, IAdfRestRequest<T> aRequest, Class<R> aResponseType) throws AdfRestException;


  /**
   * method to make HTTP request using the given information
   *
   * @param  aUri          URI to which HTTP call need to be made
   * @param  aRequest      {@link IAdfRestRequest} containing request information
   * @param  aResponseType response type Class
   *
   * @return {@link IAdfRestRequest} containing response data
   *
   * @throws AdfRestException When HTTP request fails
   */
  public <T, R> IAdfRestResponse<R> request(String aUri, IAdfRestRequest<T> aRequest, Class<R> aResponseType) throws AdfRestException;
}
