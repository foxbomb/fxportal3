package fxportal3.test

import fxportal3.*
import fxportal3.helpers.Contents
import org.apache.commons.lang.StringEscapeUtils

class TestController {
    
    def index() {

        def pageComponent = PageComponent.get(flash.pageComponentId);
        def contents = new Contents(pageComponent.contents).getMap();
        def component = [pageTitle: pageComponent.page.title, pageUrl: pageComponent.page.url, friendlyName: pageComponent.friendlyName, id: pageComponent.id, contents: contents];        
        
        component.contents.text = StringEscapeUtils.escapeHtml(component.contents.text)
        
        render (view:"plugintest", model:[component: component])
        
    }
}
