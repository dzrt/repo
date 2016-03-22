/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd1","root","");
        statement = connection.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    /**This method verifies if a given username exists with the correct password
     * 
     * @param user String
     * @param password String
     * @return boolean
     */
    public boolean isUser(String user,String password){
        boolean flag = false ;
        try{
            String query = "SELECT user.username FROM user WHERE user.username='"+user+"' AND user.password='"+password+"'";
            result = statement.executeQuery(query);
            flag = result.next();
        }catch(Exception e){
            System.out.println(e);
        }
        return flag;
    }
    /**This method returns the next 7 days including today's date 
     * 
     * @return Array
     */
    public String[] getNext7Days(){
        //Date format
        String dias[] = new String[7];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        for(int i = 0;i <= 6;i++){
             cal.add(Calendar.DATE, i);            
             dias[i] = sdf.format(cal.getTime());
             cal.add(Calendar.DATE,-i);
        }
    return dias;
    }
    /**This method return the number of events a given username has 
     * 
     * @param username
     * @return int
     */
    public int getAgendaRows(String username){
        int i = 0;
        String query = "SELECT agenda.day,agenda.urgency,agenda.description FROM agenda WHERE agenda.username='"+username+"'";
        try{
        result = statement.executeQuery(query);
        while(result.next()){
            i++;
        }
        }catch(Exception e){
            System.out.println(e);
        }
        return i ;
    }
    /**This method return a multidimensional array that contains the days,events and descriptions of the giver username's agenda.
     * 
     * @param username 
     */
    public String[][] getAgenda(String username){
        int i = getAgendaRows(username);
        String array[][] = new String[i][3];
        String query = "SELECT agenda.day,agenda.urgency,agenda.description FROM agenda WHERE agenda.username='"+username+"'";
        try{
            result = statement.executeQuery(query);
            int ii = 0;
            while(result.next()){
                array[ii][0] = result.getString("day");
                array[ii][1] = result.getString("urgency");
                array[ii][2] = result.getString("description");
                ii++;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return array;
    }
}