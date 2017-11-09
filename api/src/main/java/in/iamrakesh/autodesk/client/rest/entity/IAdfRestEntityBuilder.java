package in.iamrakesh.autodesk.client.rest.entity;

import javax.ws.rs.client.*;

import in.iamrakesh.autodesk.client.rest.AdfRestException;

/**
 * Marker interface for REST {@link Entity} builders.
 */
public interface IAdfRestEntityBuilder<T>
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * method to create REST {@link Entity}, which can be used to make request and parse responses for
   * REST calls.
   *
   * @param  aBodyData T data to be used for {@code Entity} creation
   *
   * @return {@link Entity} REST entity
   *
   * @throws AdfRestException When REST entity creation fails
   */
  public Entity<?> createEntity(T aBodyData) throws AdfRestException;
}
