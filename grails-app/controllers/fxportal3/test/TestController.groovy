package fxportal3.test

import fxportal3.*
import fxportal3.helpers.Contents

class TestController {

    def chainModel
    
    def index() {
        
        def pageComponent = PageComponent.get(flash.pageComponentId);

        def contents = new Contents(pageComponent.contents).getMap();
        
        println (contents)
        
        def component = [pageTitle: pageComponent.page.title, pageUrl: pageComponent.page.url, friendlyName: pageComponent.friendlyName, id: pageComponent.id, contents: contents];
        
        render (view:"plugintest", model:[component: component])
        
    }
}
