/*
 Scrinch is a stand-alone Swing application that helps managing your
 projects based on Agile principles.
 Copyright (C) 2007  Julien Piaser, Jerome Layat, Peter Fluekiger,
 Christian Lebaudy, Jean-Marc Borer

 Scrinch is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 Scrinch is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.scrinch.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class DatePanel extends javax.swing.JPanel {

    private List<ActionListener> actionListenerList = new Vector();
    
    public DatePanel() {
        initComponents();
        jXDatePicker.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
    }

    public void addActionListener(ActionListener listener) {
        actionListenerList.add(listener);
    }

    public void removeActionListener(ActionListener listener){
        actionListenerList.remove(listener);
    }

    private void fireActionPerformed(){
        for(int i=0; i<actionListenerList.size(); i++){
            actionListenerList.get(i).actionPerformed(new ActionEvent(this,0,""));
        }
    }

    public String getText(){
        Date date = this.jXDatePicker.getDate();
        if( date==null ){
            date = new Date(0);
        }
        return ScrinchGuiToolkit.getDefaultDayFormat().format(date);
    }

    public void setText(String text){
        try{
            this.jXDatePicker.setDate(ScrinchGuiToolkit.getDefaultDayFormat().parse(text));
        }catch(ParseException pe){
            this.jXDatePicker.setDate(new Date());
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXDatePicker = new org.jdesktop.swingx.JXDatePicker();

        setLayout(new java.awt.BorderLayout());

        jXDatePicker.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateChanged(evt);
            }
        });
        add(jXDatePicker, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void dateChanged(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateChanged
        fireActionPerformed();
    }//GEN-LAST:event_dateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker jXDatePicker;
    // End of variables declaration//GEN-END:variables

}