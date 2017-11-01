package in.rakesh.autodesk.client.rest.entity.impl;

import in.rakesh.autodesk.client.rest.*;
import in.rakesh.autodesk.client.rest.entity.*;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

/**
 * Base implementation of {@link IAdfRestEntityBuilder}, which allows creation of {@link Form}, to
 * be used in REST calls.
 */
public abstract class AdfRestFormEntityBuilder<T> extends AdfDefaultRestEntityBuilder<T>
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public Entity<?> createEntity(T aBodyData) throws AdfRestException
  {
    Form form = this.createForm(aBodyData);
    return Entity.form(form);
  }


  /**
   * method creates and return {@link Form}, using the given form data.
   *
   * @param  aBodyData T data to be used to create {@link Form}
   *
   * @return {@link Form} to be used in REST call
   */
  protected abstract Form createForm(T aBodyData);
}
