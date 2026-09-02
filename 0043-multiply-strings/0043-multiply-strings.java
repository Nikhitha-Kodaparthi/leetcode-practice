class Solution {
    public String multiply(String num1, String num2) {

        // If either number is 0
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();

        // Maximum digits possible = m + n
        int[] result = new int[m + n];

        // Multiply from right to left
        for (int i = m - 1; i >= 0; i--) {

            int digit1 = num1.charAt(i) - '0';

            for (int j = n - 1; j >= 0; j--) {

                int digit2 = num2.charAt(j) - '0';

                int multiplication = digit1 * digit2;

                // Positions where the result belongs
                int pos1 = i + j;
                int pos2 = i + j + 1;

                int sum = multiplication + result[pos2];

                result[pos2] = sum % 10;
                result[pos1] += sum / 10;
            }
        }

        // Convert array to String
        StringBuilder answer = new StringBuilder();

        for (int num : result) {

            // Skip leading zeros
            if (answer.length() == 0 && num == 0) {
                continue;
            }

            answer.append(num);
        }

        return answer.toString();
    }
}