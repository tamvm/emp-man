/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.filechooser.FileNameExtensionFilter;
import models.Client;
import models.ClientTableModel;
import models.control.ClientControl;
import net.miginfocom.swing.MigLayout;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 *
 * @author tamvo
 */
public class ClientListPanel extends AbstractPanel {

    private JScrollPane scrollPane;
    private JTable tblClient;
    private ClientTableModel absTblModel;
    private ClientControl ctrlClient;
    private JButton btnImport;
    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnDelete;

    public ClientListPanel() {
    }

    protected void initComponents() {
        setLayout(new MigLayout("wrap 2", "[grow,800] []", "[grow,300]"));
        ctrlClient = new ClientControl();
        initTable();

        btnAdd = getImageButton("img/list-add.png", "Add");
        btnEdit = getImageButton("img/edit-redo.png", "Edit");
        btnDelete = getImageButton("img/list-remove.png", "Delete");
        btnImport = getImageButton("img/list-add.png", "Import");

        add(scrollPane, "grow");
        add(btnAdd, "sg 1, split 4, flowy, top");
        add(btnEdit, "sg 1");
        add(btnDelete, "sg 1");
        add(btnImport, "sg 1, wrap");
        initButtonControl();
    }

    public void initButtonControl() {
        btnImport.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser(".");
                FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("excel files (*.xls)", "xls", "xlsx");
                fileChooser.setDialogTitle("Choose a file for import data");
                fileChooser.addChoosableFileFilter(xmlfilter);
                int res = fileChooser.showOpenDialog(null);
                if (res == JFileChooser.APPROVE_OPTION) {
                    ctrlClient.createClient(read(fileChooser.getSelectedFile()));
                    dataChanged(ctrlClient.getAllClientPaging(0, 10));
                }
            }
        });

        btnAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });

        btnEdit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });

        btnDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });

    }

    private static List<Client> read(File fileName) {
        int countAttr;
        List<Client> clientLst = new ArrayList<Client>();
        try {
            FileInputStream myInput = new FileInputStream(fileName);
            POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
            HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);
            HSSFSheet mySheet = myWorkBook.getSheetAt(0);
            Iterator rowIter = mySheet.rowIterator();
            rowIter.next();
            while (rowIter.hasNext()) {
                HSSFRow myRow = (HSSFRow) rowIter.next();
                countAttr = 0;
                Iterator cellIter = myRow.cellIterator();
                Client client = new Client();
                while (cellIter.hasNext()) {
                    countAttr++;
                    HSSFCell myCell = (HSSFCell) cellIter.next();
                    client.set(Client.attributes().get(countAttr), myCell.getStringCellValue());
                }
                clientLst.add(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientLst;
    }

    private void initTable() {
        absTblModel = new ClientTableModel();
        absTblModel.initData(ctrlClient.getAllClientPaging(0, 10));
        scrollPane = getTable(absTblModel);
        tblClient = (JTable) ((JViewport) scrollPane.getComponent(0)).getComponent(0);
    }

    public void dataChanged(List<Client> clientLst) {
        absTblModel.initData(clientLst);
        tblClient.setModel(absTblModel);
        this.updateUI();
    }

    public String toString() {
        return "Clients";
    }
}
