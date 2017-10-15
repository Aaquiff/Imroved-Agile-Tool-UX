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
    public ArrayList<Project> projects;
    public ArrayList<Target> targets;
    public TargetsScreen_DummyData(){
        projects = null;
        
        targets = null;        
        targets.add(new Target(0, "Target 1", new Date(), new Date(2017, 12, 12), false));
        targets.add(new Target(1, "Target 2", new Date(), new Date(2017, 9, 12), false));
        targets.add(new Target(2, "Target 3", new Date(), new Date(2017, 12, 2), true));
        targets.add(new Target(3, "Target 4", new Date(), new Date(2018, 01, 6), false));
        targets.add(new Target(4, "Target 5", new Date(), new Date(2018, 02, 02), true));
        projects.add(new Project("Project 1", "Mfin Mobile Apllication", targets));
        
        targets = null;        
        targets.add(new Target(1, "Target 1", new Date(), new Date(2017, 12, 12), false));
        targets.add(new Target(2, "Target 2", new Date(), new Date(2017, 9, 12), false));
        targets.add(new Target(3, "Target 3", new Date(), new Date(2017, 12, 2), true));
        targets.add(new Target(4, "Target 4", new Date(), new Date(2018, 01, 6), false));
        targets.add(new Target(5, "Target 5", new Date(), new Date(2018, 02, 02), true));
        projects.add(new Project("Project 2", "Mfin Mobile Apllication", targets));
        
        targets = null;        
        targets.add(new Target(1, "Target 1", new Date(), new Date(2017, 12, 12), false));
        targets.add(new Target(2, "Target 2", new Date(), new Date(2017, 9, 12), false));
        targets.add(new Target(3, "Target 3", new Date(), new Date(2017, 12, 2), true));
        targets.add(new Target(4, "Target 4", new Date(), new Date(2018, 01, 6), false));
        targets.add(new Target(5, "Target 5", new Date(), new Date(2018, 02, 02), true));
        projects.add(new Project("Project 3", "Mfin Mobile Apllication", targets));
    }
    
    public ArrayList<Project> getDummyProjects()
    {
        return projects;
    }
}
