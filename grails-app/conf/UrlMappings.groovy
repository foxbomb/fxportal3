class UrlMappings {

	static mappings = {
        "/admin" {
            controller = 'authentication'
            action = 'index'
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
        
        "/admin/users" {
            controller = 'users'
        }                
        
	}
}
