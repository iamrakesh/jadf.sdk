package in.iamrakesh.autodesk.client.rest.auth.impl;

import in.iamrakesh.autodesk.client.rest.entity.impl.*;
import in.iamrakesh.autodesk.model.auth.*;

import javax.ws.rs.core.*;

import java.util.*;

/**
 * {@link AdfRestFormEntityBuilder} implementation to create {@link Form} to be used for AutoDesk
 * Forge authentication.
 */
public final class AdfCredentialsFormEntityBuilder extends AdfRestFormEntityBuilder<IAdfCredentials>
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * {@inheritDoc}
   */
  protected Form createForm(IAdfCredentials aCredentials)
  {
    Form form = new Form();

    form.param("client_id", aCredentials.getClientId()) //
        .param("client_secret", aCredentials.getClientSecret()) //
        .param("grant_type", aCredentials.getGrantType()) //
        .param("scope", getScopeAsString(aCredentials.getScope()));

    return form;
  }


  /**
   * method to prepare value for the 'scope' authentication form field, by appending given scopes
   * with space character as separator.
   *
   * @param  aScopes List of scopes
   *
   * @return 'Scope' form field value
   */
  private String getScopeAsString(List<String> aScopes)
  {
    StringBuilder scope = new StringBuilder();
    for (String scp : aScopes)
    {
      if (scope.length() != 0)
      {
        scope.append(" ");
      }
      scope.append(scp);
    }
    return scope.toString();
  }
}
