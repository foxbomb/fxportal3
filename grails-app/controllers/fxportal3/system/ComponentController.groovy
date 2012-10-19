package fxportal3.system

import fxportal3.*
import fxportal3.helpers.Contents

class ComponentController {

        def pageComponent = PageComponent.get(flash.pageComponentId);
        def contents = new Contents(pageComponent.contents).getMap();
        def component = [pageTitle: pageComponent.page.title, pageUrl: pageComponent.page.url, friendlyName: pageComponent.friendlyName, id: pageComponent.id, contents: contents];
    
}

