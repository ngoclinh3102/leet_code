package logixtek.moitech.leetcode.practice.structure;

public class Condition {

    public boolean c;
    public int posVal;
    public int negVal;

    public static ConditionBuilder builder() {
        return new ConditionBuilder();
    }

    public static class ConditionBuilder {

        Condition condition;

        public ConditionBuilder() {
            condition = new Condition();
        }

        public ConditionBuilder of(boolean condition) {
            this.condition.c = condition;
            return this;
        }

        public ConditionBuilder pos(int posVal) {
            this.condition.posVal = posVal;
            return this;
        }

        public ConditionBuilder neg(int negVal) {
            this.condition.negVal = negVal;
            return this;
        }

        public int build() {
            return condition.c ? condition.posVal : condition.negVal;
        }
    }
}
