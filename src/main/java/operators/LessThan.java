package operators;

import java.util.ArrayList;
import java.util.List;

public class LessThan implements LogicalOperator {
    private static int precedence;
    private static LessThan lessThan = null;
    private List<String> symbols;
    private int operandCount;

    private LessThan(){
        precedence = 4;
        symbols = new ArrayList<String>();
        symbols.add("<");
        operandCount = 2;
    }
    public static LessThan getInstance() {
        if(lessThan == null)
            lessThan = new LessThan();
        return lessThan;
    }

    public int getOperandCount() {
        return operandCount;
    }

    public int getPrecedence() {
        return precedence;
    }

    public List<String> getSymbols() {
        return symbols;
    }

    public <E> boolean operate(List<E> operands) throws Exception {
        if(operands.size()!=2)
            throw new Exception();
        E operand1 = operands.get(0);
        E operand2 = operands.get(1);

        if(operand1 instanceof Integer){
            if(operand2 instanceof Integer){
                return (Integer)operand1<(Integer)operand2;
            }
            if(operand2 instanceof Double){
                return (Integer)operand1<(Double)operand2;
            }
            throw new Exception("");
        }
        if(operand1 instanceof Double){
            if(operand2 instanceof Double){
                return (Double)operand1<(Double)operand2;
            }
            if(operand2 instanceof Integer){
                return (Double)operand1<(Integer)operand2;
            }
            throw new Exception("");
        }
        throw new Exception("Operand is not of the desired type");
    }

}
