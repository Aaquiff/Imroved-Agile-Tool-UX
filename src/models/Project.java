/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author lathlk
 */
public class Project {
    public String name = "";
    public String description = "";
    public ArrayList<Target> targetList;
    public Date startDate;
    public Date endDate;
    
    public Project(String name, String desc, ArrayList<Target> targets)
    {
        this.name = name;
        this.description = desc;
        this.targetList = targets;
    }
    
    public Project(String Name, Date StartDate, Date EndDate, String Description)
    {
        this.name = Name;
        this.startDate = StartDate;
        this.endDate = EndDate;
        this.description = Description;
    }
}
