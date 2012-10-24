package fxportal3.helpers

import fxportal3.*

public class ComponentHelper {

    def componentData
    
    public getComponentData(key) {

        def pageComponent = PageComponent.get(key)
        def contents = new Contents(pageComponent.contents).getMap();
        componentData = [pageTitle: pageComponent.page.title, pageUrl: pageComponent.page.url, friendlyName: pageComponent.friendlyName, id: pageComponent.id, contents: contents];                
        
    }
    
}