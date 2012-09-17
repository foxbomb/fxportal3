package fxportal3

class PageComponent {
    
    static mapping = {        
        table: 'page_component'
        order column: 'ordering'
    }    
    
    static belongsTo = [page: Page, component: Component]
    static hasMany = [contents: Content]
    
    String friendlyName
    int    order

}
