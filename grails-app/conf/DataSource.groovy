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
            dbCreate = "create-drop"
            url = "jdbc:mysql://localhost/fxportal3"            
        }
    }
    production {
        dataSource {
            username = "b5149526887d72"
            password = "d6f06a38"
            dbCreate = "create-drop"
            logSql = true
            formatSql = true
            url = "jdbc:mysql://us-cdbr-east.cleardb.com/heroku_c51a83649879755"                        
        }
    }
}
