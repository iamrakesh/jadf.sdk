package in.iamrakesh.autodesk.client.gson.serializer;

import com.google.gson.*;

import in.iamrakesh.autodesk.model.bucket.*;
import in.iamrakesh.autodesk.model.bucket.impl.*;

import java.lang.reflect.*;

/**
 * {@link JsonDeserializer} implementation to de-serialize JSON string into {@code AdfBucketAccess}.
 * As models have generic collections of type {@code IAdfBucketAccess}, we need this de-serializer
 * configured for Google GSON API to de-serialize models correctly.
 */
public class AdfBucketAccessSerializer implements JsonDeserializer<IAdfBucketAccess>
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public IAdfBucketAccess deserialize(JsonElement aJson, Type aTargetType, JsonDeserializationContext aContext) throws JsonParseException
  {
    return aContext.deserialize(aJson, AdfBucketAccess.class);
  }
}
