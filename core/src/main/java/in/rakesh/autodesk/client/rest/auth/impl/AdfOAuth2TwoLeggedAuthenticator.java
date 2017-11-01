package in.rakesh.autodesk.client.rest.auth.impl;

import in.rakesh.autodesk.client.rest.*;
import in.rakesh.autodesk.client.rest.auth.*;
import in.rakesh.autodesk.client.rest.request.*;
import in.rakesh.autodesk.client.rest.request.impl.*;
import in.rakesh.autodesk.model.auth.*;

import org.slf4j.*;

import javax.ws.rs.core.Response.*;

/**
 * Two legged authentication implementation for AutoDesk Forge API
 */
public class AdfOAuth2TwoLeggedAuthenticator implements IAdfAuthenticator
{
  //~ Static Variables & Initializers --------------------------------------------------------------

  private static final Logger LOG = LoggerFactory.getLogger(AdfOAuth2TwoLeggedAuthenticator.class);

  //~ Instance Variables ---------------------------------------------------------------------------

  private final IAdfRestClient restClient;
  private final String authUri;

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new AdfOAuth2TwoLeggedAuthenticator object.
   *
   * @param aRestClient {@link IAdfRestClient} client to make REST calls
   * @param aAuthUri    URI to be used for authentication
   */
  public AdfOAuth2TwoLeggedAuthenticator(IAdfRestClient aRestClient, String aAuthUri)
  {
    this.authUri = aAuthUri;
    this.restClient = aRestClient;
  }

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public IAdfRestSession authenticate(IAdfCredentials aCredentials) throws AdfRestException
  {
    if (LOG.isDebugEnabled())
    {
      LOG.debug("Authenticating using client id: " + aCredentials.getClientId());
    }

    AdfRequestBody<IAdfCredentials> body = new AdfRequestBody<>();
    body.setData(aCredentials);

    AdfRestRequest<IAdfCredentials> request = new AdfRestRequest<>();
    request.setBody(body);
    request.setEntityBuilder(new AdfCredentialsFormEntityBuilder());

    IAdfRestResponse<AdfRestSession> response = this.restClient.post(this.authUri, request, AdfRestSession.class);
    if (response.getStatus() == Status.OK)
    {
      return response.getData();
    }

    if (LOG.isDebugEnabled())
    {
      LOG.debug("Failed to authenticate client with id - " + aCredentials.getClientId() + "\n" + response);
    }
    throw new AdfRestException("Authentication failed - " + response);
  }
}
