package core;

import dao.WebsiteCommentDAO;

/**
 * Created by alvin on 2/25/16.
 */
public class main {
    public static void main(String[] args){
        WebsiteCommentDAO websiteCommentDAO = new WebsiteCommentDAO();
        websiteCommentDAO.addComment("nihao","wobuhao");
    }
}
