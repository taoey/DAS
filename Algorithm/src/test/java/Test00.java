import org.junit.Test;

public class Test00 {
    @Test
    public void test0824(){
        int [] arr = {5,4,3,2,1};
        //主体代码
        int y,n;
        for(n=1;n<arr.length;n++){
            int key = arr[n];
            for(y=n-1;y>=0 && key<arr[y];y--){
                arr[y+1] = arr[y];
            }
            arr[y+1] = key;
        }

        //测试
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
