class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        StringBuilder sb = new StringBuilder("^");
        for (int i = 0; i < s.length(); i++) sb.append("#").append(s.charAt(i));
        sb.append("#$");
        String T = sb.toString();

        int n = T.length();
        int[] P = new int[n];
        int center = 0, right = 0;

        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i;
            if (i < right) P[i] = Math.min(right - i, P[mirror]);
            while (T.charAt(i + (1 + P[i])) == T.charAt(i - (1 + P[i]))) P[i]++;
            if (i + P[i] > right) {
                center = i;
                right = i + P[i];
            }
        }

        int maxLen = 0, centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }

        int start = (centerIndex - maxLen) / 2;
        int end = start + maxLen;
        if (start < 0) start = 0;
        if (end > s.length()) end = s.length();
        return s.substring(start, end);
    }
}