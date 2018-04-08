package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * The Data Access for Implementing business rules
 */
public class implementBusinessRuleDAO extends BaseDAO {



    /**
     * Update active business rule.
     *
     * @param businessRuleID the business rule id
     */
    public void updateActiveBusinessRule(int businessRuleID) {

        try {
            String baseStatement = "update TOSAD_2017_2C_TEAM3.businessrule set actief = 1" +
                    " where id_businessrule = " + businessRuleID;
            Connection con = getToolConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate(baseStatement);

            con.close();
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    /**
     * Update generated code.
     *
     * @param generatedCode  the generated code
     * @param businessRuleID the business rule id
     */
    public void updateGeneratedCode(String generatedCode, int businessRuleID) {
        try {
            generatedCode = generatedCode.replaceAll("'", "''");
            String baseStatement = "update TOSAD_2017_2C_TEAM3.businessrule set generatedcode = '" + generatedCode +
                    "' where id_businessrule = " + businessRuleID;
            System.out.println(baseStatement);
            Connection con = getToolConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate(baseStatement);

            con.close();
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }
}