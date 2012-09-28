<!--

* Pressing enter should save or be disabled
* Clicking outside the box should not remove the box

-->
<div id="edit-modal" class="modal hide fade">
  <div class="modal-header">    
    <button type="button" class="modal-close close" aria-hidden="true">&times;</button>
    <h3><span id="component-title"></span>: <span id="component-friendlyname"></span></h3>
    <small><span id="component-key"></small>
  </div>
  <div class="modal-body">
    <form id="component-form" class="form-horizontal">
      <div class="control-group">
        <label class="control-label" for="input-friendlyname">Friendly Name</label>
        <div class="controls">
          <input type="text" id="input-friendlyname">
          <span class="help-block">To make it easier for you to tell them apart.</span>
        </div>        
      </div>
      <div id="modal-content">
      </div>
    </form>
  </div>
  <div class="modal-footer">
    <a href="javascript:" class="btn modal-close">Cancel</a>
    <a id="input-done" href="javascript:" class="btn btn-primary">Done</a>
  </div>
</div>