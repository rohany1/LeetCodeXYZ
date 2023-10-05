import java.util.ArrayList;
import java.util.Arrays;

public class MinimumDifference {
    public int solve(int A, int B, int[][] C) {
        // first we will sort each array
        int n = C.length;
        for (int i = 0; i < n; i++) {
            Arrays.sort(C[i]);
        }
        // once all arrays are sorted
        // we will calculate minimum for each two adjacent array
        ArrayList<Integer> D = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            // for each array, for each number we will find minimum difference
            int min = Integer.MAX_VALUE;
            int m = C[i].length;
            for (int j = 0; j < m; j++) {
                int curr = C[i][j];
                int left = 0;
                int right = m - 1;
                int mid = 0;
                int curr_min = Integer.MAX_VALUE;
                while (left <= right) {
                    mid = (left + right) / 2;
                    int currDiff = (int) Math.abs(C[i + 1][mid] - curr);
                    // check whether curr diff is less than curr min
                    if (currDiff < curr_min) {
                        curr_min = currDiff;
                    } else {
                        break;
                    }
                    // value of mid is greater than curr, search in left
                    if (C[i + 1][mid] == curr) {
                        // smallest value diff can produce
                        curr_min = 0;
                        break;
                    } // search in right if curr > mid
                    else if (C[i + 1][mid] < curr) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                if (curr_min < min) {
                    min = curr_min;
                }
            }
            System.out.println(min+"----");
            D.add(min);
        }
        // now we have all the difference of adjacent rows
        // calculate min differece between them
        int[] finalArr = new int[D.size()];
        for (int i = 0; i < D.size(); i++) {
            finalArr[i] = D.get(i);
        }
        Arrays.sort(finalArr);
        return finalArr[0];
    }

    public static void main(String[] args) {
        MinimumDifference md = new MinimumDifference();
        int[][] C = { { 95171, 64925, 51398, 40114, 693, 2377, 73808, 80091, 76151, 79440 },
                { 67162, 89457, 65239, 89157, 31092, 37848, 22896, 30167, 37883, 36897 },
                { 5988, 77161, 72711, 64765, 26452, 77921, 9225, 96615, 24939, 45282 },
                { 22835, 8357, 10207, 74133, 36619, 98949, 64658, 10426, 79039, 29057 },
                { 89767, 34448, 18513, 43253, 23604, 37753, 81001, 34649, 67820, 7132 },
                { 59694, 73708, 84193, 32404, 26720, 98793, 98473, 35846, 83656, 11659 },
                { 69276, 6490, 19916, 67631, 68771, 56435, 66579, 33428, 66762, 45617 },
                { 50633, 44776, 68213, 69046, 87929, 79966, 6799, 68930, 2862, 62767 },
                { 75962, 62456, 24723, 48402, 83008, 51343, 35443, 69728, 87089, 19098 },
                { 81288, 44613, 13736, 1203, 12243, 70655, 45787, 78723, 92231, 12548 } };
        System.out.println(md.solve(10, 10, C));
    }
}
