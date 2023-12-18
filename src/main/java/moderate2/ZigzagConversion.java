package moderate2;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
string convert(string s, int numRows);
 */

public class ZigzagConversion {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    private static String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        int direction = 1;
        int position = 0;
        StringBuilder[] strings = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            strings[i] = new StringBuilder();
        }

        for (int i = 0; i < s.length(); i++) {
            if (position == 0) {
                direction = 1;
            } else if (position == numRows - 1) {
                direction = -1;
            }

            strings[position].append(s.charAt(i));
            position += direction;
        }

        StringBuilder ans = new StringBuilder();
        for (StringBuilder string : strings) {
            ans.append(string);
        }

        return ans.toString();
    }
}




















