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
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        // we will solve this using binary search
        int left = 1;
        int right = n-2;
        int mid=0;
        //edge cases
        //size is 1
        if(n==1){
            return nums[0];
        }
        //first element is peak
        if(nums[0]>nums[1]){
            return nums[0];
        }
        //last element is peak
        if(nums[n-1]>nums[n-2]){
            return nums[n-1];
        }
        //other cases
        while(left<=right){
            mid= (left+right)/2;
            //mid is peak
            if(nums[mid]>=nums[mid-1] && nums[mid]>=nums[mid+1]){
                return nums[mid];
            }
            //if peak is at right, search in right
            else if(nums[mid+1]>nums[mid]){
                left=mid+1;
            }
            //if peak is at left, search in left
            else{
                right= mid-1;
            }
        }
        return nums[mid];
    }
    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(5, 17, 100, 11);
        ArrayList<Integer> A = new ArrayList<>(li);
        FindPeakElement fpe = new FindPeakElement();
        int[] AA = {1,2,3,1};
        System.out.println(fpe.findPeakElement(AA));
    }
}
