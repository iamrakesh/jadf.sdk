package in.iamrakesh.autodesk.client.impl;

import java.util.*;

import in.iamrakesh.autodesk.client.*;

/**
 * Class holding configuration to be used for AutoDesk Forge API calls.
 */
public final class AdfConfig implements IAdfConfig
{
  //~ Static Variables & Initializers --------------------------------------------------------------

  private static final String DEF_BASE_URL = "https://developer.api.autodesk.com/";

  private static final String BASE_URL_KEY = "autodesk.api.base.url";
  private static final String ROOT_FOLDER_KEY = "root.folder";

  private static final String CLIENT_ID_KEY = "autodesk.client.id";

  private static final String CLIENT_SECRET_KEY = "autodesk.client.sceret";

  private static final String CLIENT_SCOPES_KEY = "autodesk.client.scopes";

  //~ Instance Variables ---------------------------------------------------------------------------

  private List<String> scopes;

  private final Map<String, String> config;

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new AdfConfig object.
   *
   * @param aConfig Map configuration
   */
  public AdfConfig(Map<String, String> aConfig)
  {
    assert aConfig != null : "Configuration cannot be NULL";
    this.config = aConfig;
  }

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public String getBaseUrl()
  {
    String baseUrl = this.config.get(BASE_URL_KEY);
    if (baseUrl != null)
    {
      return baseUrl;
    }
    return DEF_BASE_URL;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getClientId()
  {
    String clientId = this.config.get(CLIENT_ID_KEY);
    if (clientId == null)
    {
      throw new IllegalArgumentException("Autodesk client id is not configured.");
    }
    return clientId;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getClientSecret()
  {
    String clientSecret = this.config.get(CLIENT_SECRET_KEY);
    if (clientSecret == null)
    {
      throw new IllegalArgumentException("Autodesk client secret is not configured.");
    }
    return clientSecret;
  }


  /**
   * {@inheritDoc}
   */
  public final Map<String, String> getConfig()
  {
    return Collections.unmodifiableMap(config);
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getRootFolder()
  {
    String rootFolder = this.config.get(ROOT_FOLDER_KEY);
    if (rootFolder == null)
    {
      throw new IllegalArgumentException("Root folder is not configured.");
    }
    return rootFolder;
  }


  /**
   * {@inheritDoc}
   */
  @Override public List<String> getScopes()
  {
    if (this.scopes != null)
    {
      return this.scopes;
    }

    String scopesString = this.config.get(CLIENT_SCOPES_KEY);
    if (scopesString == null)
    {
      throw new IllegalArgumentException("Autodesk client secret is not configured.");
    }

    this.scopes = Arrays.asList(scopesString.split(","));
    return this.scopes;
  }
}
