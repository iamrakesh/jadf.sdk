package in.rakesh.autodesk.client.resteasy;

import in.rakesh.autodesk.client.factory.*;
import in.rakesh.autodesk.client.rest.*;
import in.rakesh.autodesk.client.rest.entity.*;
import in.rakesh.autodesk.client.rest.entity.impl.*;
import in.rakesh.autodesk.client.rest.impl.*;
import in.rakesh.autodesk.client.rest.model.*;
import in.rakesh.autodesk.client.rest.request.*;
import in.rakesh.autodesk.client.rest.request.impl.*;

import org.jboss.resteasy.client.jaxrs.*;
import org.slf4j.*;

import javax.ws.rs.client.*;
import javax.ws.rs.client.Invocation.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.*;

import java.util.*;

/**
 * RestEasy library implementation of {@link AdfAbstractRestClient}
 */
public class AdfRestEasyRestClient extends AdfAbstractRestClient
{
  //~ Static Variables & Initializers --------------------------------------------------------------

  private static final Logger LOG = LoggerFactory.getLogger(AdfRestEasyRestClient.class);

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new AdfRestEasyRestClient object.
   *
   * @param aBaseUrl String base URL for REST calls
   */
  public AdfRestEasyRestClient(String aBaseUrl)
  {
    super(aBaseUrl);
  }

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public <T, R> IAdfRestResponse<R> request(String aUrl, IAdfRestRequest<T> aRequest, Class<R> aResponseType) throws AdfRestException
  {
    ResteasyClient client = new ResteasyClientBuilder().register(AdfJsonSerializerFactory.getInstance().getRestProviderClass()).build();
    ResteasyWebTarget target = client.target(aUrl);

    Builder requestBuilder = target.request();
    setHeaders(requestBuilder, aRequest.getHeaders());

    Response response;
    if (!aRequest.allowsRequestBody())
    {
      response = requestBuilder.method(aRequest.getMethod().name());
    }
    else
    {
      IAdfRestEntityBuilder<T> entityBuilder = aRequest.getEntityBuilder();
      T bodyData = aRequest.getBodyData();

      response = request(requestBuilder, entityBuilder, bodyData, aRequest.getMethod().name());
    }

    Status status = Status.fromStatusCode(response.getStatus());
    MultivaluedMap<String, Object> headers = response.getHeaders();

    if (status == Status.OK)
    {
      return new AdfRestResponse<>(status, headers, response.readEntity(aResponseType));
    }

    if (LOG.isDebugEnabled())
    {
      LOG.debug("REST call failed with status '" + status + "', entity '" + response.getEntity() + "'.");
    }

    return new AdfRestResponse<>(status, headers, null, response.readEntity(String.class));
  }


  /**
   * method to make a REST call using the given information
   *
   * @param  aRequestBuilder {@code Builder} request builder
   * @param  aEntityBuilder  {@code Entity} builder
   * @param  aBodyData       request body data
   * @param  aMethod         request method
   *
   * @return {@link Response} REST call response
   *
   * @throws AdfRestException When the REST call fails
   */
  private <T> Response request(Builder aRequestBuilder, IAdfRestEntityBuilder<T> aEntityBuilder, T aBodyData, String aMethod) throws AdfRestException
  {
    if (aEntityBuilder == null)
    {
      aEntityBuilder = new AdfDefaultRestEntityBuilder<>();
    }

    Entity<?> entity = aEntityBuilder.createEntity(aBodyData);
    assert entity != null : "Entity to make REST api call cannot be NULL.";

    return aRequestBuilder.method(aMethod, entity);
  }


  /**
   * method to set all given headers, to the given {@link Builder} including 'Authorization' header
   * if there is session available.
   *
   * @param aRequestBuilder {@link Builder} request builder
   * @param aHeaders        Set<INameValue> request headers collection
   */
  private void setHeaders(Builder aRequestBuilder, Set<INameValue<String>> aHeaders)
  {
    IAdfRestSession adfSession = this.getAdfSession();
    if (adfSession != null)
    {
      aRequestBuilder.header("Authorization", "Bearer " + adfSession.getAccessToken());
    }

    for (INameValue<String> header : aHeaders)
    {
      aRequestBuilder.header(header.getName(), header.getValue());
    }
  }
}
