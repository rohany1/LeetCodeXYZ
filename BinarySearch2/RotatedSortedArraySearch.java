public class RotatedSortedArraySearch {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int search(final int[] A, int B) {
        int n = A.length;
        int left = 0;
        int right = n-1;
        int mid=0;
        while(left<=right){
            mid = (left+right)/2;
            if(A[mid]==B){
                return mid;
            }
            /* check whether which side of array is correctly sorted
             and check the existense of our number in that side */
            //left side is sorted
            else if(A[left]<A[mid]){
                if(B>=A[left] && B<A[mid]){
                    //search in left
                    right = mid-1;
                }else{
                    //search in right
                    left = mid+1;
                }
            }//right side is sorted
            else{
                if(B>A[mid] && B<=A[right]){
                    left= mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        RotatedSortedArraySearch rsas = new RotatedSortedArraySearch();
        System.out.println(rsas.search(arr, 3));
    }
}
