# 二分查找法

## 基本思想
将n个元素分成大致相等的两部分，取a[n/2]与x做比较，如果x=a[n/2],则找到x,算法中止；如果x<a[n/2],则只要在数组a的左半部分继续搜索x,如果x>a[n/2],则只要在数组a的右半部搜索x.

## 时间复杂度
O(h)=O(log2n) (以2为底，n的对数)

## 算法用途
快速定位一个数据所在容器的位置，或是数据所在的最小数据区间

结合数据容器进行使用时，先对容器中的元素进行排序，然后再使用二分查找法定位元素

## 算法实现

'''
	/**
	 * 查找num所在的位置
	 * @param array
	 * @param num
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
'''
