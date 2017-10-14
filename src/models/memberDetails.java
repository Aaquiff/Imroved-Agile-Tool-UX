/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Apisajan
 */
public class memberDetails {
    public String nickName;
    public String fullName;
    public int internalPhone;
    public long mobileNumber;
    public String status;
    
    public memberDetails(String nick,String full,int internal,long mobile ,String status){
        this.fullName = full;
        this.nickName = nick;
        this.internalPhone=internal;
        this.mobileNumber = mobile;
        this.status = status;
    }
}
