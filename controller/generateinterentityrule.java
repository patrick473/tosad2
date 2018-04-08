package controller;

import domain.interEntityCompareRule;

/**
 * The Controller Generate inter entity rule.
 */
public class generateinterentityrule {

    private generalControllerFunctions gtws = new generalControllerFunctions();

    /**
     * Decide type generated inter entity compare inter entity compare rule.
     *
     * @param compareRule the compare rule
     * @return the inter entity compare rule
     */
    public interEntityCompareRule decideTypeGeneratedIEcomp(interEntityCompareRule compareRule) {
        String result = "";
        if (compareRule.isConstraint()) {
            result = createinterentityRuleConstraint(compareRule);
        }
        if (compareRule.isTrigger()) {
            result = createinterentityRuleTrigger(compareRule);

        }
        compareRule.setGeneratedCode(result);
        return compareRule;
    }

    /**
     * Create interentity rule trigger .
     *
     * @param compareRule the compare rule
     * @return the string
     */
    public String createinterentityRuleTrigger(interEntityCompareRule compareRule) {


        String query =  "create or replace trigger "+ compareRule.getName()+" "+
                " "+
                 gtws.generateTriggerWhenString(compareRule.isInsert(),compareRule.isDelete(),compareRule.isUpdate(),compareRule.getMainTable(),compareRule.getAffectedColumn())+
                " for each row " +
                "when (NEW."+compareRule.getAffectedColumn()+" "+compareRule.getOperator()+" "+compareRule.getOtherTable()+"."+compareRule.getOtherColumn()+" )"+
                "begin"+
                "raise_Application_Error(-20000, '"+compareRule.getErrorCode()+"');"+
                "end;";
        return query;
    }

    /**
     * Create interentity rule constraint .
     *
     * @param compareRule the compare rule
     * @return the string
     */
    public String createinterentityRuleConstraint(interEntityCompareRule compareRule) {

        String basestring = "alter table ";

        basestring += compareRule.getMainTable() + "\n";
        basestring += "add constraint " + compareRule.getName() + " check ("
                + compareRule.getMainTable() + "." + compareRule.getAffectedColumn() + " " + compareRule.getOperator()
                + compareRule.getOtherTable() + "." + compareRule.getOtherColumn() + ");";
        return basestring;


    }
}
