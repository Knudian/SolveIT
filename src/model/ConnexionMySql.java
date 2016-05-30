/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionMySql {


    private String host = "176.16.10.5:3306";
    private String db_name = "projetjava_dl05groupe3";
    private String user = "dl05groupe3";
    private String pass = "s07v3!t_JYK";
    private String driver_pass = "com.mysql.jdbc.Driver";

    private static Connection instance;

    private ConnexionMySql() {

        try {
            Class.forName(driver_pass);
            this.instance = DriverManager.getConnection(
                    "jdbc:mysql://" + host + "/" + db_name,
                    user,
                    pass
            );
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void finalize() {
        try {
            instance.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getInstance() {
        if (instance == null) {
            instance = new ConnexionMySql().instance;
        }
        return instance;
    }

}
