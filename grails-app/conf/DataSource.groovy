dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
    dialect = "org.hibernate.dialect.MySQLDialect"
    properties { 
       validationQuery="select 1" 
       testWhileIdle=true 
       timeBetweenEvictionRunsMillis=60000 
    }     
    
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
            username = "root"
            password = ""
            dbCreate = "update"
            url = "jdbc:mysql://localhost/fxportal3"            
        }
    }
    production {
        dataSource {
            username = "b32fe4f8d41690"
            password = "e11c648f"
            dbCreate = "update"
            logSql = true
            formatSql = true
            url = "jdbc:mysql://us-cdbr-east-02.cleardb.com/heroku_61a3b1a094f3e54"   
            
        }
    }
}
