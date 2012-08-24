package fxportal3

class Content {
    
    static mapping = {        
        key column: 'fxKey'
        value column: 'fxValue'
    }    

    static belongsTo = [pageComponent: PageComponent]
    
    String title
    String key
    String value
    
}
