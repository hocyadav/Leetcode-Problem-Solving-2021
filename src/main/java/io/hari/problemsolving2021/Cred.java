package io.hari.problemsolving2021;

import org.junit.Test;

import java.util.*;

/**
 * @Author hayadav
 * @create 5/6/2021
 */
public class Cred {

    public static final String LESS_THAN = ">=";
    public static final String EQUAL_TO = "==";
    public static final String NOT_EQUAL_TO = "!=";
    public static final String LESS_THAN_EQUAL = "<=";
    Stack<String> stack1 = new Stack<>();
    Stack<String> stack2 = new Stack<>();

    List<String> operatorList = new LinkedList<>();
    List<String> attributeList = new LinkedList<>();
    String expression;
    Map<String, Object> userAttributes;


    public Cred() {
//        this.userAttributes = userAttributes;
//        this.expression = expression;

        attributeList.add("AGE");
        attributeList.add("GENDER");
        attributeList.add("IS_AFFLUENT");

        operatorList.add("(");
        operatorList.add(">");
        operatorList.add(">=");
        operatorList.add("<");
        operatorList.add("<=");
        operatorList.add("==");
        operatorList.add("!=");
    }

    @Test
    public void test1() {
        Map<String, Object> userAttributes = new HashMap<>();
        userAttributes.put("AGE", 44);
        userAttributes.put("GENDER", "male");
        userAttributes.put("IS_AFFLUENT", true);
        checkExpression("( AGE >= 25 )", userAttributes);
    }

    public boolean checkExpression(String expression, Map<String, Object> userAttributes) {
        if (validateExpression(expression)) return false;

        final String[] tokens = expression.split(" ");
        for (int i = 0; i < tokens.length; i++) {
            final String token = tokens[i];
            if (operatorList.contains(token)) {
                stack1.push(token);
                continue;
            }
            if (attributeList.contains(token)) {
                stack2.push(token);
                continue;
            }
            if (token.equalsIgnoreCase(")")) {
                final String operator = pop(stack1);//)
                final String value1 = pop(stack2);//age
                final String value2 = pop(stack2);//24
                if (evaluateExpression(value1, operator, value2, userAttributes)) {
                    pop(stack1);//(
                }
            } else {
                stack2.push(token);
            }
        }
        if (stack1.isEmpty() && stack2.isEmpty()) return true;
        return false;
    }

    private boolean validateExpression(String expression) {
        if (expression.length() == 0) return true;
        if (!expression.startsWith("(")) return true;
        if (!expression.endsWith(")")) return true;
        return false;
    }

    public String pop(Stack<String> stack) {
        if (stack.isEmpty()) throw new RuntimeException("invalid expression");
        return stack.pop();
    }

    private boolean evaluateExpression(String dataValue, String operator, String attributeName, Map<String, Object> userAttributes) {
        final FieldValue fieldValue = FieldValue.valueOf(attributeName);
        if (fieldValue.equals(FieldValue.AGE)) {
            final Integer value = Integer.valueOf(dataValue);
            if (operator.equals(LESS_THAN)) {
                final Integer integer = Integer.valueOf(String.valueOf(userAttributes.get(attributeName)));
                return (integer >= value) ? true : false;
            }
            if (operator.equals(EQUAL_TO)) {
                final Integer integer = Integer.valueOf(String.valueOf(userAttributes.get(attributeName)));
                return (integer == value) ? true : false;
            }
            if (operator.equals(NOT_EQUAL_TO)) {
                final Integer integer = Integer.valueOf(String.valueOf(userAttributes.get(attributeName)));
                return (integer != value) ? true : false;
            }
            if (operator.equals(LESS_THAN_EQUAL)) {
                final Integer integer = Integer.valueOf(String.valueOf(userAttributes.get(attributeName)));
                return (integer <= value) ? true : false;
            }
        }
        return false;
    }

}
