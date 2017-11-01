package in.rakesh.autodesk.client;

import in.rakesh.autodesk.client.rest.*;
import in.rakesh.autodesk.model.auth.*;

/**
 * Client (marker) interface which allows to make AutoDesk Forge API calls.
 */
public interface IAdfClient
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * method to authenticate with AutoDesk forge server, after which using the session one can make
   * api calls.
   *
   * @param  aCredentials Credentials to use for authentication
   *
   * @return IAdfRestSession session object containing details of authentication key and others.
   *
   * @throws AdfRestException when authentication api call fails
   */
  public IAdfRestSession authenticate(IAdfCredentials aCredentials) throws AdfRestException;


  /**
   * method returns {@link IAdfContext} using which one can make AutoDesk Forge API calls.
   *
   * @return IAdfContext context object, to be used for further api calls.
   */
  public IAdfContext getContext();
}
