/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection.test;

import connection.ConectionFactory;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Test {
    public static void main(String[] args) {
        try {
            ConectionFactory.getConnection();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
}
