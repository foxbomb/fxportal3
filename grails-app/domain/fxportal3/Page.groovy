package fxportal3

class Page {
    
    String title
    String url
    
    static hasMany = [components:PageComponent]

}
