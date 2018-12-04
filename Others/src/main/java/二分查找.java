import org.junit.Test;

class Solution{
    public static Integer serchNum(int arr[],int num){
        int head =0;
        int tail =arr.length-1;
        int mid = (head+tail)/2;

        while (num!=arr[mid]) {
            if(num>arr[mid]){
                head = mid+1;
            }else if(num<arr[mid]){
                tail = mid-1;
            }else{
                return mid;
            }
            mid = (head+tail)/2;
        }
        return null;
    }

    public static void main(String[] args) {
        int [] arr ={1,2,3,4,5,6,7,8,9};
        Integer integer = serchNum(arr, 1);
        System.out.println(integer);


    }
}
