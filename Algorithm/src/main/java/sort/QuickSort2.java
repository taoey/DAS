package sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort2 {
    public static  void swap (int arr[],int i, int j){
        int temp =arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 三值取中 (必须保证有三个值啊)
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int median3(int arr[],int left ,int right){
            int center = (left+right)/2;
            if(arr[left]>arr[center])
                swap(arr,left,center);
            if(arr[left]>arr[right])
                swap(arr,left,right);//此时左侧最小
            if(arr[center]>arr[right])
                swap(arr,center,right);//此时右侧最大
            swap(arr,center,right-1); //把主元放到一个特定的位置，为了后面交换主元时方便
            return arr[right-1];
    }


    public static void QuickSort(int[] arr,int left,int right){
        if(left<right){
            //定义 主元，低位指针，高位指针
            int pivot = median3(arr,left,right);
            int low = left;
            int hight = right-1;

            while(true){
                while (arr[++low]<pivot){};
                while (hight > left && arr[--hight]>pivot){};
                //交换左右指针的元素
                if(low<hight){
                    swap(arr,low,hight);
                }else {
                    break;
                }
            }
            if(low<right){
                swap(arr,low,right-1); //一次快排结束
            }

            QuickSort(arr,left,low-1);
            QuickSort(arr,low+1,right);
        }

    }

    public static void main(String[] args) {
        //int [] arr ={6,1,4,5,9,10,6,6};
        int [] arr ={2,1};
        QuickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
