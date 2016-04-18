package core;

import dao.StatusDAO;

/**
 * Created by alvin on 2/29/16.
 * For test, no function related with this project
 */
public class main {
    public static  void main(String[] args){
        StatusDAO statusDAO = StatusDAO.getStatusDAO();
        statusDAO.addStatus("nihaoma");
    }
}
