/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author aaralk
 */
public class Sprint {
    public String name;
    public int duration;
    public String startEnd;
    public ArrayList<Task> tasks;
    public String note;

    public Sprint(String name, int duration, String startEnd, ArrayList<Task> tasks, String note) {
        this.name = name;
        this.duration = duration;
        this.startEnd = startEnd;
        this.tasks = tasks;
        this.note = note;
    }
    
}
