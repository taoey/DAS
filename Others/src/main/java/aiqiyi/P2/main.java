package aiqiyi.P2;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static boolean isOk(int [] arr){
        for(int i =1;i<arr.length;i++){
            if(arr[i]-1==arr[i-1] ){
                return false;
            }
        }
        return true;
    }
    public static int getCount (int [] arr){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j <= arr.length; j++) {
                int[] tempArr = Arrays.copyOfRange(arr, i, j);
                //System.out.println(Arrays.toString(tempArr));
                if(isOk(tempArr)){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int [] arr = new int[num];
        for(int i = 0;i<num;i++){
            arr[i]=i;
        }
        int result =getCount(arr);
        System.out.println(result+2);
    }
}
