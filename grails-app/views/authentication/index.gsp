<html>
  <head>
    <title>Login</title>
  </head>
  <body>
    <header>
      <div class="hero-unit">
        <h1>fxPortal 3.0</h1>
        <p class="lead">Content Management Framework for Mobi Sites with Support for MXit</p>
      </div>
    </header>
    <section>
      <h2>Login</h2>
      <g:if test="${flash.message}">
        <div class="alert alert-error">${flash.message}</div>
      </g:if>
      <g:form controller="authentication" action="login" class="form-horizontal">
        <div class="control-group">
          <label class="control-label" for="email">Email</label>
          <div class="controls">
            <input type="text" name="email" id="email" placeholder="Email">
          </div>
        </div>
        <div class="control-group">
          <label class="control-label" for="password">Password</label>
          <div class="controls">
            <input type="password" name="password" id="inputPassword" placeholder="Password">
          </div>
        </div>
        <div class="control-group">
          <div class="controls">
            <button type="submit" class="btn btn-primary">Sign in</button>
          </div>
        </div>
      </g:form>
    </section>
  </body>
</html>
