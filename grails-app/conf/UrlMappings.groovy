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

        "/admin/pages/$id/delete" {
            controller = 'pages'
            action = 'delete'
        }          

        "/admin/users" {
            controller = 'users'
        }              

        /** ERRORS **/

        "500" {
            view = '/error' 
        }
        "404" {
            view = '/404'
        }

        /** AJAX **/

        "/service/component/$id/$key**" {
            controller = 'component'
            action = 'backend'
        }
    }
}
