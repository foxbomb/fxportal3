package fxportal3

class AuthenticationController {

    static layout = "admin"
    
    def index() {
        // Render default
    }
    
    def login() {
        def user = User.findByEmailAndPassword(params.email, params.password)
        
        if (user) {
            session.user = user
            flash.message = "Welcome"
            redirect(controller:"admin", action:"home")
            
        } else {
            flash.message = "Username or password incorrect"
            redirect(action:"index")
        }
    }
}
