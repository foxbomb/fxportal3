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
            case "development":
            
                // Create Users
            
                def mark = new User(email:"mark@foxbomb.com", password:"password", fullName:"Mark van Wyk").save()
                def admin = new User(email:"admin@admin.net", password:"admin", fullName:"Super User").save()
                
                // Create Some Pages
            
                def home = new Page(title: "home", url: "/").save()
                
                new Page(title: "I want a loan", url: "/get-a-loan").save()
                new Page(title: "Choose a lender", url: "/choose-a-lender").save()
                new Page(title: "Submit a comment", url: "/submit-a-comment").save()
                
                // Create Some Components
                
                def text = new Component(title: "Text", key: "com.foxbomb.fxportal3.component.Text").save()
                def menu = new Component(title: "Menu", key: "com.foxbomb.fxportal3.component.Menu").save()    
                def header = new Component(title: "Header", key: "com.foxbomb.fxportal3.component.Header").save()
                
                new Component(title: "Html", key: "com.foxbomb.fxportal3.component.Html").save()                
                new Component(title: "Footer", key: "com.foxbomb.fxportal3.component.Footer").save()
                new Component(title: "Quiz", key: "com.foxbomb.fxportal3.component.Quiz").save()
                new Component(title: "FAQ", key: "com.foxbomb.fxportal3.component.FAQ").save()
                new Component(title: "List", key: "com.foxbomb.fxportal3.component.List").save()
                
                // Associate some Components to some Pages and give them some Content
                
                new PageComponent(title: "Loan Adviser", page: home, component: header)
                    .addToContents(new Content(title:"Header Name", key: "header_name", value: "Loan Adviser"))
                    .addToContents(new Content(title:"Slogan", key: "header_slogan", value: "Rate and review personal loans"))
                    .save()
                new PageComponent(title: "Welcome Text", page: home, component: text).save()
                    .addToContents(new Content(title:"Text", key: "text", value: "Welcome to Loan Adviser. Don't forget to give us your feedback in the Submit a Comment section!"))
                    .save()
                    
                // Crate a Permission and allows some Users this permission
                    
                def canLogin = new Permission(name: "allow_login")
                    .addToUserPermissions(new UserPermission(user: mark))
                    .addToUserPermissions(new UserPermission(user: admin))
                    .save()
                
            break;
            
            case "production":
            break;
        }
        
    }
    def destroy = {
    }
}
