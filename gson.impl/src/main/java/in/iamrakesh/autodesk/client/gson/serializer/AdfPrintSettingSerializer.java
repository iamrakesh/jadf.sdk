package in.iamrakesh.autodesk.client.gson.serializer;

import com.google.gson.*;

import in.iamrakesh.autodesk.model.manifest.*;
import in.iamrakesh.autodesk.model.manifest.impl.*;

import java.lang.reflect.*;

/**
 * {@link JsonDeserializer} implementation to de-serialize JSON string into {@code AdfPrintSetting}.
 * As models have generic collections of type {@code IAdfPrintSetting}, we need this de-serializer
 * configured for Google GSON API to de-serialize models correctly.
 */
public class AdfPrintSettingSerializer implements JsonDeserializer<IAdfPrintSetting>
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public IAdfPrintSetting deserialize(JsonElement aJson, Type aTargetType, JsonDeserializationContext aContext) throws JsonParseException
  {
    return aContext.deserialize(aJson, AdfPrintSetting.class);
  }
}
