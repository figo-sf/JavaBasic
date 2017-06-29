package com.figo.algorithm.sort;

/**
 * Created by 50245 on 2017/6/29.
 */

public class InsertSort {
    public static void main(String[] args) {
        int[] array = {2,3,1,8,6};
        System.out.print("排序前；");
        printArray(array);

        insertAscSort(array);
        insertDescSort(array);
    }

    /**
     * 插入升序排序
     * @param array
     */
    public static void insertAscSort(int[] array){
        int length = array.length;
        for(int out = 1;out<length;out++){
            int temp = array[out];
            int in = out;
            while(in>0 && array[in-1]>temp){
                array[in] = array[in-1];
                --in;
            }
            array[in]=temp;
        }

        System.out.println();
        System.out.print("升序排序后；");
        printArray(array);
    }

    /**
     * 插入降序排序
     * @param array
     */
    public static void insertDescSort(int[] array){
        int length = array.length;
        for(int out = 1;out<length;out++){
            int temp = array[out];
            int in = out;
            while(in>0 && array[in-1]<temp){
                array[in] = array[in-1];
                --in;
            }
            array[in]=temp;
        }

        System.out.println();
        System.out.print("升序排序后；");
        printArray(array);
    }

    public static void printArray(int[] array){
        int length = array.length;
        for(int i=0;i<length;i++){
            System.out.print(array[i]);
            if(i!=length-1){
                System.out.print(",");
            }
        }
    }
}
