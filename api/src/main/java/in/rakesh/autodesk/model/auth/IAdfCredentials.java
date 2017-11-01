package in.rakesh.autodesk.model.auth;

import java.util.*;

/**
 * marker interface for AutoDesk Forge credentials used for authentication
 */
public interface IAdfCredentials
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * method returns client id
   *
   * @return String client id
   */
  public String getClientId();


  /**
   * method returns client secret
   *
   * @return String client secret
   */
  public String getClientSecret();


  /**
   * method returns grant type
   *
   * @return String grant type
   */
  public String getGrantType();


  /**
   * method returns collection of scopes
   *
   * @return List collection of scopes
   */
  public List<String> getScope();
}
