class Solution {
    public boolean isMatch(String s, String p) {

        int i = 0; // Pointer for s
        int j = 0; // Pointer for p

        int starIndex = -1;
        int matchIndex = 0;

        while (i < s.length()) {

            // Characters match OR '?' matches any character
            if (j < p.length() &&
                (p.charAt(j) == '?' ||
                 p.charAt(j) == s.charAt(i))) {

                i++;
                j++;
            }

            // Found '*'
            else if (j < p.length() && p.charAt(j) == '*') {

                starIndex = j;
                matchIndex = i;
                j++;
            }

            // Previous '*' can match one more character
            else if (starIndex != -1) {

                j = starIndex + 1;
                matchIndex++;
                i = matchIndex;
            }

            // No match
            else {
                return false;
            }
        }

        // Remaining pattern characters must all be '*'
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        return j == p.length();
    }
}