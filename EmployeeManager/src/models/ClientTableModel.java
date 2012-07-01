/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author TRONG
 */
public class ClientTableModel extends AbstractTableModel{

    private List<Client> clientLst;
    private String[] header = {"ID", "F.Name", "L.Name"};
    private String[] headerDB = {"id", "first_name", "last_name"};

    public ClientTableModel() {
    }

    public void initData(List<Client> clientLst){
        this.clientLst = clientLst;
        this.fireTableDataChanged();
    }
    
    @Override
    public int getColumnCount() {
//        throw new UnsupportedOperationException("Not supported yet.");
        return header.length;
    }

    @Override
    public int getRowCount() {
//        throw new UnsupportedOperationException("Not supported yet.");
        return clientLst.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
//        throw new UnsupportedOperationException("Not supported yet.");
        return clientLst.get(rowIndex).get(headerDB[columnIndex]);
    }
    
    @Override
    public String getColumnName(int index) {
        return header[index];
    }
    
}
