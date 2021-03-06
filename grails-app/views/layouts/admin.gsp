<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>fxPortal 3.0 - <g:layoutTitle/></title>
    <link rel="stylesheet" type="text/css" href="${resource(dir: 'bootstrap/css', file: 'bootstrap.min.css')}">
    <link rel="stylesheet" type="text/css" href="${resource(dir: 'bootstrap/css', file: 'bootstrap-responsive.min.css')}">
    <link rel="stylesheet" type="text/css" href="${resource(dir: 'css/', file: 'bootstrap-override.css')}">
    <link rel="stylesheet" type="text/css" href="${resource(dir: 'css/', file: 'default.css')}">
    <script type="text/javascript" src="${resource(dir: '/js', file: 'jquery-1.8.0.min.js')}"></script>
    <script type="text/javascript" src="${resource(dir: 'bootstrap/js', file: 'bootstrap.min.js')}"></script>
    <script type="text/javascript" src="${resource(dir: '/js', file: 'application.js')}"></script>
    
    <g:layoutHead/>
  </head>
  <body>
    <div class="container">
      <g:layoutBody/>
    </div>    
  </body>
</html>
