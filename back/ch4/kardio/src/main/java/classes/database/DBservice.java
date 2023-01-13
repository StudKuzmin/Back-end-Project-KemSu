package classes.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBservice {
        private Statement stmt;
        private ResultSet rs;
        private PreparedStatement statement;
        private Connection con;

        public DBservice(){
            try
            {
                String url = "jdbc:mysql://localhost/kardioCenter?serverTimezone=Europe/Moscow&useSSL=false";
                String username = "root";
                String password = "3572";
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                con = DriverManager.getConnection(url, username, password);
            } catch (Exception ex) { System.out.println("ERROR in DBservice.DBservice: " + ex); }
        }

        public boolean checkUserData(String login, String password){
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
                System.out.println("ERROR in DBservice.userLogin: " + e.getMessage());
                return false;
            }
            return false;
        }
        public List<ArrayList<String>> getUserList(){
            List<ArrayList<String>> userList = new ArrayList<>();

            try
            {
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("SELECT * FROM users");

                for(int i = 0; rs.next(); i++){
                    userList.add(new ArrayList<>());
                    userList.get(i).add(rs.getString(1));
                    userList.get(i).add(rs.getString(2));
                    userList.get(i).add(rs.getString(3));
                    userList.get(i).add(rs.getString(4));
                    userList.get(i).add(rs.getString(5));
                    userList.get(i).add(rs.getString(6));
                    userList.get(i).add(rs.getString(7));
                    userList.get(i).add(rs.getString(8));
                }

                System.out.println(userList);

                rs.close();
                stmt.close();
            }
            catch (Exception e) {
                System.out.println("ERROR in DBservice.userLogin: " + e.getMessage());
            }

            return userList;
        }
}
