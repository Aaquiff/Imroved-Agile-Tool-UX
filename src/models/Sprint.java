/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author aaralk
 */
public class Sprint {
    public String name;
    public long duration;
    public ArrayList<Task> tasks;
    public String note;
    public Date startDate;
    public Date endDate;
    
    public String startEnd()
    {
        DateFormat dateFormat = DateFormat.getDateInstance();
        return dateFormat.format(startDate) +  " - " + dateFormat.format(endDate);
    }
    
    public int getDateDiff() {
        return (int)( (endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24) );
    }

    public Sprint(String name, Date startDate, Date endDate, ArrayList<Task> tasks, String note) {
        this.name = name;
        int diffInDays = (int)( (endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24) );
        this.duration = diffInDays;
        this.tasks = tasks;
        this.note = note;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public Sprint(String name, Date startDate, Date endDate) {
        this.name = name;
        int diffInDays = (int)( (endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24) );
        this.duration = diffInDays;
        this.startDate = startDate;
        this.endDate = endDate;
    }    

    public Sprint(String name, int duration, String startEnd, ArrayList<Task> tasks, String note) {
        this.name = name;
        this.duration = duration;
        this.tasks = tasks;
        this.note = note;
    }
    
}
