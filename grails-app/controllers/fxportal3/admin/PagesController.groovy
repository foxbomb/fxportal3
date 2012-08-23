package fxportal3.pages

import fxportal3.system.AdminController
import fxportal3.Page

class PagesController { //extends AdminController {
    
    static layout = "admin"

    def index() {
        //authorize()
        
        def selectedId = null;
        try {
            selectedId = Integer.valueOf(params.id)
        } catch (Exception ex) {}
        
        ['pages': Page.list(), 'selectedId': selectedId]
    }
}
