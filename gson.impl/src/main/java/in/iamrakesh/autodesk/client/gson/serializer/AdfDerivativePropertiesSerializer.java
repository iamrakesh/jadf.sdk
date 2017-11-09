package in.iamrakesh.autodesk.client.gson.serializer;

import com.google.gson.*;

import in.iamrakesh.autodesk.model.manifest.*;
import in.iamrakesh.autodesk.model.manifest.impl.*;

import java.lang.reflect.*;

/**
 * {@link JsonDeserializer} implementation to de-serialize JSON string into {@code
 * AdfDerivativeProperties}. As models have generic collections of type {@code
 * IAdfDerivativeProperties}, we need this de-serializer configured for Google GSON API to
 * de-serialize models correctly.
 */
public class AdfDerivativePropertiesSerializer implements JsonDeserializer<IAdfDerivativeProperties>
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public IAdfDerivativeProperties deserialize(JsonElement aJson, Type aTargetType, JsonDeserializationContext aContext) throws JsonParseException
  {
    return aContext.deserialize(aJson, AdfDerivativeProperties.class);
  }
}
