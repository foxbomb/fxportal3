import fxportal3.User
import fxportal3.Page
import grails.util.GrailsUtil

class BootStrap {

    def init = { servletContext ->
        
        switch (GrailsUtil.environment) {
            case "development":
                new User(email:"mark@foxbomb.com", password:"password", fullName:"admin").save()
                new Page(title: "home", url: "/").save()
                new Page(title: "I want a loan", url: "/get-a-loan").save()
                new Page(title: "Choose a lender", url: "/choose-a-lender").save()
                new Page(title: "Submit a comment", url: "/submit-a-comment").save()
            break;
            
            case "production":
            break;
        }
        
    }
    def destroy = {
    }
}
