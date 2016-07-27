package sun.java.sorting;

public class QuickSort {

	public static void main(String[] args) {
		int[] values = {46,26,7,8,3,4,16,2,6,9};
		quickSort(values,0,values.length-1);
		for(int i=0;i<values.length;i++){
			System.out.print(values[i] + " ");
		}
	}

	private static void quickSort(int[] values, int left, int right) {
		int index = partition(values,left,right);
		if(left<index-1)
			quickSort(values,left,index-1);
		if(index<right)
			quickSort(values,index,right);
	}

	private static int partition(int[] values, int left, int right) {
		int pivot = values[(left + right)/2];
		while(left<=right){
			while(values[left]<pivot){
				left++;
			}
			while(values[right]>pivot){
				right--;
			}
			if(left<=right){
				int temp = values[left];
				values[left] = values[right];
				values[right] = temp;
				left++;
				right--;
			}
		}
		return left;
	}

}
