package com.abdelkhalek_bane.tp_android;

class User {

    public String first_name ;
    public String last_name  ;
    public String avatar  ;
    public String email  ;

    public User(String name , String last_name , String avatar){
        this.first_name = name  ;
        this.last_name  = last_name ;
        this.avatar = avatar ;
    }

    public User(String name , String last_name , String avatar ,String email ){
        this.first_name = name  ;
        this.last_name  = last_name ;
        this.avatar = avatar ;
        this.email  = email  ;
    }
}
