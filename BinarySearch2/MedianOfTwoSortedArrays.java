/*
    * There are two sorted arrays A and B of sizes N and M respectively.

    Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

    NOTE:

    The overall run time complexity should be O(log(m+n)).
    IF the number of elements in the merged array is even, then the median is the average of (n/2)th and (n/2+1)th element.
    For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianOfTwoSortedArrays {
    // DO NOT MODIFY BOTH THE LISTS
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        double median = 0;
        int n = a.size();
        int m = b.size();
        if(m==0 && n==0){
            return 0;
        }
        if(n==0){
            return m%2==0?(double)(b.get(m/2-1)+b.get(m/2))/2:(double)(b.get(m/2));
        }
        if(m==0){
            return n%2==0?(double)(a.get(n/2-1)+a.get(n/2))/2:(double)(a.get(n/2));
        }
        // now we will do binary search on selecting number of elements in array a
        int left = 0;
        int right = ((n+m+1)/2);
        while(left<=right){
            int mid = (left+right)/2;
            int numberLeft = ((n+m+1)/2)-mid;
            //now we will select mid number of elements from A
            if(mid<=n && numberLeft<=m){
                // we will store value of position of l1, r1, l2, r2
                int l1= mid - 1>=0?a.get(mid-1):Integer.MIN_VALUE;
                int r1= mid<n?a.get(mid):Integer.MAX_VALUE;
                int l2= numberLeft-1>=0?b.get(numberLeft-1):Integer.MIN_VALUE;
                int r2= numberLeft<m?b.get(numberLeft):Integer.MAX_VALUE;
                //now we have values of each index position
                if(l1<=r2 && l2<=r1){
                    if((n+m)%2==0){
                        return (double)(Math.max(l1, l2)+Math.min(r1,r2))/2;
                    }else{
                        return (double)(Math.max(l1, l2));
                    }
                }else if (l1>r2 && l2<r1){
                    //shift left side
                    right = mid-1;
                }else{
                    //shift right side
                    left = mid+1;
                }

            }//increase number of element to pick from array A
            else if (mid<=n && numberLeft>m){
                left = mid+1;
            }else{
                //decrease number of element to pick from A
                right = mid-1;
            }
        }
        return median;
	}
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(35);
        List<Integer> l2 =Arrays.asList( 1, 26, 35, 49 );
        ArrayList<Integer> a = new ArrayList<>(l1);
        ArrayList<Integer> b = new ArrayList<>(l2);
        MedianOfTwoSortedArrays motsa = new MedianOfTwoSortedArrays();
        System.out.println(motsa.findMedianSortedArrays(a, b));
    }
}
