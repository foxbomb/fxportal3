<!--

* Mandatory Fields to be highlighted and validated
* Number boxes should be smaller
* Populate default values
* Add a link to markdown syntax

-->
  <div>
    <h3>${title} Settings</h3>
    <p>${config.profiles.default.instructions}</p>    
      <g:each in="${config.profiles.default.fields}">
        <div class="control-group">
          <label class="control-label" for="input-friendlyname">${config.profiles.default.fieldDetail[it].title}</label>
          <div class="controls">
            <g:if test="${config.profiles.default.fieldDetail[it].type == 'memo'}">
              <textarea name="${it}">${config.profiles.default.fieldDetail[it].default}</textarea>
            </g:if>
            <g:elseif test="${config.profiles.default.fieldDetail[it].type == 'yesno'}">
              <input name="${it}" type="radio" value="yes" checked="${config.profiles.default.fieldDetail[it].default == "yes" ? "checked" : ""}"/>&nbsp;Yes&nbsp;&nbsp;<input name="${it}" type="radio" value="no" ${config.profiles.default.fieldDetail[it].default == "no" ? "checked" : ""}/>&nbsp;No
            </g:elseif>
            <g:elseif test="${config.profiles.default.fieldDetail[it].type == 'number'}">
              <input name="${it}" type="number" maxlength="4" size="4" style="span1" value="${config.profiles.default.fieldDetail[it].default}"/>
            </g:elseif>          
            <span class="help-block">${config.profiles.default.fieldDetail[it].help}</span>
          </div>        
        </div>      
      </g:each>    
  </div>

<!--
<markdown:renderHtml>***test*** **test** *test*</markdown:renderHtml>
-->