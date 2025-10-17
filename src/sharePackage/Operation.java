package sharePackage;

import java.io.Serializable;

public class Operation implements Serializable {
    private static final long serialVersionUID = 1L;

    private double operand1;
    private String operator;
    private double operand2;

    public Operation(double operand1, String operator, double operand2) {
        this.operand1 = operand1;
        this.operator = operator;
        this.operand2 = operand2;
    }

    // Getters
    public double getOperand1() { return operand1; }
    public String getOperator() { return operator; }
    public double getOperand2() { return operand2; }

    @Override
    public String toString() {
        return operand1 + " " + operator + " " + operand2;
    }
}