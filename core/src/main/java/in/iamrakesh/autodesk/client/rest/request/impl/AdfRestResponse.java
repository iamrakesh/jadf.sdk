package in.iamrakesh.autodesk.client.rest.request.impl;

import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.*;

import in.iamrakesh.autodesk.client.rest.request.*;

/**
 * REST response wrapper implementation which hold response status, data, headers and error when
 * request fails.
 */
public final class AdfRestResponse<T> implements IAdfRestResponse<T>
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private final MultivaluedMap<String, Object> headers;
  private final Status status;

  private final String errorResponse;
  private final T data;

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new AdfRestResponse object.
   *
   * @param aStatus  Status
   * @param aHeaders MultivaluedMap response headers
   * @param aData    response data
   */
  public AdfRestResponse(Status aStatus, MultivaluedMap<String, Object> aHeaders, T aData)
  {
    this(aStatus, aHeaders, aData, null);
  }


  /**
   * Creates a new AdfRestResponse object.
   *
   * @param aStatus        Status response status
   * @param aHeaders       MultivaluedMap response headers
   * @param aData          response data
   * @param aErrorResponse Error response
   */
  public AdfRestResponse(Status aStatus, MultivaluedMap<String, Object> aHeaders, T aData, String aErrorResponse)
  {
    this.status = aStatus;
    this.headers = aHeaders;
    this.data = aData;
    this.errorResponse = aErrorResponse;
  }

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public T getData()
  {
    return this.data;
  }


  /**
   * {@inheritDoc}
   */
  public String getErrorResponse()
  {
    return errorResponse;
  }


  /**
   * {@inheritDoc}
   */
  @Override public MultivaluedMap<String, Object> getHeaders()
  {
    return this.headers;
  }


  /**
   * {@inheritDoc}
   */
  @Override public Status getStatus()
  {
    return this.status;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String toString()
  {
    StringBuilder sb = new StringBuilder();

    sb.append("Status: ").append(this.status) //
      .append(", data: ").append(this.data) //
      .append(", error: ").append(this.errorResponse);

    return sb.toString();
  }
}
