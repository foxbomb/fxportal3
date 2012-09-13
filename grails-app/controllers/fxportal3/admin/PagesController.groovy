package fxportal3.admin

import fxportal3.Component
import fxportal3.Page
import fxportal3.PageComponent
import fxportal3.system.GenericSecurityController

class PagesController extends GenericSecurityController {
    
    static layout = "admin"
    
    def save() {
        log.error (params);
        forward action: "index", id: params.id
    }

    def index() {

        authorize();
        
        def selectedId = 0;
        def pageComponents = null;
        
        try {
            selectedId = Long.valueOf(params.id)
            pageComponents = PageComponent.where{page.id == selectedId}
        } catch (Exception ex) {}
        
        ['pages': Page.list(), 'selectedId': selectedId, 'components': Component.list(), 'pageComponents': pageComponents]
        
    }
}
