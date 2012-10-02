package fxportal3.admin

import fxportal3.system.GenericSecurityController

class UsersController extends GenericSecurityController {
    
    static layout = "admin"

    def index() {
        println ("Hello there")
        authorize()        
    }
}
