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
            <textarea></textarea>
          </g:if>
          <g:elseif test="${config.profiles.default.fieldDetail[it].type == 'yesno'}">
            <input name="group" type="radio"/>&nbsp;Yes&nbsp;&nbsp;<input name="group" type="radio"/>&nbsp;No
          </g:elseif>
          <g:elseif test="${config.profiles.default.fieldDetail[it].type == 'number'}">
            <input type="number" maxlength="4" size="4"/>
          </g:elseif>          
          <span class="help-block">${config.profiles.default.fieldDetail[it].help}</span>
        </div>        
      </div>      
    </g:each>
  </div>

<!--
<markdown:renderHtml>***test*** **test** *test*</markdown:renderHtml>
-->