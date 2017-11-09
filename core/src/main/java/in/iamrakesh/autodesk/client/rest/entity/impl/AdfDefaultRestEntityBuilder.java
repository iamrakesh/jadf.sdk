package in.iamrakesh.autodesk.client.rest.entity.impl;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

import in.iamrakesh.autodesk.client.rest.*;
import in.iamrakesh.autodesk.client.rest.entity.*;

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
