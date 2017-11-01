package in.rakesh.autodesk.client.rest.entity.impl;

import in.rakesh.autodesk.client.rest.*;
import in.rakesh.autodesk.client.rest.entity.*;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

/**
 * Default implementation of {@link IAdfRestEntityBuilder}, which is capable of handling JSON type
 * request/responses.
 */
public class AdfDefaultRestEntityBuilder<T> implements IAdfRestEntityBuilder<T>
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public Entity<?> createEntity(T aBodyData) throws AdfRestException
  {
    return Entity.entity(aBodyData, MediaType.APPLICATION_JSON);
  }
}
