class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] suffix = new int[m + 1];

        suffix[m] = n;

        int i = n - 1;

        for (int j = m - 1; j >= 0; j--) {
            while (i >= 0 && word1.charAt(i) != word2.charAt(j)) {
                i--;
            }

            if (i < 0) {
                suffix[j] = -1;
            } else {
                suffix[j] = i;
                i--;
            }
        }

        int[] ans = new int[m];

        int p1 = 0;
        int p2 = 0;

        boolean usedMismatch = false;

        while (p1 < n && p2 < m) {
            if (word1.charAt(p1) == word2.charAt(p2)) {
                ans[p2] = p1;
                p1++;
                p2++;
            }

            else if (!usedMismatch) {
                if (p2 == m - 1) {
                    ans[p2] = p1;
                    usedMismatch = true;
                    p1++;
                    p2++;
                }

                // check whether remaining word2
                // can still be completed after p1
                else if (suffix[p2 + 1] > p1) {
                    ans[p2] = p1;
                    usedMismatch = true;
                    p1++;
                    p2++;
                }

                else {
                    p1++;
                }
            }

            else {
                p1++;
            }
        }

        if (p2 != m) {
            return new int[0];
        }

        return ans;
    }
}