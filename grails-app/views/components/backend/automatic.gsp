<!--

* Mandatory Fields to be highlighted and validated
* Number boxes should be smaller
* Populate default values
* Add a link to markdown syntax

-->
  <div>
    <h3>${title} Settings</h3>
    <p>${config.instructions}</p>    
      <g:each in="${config.fields}">
        <div class="control-group">
          <label class="control-label" for="input-friendlyname">${config.fieldDetail[it].title}</label>
          <div class="controls">
            <g:if test="${config.fieldDetail[it].type == 'memo'}">
              <textarea name="${it}">${config.fieldDetail[it].default}</textarea>
            </g:if>
            <g:elseif test="${config.fieldDetail[it].type == 'yesno'}">
              <input name="${it}" type="radio" value="yes" checked="${config.fieldDetail[it].default == "yes" ? "checked" : ""}"/>&nbsp;Yes&nbsp;&nbsp;<input name="${it}" type="radio" value="no" ${config.fieldDetail[it].default == "no" ? "checked" : ""}/>&nbsp;No
            </g:elseif>
            <g:elseif test="${config.fieldDetail[it].type == 'number'}">
              <input name="${it}" type="number" maxlength="4" size="4" style="span1" value="${config.fieldDetail[it].default}"/>
            </g:elseif>          
            <span class="help-block">${config.fieldDetail[it].help}</span>
          </div>        
        </div>      
      </g:each>    
  </div>