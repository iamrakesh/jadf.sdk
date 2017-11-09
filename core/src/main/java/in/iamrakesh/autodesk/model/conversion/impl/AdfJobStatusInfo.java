package in.iamrakesh.autodesk.model.conversion.impl;

import in.iamrakesh.autodesk.model.conversion.*;

/**
 * AdfJobStatusInfo
 */
public final class AdfJobStatusInfo implements IAdfJobStatusInfo
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private String result;
  private String urn;

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public String getResult()
  {
    return result;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getUrn()
  {
    return urn;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aResult the result to set
   */
  public void setResult(String aResult)
  {
    this.result = aResult;
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


  /**
   * {@inheritDoc}
   */
  @Override public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("Urn: ").append(this.urn) //
      .append(", Result: ").append(this.result);
    return sb.toString();
  }
}
