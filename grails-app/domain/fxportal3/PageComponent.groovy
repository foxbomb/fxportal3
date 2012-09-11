package fxportal3

class PageComponent {
    
    static mapping = {        
        table: 'page_component'
    }    
    
    static belongsTo = [page: Page, component: Component]
    static hasMany = [contents: Content]
    
    String friendlyName

}
