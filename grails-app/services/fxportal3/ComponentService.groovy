package fxportal3

class ComponentService {
    
    static scope = "singleton"
    
    // def componentSettings = new ArrayList<ObjectGraphBuilder>()
    
    def getConfiguration(key) {
        
        println("Initiating Component:" + key)
        
        Class scriptClass = getClass().classLoader.loadClass('com.foxbomb.fxportal3.component.text.properties')
        
        if (scriptClass) {
            ConfigObject config = new ConfigSlurper().parse(scriptClass)
            return config;
        } else {
            return null;
        }
       
    }
}
