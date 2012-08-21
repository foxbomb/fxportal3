class UrlMappings {

	static mappings = {
        "/admin" {
            controller = 'authentication'
            action = 'index'
        }
        "/admin/login" {
            controller = 'authentication'
            action = 'login'
        }
        "/admin/home" {
            controller = 'admin'
            action = 'home'
        }
        
	}
}
