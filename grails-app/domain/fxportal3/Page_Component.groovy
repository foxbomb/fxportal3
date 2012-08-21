package fxportal3

class Page_Component {
    
    static belongsTo = Page, Component
    static hasMany = [blobs:Blob]
    
    String referenceName

}
