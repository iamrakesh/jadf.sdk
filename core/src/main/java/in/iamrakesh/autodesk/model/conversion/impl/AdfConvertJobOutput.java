package in.iamrakesh.autodesk.model.conversion.impl;

import java.util.*;

import in.iamrakesh.autodesk.model.conversion.*;

/**
 * AdfConvertJobOutput
 */
public final class AdfConvertJobOutput implements IAdfConvertJobOutput
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private List<IAdfConvertJobFormat> formats;

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param aFormat formats the formats to set
   */
  public void addFormat(IAdfConvertJobFormat aFormat)
  {
    if (this.formats == null)
    {
      this.formats = new ArrayList<>();
    }
    this.formats.add(aFormat);
  }


  /**
   * {@inheritDoc}
   */
  @Override public List<IAdfConvertJobFormat> getFormats()
  {
    if (this.formats == null)
    {
      return Collections.emptyList();
    }
    return this.formats;
  }
}
