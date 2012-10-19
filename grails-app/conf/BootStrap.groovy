import fxportal3.Component
import fxportal3.Content
import fxportal3.Page
import fxportal3.PageComponent
import fxportal3.Permission
import fxportal3.User
import fxportal3.UserPermission
import grails.util.GrailsUtil

class BootStrap {

    def init = { servletContext ->
        
        switch (GrailsUtil.environment) {
            
            case "production":
            case "development":
                
                if (!User.count()) {
            
                    // Create Users

                    def mark = new User(email:"mark@foxbomb.com", password:"password", fullName:"Mark van Wyk").save()
                    def admin = new User(email:"admin@admin.net", password:"admin", fullName:"Super User").save()

                    // Create Some Pages

                    def home = new Page(title: "home", url: "/").save()

                    // Create Some Components

                    def text = new Component(title: "Text", key: "com.foxbomb.fxportal3.component.text").save()

                    // Associate some Components to some Pages and give them some Content

                    new PageComponent(friendlyName: "Introduction", page: home, component: text)
                        .addToContents(new Content(key: "text", value: "This is the default text that you can change.", iterationKey: "", iterationIndex: 0))
                        .addToContents(new Content(key: "markdown", value: "yes", iterationKey: "", iterationIndex: 0))
                        .addToContents(new Content(key: "paginate", value: "yes", iterationKey: "", iterationIndex: 0))
                        .addToContents(new Content(key: "wordsperpage", value: "50", iterationKey: "", iterationIndex: 0))
                        .save()

                    new PageComponent(friendlyName: "Welcome Text", page: home, component: text)
                        .addToContents(new Content(title:"Text", key: "text", value: "Welcome to Loan Adviser. Don't forget to give us your feedback in the Submit a Comment section!"))
                        .save()

                    // Crate a Permission and allows some Users this permission

                    def canLogin = new Permission(name: "allow_login")
                        .addToUserPermissions(new UserPermission(user: mark))
                        .addToUserPermissions(new UserPermission(user: admin))
                        .save()
                        
                } // if
                
            break;
        }
        
    }
    def destroy = {
    }
}
