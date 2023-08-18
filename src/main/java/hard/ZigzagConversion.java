package hard;

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
        StringBuilder[] stringArrays = new StringBuilder[numRows];

        for(int i = 0; i < stringArrays.length; i++){
            stringArrays[i] = new StringBuilder();
        }

        // direction = 1 when going down -> change to -1 when going up
        int direction = 1;
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            stringArrays[index].append(s.charAt(i));

            // reach the last row -> change direction to going up
            if (index == numRows - 1) {
                direction = -1;
            } else if (index == 0) {
                // reach the first row -> change direction to going down
                direction = 1;
            }

            index += direction;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder str : stringArrays) {
            result.append(str);
        }

        return result.toString();
    }
}




















