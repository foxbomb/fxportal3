package fxportal3

class Content {
    
    static mapping = {        
        key column: 'fxKey'
        value column: 'fxValue'
    }    

    static belongsTo = PageComponent
    
    String title
    String key
    String value
    
}
