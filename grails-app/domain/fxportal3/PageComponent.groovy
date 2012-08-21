package fxportal3

class PageComponent {
    
    static mapping = {        
        table: 'page_component'
    }    
    
    static belongsTo = Page, Component
    static hasMany = [contents:Content]
    
    String title

}
