package in.rakesh.autodesk.client.rest.request.impl;

import in.rakesh.autodesk.client.rest.*;
import in.rakesh.autodesk.client.rest.entity.*;
import in.rakesh.autodesk.client.rest.model.*;
import in.rakesh.autodesk.client.rest.request.*;

import java.util.*;

/**
 * REST request wrapper implementation which holds request method, body, headers, and other
 * information. Client use instance of this class while making REST calls using {@link
 * IAdfRestClient}.
 */
public class AdfRestRequest<T> implements IAdfRestRequest<T>
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private AdfRequestMethod method;
  private IAdfRequestBody<T> body;

  private IAdfRestEntityBuilder<T> entityBuilder;
  private Set<INameValue<String>> headers;

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * method to add request header
   *
   * @param aHeader INameValue
   */
  public void addHeader(INameValue<String> aHeader)
  {
    if (this.headers == null)
    {
      this.headers = new HashSet<>();
    }
    this.headers.add(aHeader);
  }


  /**
   * {@inheritDoc}
   */
  @Override public boolean allowsRequestBody()
  {
    return (this.method != AdfRequestMethod.GET) //
      && (this.method != AdfRequestMethod.DELETE);
  }


  /**
   * {@inheritDoc}
   */
  @Override public T getBodyData()
  {
    assert this.body != null : "request body cannot be null";
    return this.body.getData();
  }


  /**
   * {@inheritDoc}
   */
  @Override public IAdfRestEntityBuilder<T> getEntityBuilder()
  {
    return this.entityBuilder;
  }


  /**
   * {@inheritDoc}
   */
  @Override public Set<INameValue<String>> getHeaders()
  {
    if (this.headers == null)
    {
      return Collections.emptySet();
    }
    return this.headers;
  }


  /**
   * {@inheritDoc}
   */
  @Override public AdfRequestMethod getMethod()
  {
    if (this.method == null)
    {
      return AdfRequestMethod.GET;
    }
    return this.method;
  }


  /**
   * method to set request body
   *
   * @param aBody {@link IAdfRequestBody} request body
   */
  public void setBody(IAdfRequestBody<T> aBody)
  {
    this.body = aBody;
  }


  /**
   * method to set entity builder
   *
   * @param aEntityBuilder {@link IAdfRestEntityBuilder}
   */
  public void setEntityBuilder(IAdfRestEntityBuilder<T> aEntityBuilder)
  {
    this.entityBuilder = aEntityBuilder;
  }


  /**
   * {@inheritDoc}
   */
  public void setMethod(AdfRequestMethod aMethod)
  {
    this.method = aMethod;
  }
}
