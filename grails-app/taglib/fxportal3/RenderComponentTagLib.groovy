package fxportal3

import org.codehaus.groovy.grails.web.mapping.UrlMapping
import org.codehaus.groovy.grails.web.util.WebUtils

class RenderComponentTagLib {
    
    def grailsUrlMappingsHolder
    
    def renderComponent = {attrs, body ->
        
        def mapping = grailsUrlMappingsHolder.match("/component/" + attrs.key + "/" + attrs.id) 

        if (mapping) {
            
            out << WebUtils.includeForUrlMappingInfo(request, response, mapping, [:])?.content
            
        } else {
            out << "No component plugin found with key: " + attrs.key
        }
    }
}
