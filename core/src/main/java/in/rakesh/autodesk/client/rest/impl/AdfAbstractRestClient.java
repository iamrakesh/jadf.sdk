package in.rakesh.autodesk.client.rest.impl;

import in.rakesh.autodesk.client.rest.*;
import in.rakesh.autodesk.client.rest.auth.*;
import in.rakesh.autodesk.client.rest.auth.impl.*;
import in.rakesh.autodesk.client.rest.model.*;
import in.rakesh.autodesk.client.rest.request.*;
import in.rakesh.autodesk.model.auth.*;

/**
 * Abstract implementation of {@link IAdfRestClient}, which can be extended to use any JaxRS
 * implementation library.
 */
public abstract class AdfAbstractRestClient implements IAdfRestClient
{
  //~ Static Variables & Initializers --------------------------------------------------------------

  private static final String AUTH_URI = "/authentication/v1/authenticate";

  //~ Instance Variables ---------------------------------------------------------------------------

  private IAdfAuthenticator authenticator;

  private IAdfRestSession session;

  private final String baseUrl;

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new AdfRestClient object.
   *
   * @param aBaseUrl Base URL to use while making REST calls
   */
  public AdfAbstractRestClient(String aBaseUrl)
  {
    assert aBaseUrl != null : "Autodesk API base URL cannot be NULL";

    this.baseUrl = aBaseUrl;
  }

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public final IAdfRestSession authenticate(IAdfCredentials aCredentials) throws AdfRestException
  {
    this.session = this.getAuthenticator().authenticate(aCredentials);
    return this.session;
  }


  /**
   * {@inheritDoc}
   */
  @Override public final <T, R> IAdfRestResponse<R> delete(String aUri, IAdfRestRequest<T> aRequest, Class<R> aResponseType) throws AdfRestException
  {
    aRequest.setMethod(AdfRequestMethod.DELETE);
    return this.request(this.baseUrl + aUri, aRequest, aResponseType);
  }


  /**
   * {@inheritDoc}
   */
  @Override public final <T, R> IAdfRestResponse<R> get(String aUri, IAdfRestRequest<T> aRequest, Class<R> aResponseType) throws AdfRestException
  {
    aRequest.setMethod(AdfRequestMethod.GET);
    return this.request(this.baseUrl + aUri, aRequest, aResponseType);
  }


  /**
   * {@inheritDoc}
   */
  @Override public final IAdfRestSession getAdfSession()
  {
    return this.session;
  }


  /**
   * {@inheritDoc}
   */
  @Override public final IAdfAuthenticator getAuthenticator()
  {
    if (this.authenticator == null)
    {
      this.authenticator = new AdfOAuth2TwoLeggedAuthenticator(this, AUTH_URI);
    }
    return this.authenticator;
  }


  /**
   * {@inheritDoc}
   */
  @Override public final boolean hasSession()
  {
    IAdfRestSession adfSession = this.getAdfSession();
    return (adfSession != null) && !adfSession.isExpired();
  }


  /**
   * {@inheritDoc}
   */
  @Override public final <T, R> IAdfRestResponse<R> patch(String aUri, IAdfRestRequest<T> aRequest, Class<R> aResponseType) throws AdfRestException
  {
    aRequest.setMethod(AdfRequestMethod.PATCH);
    return this.request(this.baseUrl + aUri, aRequest, aResponseType);
  }


  /**
   * {@inheritDoc}
   */
  @Override public final <T, R> IAdfRestResponse<R> post(String aUri, IAdfRestRequest<T> aRequest, Class<R> aResponseType) throws AdfRestException
  {
    aRequest.setMethod(AdfRequestMethod.POST);
    return this.request(this.baseUrl + aUri, aRequest, aResponseType);
  }


  /**
   * {@inheritDoc}
   */
  @Override public final <T, R> IAdfRestResponse<R> put(String aUri, IAdfRestRequest<T> aRequest, Class<R> aResponseType) throws AdfRestException
  {
    aRequest.setMethod(AdfRequestMethod.PUT);
    return this.request(this.baseUrl + aUri, aRequest, aResponseType);
  }


  /**
   * method returns base URL used for making REST calls
   *
   * @return the baseUrl
   */
  protected final String getBaseUrl()
  {
    return baseUrl;
  }
}
