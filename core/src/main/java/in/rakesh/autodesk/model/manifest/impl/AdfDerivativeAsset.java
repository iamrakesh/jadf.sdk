package in.rakesh.autodesk.model.manifest.impl;

import in.rakesh.autodesk.model.manifest.*;

/**
 * AdfDerivativeAsset
 */
public class AdfDerivativeAsset implements IAdfDerivativeAsset
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private long size;
  private String id;
  private String mime;
  private String type;
  private String uri;

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public String getId()
  {
    return id;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getMime()
  {
    return mime;
  }


  /**
   * {@inheritDoc}
   */
  @Override public long getSize()
  {
    return size;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getType()
  {
    return type;
  }


  /**
   * {@inheritDoc}
   */
  public String getUri()
  {
    return uri;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aId the id to set
   */
  public void setId(String aId)
  {
    this.id = aId;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aMime the mime to set
   */
  public void setMime(String aMime)
  {
    this.mime = aMime;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aSize the size to set
   */
  public void setSize(long aSize)
  {
    this.size = aSize;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aType the type to set
   */
  public void setType(String aType)
  {
    this.type = aType;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aUri the uri to set
   */
  public void setUri(String aUri)
  {
    this.uri = aUri;
  }
}
