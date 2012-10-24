package fxportal3.backend

import fxportal3.system.GenericSecurityController

class StylesController extends GenericSecurityController {

    static layout = "admin"

    def index() {
        authorize()        
    }
    
}
