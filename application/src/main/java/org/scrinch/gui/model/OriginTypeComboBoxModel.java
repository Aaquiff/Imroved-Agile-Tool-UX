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

package org.scrinch.gui.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import org.scrinch.model.OriginType;
import org.scrinch.model.OriginTypeFactory;
import org.scrinch.model.ScrinchEnvToolkit;

public class OriginTypeComboBoxModel implements OriginTypeFactory.Listener, ComboBoxModel {

    private List<OriginType> originTypeList = new ArrayList<OriginType>();
    private OriginType selectedOrigin;
    private List<ListDataListener> listDataListenerList = new ArrayList<ListDataListener>();

    private final ScrinchEnvToolkit toolkit;

    public void originTypeListChanged(){
        updateOriginTypeList();
        notifyListeners();
    }
    
    private void updateOriginTypeList(){
        originTypeList.clear();
        originTypeList.addAll(toolkit.getOriginTypeFactory().getOriginTypeList());
    }
    
    public OriginTypeComboBoxModel(ScrinchEnvToolkit toolkit) {
        this.toolkit = toolkit;
        updateOriginTypeList();
        toolkit.getOriginTypeFactory().addListener(this);
    }
    
    public void releaseAllResources(){
        toolkit.getOriginTypeFactory().removeListener(this);
    }

    public void setSelectedItem(Object object) {
        try {
            this.selectedOrigin = (OriginType)object;
        } catch(Exception e){
            this.selectedOrigin = null;
        }
    }

    public Object getElementAt(int i) {
        return originTypeList.get(i);
    }

    public void removeListDataListener(ListDataListener listDataListener) {
        listDataListenerList.remove(listDataListener);
    }

    public void addListDataListener(ListDataListener listDataListener) {
        listDataListenerList.add(listDataListener);
    }
    
    private void notifyListeners(){
        for(ListDataListener listener : listDataListenerList){
            listener.contentsChanged(new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, listDataListenerList.size()-1));
        }
    }

    public int getSize() {
        return this.originTypeList.size();
    }

    public Object getSelectedItem() {
        return selectedOrigin;
    }
}
