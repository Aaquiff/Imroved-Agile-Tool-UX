/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author aaralk
 */
public class Task {

    
    private SimpleStringProperty id = new SimpleStringProperty("id");
    private SimpleStringProperty title = new SimpleStringProperty("");
    private SimpleStringProperty description = new SimpleStringProperty("");
    private SimpleStringProperty origin = new SimpleStringProperty("");
    private SimpleStringProperty type = new SimpleStringProperty("");
    private SimpleStringProperty bv = new SimpleStringProperty("");
    private SimpleStringProperty w = new SimpleStringProperty("");
    private SimpleStringProperty target = new SimpleStringProperty("");
    private SimpleStringProperty status = new SimpleStringProperty("");
    private SimpleStringProperty project = new SimpleStringProperty("");
    private SimpleStringProperty sprint = new SimpleStringProperty("");

    public Task(String pid,String pproject) {
        id.set(pid);
        project.set(pproject);
    }

    
    
    public Task(String pid, String ptitle, String pdescription, String porigin, String ptype, int pbv, int pw, String ptarget, String pstatus, String pproject, String psprint) {
        id.set(pid);
        title.set(ptitle);
        description.set(pdescription);
        origin.set(porigin);
        type.set(ptype);
        bv.set(Integer.toString(pbv));
        w.set(Integer.toString(pw));
        target.set(ptarget);
        status.set(pstatus);
        project.set(pproject);
        sprint.set(psprint);
        
    }
    
    public void setStatus(String pstatus){
        status.set(pstatus);
    }
    
    public String getId() {
        return id.get();
    }

    public String getTitle() {
        return title.get();
    }

    public String getDescription() {
        return description.get();
    }

    public String getOrigin() {
        return origin.get();
    }

    public String getType() {
        return type.get();
    }

    public String getBv() {
        return bv.get();
    }

    public String getW() {
        return w.get();
    }

    public String getTarget() {
        return target.get();
    }


    public String getStatus() {
        return status.get();
    }


    public String getProject() {
        return project.get();
    }


    public String getSprint() {
        return sprint.get();
    }


    
    
}
