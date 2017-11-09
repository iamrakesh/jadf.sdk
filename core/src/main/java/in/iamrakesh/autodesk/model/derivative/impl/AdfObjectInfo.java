package in.iamrakesh.autodesk.model.derivative.impl;

import in.iamrakesh.autodesk.model.derivative.*;

/**
 * AdfObjectInfo
 */
public class AdfObjectInfo implements IAdfObjectInfo
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private int size;
  private String bucketKey;
  private String location;
  private String objectId;
  private String objectKey;

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public String getBucketKey()
  {
    return this.bucketKey;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getLocation()
  {
    return this.location;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getObjectId()
  {
    return this.objectId;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getObjectKey()
  {
    return this.objectKey;
  }


  /**
   * {@inheritDoc}
   */
  @Override public int getSize()
  {
    return this.size;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getUrn()
  {
    return this.getObjectId();
  }


  /**
   * {@inheritDoc}
   */
  @Override public String toString()
  {
    StringBuilder sb = new StringBuilder();

    sb.append("Bucket key: ").append(this.bucketKey) //
      .append(", Location: ").append(this.location) //
      .append(", Urn (Object Id): ").append(this.objectId) //
      .append(", Object key: ").append(this.objectKey) //
      .append(", Size: ").append(this.size);

    return sb.toString();
  }
}
