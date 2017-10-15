/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DummyData;

import java.util.ArrayList;
import models.Project;
import models.Target;
import java.util.Date;

/**
 *
 * @author lathlk
 */
public class TargetsScreen_DummyData {
    public ArrayList<Project> projects = new ArrayList<Project>();
    
    
    public TargetsScreen_DummyData(){
        ArrayList<Target> targets1 = new ArrayList<Target>();   
        targets1.add(new Target(0, "Target 1", new Date(), new Date(2017, 10, 10), false));
        targets1.add(new Target(1, "Target 2", new Date(), new Date(), false));
        targets1.add(new Target(2, "Target 3", new Date(), new Date(), true));
        targets1.add(new Target(3, "Target 4", new Date(), new Date(), false));
        targets1.add(new Target(4, "Target 5", new Date(), new Date(), true));
        projects.add(new Project("Project 1", "Mfin Mobile Apllication iOS", targets1));
        
        ArrayList<Target> targets2 = new ArrayList<Target>();   
        targets2.add(new Target(0, "Target 1", new Date(), new Date(), false));
        targets2.add(new Target(1, "Target 2", new Date(), new Date(), false));
        targets2.add(new Target(2, "Target 3", new Date(), new Date(), true));
        targets2.add(new Target(3, "Target 4", new Date(), new Date(), false));
        targets2.add(new Target(4, "Target 5", new Date(), new Date(), true));
        projects.add(new Project("Project 2", "Mfin Web Apllication", targets1));
        
        ArrayList<Target> targets3 = new ArrayList<Target>();   
        targets3.add(new Target(0, "Target 1", new Date(), new Date(), false));
        targets3.add(new Target(1, "Target 2", new Date(), new Date(), false));
        targets3.add(new Target(2, "Target 3", new Date(), new Date(), true));
        targets3.add(new Target(3, "Target 4", new Date(), new Date(), false));
        targets3.add(new Target(4, "Target 5", new Date(), new Date(), true));
        projects.add(new Project("Project 3", "Mfin Backend Server Application", targets3));
        
        ArrayList<Target> targets4 = new ArrayList<Target>();   
        targets4.add(new Target(0, "Target 1", new Date(), new Date(), false));
        targets4.add(new Target(1, "Target 2", new Date(), new Date(), false));
        targets4.add(new Target(2, "Target 3", new Date(), new Date(), true));
        targets4.add(new Target(3, "Target 4", new Date(), new Date(), false));
        targets4.add(new Target(4, "Target 5", new Date(), new Date(), true));
        projects.add(new Project("Project 4", "Mfin Mobile Apllication Android", targets4));
    }
    
    public ArrayList<Project> getDummyProjects()
    {
        return projects;
    }
    
    public Project GetProject(String name)
    {
        for(Project p: projects)
        {
            if(p.name.equalsIgnoreCase(name)){
                return p;
            }            
        }
        return null;
    }
}
