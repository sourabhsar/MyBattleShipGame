import java.sql.*;

/**
 * Created by Sourabh on 4/21/2018.
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("-------- Oracle JDBC Connection Testing ------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return;

        }

        System.out.println("Oracle JDBC Driver Registered!");

        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "select * from dump where s_no = 1";
        int id =0;
        String name = "";
        String mobile = "";
        try {

            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "piku", "piku");
            st = connection.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                id = rs.getInt("s_no");
                name = rs.getString("name");
                mobile = rs.getString("mobile_no");
            }

            System.out.println("Entity found\n");
            System.out.println(id + " " + name + " " + mobile);


        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        } finally {
            try {
                if(st != null) {
                    System.out.println("CLosing statement");
                    st.close();
                }
                if(rs != null) {
                    System.out.println("Closing resultset");
                    rs.close();
                }
                if (connection != null) {
                    System.out.println("Closing connection");
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Not able to close the connection : " +e);
            }
        }
    }
}
