public class BClosestPointToOrigin {
    public int[][] solve(int[][] A, int B) {
        // we will sort the array till we found B elements in it
        // first we will create a new array in which we will store
        // distance of each cordinate with origin
        int n = A.length;
        long[] distance = new long[n];
        for (int i = 0; i < n; i++) {
            long dis = (A[i][0] * A[i][0]) + (A[i][1] * A[i][1]);
            distance[i] = dis;
        }
        // once we have calculated the distances
        // now we will use insetion sort by picking up last element
        // until we are find the correct position of B
        quickSelect(A,distance,0,n-1,B);
        int ans[][] = new int[B][2];
        for (int i = 0; i < B; i++) {
            ans[i][0] = A[i][0];
            ans[i][1] = A[i][1];
        }
        return ans;
    }

    public void quickSelect(int[][] A, long[] distance, int start, int end,int k){
        int pivot_index=partition(A, distance, start, end);
        if(pivot_index==k){
            return;
        }else if(pivot_index>k-1){
            quickSelect(A, distance, start, pivot_index-1, k);
        }else{
            quickSelect(A, distance, pivot_index+1, end, k);
        }
    }
    public int partition(int[][] A, long[] distance, int start, int end) {
        long pivot = distance[end];
        int index = start;
        for (int j = start; j <= end - 1; j++) {
            if (distance[j] < pivot) {
                // swap this with index position
                // swap both A and distance
                long temp = distance[j];
                distance[j] = distance[index];
                distance[index] = temp;
                int tempX = A[j][0];
                A[j][0] = A[index][0];
                A[index][0] = tempX;
                int tempY = A[j][1];
                A[j][1] = A[index][1];
                A[index][1] = tempY;
                // increment the value of index
                index++;
            }
        }
        // swap the last value with index
        long temp = distance[end - 1];
        distance[end - 1] = distance[index];
        distance[index] = temp;
        int tempX = A[end - 1][0];
        A[end - 1][0] = A[index][0];
        A[index][0] = tempX;
        int tempY = A[end - 1][1];
        A[end - 1][1] = A[index][1];
        A[index][1] = tempY;
        return index;
    }

    public static void main(String[] args) {
        int[][] A = { { 48, 18 }, { 46, 34 }, { 47, 30 }, { 19, 9 } };
        BClosestPointToOrigin bcpto = new BClosestPointToOrigin();
        int[][] ans = bcpto.solve(A, 2);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + " " + ans[i][1] + " ");
        }
    }
}
