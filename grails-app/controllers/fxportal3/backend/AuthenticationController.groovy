package fxportal3.admin

import fxportal3.User

class AuthenticationController {

    static layout = "admin"
    
    def index() {
        render(view:"/authentication/index")
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
