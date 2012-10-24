package fxportal3.frontend

import fxportal3.*

class PageController {

    def index() {
        
        // We really need to lose the "/go"
        def path = request.forwardURI
        def page = Page.findByUrl(path ? path : "/")
        
        if (page) {
            
            def pageComponents = PageComponent.findAllByPage(page, [sort: "order", order: "asc"]);
            
            render(view: "/templates/default", model: [title:page.title, components:pageComponents])
            
        } else {
            render(text:"Page Not Found")
        }
        
    }
}
