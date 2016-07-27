package sun.java.sorting;

public class MergeTwoSortedArray {

	public static void main(String[] args) {
		int[] arr1 = new int[8];
		arr1[0]=2;
		arr1[1]=3;
		arr1[2]=5;
		arr1[3]=6;
		int[] arr2 = {4,7,8,9};
		//using merge sort merging function but it use extra memory for another array
//		mergeSortedArray(arr1,arr2);
		mergeSortedArray2(arr1,arr2);
		for(int i=0;i<arr1.length;i++){
			System.out.print(arr1[i] + " ");
		}
	}

	private static void mergeSortedArray(int[] arr1, int[] arr2) {
		for(int i= arr1.length-arr2.length;i<arr1.length;i++){
			arr1[i]=arr2[i-arr2.length];
		}
		int[] helper = new int[arr1.length];
		MergeSort.merge(arr1, helper, 0, arr1.length-arr2.length-1, arr1.length-1);
	}

	private static void mergeSortedArray2(int[] arr1, int[] arr2){
		int index1 = arr1.length-arr2.length-1;
		int index2 = arr2.length-1;
		int indexMerge = arr1.length -1;
		
		while(index2>=0){
			if(index1>=0 && arr1[index1] >arr2[index2]){
				arr1[indexMerge] = arr1[index1];
				indexMerge--;
				index1--;
			}else{
				arr1[indexMerge] = arr2[index2];
				indexMerge--;
				index2--;
			}
		}
		
	}
}
