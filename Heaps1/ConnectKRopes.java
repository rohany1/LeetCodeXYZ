public class ConnectKRopes {
    public int solve(int[] A) {
        // first build an heap array
        buildHeap(A);
        // now we have build the heap
        // we will fetch the minimum two value
        // until the length becomes 1;
        int n = A.length;
        int totalCost = 0;
        // we have to perform total of n-1 operations
        int currLength = n;
        for (int i = 1; i < n; i++) {
            int min1 = getMin(A, currLength);
            // System.out.println("min1->" + min1);
            currLength--;
            int min2 = getMin(A, currLength);
            // System.out.println("min2 ->" + min2);
            currLength--;
            totalCost += (min1 + min2);
            insert(A, min1 + min2, currLength);
            // System.out.println("A[0]->" + A[0]);
            currLength++;
            // System.out.println("currLength ->" +currLength);
        }
        return totalCost;
    }

    public void buildHeap(int[] A) {
        // we know all the elements
        // so we build from bottom to top
        int n = A.length;
        int leavesNode = (n + 1) / 2;
        int start = n - leavesNode - 1;
        for (int i = start; i >= 0; i--) {
            int curr = i;
            while (curr < n) {
                int lc = (2 * curr) + 1;
                int rc = (2 * curr) + 2;

                int lv = (lc < n) ? A[lc] : Integer.MAX_VALUE;
                int rv = (rc < n) ? A[rc] : Integer.MAX_VALUE;

                if (lv <= rv && A[curr] > lv) {
                    // replace with left children
                    int temp = A[curr];
                    A[curr] = A[lc];
                    A[lc] = temp;
                    // move curr
                    curr = lc;
                } else if (rv <= lv && A[curr] > rv) {
                    // replace with right children
                    int temp = A[curr];
                    A[curr] = A[rc];
                    A[rc] = temp;
                    // move curr
                    curr = rc;
                } else {
                    break;
                }
            }
        }
    }

    public int getMin(int[] A, int size) {
        int min = A[0];
        A[0] = A[size - 1];
        // now we need to reheapify
        // we need to go from top to bottom
        int n = size - 1;
        int curr = 0;
        while (curr < n) {
            int lc = 2 * curr + 1;
            int rc = 2 * curr + 2;

            int lv = (lc < n) ? A[lc] : Integer.MAX_VALUE;
            int rv = (rc < n) ? A[rc] : Integer.MAX_VALUE;

            if (lv <= rv && A[curr] >= lv) {
                // replace with left children
                int temp = A[curr];
                A[curr] = A[lc];
                A[lc] = temp;
                // move curr
                curr = lc;
            } else if (rv <= lv && A[curr] >= rv) {
                // replace with right children
                int temp = A[curr];
                A[curr] = A[rc];
                A[rc] = temp;
                // move curr
                curr = rc;
            } else {
                break;
            }
        }
        return min;
    }

    public void insert(int[] A, int val, int size) {
        A[size] = val;
        int curr = size;
        while (curr > 0) {
            int parent = (curr - 1) / 2;
            if (A[parent] > A[curr]) {
                int temp = A[parent];
                A[parent] = A[curr];
                A[curr] = temp;
                curr = parent;
            } else {
                break;
            }
        }
    }

    public void printArray(int[] A, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println("");
    }
}
