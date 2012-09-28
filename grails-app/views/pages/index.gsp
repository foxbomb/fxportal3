<html>
  <head>
    <title>Pages</title>
    <script type="text/javascript" src="${resource(dir: '/js', file: 'jquery-ui-1.8.23.custom.min.js')}"></script>
    <script type="text/javascript" src="${resource(dir: '/js', file: 'jquery.serializeForm.js')}"></script>
    <script type="text/javascript" src="${resource(dir: '/js', file: 'jquery.deserializeForm.js')}"></script>
    <style>
      #sortable1, #sortable2 { list-style-type: none; margin: 0; padding: 0 0 2.5em; float: left; margin-right: 10px; }
      #sortable1 li, #sortable2 li { margin: 0 5px 5px 5px; padding: 5px; font-size: 1.2em; width: 120px; }
    </style>
    <script>
      $(function() {
        
        // Populate Default values to existing items

        var elements = $("ul#page li");
        $.each(elements, function(index, elem) {
          var data = {};
          data.general = {}
          data.general.id = $(elem).attr("id");
          data.general.new = false;
          data.general.edited = false;
          data.general.title = $(elem).attr("data-component-title");
          data.general.friendlyName = $(elem).attr("data-component-friendlyname");
          data.general.key = $(elem).attr("data-component-key");;
          $(elem).data(data);
        });        
        
        // Delete List
        
        var removed = [];
        
        // Drag and Drop
        
        var currentId = 0;
        var currentComponent = null;
        
        var dropHereDisplayed = false;
        checkDisplay();

        $("#components li").draggable({
          connectToSortable: '#page',
          helper: 'clone'
        })
        
        $("#page").sortable({
          update: function() {
            if (dropHereDisplayed == true) {
              $('.cms-panel div.drag-text').fadeTo(250, 0);
              $("#page").css("height", "");
              dropHereDisplayed = false;
            }
          },
          stop: function(evt, ui) {
            
            var elem = ui.item;
            
            if (elem.data().general) {
              // existing
            } else {

              var type = ui.item.text();
              var badge = $('<span class="component-label label label-inverse">' + type + '</span>');                            
              var edit = $('<a class="edit-component"><i class="icon-edit icon-white"></i></a>')
              var close = $('<a class="remove-component"><i class="icon-remove icon-white"></i></a>');
              
              elem.find("span.friendly-name").text("Untitled");
              elem.addClass("btn-success");
              elem.prepend(badge);
              elem.append(close);
              elem.append(edit);

              var data = {};
              data.general = {}
              data.general.id = null;              
              data.general.new = true;
              data.general.edited = false;
              data.general.title = elem.attr("data-component-title");
              data.general.friendlyName = elem.attr("data-component-friendlyname");
              data.general.key = elem.attr("data-component-key");;
              
              elem.data(data);

            }
            
          }
        });
        
        // Remove Button
                
        $("ul#page").on({'click' : function() {          
          
          $(this).parent().hide(250, function(){
            var id = $(this).data().general.id;
            if (id != null) {
              removed.push(id);
            }
            $(this).remove();
            checkDisplay();
          });          
          
        }}, 'a.remove-component');
        
        // Edit Button
        
        $("ul#page").on({'click' : function() {          
          
          currentComponent = $(this).closest("li");
          
          var data = currentComponent.data();
                    
          $('#component-title').text(data.general.title);
          $('#component-friendlyname').text(data.general.friendlyName);
          $('#component-key').text(data.general.key);
          $('#input-friendlyname').val(data.general.friendlyName);

          $.ajax({url:'/service/component/' + data.general.id + '/' + escape(data.general.key)}).done(function(response) {
            $("#modal-content").html(response);
            
            
            
            if (data.general.fields) {
              $("#component-form").deserializeForm(data.general.fields);
            }
            
            $("#edit-modal").modal();
          });

          
          
        }}, 'a.edit-component');
      
        // Modal Buttons
        
        $('#input-friendlyname').keyup(function() {
          $('#component-friendlyname').text($(this).val());
        })
        
        // DONE
        
        $('#input-done').click(function() {
          
          var data = currentComponent.data();
          data.general.friendlyName = $('#input-friendlyname').val();
          data.general.edited = true;
          data.general.fields = $("#component-form").serializeForm();
          currentComponent.data(data);
          currentComponent.find("span.friendly-name").text(data.general.friendlyName);
          
          $('#edit-modal').modal('hide');
        });
        
        $('.modal-close').click(function() {          
          $("#edit-modal").modal('hide');
          currentComponent = null;
        });
      
        // Show or Hide the "Drag your components here..."

        function checkDisplay() {
          if ($("#page li.component").size() == 0) {
              $('.cms-panel div.drag-text').fadeTo(250, 0.5);
              dropHereDisplayed = true;              
            }
        }
        
        // Prepare data for AJAX Submit
        
        $("#page-components").submit(function(evt) {
          
          var updated = [];
          
          var elements = $("ul#page li");
          $.each(elements, function(index, elem) {
            updated.push ($(elem).data().general);
          });
          
          var data = {}
          data.updated = updated
          data.removed = removed
          
          var dataString = JSON.stringify(data);
          
          $("form#page-components").find("input#data").val(dataString);
          
          console.log (dataString);
          evt.preventDefault();
                    
        });

      });
    </script>
  </head>
  <body>

    <!-- Menu Bar -->
    <g:include view="includes/adminmenu.gsp"/>
    
    <!-- Flash Messages -->
    <g:if test="${flash.message}">
      <section>              
        <div class="alert alert-${flash.type} fade in"><button type="button" class="close" data-dismiss="alert">&times;</button>${flash.message}</div>
      </section>          
    </g:if>  
    
    <g:if test="${!page.id}">  
      <section>
        <div class="alert alert-info fade in">
          <button  type="button" class="close" data-dismiss="alert">×</button>    
          <strong>Create New Page Mode:</strong> You are in create mode. Use the <em>Your Components</em> area to drag components to the <em>Build your page</em> area. To rather edit a page, select a page under the <em>Choose a page</em> area.
        </div>  
      </section>        
    </g:if>
    <g:else>
      <section>
        <div class="alert alert-info fade in">
          <button type="button" class="close" data-dismiss="alert">&times;</button>    
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
          <g:if test="${page.id}">  
            <g:link controller="pages" data-toggle="modal" class="btn btn-primary"><i class="icon-plus icon-white"></i>&nbsp;Create New Page</a></g:link>
          </g:if>  
          <section>
            <ul class="nav nav-tabs nav-stacked custom-nav-stacked">                        

              <g:if test="${!page.id}">  

                <li class="active">                  
                  <g:link controller="pages" action="index" id="-1">
                    <i class="icon-chevron-right"></i>
                    &laquo; New Page &raquo; <br/>
                    <small>&laquo; /url &raquo;</small>
                  </g:link>
                </li>
                
              </g:if>
              
              <g:each in="${pages}">
                <li class="${it.id == page.id ? 'active' : ''}">
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
            
             <g:each in="${components}">
                <li class="btn btn-large btn-block component" data-component-key="${it.key}" data-component-title="${it.title}" data-component-friendlyname="Untitled"> <span class="friendly-name">${it.title}</span></li>                
             </g:each>              
            
          </ul>

        </div>
        
        <!-- 3. Build Your Page -->
        <div class="span3 cms-panel">
          <h3>3. Build your page </h3>
          
          <g:form id="page-components" url="[controller:'pages', action:'save', id:page.id]" class="inline-form">
            <input id="title" name="title" type="text" placeholder="title" value="${page.title}"/>
            <input id="url" name="url" type="text" placeholder="url" value="${page.url}"/>
            <input id="data" name="data" type="hidden"/>
            <input id="pageId" name="pageId" type="hidden" value="${page.id}"/>
            <div class="drag-text">Drag your components here...</div>
            <ul id="page" style="position:relative">

               <g:each in="${pageComponents}">
                  <li id="${it.id}" class="btn-success btn-large btn-block component" data-component-key="${it.component.key}" data-component-title="${it.component.title}" data-component-friendlyname="${it.friendlyName}"><span class="component-label label label-inverse">${it.component.title}</span> <span class="friendly-name">${it.friendlyName}</span><a class="remove-component"><i class="icon-remove icon-white"></i></a><a class="edit-component"><i class="icon-edit icon-white"></i></a></li>                
               </g:each>              

            </ul>          
            
            <button type="submit" class="btn btn-primary save-button"><i class="icon-plus icon-white"></i>&nbsp;Save Page</button>            
          </g:form>
          <g:if test="${page.id != 0}">
            <g:form id="page-components" url="[controller:'pages', action:'delete', id:page.id]" class="inline-form">
              <button type="submit" class="btn btn-danger save-button"><i class="icon-remove icon-white"></i>&nbsp;Delete Page</button>
            </g:form>
          </g:if>
        </div>

        <!-- 4. Preview -->
        <div class="span3 cms-panel">
          <h3>4. Preview</h3>
        </div>

      </div>
    </section>
    <div>
      <g:include view="/pages/_edit.gsp"></g:include>
    </div>
  </body>
</html>