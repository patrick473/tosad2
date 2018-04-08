package controller;

import domain.attributeListRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * The controller Generate attribute listrule.
 */
public class generateAttributeListrule {

    /**
     * declaration of general control functions
     */
    private generalControllerFunctions gtws = new generalControllerFunctions();

    /**
     * Decide type generated of attribute list rule.
     *
     *  returns a string
     *
     * @param listRule the list rule
     * @return listRule
     */
    public attributeListRule decideTypeGeneratedAttrList(attributeListRule listRule) {
        String result = "";
        if (listRule.isConstraint()) {
            result = createAttributeListRuleConstraint(listRule);
        }
        if (listRule.isTrigger()) {
            result = createAttributeListRuleTrigger(listRule);

        }
        listRule.setGeneratedCode(result);
        return listRule;
    }

    /**
     * Create attribute list rule trigger .
     *
     * @param listRule the list rule
     * @return generated code
     */
    public String createAttributeListRuleTrigger(attributeListRule listRule) {


        String query =  "create or replace trigger "+ listRule.getName()+" "+
                " "+
                gtws.generateTriggerWhenString(listRule.isInsert(),listRule.isDelete(),listRule.isUpdate(),listRule.getMainTable(),listRule.getAffectedColumn())+
                " for each row " +
                "when (INSTR(',' || "+listRule.getList()+" || ','\n" +
                "        ,',' || NEW."+listRule.getAffectedColumn()+" || ',') > 0 )"+
                "begin"+
                "raise_Application_Error(-20000, '"+listRule.getErrorCode()+"');"+

                "end;";
        return query;
    }

    /**
     * Create attribute list rule constraint .
     *
     * @param listRule the list rule
     * @return generated code
     */
    public String createAttributeListRuleConstraint(attributeListRule listRule) {
        String basestring = "alter table ";

        basestring += listRule.getMainTable() + "\n";
        basestring += "add constraint " + listRule.getName() + "\n";
        basestring += "check( " + listRule.getAffectedColumn();
        if (listRule.isInList()) {
            basestring += " in ";

        } else {
            basestring = " not in ";
        }

        basestring += " (" + generateStringfromlistForConstraint(listRule);

        return basestring;
    }


    /**
     * Generates a string of a list for triggers .
     *
     * @param listRule the list rule
     * @return the string
     */


    /**
     * Generate a string of a list for constraints .
     *
     * @param listRule the list rule
     * @return the string
     */
    public String generateStringfromlistForConstraint(attributeListRule listRule) {
        String basestring = "";
        List<String> list = Arrays.asList(listRule.getList().split(","));
        int counter = 0;

        for (String i : list) {
            if (counter > 0) {
                basestring += ", ";

            }
            basestring += "'" + i + "'";
            counter++;
        }
        basestring += "));";
        return basestring;

    }
}
