package sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
    public static  void swap (int arr[],int i, int j){
        if(arr[i]!=arr[j]){
            arr[i]=arr[i]^arr[j];
            arr[j]=arr[i]^arr[j];
            arr[i]=arr[i]^arr[j];
        }
    }
    // 递归使用快速排序,对arr[l...r]的范围进行排序
    public static void QuickSort(int[] arr,int l,int r){
        if(l>=r) return;
        int p = partition(arr,l,r);
        QuickSort(arr,l,p-1);
        QuickSort(arr,p+1,r);
    }
    //一次快速排序过程，返回两个指针相遇的位置
    private static int partition(int[] arr, int left, int right) {
        //获取三个元素：基数，左指针，右指针
        int key = arr[left];
        int i = left ;
        int j = right;
        while(i!=j){
            while (arr[j]>=key && i<j) j--;
            while (arr[i]<=key && i<j) i++;
            swap(arr,i,j);
        }
        swap(arr,left,j);
        return j;
    }

    public static void main(String[] args) {
        //int [] arr ={6,1,4,5,9,10,6,6};
        int [] arr ={3, 2, 5, 7, 6, 8};

        QuickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));//[2, 3, 5, 6, 7, 8]
    }
}
