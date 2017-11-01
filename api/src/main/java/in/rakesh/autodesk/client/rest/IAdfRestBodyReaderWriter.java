package in.rakesh.autodesk.client.rest;

import javax.ws.rs.ext.*;

/**
 * marker interface for REST message body reader/writer implementations
 */
public interface IAdfRestBodyReaderWriter extends MessageBodyReader<Object>, MessageBodyWriter<Object>
{
}
