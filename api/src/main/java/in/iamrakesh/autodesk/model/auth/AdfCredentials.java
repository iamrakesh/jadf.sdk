package in.iamrakesh.autodesk.model.auth;

import java.util.*;

/**
 * model class holding credentials for AutoDesk Forge authentication
 */
public class AdfCredentials implements IAdfCredentials
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private final List<String> scopes;

  private final String clientId;

  private final String clientSecret;

  private final String grantType = "client_credentials";

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new AdfCredentials object.
   *
   * @param aClientId     String client id
   * @param aClientSecret String client secret
   * @param aScopes       List scope collection
   */
  public AdfCredentials(String aClientId, String aClientSecret, List<String> aScopes)
  {
    this.clientId = aClientId;
    this.clientSecret = aClientSecret;
    this.scopes = aScopes;
  }

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public String getClientId()
  {
    return this.clientId;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getClientSecret()
  {
    return this.clientSecret;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getGrantType()
  {
    return this.grantType;
  }


  /**
   * {@inheritDoc}
   */
  @Override public List<String> getScope()
  {
    return this.scopes;
  }
}
