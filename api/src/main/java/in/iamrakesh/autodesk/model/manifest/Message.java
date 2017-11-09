package in.iamrakesh.autodesk.model.manifest;

import java.util.*;

/**
 * model class used to hold messages property of sub-derivative in manifest json
 */
public class Message
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private List<String> message;

  private String code;
  private String type;

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * method returns message code.
   *
   * @return the code
   */
  public String getCode()
  {
    return code;
  }


  /**
   * method returns Collection of message strings
   *
   * @return the message
   */
  public List<String> getMessage()
  {
    return message;
  }


  /**
   * method returns type of the message
   *
   * @return message type
   */
  public String getType()
  {
    return type;
  }


  /**
   * method to set code of the message
   *
   * @param aCode the code to set
   */
  public void setCode(String aCode)
  {
    this.code = aCode;
  }


  /**
   * method to set messages
   *
   * @param aMessage the message to set
   */
  public void setMessage(List<String> aMessage)
  {
    this.message = aMessage;
  }


  /**
   * method to set type of the message
   *
   * @param aType the type to set
   */
  public void setType(String aType)
  {
    this.type = aType;
  }
}
