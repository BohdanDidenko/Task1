package com.epam.task1.task1_1.model;

public class Model {
    public StringBuilder result = new StringBuilder();

    public void toBinary(int number) {
        if (number > 0) {
            if (number % 2 == 0) result.append(0);
            else result.append(1);
            toBinary(number / 2);
        }
    }

    public void toOctal(int number){
        if (number > 7) {
            result.append(number % 8);
            toOctal(number / 8);
        }
        else result.append(number % 8);
    }

    public void toHexadecimal(int number){
        if (number > 15) {
            switch (number % 16) {
                case 10:
                    result.append("A");
                    break;
                case 11:
                    result.append("B");
                    break;
                case 12:
                    result.append("C");
                    break;
                case 13:
                    result.append("D");
                    break;
                case 14:
                    result.append("E");
                    break;
                case 15:
                    result.append("F");
                    break;
                default:
                    result.append(number % 16);
            }
            toHexadecimal(number / 16);
        }
        else result.append(number % 16);
    }
}
