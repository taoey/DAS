package sort;

import org.junit.Test;

/**
 * 冒泡排序（升序）
 * 		包括两种冒泡排序
 * 			1.传统冒泡
 * 			2。冒泡排序的优化
 * @author tao
 *
 */
public class BubbleSort {

	/**
	 * 传统的冒泡排序
	 * @param arr
	 * @return
     */
	public static int [] bubbleSort(int [] arr) {
		for(int i=0;i<arr.length-1;i++) {  //外层控制循环次数
			for(int j=0;j<arr.length-1-i;j++) { //内层控制每一趟排多少次  j=0:每次从第一个开始冒泡；
				if(arr[j]>arr[j+1]){  //利用异或法交换两数位置
					int temp = arr[j];
					arr[j]  =arr[j+1];
					arr[j+1] =temp;
				}
			}
		}		
		return arr;
	}

	/**
	 *  经过优化的冒泡排序，只是在原有的逻辑上添加了didSort变量进行优化
	 * @param arr
	 * @return
     */
	public static  int [] bubbleSort2(int  [] arr ){
		boolean didSort;
		for(int i=0;i<arr.length-1;i++) {  //外层控制循环次数
			didSort = false;
			for(int j=0;j<arr.length-1-i;j++) { //内层控制每一趟排多少次  j=0:每次从第一个开始冒泡；
				if(arr[j]>arr[j+1]){  //利用异或法交换两数位置
					int temp = arr[j];
					arr[j]  =arr[j+1];
					arr[j+1] =temp;

					didSort = true;
				}
			} //end for2   如果没有做排序，即didSort 为false说明了：该序列已经有序了不需要再进行排序，直接返回该序列即可
			if (didSort == false) return arr;
		}
		return arr;
	}

	@Test
	public void bubbleSort2Test(){
		int [] arr = {8,8,4,2,2,1};
		int [] arr2 = {8,1,2,4};
		for (int i : bubbleSort2(arr2)) {
			System.out.print(i);
		}
	}
}
