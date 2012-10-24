package fxportal3.backend

import fxportal3.system.GenericSecurityController

class ComponentsController extends GenericSecurityController {

    static layout = "admin"

    def index() {
        authorize()        
    }
    
}
