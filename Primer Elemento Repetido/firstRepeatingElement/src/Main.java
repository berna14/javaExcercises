public class Main {
        public static int firstRepeated(int[] arr, int n) {
            HashSet<Integer> set = new HashSet<>();
            int res = -1;

            for (int i = n - 1; i >= 0; i--) {
                if (set.contains(arr[i])) {
                    res = i + 1;
                } else {
                    set.add(arr[i]);
                }
            }
            return res;
        }
    }

