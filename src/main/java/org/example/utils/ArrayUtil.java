package org.example.utils;

public class ArrayUtil {
    public static int getBucketIndexOfValue (int[] arr, float value) {
        for (int i = 0; i < arr.length; i++) {
            if (value < arr[i]) {
                return i - 1;
            }
        }
        return arr.length - 1;
    }
}
