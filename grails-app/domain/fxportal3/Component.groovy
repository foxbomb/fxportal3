package fxportal3

class Component {
    
    static mapping = {        
        key column: 'fxKey'
    }
    
    static hasMany = [components:PageComponent]

    String title
    String key
        

}
