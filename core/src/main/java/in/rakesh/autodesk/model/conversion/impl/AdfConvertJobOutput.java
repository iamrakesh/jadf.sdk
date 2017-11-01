package in.rakesh.autodesk.model.conversion.impl;

import in.rakesh.autodesk.model.conversion.*;

import java.util.*;

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
