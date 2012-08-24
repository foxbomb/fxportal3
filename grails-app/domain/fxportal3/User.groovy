package fxportal3

class User {
    
    static constraints = {
        email(unique:true)
        password(password:true)
    }

    static hasMany = [userPermissions:UserPermission]
    
    String email
    String fullName
    String password
    
}
