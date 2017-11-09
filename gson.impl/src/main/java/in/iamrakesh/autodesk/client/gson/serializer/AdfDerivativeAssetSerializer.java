package in.iamrakesh.autodesk.client.gson.serializer;

import com.google.gson.*;

import in.iamrakesh.autodesk.model.manifest.*;
import in.iamrakesh.autodesk.model.manifest.impl.*;

import java.lang.reflect.*;

/**
 * {@link JsonDeserializer} implementation to de-serialize JSON string into {@code
 * AdfDerivativeAsset}. As models have generic collections of type {@code IAdfDerivativeAsset}, we
 * need this de-serializer configured for Google GSON API to de-serialize models correctly.
 */
public class AdfDerivativeAssetSerializer implements JsonDeserializer<IAdfDerivativeAsset>
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public IAdfDerivativeAsset deserialize(JsonElement aJson, Type aTargetType, JsonDeserializationContext aContext) throws JsonParseException
  {
    return aContext.deserialize(aJson, AdfDerivativeAsset.class);
  }
}
