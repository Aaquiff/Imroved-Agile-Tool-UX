/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author lathlk
 */
public class Project {
    public String name = "";
    public String description = "";
    public ArrayList<Target> targetList;
    
    public Project(String name, String desc, ArrayList<Target> targets)
    {
        this.name = name;
        this.description = desc;
        this.targetList = targets;
    }
}
