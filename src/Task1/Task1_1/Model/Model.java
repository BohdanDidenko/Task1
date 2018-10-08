package Task1.Task1_1.Model;

public class Model {
    private StringBuilder stringBuilder = new StringBuilder();

    public String toBinary(int number) {
        if (number > 0) {
            if (number % 2 == 0) stringBuilder.append(0);
            else stringBuilder.append(1);
            toBinary(number / 2);
        }

        return stringBuilder.reverse().toString();
    }

    public String toOctal(int number){
        if (number > 7) {
            stringBuilder.append(number % 8);
            toOctal(number / 8);
        }
        else stringBuilder.append(number % 8);

        return stringBuilder.reverse().toString();
    }

    public String toHexadecimal(int number){
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
            toHexadecimal(number / 16);
        }
        else stringBuilder.append(number % 16);

        return stringBuilder.reverse().toString();
    }
}
