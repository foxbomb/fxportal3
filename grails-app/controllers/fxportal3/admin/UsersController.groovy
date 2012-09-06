package fxportal3.pages

import fxportal3.system.GenericSecurityController

class UsersController extends GenericSecurityController {
    
    static layout = "admin"

    def index() {
        authorize()        
    }
}
