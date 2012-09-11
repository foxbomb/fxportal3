
<div id="edit-modal" class="modal hide fade">
  <div class="modal-header">    
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    <h3><span id="component-title"></span>: <span id="component-friendlyname"></span></h3>
    <small><span id="component-key"></small>
  </div>
  <div class="modal-body">
    <form class="form-horizontal">
      <div class="control-group">
        <label class="control-label" for="input-friendlyname">Friendly Name</label>
        <div class="controls">
          <input type="text" id="input-friendlyname">
          <input type="hidden" id="input-parent-id">
          <span class="help-block">To make it easier for you to tell them apart.</span>
        </div>        
      </div>
    </form>
  </div>
  <div class="modal-footer">
    <a href="javascript:" data-dismiss="modal" class="btn">Cancel</a>
    <a id="input-done" href="javascript:" class="btn btn-primary">Done</a>
  </div>
</div>