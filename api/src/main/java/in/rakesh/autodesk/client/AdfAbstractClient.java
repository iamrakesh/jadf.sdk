package in.rakesh.autodesk.client;

import in.rakesh.autodesk.client.rest.*;
import in.rakesh.autodesk.client.rest.model.*;

/**
 * Abstract API client implementation which holds basic information, required/used by subclasses.
 */
public abstract class AdfAbstractClient
{
  //~ Static Variables & Initializers --------------------------------------------------------------

  protected static final String NO_SESSION_ERROR_MESSAGE = "No session, need authenticated session to get manifest information.";
  protected static final String ACCEPT_HEADER_NAME = "Accept";
  protected static final String CONTENT_TYPE_HEADER_NAME = "Content-type";
  protected static final String ACCEPT_ENCODING = "Accept-Encoding";

  protected static final INameValue<String> CONTENT_TYPE_OCTET_STREAM_HEADER = new NameValue<>(CONTENT_TYPE_HEADER_NAME, "application/octet-stream");
  protected static final INameValue<String> CONTENT_TYPE_FORM_HEADER = new NameValue<>(CONTENT_TYPE_HEADER_NAME, "application/x-www-form-urlencoded");
  protected static final INameValue<String> ACCEPT_JSON_HEADER = new NameValue<>(ACCEPT_HEADER_NAME, "application/vnd.api+json, application/json");
  protected static final INameValue<String> ACCEPT_OCTET_STREAM_HEADER = new NameValue<>(ACCEPT_HEADER_NAME, "application/octet-stream");
  protected static final INameValue<String> CONTENT_TYPE_JSON_HEADER = new NameValue<>(CONTENT_TYPE_HEADER_NAME, "application/json");
  protected static final INameValue<String> CONTENT_ENCODING = new NameValue<>(ACCEPT_ENCODING, "gzip, deflate");

  //~ Instance Variables ---------------------------------------------------------------------------

  private final IAdfRestClient restClient;

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new AdfAbstractClient object.
   *
   * @param aRestClient {@code IAdfRestClient}
   */
  public AdfAbstractClient(IAdfRestClient aRestClient)
  {
    this.restClient = aRestClient;
  }

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * method returns {@link IAdfRestClient}, which can be used to make REST calls to AutoDesk Forge
   * server.
   *
   * @return REST API client {@link IAdfRestClient}
   */
  protected final IAdfRestClient getRestClient()
  {
    return restClient;
  }
}
