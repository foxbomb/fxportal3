package fxportal3.helpers;

import fxportal3.*

class ComponentHelper {

    public static getComponentData(key) {

        def pageComponent = PageComponent.get(key)
        def contents = new Contents(pageComponent.contents).getMap();
        return [pageTitle: pageComponent.page.title, pageUrl: pageComponent.page.url, friendlyName: pageComponent.friendlyName, id: pageComponent.id, contents: contents];                
        
    }
    
}

