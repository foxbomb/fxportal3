<g:if test="${contents.markdown == 'yes'}">
  <markdown:renderHtml>${contents.text}</markdown:renderHtml>
</g:if>
<g:else>
  ${contents.text}
</g:else>