package in.iamrakesh.autodesk.client.rest.entity.impl;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

import in.iamrakesh.autodesk.client.io.*;
import in.iamrakesh.autodesk.client.rest.*;
import in.iamrakesh.autodesk.client.rest.entity.*;

import java.io.*;

/**
 * {@link IAdfRestEntityBuilder} implementation which supports handling "octet-stream" request and
 * responses of REST calls.
 */
public class AdfStreamEntityBuilder extends AdfDefaultRestEntityBuilder<IFileData>
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public Entity<?> createEntity(IFileData aBodyData) throws AdfRestException
  {
    try
    {
      return Entity.entity(aBodyData.getInputStream(), MediaType.APPLICATION_OCTET_STREAM_TYPE);
    }
    catch (FileNotFoundException e)
    {
      throw new AdfRestException("Input file for multipart request is not found.", e);
    }
  }
}
