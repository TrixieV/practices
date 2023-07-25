package moderate;

import java.util.Stack;

public class ConvertNumber {
    public static void main(String[] args) {
        int num = 10000678;
        System.out.println(convert(num));
    }

    private static String smallConvert(int num) {
        String[] unit = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
                                    "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
                                    "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
                                        "Eighty", "Ninety"};

        StringBuilder converted = new StringBuilder();
        // number: abc
        int a = num / 100;
        int b = (num / 10) % 10;
        int c = num % 10;
        if (a != 0) {
            converted.append(unit[a]).append(" Hundred ");
        }
        if (num % 100 != 0) {
            if (num % 100 < 20) {
                converted.append(unit[num % 100]);
            } else {
                converted.append(tens[b]);
                if (c != 0) {
                    converted.append(" ").append(unit[c]);
                }
            }
        }
        return converted.toString();
    }

    private static String convert(int num) {
        String[] bigNum = new String[] {"", " Thousand ", " Million ", " Billion "};
        Stack<String> list = new Stack<>();
        StringBuilder converted = new StringBuilder();
        int count = 0;
        if (num < 0) {
            converted.append("Negative ").append(convert(-1 * num));
        }
        if (num / 1000 == 0) {
            converted.append(smallConvert(num));
            return converted.toString();
        }

        while (num > 0) {
            if (num % 1000 != 0) {
                list.add(bigNum[count]);
                list.add(smallConvert(num % 1000));
                count++;
            }
            num /= 1000;
        }

        while (list.size() > 0) {
            converted.append(list.pop());
        }

        return converted.toString();
    }
}
