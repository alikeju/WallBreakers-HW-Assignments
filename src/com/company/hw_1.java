package com.company;

public class hw_1 {

    public int[] sortArrayByParity(int[] A){
        int[] result = new int[A.length];
        int evenIndex = 0;
        int oddIndex = A.length -  1;

        for (int i = 0; i < A.length; i++){
            if (A[i] % 2 == 0){
                result[evenIndex] = A[i];
                evenIndex++;
            } else {
                result[oddIndex] = A[i];
                oddIndex--;
            }
        }

        return result;
    }

    public int[][] transpose(int[][] A) {
        int C = A.length;
        int R = A[0].length;
        int[][] ans = new int[R][C];

        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < A[0].length; j++){
                ans[j][i] = A[i][j];
            }
        }

        return ans;
    }
}
