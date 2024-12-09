public class Solution {
    public String convert(String s, int numRows) {
        // If numRows is 1 or the string is too short, no zigzag conversion is needed
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // Create an array of StringBuilder to represent each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        // Initialize variables for the current row and the direction of movement
        int currentRow = 0;
        boolean goingDown = false;

        // Traverse through the input string and distribute characters to the rows
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // If we're at the top or bottom row, change direction
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move the current row pointer
            currentRow += goingDown ? 1 : -1;
        }

        // Combine all rows into one string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
