/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author lathlk
 */
public class Target {
    public int targetId;
    public String targetDescription;
    public Date created;
    public Date dueDate;
    public boolean status;   
    
    public Target(int id, String des, Date created, Date due, boolean stat){
        targetId = id;
        targetDescription = des;
        this.created = created;
        dueDate = due;
        status = stat;
    }
}
