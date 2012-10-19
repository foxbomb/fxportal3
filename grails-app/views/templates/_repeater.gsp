<g:each in="${components}">
  <p>
    <g:renderComponent key="${it.component.key}" id="${it.id}"/> 
  </p>
</g:each>
