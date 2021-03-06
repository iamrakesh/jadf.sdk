package in.iamrakesh.autodesk.client.rest.auth;

import in.iamrakesh.autodesk.client.rest.*;
import in.iamrakesh.autodesk.model.auth.*;

/**
 * Marker interface to support multiple authentication types
 */
public interface IAdfAuthenticator
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * method to authenticate using the given credentials {@link IAdfCredentials}.
   *
   * @param  aCredentials {@link IAdfCredentials} credentials for authentication
   *
   * @return {@link IAdfRestSession} session information upon successful authentication
   *
   * @throws AdfRestException When authentication fails
   */
  public IAdfRestSession authenticate(IAdfCredentials aCredentials) throws AdfRestException;
}
