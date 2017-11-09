package in.iamrakesh.autodesk.model.manifest.impl;

import in.iamrakesh.autodesk.model.manifest.*;

/**
 * AdfPrintSetting
 */
public class AdfPrintSetting implements IAdfPrintSetting
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private String layout;
  private String paperSize;

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public String getLayout()
  {
    return layout;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getPaperSize()
  {
    return paperSize;
  }


  /**
   * setLayout
   *
   * @param aLayout
   */
  public void setLayout(String aLayout)
  {
    this.layout = aLayout;
  }


  /**
   * setPaperSize
   *
   * @param aPaperSize
   */
  public void setPaperSize(String aPaperSize)
  {
    this.paperSize = aPaperSize;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String toString()
  {
    StringBuilder sb = new StringBuilder();

    sb.append("Layout: ").append(this.layout).append("\n");
    sb.append("Paper size: ").append(this.paperSize).append("\n");

    return sb.toString();
  }
}
