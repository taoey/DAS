package sort;

/**
 * 插入排序
 * 类似于打牌是抽牌放位置
 */
public class InsertionSort {

    /**
     * 非降序排序
     * @param arr
     * @return
     */
    public static int []  InsertionSort(int arr[]){
        int n,y;  //n 指未排序的，y指以排好序的
        for(n = 1;n<arr.length;n++){
            int key = arr[n];    //取出一张未排序的牌
            for(y = n-1;y>=0 && arr[y]>key;y--){   //找出空位 实际按照理论y应该是空位，但是最后又执行了一次y--，所以最后的空位应该是y+1
                arr[y+1] = arr[y];
            }
            arr[y+1] = key;  //把牌放入到y+1的空位中
        }

        return arr;
    }

    public static void main (String [] args){
        int arr[]={5,4,3,2,1};
        arr = InsertionSort(arr);

        //输出
        for(int num : arr){
            System.out.print(num+" ");
        }
    }
}
