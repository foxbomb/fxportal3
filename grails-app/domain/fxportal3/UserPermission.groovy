package fxportal3

class UserPermission {

    static belongsTo = [users: User, permissions: Permission]
    
}
