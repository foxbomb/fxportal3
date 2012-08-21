package fxportal3

class User {

    static hasMany = [rights:Right]
    
    String fullName
    String email
    String passwordHash
    
}
