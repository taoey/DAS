package search;

public class BinarySearch {
	
	/**
	 * 二分查找法
	 * @param arr
	 * @param key
	 */
	public static int binarySearch(int [] arr,int key) {
		int low = 0;
		int high = arr.length-1;
		int middle = 0;
	    if(key < arr[low] || key > arr[high] || low > high){  
	        return -1;                
	    }  		
		while(low <= high) {
			middle = (low + high)/2;
			if(key < arr[middle]) {
				high = middle-1;				
			}
			else if(key >arr[middle]){
				low = middle+1;
			}
			else {
				return middle;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int [] array = {1,2,3,4,5};
		int index = binarySearch(array,5);
		System.out.println(index);
	}
	
	
	
	
	
	
	
	
	
	
}
