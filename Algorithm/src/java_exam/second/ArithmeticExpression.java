package java_exam.second;

public class ArithmeticExpression {
    private double x, y;
    //1,2,3,4代表 + - * /
    private double operator;

    public ArithmeticExpression(String s) throws Exception {
        StringBuffer sb = new StringBuffer();
        int i = 0;
        char[] str = s.toCharArray();
        for (; i < str.length; i++) {
            if (Character.isDigit(str[i]) || str[i] == '.' || str[i] == 'E'
                    || (i == 0 && str[i] == '-'))
                sb.append(s.charAt(i));
            else if (str[i] == '+') {
                operator = 1;
                break;
            } else if (str[i] == '-') {
                operator = 2;
                break;
            } else if (str[i] == '*') {
                operator = 3;
                break;
            } else if (str[i] == '/') {
                operator = 4;
                break;
            } else throw new Exception("符号不为 + - * /");
        }
        if (operator == 0) throw new Exception("未检测到符号");
        else {
            //录入x和y
            x = Double.parseDouble(sb.toString());
            y = Double.parseDouble(s.substring(i + 1));
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getOperator() {
        return operator;
    }

    public double getResult() throws Exception {
        if (operator == 1) return x + y;
        else if (operator == 2) return x - y;
        else if (operator == 3) return x * y;
        if (y == 0) throw new Exception("被除数为0");
        return x / y;
    }
}
