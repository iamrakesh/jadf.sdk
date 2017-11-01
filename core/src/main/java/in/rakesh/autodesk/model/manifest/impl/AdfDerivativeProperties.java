package in.rakesh.autodesk.model.manifest.impl;

import in.rakesh.autodesk.model.manifest.*;

/**
 * AdfDerivativeProperties
 */
public class AdfDerivativeProperties implements IAdfDerivativeProperties
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private IAdfPrintSetting printSetting;

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public IAdfPrintSetting getPrintSetting()
  {
    return printSetting;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aPrintSetting DOCUMENT ME!
   */
  public void setPrintSetting(IAdfPrintSetting aPrintSetting)
  {
    this.printSetting = aPrintSetting;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String toString()
  {
    StringBuilder sb = new StringBuilder();

    sb.append("Print Setting: ").append(this.printSetting).append("\n");

    return sb.toString();
  }
}
