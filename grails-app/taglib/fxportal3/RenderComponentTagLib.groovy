package fxportal3

import org.codehaus.groovy.grails.web.mapping.UrlMapping
import org.codehaus.groovy.grails.web.util.WebUtils

class RenderComponentTagLib {
    
    def grailsUrlMappingsHolder
    
    def renderComponent = {attrs, body ->
        //def mapping = grailsUrlMappingsHolder.match("/components/" + attrs.key) 
        def mapping = grailsUrlMappingsHolder.match("/plugin-test")
        if (mapping) {
            
            flash.pageComponentId = attrs.id
            
            out << WebUtils.includeForUrlMappingInfo(request, response, mapping, [:])?.content
            
        } else {
            out << "No component plugin found with key: " + attrs.key
        }
    }
}
