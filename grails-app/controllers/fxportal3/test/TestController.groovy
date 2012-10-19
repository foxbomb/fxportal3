package fxportal3.test


import fxportal3.system.ComponentController
import org.apache.commons.lang.StringEscapeUtils

class TestController extends ComponentController {
    
    def index() {
        component.contents.text = StringEscapeUtils.escapeHtml(component.contents.text)
        render (view:"plugintest", model:[component: component])
        
    }
}
