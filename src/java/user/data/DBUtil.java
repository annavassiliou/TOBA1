package user.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {

    public static void closeStatement(Statement s) {
        try {
            if (s != null) {
                s.close();
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void closePreparedStatement(Statement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

}

    
    /*
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("TOBAPU");
    
    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
*/

    

