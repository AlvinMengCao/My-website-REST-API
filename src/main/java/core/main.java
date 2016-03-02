package core;

import dao.BlogDAO;
import dao.StatusDAO;
import service.Gravatar;

/**
 * Created by alvin on 2/29/16.
 */
public class main {
    public static  void main(String[] args){
        StatusDAO statusDAO = new StatusDAO();
        statusDAO.addStatus("nihaoma");
    }
}
