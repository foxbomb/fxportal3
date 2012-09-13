class UrlMappings {

	static mappings = {
        "/" {
            view = '/index'
        }
        "/admin" {
            controller = "authentication"
            action = "index"
        }
        "/admin/auth/login" {
            controller = 'authentication'
            action = 'login'
        }
        "/admin/auth/logout" {
            controller = 'authentication'
            action = 'logout'
        }        
        "/admin/pages" {
            controller = 'pages'
        }
        "/admin/pages/$id" {
            controller = 'pages'
        }                
        
        "/admin/pages/$id/save" {
            controller = 'pages'
            action = 'save'
        }                
        
        "/admin/users" {
            controller = 'users'
        }              
        "500" {
            view = '/error' 
        }
        "404" {
            view = '/404'
        }
        
	}
}
