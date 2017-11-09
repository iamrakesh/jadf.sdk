package in.iamrakesh.autodesk.client.rest.request.impl;

import in.iamrakesh.autodesk.client.rest.request.*;

/**
 * Request body wrapper implementation which hold data that needs to be sent as request body
 */
public class AdfRequestBody<T> implements IAdfRequestBody<T>
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private T data;

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  public final T getData()
  {
    return data;
  }


  /**
   * method to set data that needs to be used as REST request body
   *
   * @param aData the data to set as request body
   */
  public final void setData(T aData)
  {
    this.data = aData;
  }
}
