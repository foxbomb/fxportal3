package fxportal3.pages

import fxportal3.system.AdminController

class UsersController extends AdminController {
    
    static layout = "admin"

    def index() {
        authorize()        
    }
}
