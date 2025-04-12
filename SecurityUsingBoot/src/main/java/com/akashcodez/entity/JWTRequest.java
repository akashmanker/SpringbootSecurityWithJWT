package com.akashcodez.entity;

public class JWTRequest {

    String useremail;

    String password;

    public JWTRequest(String useremail, String password) {
        this.useremail = useremail;
        this.password = password;
    }

    public JWTRequest() {
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
