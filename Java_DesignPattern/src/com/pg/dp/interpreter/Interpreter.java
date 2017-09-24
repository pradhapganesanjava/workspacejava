package com.pg.dp.interpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Interpreter {
	public static void main(String[] args) {
		String expression = "w x z - +";
		Evaluator sentence = new Evaluator(expression);
		Map<String, ExpressionInterf> variables = new HashMap<String, ExpressionInterf>();
		variables.put("w", new Number(5));
		variables.put("x", new Number(10));
		variables.put("z", new Number(42));
		int result = sentence.interpret(variables);
		System.out.println(result);
	}
}

class Evaluator implements ExpressionInterf {
	private ExpressionInterf syntaxTree;

	public Evaluator(String expression) {
		Stack<ExpressionInterf> expressionStack = new Stack<ExpressionInterf>();
		for (String token : expression.split(" ")) {
			if (token.equals("+")) {
				ExpressionInterf subExpression = new Plus(expressionStack.pop(), expressionStack.pop());
				expressionStack.push(subExpression);
			} else if (token.equals("-")) {
				// it's necessary remove first the right operand from the stack
				ExpressionInterf right = expressionStack.pop();
				// ..and after the left one
				ExpressionInterf left = expressionStack.pop();
				ExpressionInterf subExpression = new Minus(left, right);
				expressionStack.push(subExpression);
			} else
				expressionStack.push(new Variable(token));
		}
		syntaxTree = expressionStack.pop();
	}

	public int interpret(Map<String, ExpressionInterf> context) {
		return syntaxTree.interpret(context);
	}
}

interface ExpressionInterf {
	public int interpret(Map<String, ExpressionInterf> variables);
}

class Number implements ExpressionInterf {
	private int number;

	public Number(int number) {
		this.number = number;
	}

	public int interpret(Map<String, ExpressionInterf> variables) {
		return number;
	}
}

class Plus implements ExpressionInterf {
	ExpressionInterf leftOperand;
	ExpressionInterf rightOperand;

	public Plus(ExpressionInterf left, ExpressionInterf right) {
		leftOperand = left;
		rightOperand = right;
	}

	public int interpret(Map<String, ExpressionInterf> variables) {
		return leftOperand.interpret(variables) + rightOperand.interpret(variables);
	}
}

class Minus implements ExpressionInterf {
	ExpressionInterf leftOperand;
	ExpressionInterf rightOperand;

	public Minus(ExpressionInterf left, ExpressionInterf right) {
		leftOperand = left;
		rightOperand = right;
	}

	public int interpret(Map<String, ExpressionInterf> variables) {
		return leftOperand.interpret(variables) - rightOperand.interpret(variables);
	}
}

class Variable implements ExpressionInterf {
	private String name;

	public Variable(String name) {
		this.name = name;
	}

	public int interpret(Map<String, ExpressionInterf> variables) {
		if (null == variables.get(name))
			return 0; // Either return new Number(0).
		return variables.get(name).interpret(variables);
	}
}
