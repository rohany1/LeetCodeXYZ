/* Given a matrix of integers A of size N x M in which each row is sorted.
    Find and return the overall median of matrix A.
    NOTE: No extra memory is allowed.
    NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
    N*M is odd
 */
public class MedianOfAMatrix {
    public int findMedian(int[][] A) {
        // The range is 1- Integer.MAX_VALUE
        // For each mid -> we will check number of elements smaller than or equal to mid
        // It number of elements less than are (n*m)/2 -> the mid is median
        int n = A.length;
        int m = A[0].length;
        long left = 1;
        long right = Integer.MAX_VALUE;
        long countSmaller = (n * m) / 2 + 1;
        long ans = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            int currentCount = calculateSmallerThanMid(A, mid);
            if (currentCount >= countSmaller) {
                ans = mid;
                // go left
                right = mid - 1;
            } else if (currentCount > countSmaller) {
                // go left
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) ans;
    }

    private int calculateSmallerThanMid(int[][] A, long val) {
        int n = A.length;
        int m = A[0].length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = m - 1;
            int mid = 0;
            boolean goLeft = false;
            boolean goRight = false;
            while (left <= right) {
                mid = (left + right) / 2;
                goLeft = false;
                goRight = false;
                if (A[i][mid] == val) {
                    // go right
                    left = mid + 1;
                    goRight = true;
                } else if (A[i][mid] < val) {
                    left = mid + 1;
                    goRight = true;
                } else {
                    right = mid - 1;
                    goLeft = true;
                }
            }
            if (goLeft) {
                total += right + 1;
            }
            if (goRight) {
                total += left;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] a = { { 1, 1, 3, 3, 3, 3, 3 } };
        MedianOfAMatrix moam = new MedianOfAMatrix();
        System.out.println(moam.findMedian(a));
    }
}
