package in.iamrakesh.autodesk.client;

import java.util.*;

/**
 * Configuration to be used for the API calls.
 */
public interface IAdfConfig
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * method returns base URL of the AutoDesk Forge API server.
   *
   * @return String AutoDesk Forge API server base URL
   */
  public String getBaseUrl();


  /**
   * method returns 'client id' to be used for authentication.
   *
   * @return String autodesk forge client id
   */
  public String getClientId();


  /**
   * method returns 'client secret' key to be used for authentication.
   *
   * @return String autodesk forge client secret key
   */
  public String getClientSecret();


  /**
   * method returns complete configuration as {@code Map<String, String>}
   *
   * @return Map complete configuration
   */
  public Map<String, String> getConfig();


  /**
   * method returns configured 'root folder' value
   *
   * @return String configured root folder
   */
  public String getRootFolder();


  /**
   * method returns 'scopes' to be used while authentication.
   *
   * @return String scopes list collection used while authentication
   */
  public List<String> getScopes();
}
