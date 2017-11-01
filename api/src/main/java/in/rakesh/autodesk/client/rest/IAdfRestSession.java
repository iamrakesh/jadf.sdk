package in.rakesh.autodesk.client.rest;

/**
 * Marker interface representing AutoDesk Forge REST session.
 */
public interface IAdfRestSession
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * method returns access token which was returned upon successful authentication
   *
   * @return String session access token
   */
  public String getAccessToken();


  /**
   * method returns milliseconds (since 1970), at which the session expires
   *
   * @return long milliseconds at which session expires
   */
  public long getExpiresAt();


  /**
   * method return 'true' if this AutoDesk Forge session has expired, 'false' otherwise.
   *
   * @return boolean 'true' if this session expired, 'false' otherwise
   */
  public boolean isExpired();
}
