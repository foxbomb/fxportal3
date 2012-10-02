<section>
  <div class="navbar">
    <div class="navbar-inner">
      <!--<a class="brand" href="#">fxPortal 3.0 CMS Admin</a> -->
      <a class="brand" href="#">fxPortal 3.0 CMS Admin</a>
      <ul id="adminmenu" class="nav">      
        <li class="${controllerName == 'pages' ? 'active' : ""}"><g:link controller="pages">Pages</g:link></li>
        <li class="${controllerName == 'users' ? 'active' : ""}"><g:link controller="users">Users</g:link></li>
        <li><g:link id="logout" controller="authentication" action="logout">Logout</g:link></li>
      </ul>
    </div>
  </div>
</section>
<script type="text/javascript">
  
  // Script to preselect a menu item BEFORE the page reloads (make it class="active") -- Cosmetic
  
  $('#adminmenu li').click(function() { 
    console.log (this);
    $("#adminmenu li").each(function(i, item) {
      $(item).removeClass("active");
    });
    $(this).addClass("active");
    
  });
</script>



