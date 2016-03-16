/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;
import java.sql.*;
/**
 *
 * @author Felipe
 */
public class bd {
    private Connection connection;
    private Statement statement ;
    private PreparedStatement prep ;
    private ResultSet result;
    public bd(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd1","root","DAIPP2");
        statement = connection.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    /**Método que verifica que o utilizador existe,retorna true se sim
     * ou false se não existe
     * @param user String
     * @param password String
     * @return boolean
     */
    public boolean existe(String user,String password){
        boolean flag = false ;
        try{
            String query = "SELECT users.user FROM users WHERE users.user='"+user+"' AND users.password='"+password+"'";
            result = statement.executeQuery(query);
            flag = result.next();
        }catch(Exception e){
            System.out.println(e);
        }
        return flag;
    }
}
