/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui.report;

import java.util.Map;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author User
 */
class ColumnChangeListener implements TableColumnModelListener {

    Map<JTable, TableColumnModelListener> map;
    JTable sourceTable;
    JTable targetTable;

    public ColumnChangeListener(JTable source, JTable target, Map<JTable, TableColumnModelListener> map) {
        this.sourceTable = source;
        this.targetTable = target;
        this.map = map;
    }

    public void columnAdded(TableColumnModelEvent e) {
    }

    public void columnSelectionChanged(ListSelectionEvent e) {
    }

    public void columnRemoved(TableColumnModelEvent e) {
    }

    public void columnMoved(TableColumnModelEvent e) {
    }

    public void columnMarginChanged(ChangeEvent e) {
        TableColumnModel sourceModel = sourceTable.getColumnModel();
        TableColumnModel targetModel = targetTable.getColumnModel();
        TableColumnModelListener listener = map.get(targetTable);

        targetModel.removeColumnModelListener(listener);

        for (int i = 0; i < sourceModel.getColumnCount(); i++) {
            targetModel.getColumn(i).setPreferredWidth(sourceModel.getColumn(i).getWidth());
        }

        targetModel.addColumnModelListener(listener);
    }
}
