package in.rakesh.autodesk.client.rest.request.impl;

import in.rakesh.autodesk.client.rest.*;

/**
 * REST session implementation which hold access token, 'expires in' and other related information
 */
public final class AdfRestSession implements IAdfRestSession
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private final long createdOn;

  private long expiresAt = -1;

  private long expiresIn; // in seconds

  private String accessToken;

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new AdfRestSession object.
   */
  public AdfRestSession()
  {
    this.createdOn = System.currentTimeMillis();
  }

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public String getAccessToken()
  {
    return this.accessToken;
  }


  /**
   * {@inheritDoc}
   */
  @Override public long getExpiresAt()
  {
    if (this.expiresAt == -1)
    {
      this.expiresAt = this.createdOn + (this.expiresIn * 1000);
    }
    return this.expiresAt;
  }


  /**
   * {@inheritDoc}
   */
  @Override public boolean isExpired()
  {
    return (System.currentTimeMillis() - this.getExpiresAt()) >= 0;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String toString()
  {
    return this.getAccessToken();
  }
}
