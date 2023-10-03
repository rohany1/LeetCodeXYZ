/*  
 * Given an array of integers A, find and return the peak element in it.
    An array element is considered a peak if it is not smaller than its neighbors. For corner elements, we need to consider only one neighbor.

    NOTE:

    It is guaranteed that the array contains only a single peak element.
    Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPeakElement {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        // we will solve this using binary search
        int left = 1;
        int right = n-2;
        int mid=0;
        //edge cases
        //size is 1
        if(n==1){
            return A.get(0);
        }
        //first element is peak
        if(A.get(0)>A.get(1)){
            return A.get(0);
        }
        //last element is peak
        if(A.get(n-1)>A.get(n-2)){
            return A.get(n-1);
        }
        //other cases
        while(left<=right){
            mid= (left+right)/2;
            //mid is peak
            if(A.get(mid)>=A.get(mid-1) && A.get(mid)>=A.get(mid+1)){
                return A.get(mid);
            }
            //if peak is at right, search in right
            else if(A.get(mid+1)>A.get(mid)){
                left=mid+1;
            }
            //if peak is at left, search in left
            else{
                right= mid-1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(5, 17, 100, 11);
        ArrayList<Integer> A = new ArrayList<>(li);
        FindPeakElement fpe = new FindPeakElement();
        System.out.println(fpe.solve(A));
    }
}
