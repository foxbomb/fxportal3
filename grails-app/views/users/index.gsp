<html>
  <head>
    <title>Pages</title>
  </head>
  <body>
    <g:include view="includes/adminmenu.gsp"/>
    <section>
      <g:if test="${flash.message}">
        <div class="alert alert-success">${flash.message}</div>
      </g:if>  
    </secton>    
    <section>
      <h2>Users</h2>
    </section>
  </body>
</html>