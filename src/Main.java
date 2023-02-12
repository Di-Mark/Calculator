import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws CalcException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите числовую операцию в формате(a + b, a - b, a * b, a / b). Числа могут быть как из арабской системы исчисления, так и из римской, но в одной числовой операции не могут быть числа из разных систем. Допустимый диапазон чисел от 1 до 10 включительно.");
        String input = scanner.nextLine();
        System.out.print("Ответ: ");
        System.out.println(calc(input));
    }
    public static String calc(String input) throws CalcException {
        String first_Number = "";
        String second_Number = "";
        int intValue1 = 0;
        int intValue2 = 0;
        String operation;
        int intResult = 0;
        String output = "";
        String firstChar = input.substring(0,1);
        if(firstChar.equals("1") || firstChar.equals("2") || firstChar.equals("3") || firstChar.equals("4") || firstChar.equals("5") || firstChar.equals("6") || firstChar.equals("7") || firstChar.equals("8") || firstChar.equals("9")){  //Здесь работаем с арабскими цифрами
            while(!input.substring(0,1).equals(" ")){
                    if(input.substring(0,1).equals("1") || input.substring(0,1).equals("2") || input.substring(0,1).equals("3") || input.substring(0,1).equals("4") || input.substring(0,1).equals("5") || input.substring(0,1).equals("6") || input.substring(0,1).equals("7") || input.substring(0,1).equals("8") || input.substring(0,1).equals("9") || input.substring(0,1).equals("0")){
                        first_Number = first_Number + input.substring(0,1);
                        input = input.substring(1);
                }else{
                        throw new CalcException("Некорректно введено первое число");
                    }
                if(input.equals("")){
                    throw new CalcException("Строка не является числовым выражением");
                }
            }
            if(input.length() < 4){
                throw new CalcException("Строка не является числовым выражением");
            }
            input = input.substring(1);
            operation = input.substring(0,1);
            input = input.substring(2);
            if(input.substring(0,1).equals("0")){
                throw new CalcException("Некорректно введено второе число");
            }else{
            while (!input.equals("")) {
                if(input.substring(0,1).equals(" ")){
                    throw new CalcException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                }
                if(input.substring(0,1).equals("1") || input.substring(0,1).equals("2") || input.substring(0,1).equals("3") || input.substring(0,1).equals("4") || input.substring(0,1).equals("5") || input.substring(0,1).equals("6") || input.substring(0,1).equals("7") || input.substring(0,1).equals("8") || input.substring(0,1).equals("9") || input.substring(0,1).equals("0")){
                    second_Number = second_Number + input.substring(0,1);
                    input = input.substring(1);
                }else {
                    throw new CalcException("Некорректно введено второе число или используются одновременно разные системы счисления");
                }
            }
            }
             intValue1 = Integer.parseInt(first_Number);
             intValue2 = Integer.parseInt(second_Number);
            if(intValue1 > 10 || intValue2 > 10){
                throw new CalcException("Допустимое значение чисел от 1 до 10 включительно");
            }else {
                switch (operation){
                    case "+":
                        intResult = intValue1 + intValue2;
                        break;
                    case "-":
                        intResult = intValue1 - intValue2;
                        break;
                    case "*":
                        intResult = intValue1 * intValue2;
                        break;
                    case "/":
                        intResult = intValue1 / intValue2;
                        break;
                    default:
                        throw new CalcException("Введена некоректная операция. Принимаются только +,-,*,/");
                }
            }
            return Integer.toString(intResult);
        }else{
            if(firstChar.equals("I") || firstChar.equals("V") || firstChar.equals("X")){ //Здесь работаем с римскими цифрами
                while (!input.substring(0,1).equals(" ")){
                    if(input.substring(0,1).equals("I") || input.substring(0,1).equals("V") || input.substring(0,1).equals("X")){
                        first_Number = first_Number + input.substring(0,1);
                        input = input.substring(1);
                    }else {
                        throw new CalcException("Некорректно введено первое число");
                    }
                    if(input.equals("")){
                        throw new CalcException("Строка не является числовым выражением");
                    }
                }
                if(input.length() < 4){
                    throw new CalcException("Строка не является числовым выражением");
                }
                input = input.substring(1);
                operation = input.substring(0,1);
                input = input.substring(2);
                while (!input.equals("")){
                    if(input.substring(0,1).equals(" ")){
                        throw new CalcException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                    }
                    if(input.substring(0,1).equals("I") || input.substring(0,1).equals("V") || input.substring(0,1).equals("X")){
                        second_Number = second_Number + input.substring(0,1);
                        input = input.substring(1);
                    }else{
                        throw new CalcException("Некорректно введено второе число или используются одновременно разные системы счисления");
                    }
                }
                try {
                    intValue1 = Roman.valueOf(first_Number).toInt();
                    intValue2 = Roman.valueOf(second_Number).toInt();
                }catch (IllegalArgumentException e){
                    throw new CalcException("Некорректно введены значения или превышен диапазон допустимых значений(от 1 до 10 включительно)");
                }
                switch (operation){
                    case "+":
                        intResult = intValue1 + intValue2;
                        break;
                    case "-":
                        intResult = intValue1 - intValue2;
                        break;
                    case "*":
                        intResult = intValue1 * intValue2;
                        break;
                    case "/":
                        intResult = intValue1 / intValue2;
                        break;
                    default:
                        throw new CalcException("Введена некоректная операция. Принимаются только +,-,*,/");
                }
                if(intResult < 1){
                    throw new CalcException("В римской системе исчисления нет 0 и отрицательных чисел");
                }
                return intToRoman(intResult);
            }
        }
        throw new CalcException("Выражение некорректно введено");
    }
    public static String intToRoman(int num){
        String[] keys = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};
        String str = "";
        int index = 0;
        while (index < keys.length){
            while (num >= values[index]){
                int del = num / values[index];
                num = num % values[index];
                for(int i = 0;i < del;i++){
                    str = str + keys[index];
                }
            }
            index++;
        }
        return str;
    }
}


