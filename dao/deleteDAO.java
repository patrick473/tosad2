package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class deleteDAO extends BaseDAO{

    public boolean deleteBR(int id){
        int deleted = 0;

        try (Connection con = super.getToolConnection()){

            PreparedStatement stmt = con.prepareStatement("delete from businessrule where id_businessrule = ?");
            stmt.setInt(1,id);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return deleted==1;
    }
}
