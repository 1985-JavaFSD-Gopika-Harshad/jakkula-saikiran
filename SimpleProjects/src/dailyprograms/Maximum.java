package dailyprograms;


public class Maximum {
	
	public static<T extends Comparable<T>>T findMax(T[] arr){
		T max= arr[0] ;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].compareTo(max)>0) {
				max=arr[i];
				
			}
		}
		return max;
	}
	public static void main(String[] args) {
		Integer[] intArray= {1,3,5,7,9,0};
		System.out.println("Maximum number from array :"+findMax(intArray));
		
		String[] stringArray= {"ball","apple","dog","cat","elephant"};
		System.out.println("Maximum String from Array :"+findMax(stringArray));
	}

}
