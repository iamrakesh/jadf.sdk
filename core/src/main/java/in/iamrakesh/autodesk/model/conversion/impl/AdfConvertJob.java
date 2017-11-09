package in.iamrakesh.autodesk.model.conversion.impl;

import in.iamrakesh.autodesk.model.conversion.*;

/**
 * AdfConvertJob
 */
public final class AdfConvertJob implements IAdfConvertJob
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private IAdfConvertJobInput input;

  private IAdfConvertJobOutput output;

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public IAdfConvertJobInput getInput()
  {
    return this.input;
  }


  /**
   * {@inheritDoc}
   */
  @Override public IAdfConvertJobOutput getOutput()
  {
    return this.output;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aInput the input to set
   */
  public void setInput(IAdfConvertJobInput aInput)
  {
    this.input = aInput;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aOutput the output to set
   */
  public void setOutput(IAdfConvertJobOutput aOutput)
  {
    this.output = aOutput;
  }
}
