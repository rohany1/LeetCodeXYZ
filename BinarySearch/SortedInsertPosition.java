/*  You are given a sorted array A of size N and a target value B.
    Your task is to find the index (0-based indexing) of the target value in the array.

    If the target value is present, return its index.
    If the target value is not found, return the index of least element greater than equal to B.
    Your solution should have a time complexity of O(log(N)). 
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedInsertPosition {
    public int searchInsert(ArrayList<Integer> A, int B) {
        int n = A.size();
        int left=0, right=n-1;
        int mid=0;
        while(left<=right){
            mid=(right+left)/2;
            if(A.get(mid)==B){
                return mid;
            }else if(A.get(mid)>B){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        if(A.get(mid)>B){
            return mid;
        }else{
            return mid+1;
        }
    }
    public static void main(String[] args) {
        List<Integer> li= Arrays.asList(2,4,6,7,8,10);
        ArrayList<Integer> A = new ArrayList<>(li);
        SortedInsertPosition sip = new SortedInsertPosition();
        int ans = sip.searchInsert(A,11);
        System.out.println(ans);
    }
}
