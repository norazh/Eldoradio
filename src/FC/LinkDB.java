package FC;

import java.sql.*;

public class LinkDB {
    public String url;
    public String user;
    public String mdp;
    public Connection connection = null;
    public Statement statement = null;
    public ResultSet resultSet = null;

    public LinkDB(String url, String user, String mdp){
        this.url = url;
        this.user = user;
        this.mdp = mdp;
    }

    public LinkDB(){
        this.url = "";
        this.user = user;
        this.mdp = mdp;

    }
}


