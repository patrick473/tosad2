package controller;


import domain.attributeCompareRule;


/**
 * The controller Generate attribute compare rule.
 */
public class generateAttributeCompareRule {
    /**
     * declaration of general control functions
     */
    private generalControllerFunctions gtws = new generalControllerFunctions();

    /**
     * Decide type generated of  attribute compare string.
     *
     * returns object
     * for now returns a string
     * @param compareRule the compare rule
     * @return compareRule
     */
    public attributeCompareRule decideTypeGeneratedAttrComp(attributeCompareRule compareRule) {
        String result = "";
        //checks if rule is constraint or trigger and calls the corresponding function
        if (compareRule.isConstraint()) {
            result = createAttributeCompareRuleConstraint(compareRule);
        }
        if (compareRule.isTrigger()) {
            result = createAttributeCompareRuleTrigger(compareRule);

        }
        //sets generatedcode of attributecomparerule
        compareRule.setGeneratedCode(result);
        return compareRule;
    }

    /**
     * Create attribute compare rule trigger.

     * @param compareRule the compare rule
     * @return generated code
     */
    public String createAttributeCompareRuleTrigger(attributeCompareRule compareRule) {

      String query =  "create or replace trigger "+ compareRule.getName()+" "+
        " "+
        gtws.generateTriggerWhenString(compareRule.isInsert(),compareRule.isDelete(),compareRule.isUpdate(),compareRule.getMainTable(),compareRule.getAffectedColumn())+
        " for each row " +
        "when (NEW."+compareRule.getAffectedColumn()+" "+compareRule.getOperator()+" "+compareRule.getValue()+" )"+
        " begin "+
        "raise_Application_Error(-20000, '"+compareRule.getErrorCode()+"');"+
        "end;";
        return query;
    }

    /**
     * Create attribute compare rule constraint .

     * @param compareRule the compare rule
     * @return generated code
     */
    public String createAttributeCompareRuleConstraint(attributeCompareRule compareRule) {

        String basestring = "alter table ";

        basestring += compareRule.getMainTable() + "\n";
        basestring += "add constraint " + compareRule.getName() + " check (" + compareRule.getAffectedColumn() + " "
                + compareRule.getOperator() + " " + compareRule.getValue()+ ");";
        return basestring;


    }

}