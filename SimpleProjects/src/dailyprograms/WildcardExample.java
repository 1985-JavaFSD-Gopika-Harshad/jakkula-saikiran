package dailyprograms;

import java.util.List;

public class WildcardExample {
	
	public static double sumList(List<? extends Number> list) {
		double sum=0.0;
		for (int i = 0; i < list.size(); i++) {
			sum=sum+list.get(i).doubleValue();
		}
		return sum;
	}
	public static void main(String[] args) {
		List<Integer> intList=List.of(1,2,3,4,5);
		List<Double> doubleList=List.of(2.5,3.1,4.2,1.1);
		
		
		System.out.println("sum of integers :"+sumList(intList));
		System.out.println("sum of double list :"+sumList(doubleList));
	}

}
