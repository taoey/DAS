package sort;

/**
 * 冒泡排序（升序）
 * @author tao
 *
 */
public class BubbleSort {
	public static int [] bubbleSort(int [] arr) {
		for(int i=0;i<arr.length-1;i++) {  //外层控制循环次数
			for(int j=0;j<arr.length-1-i;j++) { //内层控制每一趟排多少次
				if(arr[j]>arr[j+1]){  //利用异或法交换两数位置
					arr[j]=arr[j]^arr[j+1];
					arr[j+1]=arr[j]^arr[j+1];
					arr[j]=arr[j]^arr[j+1];
				}
			}
		}		
		return arr;
	}
	
	public static void main(String [] args) {
		int [] arr = {7,4,1,3,9,6,5,8,2};
		for (int i : bubbleSort(arr)) {
			System.out.print(i);
		}
	}
}
