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
            
                // Create Users
            
                def mark = new User(email:"mark@foxbomb.com", password:"password", fullName:"Mark van Wyk").save()
                def admin = new User(email:"admin@admin.net", password:"admin", fullName:"Super User").save()
                
                // Create Some Pages
            
                def home = new Page(title: "home", url: "/").save()
                
                new Page(title: "I want a loan", url: "/get-a-loan").save()
                new Page(title: "Choose a lender", url: "/choose-a-lender").save()
                new Page(title: "Submit a comment", url: "/submit-a-comment").save()
                
                // Create Some Components
                
                def text = new Component(title: "Text", key: "com.foxbomb.fxportal3.component.text").save()
                def menu = new Component(title: "Menu", key: "com.foxbomb.fxportal3.component.menu").save()    
                def header = new Component(title: "Header", key: "com.foxbomb.fxportal3.component.header").save()
                
                new Component(title: "Html", key: "com.foxbomb.fxportal3.component.html").save()                
                new Component(title: "Footer", key: "com.foxbomb.fxportal3.component.footer").save()
                new Component(title: "Quiz", key: "com.foxbomb.fxportal3.component.quiz").save()
                new Component(title: "FAQ", key: "com.foxbomb.fxportal3.component.faq").save()
                new Component(title: "List", key: "com.foxbomb.fxportal3.component.list").save()
                
                // Associate some Components to some Pages and give them some Content
                            
                new PageComponent(friendlyName: "Loan Adviser", page: home, component: header)
                    .addToContents(new Content(title:"Header Name", key: "header_name", value: "Loan Adviser", iterationKey: "", iterationIndex: 0))
                    .addToContents(new Content(title:"Slogan", key: "header_slogan", value: "Rate and review personal loans", iterationKey: "", iterationIndex: 0))
                    .save()

                new PageComponent(friendlyName: "Welcome Text", page: home, component: text)
                    .addToContents(new Content(title:"Text", key: "text", value: "Welcome to Loan Adviser. Don't forget to give us your feedback in the Submit a Comment section!"))
                    .save()
                    
                // Crate a Permission and allows some Users this permission
                    
                def canLogin = new Permission(name: "allow_login")
                    .addToUserPermissions(new UserPermission(user: mark))
                    .addToUserPermissions(new UserPermission(user: admin))
                    .save()
                
            break;
        }
        
    }
    def destroy = {
    }
}
