<g:if test="${component.contents.markdown == 'yes'}">
  <markdown:renderHtml>${component.contents.text}</markdown:renderHtml>
</g:if>
<g:else>
  ${component.contents.text}
</g:else>