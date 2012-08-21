package fxportal3

class Component {
    
    static mapping = {        
        key column: 'fxKey'
    }
    
    static hasMany = PageComponent

    String title
    String key
        

}
