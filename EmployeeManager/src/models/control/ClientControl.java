/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.control;

import dataobject.ClientObj;
import dataobject.CriteriaSearch;
import java.util.List;
import models.Client;
import org.javalite.activejdbc.Base;

/**
 *
 * @author TRONG
 */
public class ClientControl {

    public ClientControl() {
        if (!Base.hasConnection()) {
            Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/test", "root", "");
        }
    }

    public void createClient(List<Client> clientLst) {
        for (Client clientItem : clientLst) {
            clientItem.saveIt();
        }
    }

    public List<Client> getAllClients() {
        List<Client> clientLst = Client.findAll();
        return clientLst;
    }

    public List<Client> getClientByCriteria(CriteriaSearch type) {
        List<Client> clientLst = null;

        return clientLst;
    }

    public List<Client> getAllClientPaging(int pageNum, int height) {
        List<Client> clientLst = Client.findAll().offset(pageNum * height).limit(height);
        return clientLst;
    }

    public void deleteAllClients() {
        Client.deleteAll();
    }

    public void deleteClient(Client client) {
        client.delete();
    }
}
