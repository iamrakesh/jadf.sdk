package in.iamrakesh.autodesk.client.gson.serializer;

import com.google.gson.*;

import in.iamrakesh.autodesk.model.bubble.*;
import in.iamrakesh.autodesk.model.bubble.impl.*;

import java.lang.reflect.*;

/**
 * {@link JsonDeserializer} implementation to de-serialize JSON string into {@code AdfBubbleNode}.
 * As models have generic collections of type {@code IAdfBubbleNode}, we need this de-serializer
 * configured for Google GSON API to de-serialize models correctly.
 */
public class AdfBubbleNodeSerializer implements JsonDeserializer<IAdfBubbleNode>
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public IAdfBubbleNode deserialize(JsonElement aJson, Type aTargetType, JsonDeserializationContext aContext) throws JsonParseException
  {
    return aContext.deserialize(aJson, AdfBubbleNode.class);
  }
}
