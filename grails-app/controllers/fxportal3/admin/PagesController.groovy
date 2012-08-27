package fxportal3.pages

import fxportal3.Component
import fxportal3.Page
import fxportal3.PageComponent

import fxportal3.system.AdminController


class PagesController { //extends AdminController {
    
    static layout = "admin"

    def index() {
        //authorize()
        
        
        
        def selectedId = 0;
        def pageComponents = null;
        
        try {
            selectedId = Long.valueOf(params.id)
            pageComponents = PageComponent.where{page.id == selectedId}
        } catch (Exception ex) {}
        
        
        
        ['pages': Page.list(), 'selectedId': selectedId, 'components': Component.list(), 'pageComponents': pageComponents]
        
    }
}
