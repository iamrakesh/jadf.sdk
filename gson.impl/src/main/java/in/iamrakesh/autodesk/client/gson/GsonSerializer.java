package in.iamrakesh.autodesk.client.gson;

import com.google.gson.*;

import in.iamrakesh.autodesk.client.gson.serializer.*;
import in.iamrakesh.autodesk.client.json.*;
import in.iamrakesh.autodesk.model.bubble.*;
import in.iamrakesh.autodesk.model.bucket.*;
import in.iamrakesh.autodesk.model.manifest.*;

import java.io.*;

/**
 * {@link IJsonSerializer} implementation which uses Google GSON API for JSON (de)serialization.
 */
public final class GsonSerializer implements IJsonSerializer
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private final GsonBuilder gsonBuilder;

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new JsonSerializer object.
   */
  public GsonSerializer()
  {
    this.gsonBuilder = new GsonBuilder();
    configure();
  }

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  public <T> T fromJson(String aJson, Class<T> aClass)
  {
    Gson gson = gsonBuilder.create();
    return gson.fromJson(aJson, aClass);
  }


  /**
   * {@inheritDoc}
   */
  public <T> T fromJson(Reader aJsonReader, Class<T> aClass)
  {
    Gson gson = gsonBuilder.create();
    return gson.fromJson(aJsonReader, aClass);
  }


  /**
   * {@inheritDoc}
   */
  public String toJson(Object aObj)
  {
    Gson gson = gsonBuilder.create();
    return gson.toJson(aObj);
  }


  /**
   * configure JSON serializers for different interfaces/types
   */
  private void configure()
  {
    this.gsonBuilder.registerTypeAdapter(IAdfBubbleNode.class, new AdfBubbleNodeSerializer());

    this.gsonBuilder.registerTypeAdapter(IAdfDerivative.class, new AdfDerivativeSerializer());
    this.gsonBuilder.registerTypeAdapter(IAdfSubDerivative.class, new AdfSubDerivativeSerializer());

    this.gsonBuilder.registerTypeAdapter(IAdfBucketAccess.class, new AdfBucketAccessSerializer());

    this.gsonBuilder.registerTypeAdapter(IAdfPrintSetting.class, new AdfPrintSettingSerializer());
    this.gsonBuilder.registerTypeAdapter(IAdfDerivativeProperties.class, new AdfDerivativePropertiesSerializer());

    this.gsonBuilder.registerTypeAdapter(IAdfDerivativeAsset.class, new AdfDerivativeAssetSerializer());
  }
}
