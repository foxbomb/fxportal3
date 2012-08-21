package fxportal3

class AdminController {

    def home() {
        if (session.user) {
            // Default Render
        } else {
            flash.message = "Session Expired. Please log in again."
            redirect (controller:'authentication')
        }
    }
}
