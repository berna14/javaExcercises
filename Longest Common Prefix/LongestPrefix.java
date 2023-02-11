public class LongestPrefix {
    public static String longestCommonPrefix(String[] arr, int n) {
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minLength = Math.min(minLength, arr[i].length());
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            char c = arr[0].charAt(i);
            for (int j = 1; j < n; j++) {
                if (arr[j].charAt(i) != c) {
                    return result.toString();
                }
            }
            result.append(c);
        }
        return result.toString();

}
    }
