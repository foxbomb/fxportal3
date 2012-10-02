package fxportal3.admin

import fxportal3.Component

class ComponentController {

    def componentService
    
    def frontend() {
        
    }
    
    def backend() {
        
        if (params.key) {
            def component = Component.findByKey(params.key)
            
            if (component) {
                def config = componentService.getConfiguration(params.key);
                
                if (params.id) {
                    config = componentService.overrideDefaults(params.id, config)
                }
                
                render(view:'/components/backend/automatic', model:[title:component.title, config:config])
            } else {
                render("Component Not Found")
            }
        }
        
    }
}
