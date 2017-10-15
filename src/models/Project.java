/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javafx.collections.ObservableList;

/**
 *
 * @author lathlk
 */
public class Project {
    public String name = "";
    public String description = "";
    public ObservableList<Target> targetList;
}
