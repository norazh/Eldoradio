package FC;

import java.sql.*;
import java.util.ArrayList;

public class OperationBD {


    public ArrayList returnArray() throws ClassNotFoundException, SQLException {
        String returnPersonnel = "SELECT Nom FROM personnel";
        ArrayList arr = new ArrayList();
        Connection con = new DbConnection().getConnection();
        PreparedStatement ps = con.prepareStatement(returnPersonnel);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            arr.add(rs.getString("Nom"));
        }
        return arr;
    }

}

