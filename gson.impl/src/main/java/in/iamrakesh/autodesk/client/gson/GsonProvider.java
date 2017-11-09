package in.iamrakesh.autodesk.client.gson;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.*;

import in.iamrakesh.autodesk.client.rest.*;

import java.io.*;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.nio.charset.*;

/**
 * REST {@link MessageBodyReader} and {@link MessageBodyWriter} implementation which uses Google
 * GSON library.
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Provider public class GsonProvider implements IAdfRestBodyReaderWriter
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private final GsonSerializer serializer;

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new GsonProvider object.
   */
  public GsonProvider()
  {
    this.serializer = new GsonSerializer();
  }

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public long getSize(Object aObj, Class<?> aType, Type aGenericType, Annotation[] aAnnotations, MediaType aMediaType)
  {
    return -1;
  }


  /**
   * {@inheritDoc}
   */
  @Override public boolean isReadable(Class<?> aType, Type aGenericType, Annotation[] aAnnotations, MediaType aMediaType)
  {
    return true;
  }


  /**
   * {@inheritDoc}
   */
  @Override public boolean isWriteable(Class<?> aType, Type aGenericType, Annotation[] aAnnotations, MediaType aMediaType)
  {
    return true;
  }


  /**
   * {@inheritDoc}
   */
  @Override public Object readFrom(Class<Object> aType, Type aGenericType, Annotation[] aAnnotations, MediaType aMediaType, MultivaluedMap<String, String> aHttpHeaders, InputStream aEntityStream) throws IOException, WebApplicationException
  {
    try(InputStreamReader reader = new InputStreamReader(aEntityStream, StandardCharsets.UTF_8))
    {
      return this.serializer.fromJson(reader, aType);
    }
  }


  /**
   * {@inheritDoc}
   */
  @Override public void writeTo(Object aObj, Class<?> aType, Type aGenericType, Annotation[] aAnnotations, MediaType aMediaType, MultivaluedMap<String, Object> aHttpHeaders, OutputStream aEntityStream) throws IOException, WebApplicationException
  {
    try(PrintWriter printWriter = new PrintWriter(aEntityStream))
    {
      String json = this.serializer.toJson(aObj);
      printWriter.write(json);
      printWriter.flush();
    }
  }
}
