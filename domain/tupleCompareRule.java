package domain;

public class tupleCompareRule extends BusinessRule {

    private String secondcolumn;

    private String operator;

    //getters and setters
    public String getSecondcolumn() {
        return secondcolumn;
    }

    public String getOperator() {
        return operator;
    }


    public void setSecondcolumn(String secondcolumn) {
        this.secondcolumn = secondcolumn;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }


    @Override
    public String toString() {
        return "tupleCompareRule{" +
                "operator='" + operator + '\'' +

                ", secondcolumn='" + secondcolumn + '\'' +
                "} " + super.toString();
    }

    public static final class tupleCompareRuleBuilder {
        protected String code;
        protected String name;
        protected String explanation;
        protected String mainTable;
        protected boolean insert;
        protected boolean update;
        protected boolean delete;
        protected boolean trigger;
        protected boolean constraint;
        protected String generatedCode;
        protected String errorCode;
        protected String affectedColumn;
        protected String example;
        protected int BusinessRuleID;
        private String secondcolumn;
        private String operator;

        private tupleCompareRuleBuilder() {
        }

        public static tupleCompareRuleBuilder atupleCompareRule() {
            return new tupleCompareRuleBuilder();
        }

        public tupleCompareRuleBuilder setSecondcolumn(String secondcolumn) {
            this.secondcolumn = secondcolumn;
            return this;
        }

        public tupleCompareRuleBuilder setOperator(String operator) {
            this.operator = operator;
            return this;
        }

        public tupleCompareRuleBuilder setCode(String code) {
            this.code = code;
            return this;
        }

        public tupleCompareRuleBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public tupleCompareRuleBuilder setExplanation(String explanation) {
            this.explanation = explanation;
            return this;
        }

        public tupleCompareRuleBuilder setMainTable(String mainTable) {
            this.mainTable = mainTable;
            return this;
        }

        public tupleCompareRuleBuilder setInsert(boolean insert) {
            this.insert = insert;
            return this;
        }

        public tupleCompareRuleBuilder setUpdate(boolean update) {
            this.update = update;
            return this;
        }

        public tupleCompareRuleBuilder setDelete(boolean delete) {
            this.delete = delete;
            return this;
        }

        public tupleCompareRuleBuilder setTrigger(boolean trigger) {
            this.trigger = trigger;
            return this;
        }

        public tupleCompareRuleBuilder setConstraint(boolean constraint) {
            this.constraint = constraint;
            return this;
        }

        public tupleCompareRuleBuilder setGeneratedCode(String generatedCode) {
            this.generatedCode = generatedCode;
            return this;
        }

        public tupleCompareRuleBuilder setErrorCode(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public tupleCompareRuleBuilder setAffectedColumn(String affectedColumn) {
            this.affectedColumn = affectedColumn;
            return this;
        }

        public tupleCompareRuleBuilder setExample(String example) {
            this.example = example;
            return this;
        }

        public tupleCompareRuleBuilder setBusinessRuleID(int BusinessRuleID) {
            this.BusinessRuleID = BusinessRuleID;
            return this;
        }

        public tupleCompareRule build() {
            tupleCompareRule tupleCompareRule = new tupleCompareRule();
            tupleCompareRule.setSecondcolumn(secondcolumn);
            tupleCompareRule.setOperator(operator);
            tupleCompareRule.setCode(code);
            tupleCompareRule.setName(name);
            tupleCompareRule.setExplanation(explanation);
            tupleCompareRule.setMainTable(mainTable);
            tupleCompareRule.setInsert(insert);
            tupleCompareRule.setUpdate(update);
            tupleCompareRule.setDelete(delete);
            tupleCompareRule.setTrigger(trigger);
            tupleCompareRule.setConstraint(constraint);
            tupleCompareRule.setGeneratedCode(generatedCode);
            tupleCompareRule.setErrorCode(errorCode);
            tupleCompareRule.setAffectedColumn(affectedColumn);
            tupleCompareRule.setExample(example);
            tupleCompareRule.setBusinessRuleID(BusinessRuleID);
            return tupleCompareRule;
        }
    }
}
