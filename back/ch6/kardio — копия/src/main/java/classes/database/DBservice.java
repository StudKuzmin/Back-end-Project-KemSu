package classes.database;

import classes.model.JWT.JavaWebToken;

import java.sql.*;

public class DBservice {
        private Statement stmt;
        private ResultSet rs;
        private PreparedStatement statement;
        private Connection con;

        private JavaWebToken jwt;
        public DBservice(){
            jwt = new JavaWebToken();
            try
            {
                String url = "jdbc:mysql://localhost/kardioCenter?serverTimezone=Europe/Moscow&useSSL=false";
                String username = "root";
                String password = "3572";
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                con = DriverManager.getConnection(url, username, password);
            } catch (Exception ex) { System.out.println("ERROR in DBservice.DBservice(): " + ex); }
        }

        public boolean userLogin(String login, String password){
            try
            {
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("SELECT * FROM users");

                while(rs.next())
                {
                    if (rs.getString("login").equals(login) && rs.getString("password").equals(password))
                        return true;
                }

                rs.close();
                stmt.close();
            }
            catch (Exception e) {
                System.out.println("Exception in DBSERVICE.reqDoLog(): " + e.getMessage());
                return false;
            }
            return false;
        }
}
