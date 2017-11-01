package in.rakesh.autodesk.model.conversion.impl;

import in.rakesh.autodesk.model.*;
import in.rakesh.autodesk.model.conversion.*;

import java.util.*;

/**
 * AdfConvertJobFormat
 */
public final class AdfConvertJobFormat implements IAdfConvertJobFormat
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private FileType type;
  private IAdfAdvancedConvertJob advanced;
  private List<ViewType> views;

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param aView the views to set
   */
  public void addView(ViewType aView)
  {
    if (this.views == null)
    {
      this.views = new ArrayList<>();
    }
    this.views.add(aView);
  }


  /**
   * {@inheritDoc}
   */
  @Override public IAdfAdvancedConvertJob getAdvanced()
  {
    return this.advanced;
  }


  /**
   * {@inheritDoc}
   */
  @Override public FileType getType()
  {
    return this.type;
  }


  /**
   * {@inheritDoc}
   */
  @Override public List<ViewType> getViews()
  {
    if (this.views == null)
    {
      return Collections.emptyList();
    }
    return this.views;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aAdvanced the advanced to set
   */
  public void setAdvanced(IAdfAdvancedConvertJob aAdvanced)
  {
    this.advanced = aAdvanced;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aType the fileType to set
   */
  public void setType(FileType aType)
  {
    this.type = aType;
  }
}
