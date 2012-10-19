package fxportal3.content

import fxportal3.*

class ContentController {

    def index() {
        
        // We really need to lose the "/go"
        def path = request.forwardURI.substring(3);
        def page = Page.findByUrl(path ? path : "/")
        
        if (page) {
            
            def pageComponents = PageComponent.findAllByPage(page, [sort: "order", order: "asc"]);
            
            render(view: "/templates/default", model: [title:page.title, components:pageComponents])
            
        } else {
            render(text:"Page Not Found")
        }
        
    }
}
