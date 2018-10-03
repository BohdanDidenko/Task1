import java.util.Scanner;

public class Task1 {
    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;

//        while(true){
            System.out.println("You number in decimal system");
            number = scanner.nextInt();
//            if(scanner.hasNextInt()) break;
//            else {
//                System.out.println("Error");
//                continue;
//            }
//        }

        System.out.println("Choice numeral system: 1 - octal, 2 - binary, 3 - hexadecimal");
        int change = scanner.nextInt();

        switch (change) {
            case 1: {
                octal(number);
                System.out.println(stringBuilder.reverse());
                break;
            }
            case 2: {
                binary(number);
                System.out.println(stringBuilder.reverse());
                break;
            }
            case 3: {
                hexadecimal(number);
                System.out.println(stringBuilder.reverse());
                break;
            }
            default : System.out.println("You choice error!");
        }
    }

    public static void octal(int number){
        if (number > 7) {
            stringBuilder.append(number % 8);
            octal(number / 8);
        }
        else stringBuilder.append(number % 8);
    }

    public static void binary(int number) {
        if (number > 0) {
            if (number % 2 == 0) stringBuilder.append(0);
            else stringBuilder.append(1);
            binary(number / 2);
        }
    }

    public static void hexadecimal(int number){
        if (number > 15) {
            switch (number % 16) {
                case 10:
                    stringBuilder.append("A");
                    break;
                case 11:
                    stringBuilder.append("B");
                    break;
                case 12:
                    stringBuilder.append("C");
                    break;
                case 13:
                    stringBuilder.append("D");
                    break;
                case 14:
                    stringBuilder.append("E");
                    break;
                case 15:
                    stringBuilder.append("F");
                    break;
                default:
                    stringBuilder.append(number % 16);
            }
            hexadecimal(number / 16);
        }
        else stringBuilder.append(number % 16);
    }
}
