package fxportal3.helpers

import org.hibernate.collection.PersistentSet
import fxportal3.*

class Contents {

    def list = new ArrayList<Content>();
    
    Contents(PersistentSet<Content> data) {
        
        data.each () {
            list.add (it)
        }
        
    }
    
    public String getByKey(String key) {
        
        list.each() {
            if (it.key == key) {
                return it.value
            }
        }
        
    }

    public Map<String, String> getMap() {
        def map = new HashMap<String, String>()
        list.each() {
            map.put(it.key, it.value)
        }        
        return map
    }
    
}

