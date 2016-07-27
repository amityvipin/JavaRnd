package sun.java.sorting;

public class SearchElementInSortedAndRatatedArray {

	public static void main(String[] args) {
		int[] values = {9,11,13,14,1,2,2,4,5,6,8};
		System.out.println(findElement(values,2,0,values.length-1));
	}

	private static int findElement(int[] values, int element, int left, int right) {
		if(left> right)
			return -1;
		int mid = (left + right)/2;
		if(values[mid]==element)
			return mid;
		
		if(values[left] > values[mid]){
			// right is sorted
			if(element >= values[mid] && element <= values[right])
				return findElement(values, element, mid+1, right);//search in right
			else
				return findElement(values,element,left,mid-1);//search in left
			
		}else if(values[left] < values[mid]){
			//left is sorted
			if(element >= values[left] && element <= values[mid])
				return findElement(values, element, left, mid-1);//search in left
			else
				return findElement(values,element,mid+1,right);//search in right
		}else{
			//left half is all repeats
			if(values[mid]!=values[right])
				return findElement(values,element,mid+1,right);
			else{
				int result = findElement(values, element, left, mid-1);
				if(result==-1)
					return findElement(values,element,mid+1,right);
				else
					return result;
			}
		}
		
	}

}
