package fxportal3.frontend.components

import fxportal3.helpers.Contents
import fxportal3.PageComponent
import fxportal3.helpers.ComponentHelper

class TextController extends ComponentHelper {

    def index() {
        
//        def pageComponent = PageComponent.get(params.id)
//        def contents = new Contents(pageComponent.contents).getMap();
//        def model = [pageTitle: pageComponent.page.title, pageUrl: pageComponent.page.url, friendlyName: pageComponent.friendlyName, id: pageComponent.id, contents: contents];
        render (view: '/components/frontend/text', model: getComponentData(params.id))            
        
    }
}
