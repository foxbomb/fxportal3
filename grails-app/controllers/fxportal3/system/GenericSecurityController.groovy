package fxportal3.system

class GenericSecurityController {

    def index() {}
    
    def authorize() {
        def user = session.user
        if (!user) {
            flash.message = "Your session has expired - please log in again"
            flash.type="warning"
            redirect (controller: 'authentication')
        }
    }
}
