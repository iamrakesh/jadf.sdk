package in.rakesh.autodesk.client.rest;

import in.rakesh.autodesk.client.rest.request.*;
import in.rakesh.autodesk.model.conversion.*;

import javax.ws.rs.core.Response.*;

/**
 * Exception used for all types of REST call failures
 */
public class AdfRestException extends Exception
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private IAdfRestResponse<? extends IAdfJobStatusInfo> response;

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new AdfRestException object.
   *
   * @param aMessage exception message
   */
  public AdfRestException(String aMessage)
  {
    super(aMessage);
  }


  /**
   * Creates a new AdfRestException object.
   *
   * @param aMessage  exception message
   * @param aResponse Adf REST call response
   */
  public AdfRestException(String aMessage, IAdfRestResponse<? extends IAdfJobStatusInfo> aResponse)
  {
    super(aMessage);

    this.response = aResponse;
  }


  /**
   * Creates a new AdfRestException object.
   *
   * @param aMessage exception message
   * @param aCause   exception cause
   */
  public AdfRestException(String aMessage, Throwable aCause)
  {
    super(aMessage, aCause);
  }

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * getErrorResponse
   *
   * @return response body as string can be NULL
   */
  public final String getErrorResponse()
  {
    return (this.response == null) ? null : this.response.getErrorResponse();
  }


  /**
   * getStatus: status returned by the caller which resulted in the exception
   *
   * @return Status HTTP response status, can be NULL
   */
  public Status getStatus()
  {
    return (this.response == null) ? null : this.response.getStatus();
  }
}
