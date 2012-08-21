import fxportal3.User
import grails.util.GrailsUtil

class BootStrap {

    def init = { servletContext ->
        
        switch (GrailsUtil.environment) {
            case "development":
                def admin = new User(email:"test@test.com", password:"password", fullName:"admin")
                admin.save();
            break;
            
            case "production":
            break;
        }
        
    }
    def destroy = {
    }
}
