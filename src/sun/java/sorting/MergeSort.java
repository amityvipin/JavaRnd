package sun.java.sorting;

public class MergeSort {
	
	public static void mergeSort(int[] values){
		int[] helper = new int[values.length];
		mergeSort(values,helper,0,values.length-1);
	}

	private static void mergeSort(int[] values, int[] helper, int low, int high) {
		if(low<high){
			int middle = (low + high)/2;
			mergeSort(values,helper,low, middle);
			mergeSort(values,helper,middle+1,high);
			merge(values,helper,low,middle,high);
		}
	}

	public static void merge(int[] values, int[] helper, int low, int middle,
			int high) {
		
		for(int i=low; i<=high;i++){
			helper[i] = values[i];
		}
		int helperLeft = low;
		int helperRight = middle+1;
		int current = low;
		while(helperLeft <= middle && helperRight <= high){
			if(helper[helperLeft]>=helper[helperRight]){
				values[current] = helper[helperRight];
				helperRight++;
			}else{
				values[current] = helper[helperLeft];
				helperLeft++;
			}
			current++;
		}
		
		for(int i=helperLeft;i<=middle;i++){
			values[current] = helper[helperLeft];
			current++;
		}
	}

	public static void main(String[] args) {
		int[] values = {46,26,7,8,3,4,16,2,6,9};
		mergeSort(values);
		for(int i=0;i<values.length;i++){
			System.out.print(values[i] + " ");
		}
	}

}
