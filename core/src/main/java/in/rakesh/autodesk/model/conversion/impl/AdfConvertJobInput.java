package in.rakesh.autodesk.model.conversion.impl;

import in.rakesh.autodesk.model.conversion.*;

/**
 * AdfConvertJobInput
 */
public final class AdfConvertJobInput implements IAdfConvertJobInput
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private boolean compressedUrn;
  private String rootFileName;
  private String urn;

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public String getRootFileName()
  {
    return rootFileName;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getUrn()
  {
    return this.urn;
  }


  /**
   * {@inheritDoc}
   */
  @Override public boolean isCompressedUrn()
  {
    return this.compressedUrn;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aCompressedUrn the compressedUrn to set
   */
  public void setCompressedUrn(boolean aCompressedUrn)
  {
    this.compressedUrn = aCompressedUrn;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aRootFileName the rootFileName to set
   */
  public void setRootFileName(String aRootFileName)
  {
    this.rootFileName = aRootFileName;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aUrn the urn to set
   */
  public void setUrn(String aUrn)
  {
    this.urn = aUrn;
  }
}
