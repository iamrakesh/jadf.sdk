package in.rakesh.autodesk.client.rest.model;

import java.util.*;

/**
 * Implementation to hold name/value pairs
 */
public final class NameValue<T> implements INameValue<T>
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private final String name;
  private final T value;

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new NameValue object.
   *
   * @param aName  name in name/value pair
   * @param aValue value in name/value pair
   */
  public NameValue(String aName, T aValue)
  {
    assert aName != null : "Name is required for NameValue";

    this.name = aName;
    this.value = aValue;
  }

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  @Override public boolean equals(Object aObj)
  {
    if (this == aObj)
    {
      return true;
    }

    if (aObj instanceof NameValue)
    {
      return Objects.equals(this.name, ((NameValue<?>) aObj).name);
    }
    return false;
  }


  /**
   * {@inheritDoc}
   */
  @Override public String getName()
  {
    return this.name;
  }


  /**
   * {@inheritDoc}
   */
  @Override public T getValue()
  {
    return this.value;
  }


  /**
   * {@inheritDoc}
   */
  @Override public int hashCode()
  {
    return this.name.hashCode();
  }
}
