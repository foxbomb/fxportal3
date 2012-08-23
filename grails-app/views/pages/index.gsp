<html>
  <head>
    <title>Pages</title>
    <script type="text/javascript" src="${resource(dir: '/js', file: 'jquery-ui-1.8.23.custom.min.js')}"></script>
    <style>
      #sortable1, #sortable2 { list-style-type: none; margin: 0; padding: 0 0 2.5em; float: left; margin-right: 10px; }
      #sortable1 li, #sortable2 li { margin: 0 5px 5px 5px; padding: 5px; font-size: 1.2em; width: 120px; }
    </style>
    
    <!-- Drag & Drop Script -->
    <script>
      $(function() {

        $("#components li").draggable({
          connectToSortable: '#page',
          helper: 'clone'
        })
        
        $("#page").sortable();
        
      });
    </script>
  </head>
  <body>

    <!-- Menu Bar -->
    <g:include view="includes/adminmenu.gsp"/>
    
    <!-- Flash Messages -->
    <g:if test="${flash.message}">
      <section>              
        <div class="alert alert-${flash.type} fade in"><button type="button" class="close" data-dismiss="alert">×</button>${flash.message}</div>
      </section>          
    </g:if>  
    
    <g:if test="${!selectedId}">  
      <section>
        <div class="alert alert-info fade in">
          <button type="button" class="close" data-dismiss="alert">×</button>    
          <strong>Create New Page Mode:</strong> You are in create mode. Use the <em>Your Components</em> area to drag components to the <em>Build your page</em> area. To rather edit a page, select a page under the <em>Choose a page</em> area.
        </div>  
      </section>        
    </g:if>
    <g:else>
      <section>
        <div class="alert alert-info fade in">
          <button type="button" class="close" data-dismiss="alert">×</button>    
          <strong>Edit Page Mode:</strong> You are in edit mode. Edit the selected page in the <em>Build your page</em> area. To rather create a new page, hit the <em>Create New Page</em> button below.   
        </div>  
      </section>            
    </g:else>
    
    <!-- Functional Area -->
    <section>
      <div class="row">
        
        <!-- 1. Choose a page -->
        <div class="span3 cms-panel">
          <h3>1. Choose a page</h3>
          <g:if test="${selectedId}">  
            <g:link controller="pages" data-toggle="modal" class="btn btn-primary"><i class="icon-plus icon-white"></i> Create New Page</a></g:link>
          </g:if>  
          <section>
            <ul class="nav nav-tabs nav-stacked custom-nav-stacked">                        

              <g:if test="${!selectedId}">  

                <li class="active">                  
                  <g:link controller="pages" action="index" id="-1">
                    <i class="icon-chevron-right"></i>
                    &laquo; New Page &raquo; <br/>
                    <small>&laquo; /url &raquo;</small>
                  </g:link>
                </li>
                
              </g:if>
              
              <g:each in="${pages}">
                <li class="${it.id == selectedId ? 'active' : ''}">
                <g:link controller="pages" action="index" id="${it.id}">
                  <i class="icon-chevron-right"></i>
                  ${it.title}<br/>
                  <small>${it.url}</small>
                </g:link>
                </li>
              </g:each>           
            </ul>
          </section>
        </div>
        
        <!-- 2. Your Components -->
        <div class="span3 cms-panel">
          <h3>2. Your components</h3>
          <ul id="components">
            <li class="btn btn-large btn-block component">Plain Text</li>
            <li class="btn btn-large btn-block component">Html</li>
            <li class="btn btn-large btn-block component">Form</li>
            <li class="btn btn-large btn-block component">Quiz</li>
            <li class="btn btn-large btn-block component">Header</li>
            <li class="btn btn-large btn-block component">Footer</li>
            <li class="btn btn-large btn-block component">Menu</li>
          </ul>

        </div>
        
        <!-- 3. Build Your Page -->
        <div class="span3 cms-panel">
          <h3>3. Build your page </h3>
          <input type="text">
          <input type="text">
          <ul id="page">
            <li class="btn btn-large btn-block component">Item 1</li>
            <li class="btn btn-large btn-block component">Item 2</li>
          </ul>
          <input type="checkbox"> Published<br/>
          <g:link controller="pages" data-toggle="modal" class="btn btn-primary"><i class="icon-plus icon-white"></i> Save Page</a></g:link>
        </div>

        <!-- 4. Preview -->
        <div class="span3 cms-panel">
          <h3>4. Preview</h3>
        </div>

      </div>
    </section>

  </body>
</html>