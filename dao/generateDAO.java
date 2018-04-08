package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class generateDAO extends BaseDAO{

    public boolean implementbr(String query){
        int added = 0;

        try (Connection con = super.getTargetConnection()) {

            Statement stmt = con.createStatement();
           added = stmt.executeUpdate(query);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return added==1;
    }
    public void deletebrfromtarget(String name){


        try (Connection con = super.getToolConnection()) {

            Statement stmt = con.createStatement();

                if (checktrigger(name)){
                    stmt.executeUpdate("drop trigger "+name);
                }


        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public boolean checktrigger(String name){
        try (Connection con = super.getToolConnection()) {

            Statement stmt = con.createStatement();


            ResultSet rs = stmt.executeQuery("select * from user_triggers where trigger_name =  "+name);
            if (!rs.next()) {                            //if rs.next() returns false

                System.out.println("No records found");
                return false;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return true;

    }
}
