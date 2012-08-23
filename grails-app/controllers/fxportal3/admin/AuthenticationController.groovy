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
            flash.type="success"
            flash.message = "You are logged in"
            redirect(controller:"pages")
            
        } else {
            flash.type="error"
            flash.message = "Username or password incorrect"
            redirect(action:"index")
        }
    }
    
    def logout() {
        session.user = null;
        flash.type="success"
        flash.message = "Logged out"
        redirect(action:"index")
    }
}
