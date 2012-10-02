package fxportal3

class ComponentService {
    
    static scope = "singleton"
    
    // def componentSettings = new ArrayList<ObjectGraphBuilder>()
    
    def getConfiguration(key) {
        
        Class scriptClass = getClass().classLoader.loadClass('com.foxbomb.fxportal3.component.text.properties')
        
        if (scriptClass) {
            ConfigObject config = new ConfigSlurper().parse(scriptClass)
            return config;
        } else {
            return null;
        }
       
    }
    
    def overrideDefaults(id, config) {

        
        
        if (id.isNumber()) {
            def contents = Content.withCriteria {eq "pageComponent.id", id.toLong()}
            
            contents.each { field ->
                
                config.fieldDetail[field.key].default = field.value
            
            }
        }            
            
            
        
        return config;  
    }
    
}
