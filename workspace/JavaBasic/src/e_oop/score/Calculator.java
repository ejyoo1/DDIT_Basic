package e_oop.score;

public class Calculator {
	//다섯개의 메서드 : 산술연산 (+, -, *, /, %)
	//각각의 메서드는 두개의 파라미터를 받아야 함. (피연산자가 2개이기 때문)
	//연산한 결과를 리턴하면 됨.
	
	double add(double num1, double num2) {
		return num1 + num2;
	}
	
	double sub(double num1, double num2) {
		return num1 - num2;
	}
	
	double mul(double num1, double num2) {
		double result = num1*num2;
		return result;
	}
	
	double div(double num1, double num2) {
		double result = num1/num2;
		return result;
	}
	
	double mod(double num1, double num2) {
		return num1 % num2;
	}
}
