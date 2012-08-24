package fxportal3

class Permission {

    static hasMany = [userPermissions:UserPermission]
    
    String name
    
}
