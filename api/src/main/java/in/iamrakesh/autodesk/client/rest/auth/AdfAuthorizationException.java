package in.iamrakesh.autodesk.client.rest.auth;

/**
 * Exception class used to notify that the session is invalid/expired.
 */
public class AdfAuthorizationException extends RuntimeException
{
  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new AdfAuthorizationException object.
   *
   * @param aMessage exception message
   */
  public AdfAuthorizationException(String aMessage)
  {
    super(aMessage);
  }
}
