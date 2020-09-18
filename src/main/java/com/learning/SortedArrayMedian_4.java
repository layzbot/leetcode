package com.learning;

public class SortedArrayMedian_4 {
    public static void main(String[] args) {
        System.out.println(median_brute(new int[]{13}, new int[]{}));
    }

    static double median_brute(int[] arr1, int[] arr2) {
        int i=0,j=0,k=0;
        int[] resultArr = new int[arr1.length+arr2.length];
        if(resultArr.length == 0) {
            return 0d;
        } else if(resultArr.length == 1) {
            return arr1.length>0 ? arr1[0] : arr2[0];
        }

        int midRight = resultArr.length/2;
        int midLeft = midRight-1;

        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                resultArr[k] = arr1[i];
                i++;
            } else if(arr1[i] >= arr2[j]) {
                resultArr[k] = arr2[j];
                j++;
            }
            k++;
        }

        if(i< arr1.length) {
            for(int x=i; x<arr1.length; x++)  {
                resultArr[k] = arr1[x];
                k++;
            }
        }
        if(j< arr2.length) {
            for(int x=j; x<arr2.length; x++) {
                resultArr[k] = arr2[x];
                k++;
            }
        }

        return resultArr.length%2 == 0 ? (double) (resultArr[midLeft]+resultArr[midRight])/2 : (double) resultArr[midRight];
    }
}
