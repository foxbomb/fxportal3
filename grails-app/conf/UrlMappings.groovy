class UrlMappings {

    static mappings = {

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
        "/admin/pages/$id/delete" {
            controller = 'pages'
            action = 'delete'
        }          
        "/admin/users" {
            controller = 'users'
        }
        "/service/component/$id/$key**" {
            controller = 'componentAdmin'
            action = 'backend'
        }        
        "/plugin-test" {
            controller = 'test'
        }
        "/go/**" {
            controller = 'content'
        }
        "/go**" {
            controller = 'content'
        }        
        "500" {
            view = '/error' 
        }
        "404" {
            view = '/404'
        }
    }
}
