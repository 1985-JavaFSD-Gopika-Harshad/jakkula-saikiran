package dailyprograms;

public class MultiTypeBox<T> {
	private T object;
	
	public MultiTypeBox(T object){
		this.object=object;
	}
	public T getObject() {
		return object;
	}
	public void setObject(T object) {
		this.object=object;
	}
	
	public void display() {
		System.out.println("Type :"+object.getClass().getSimpleName());
		System.out.println("Value :" + object);
	}
	public static void main(String[] args) {
		
		//integer type
		MultiTypeBox<Integer> box1=new MultiTypeBox<>(20);
		box1.display();
		box1.setObject(25);
		System.out.println("Value :" +box1.getObject());
		
		//string type
		MultiTypeBox<String> box2=new MultiTypeBox<>("Hello i am String");
		box2.display();
		box2.setObject("Hello Revature");
		System.out.println("Value :"+box2.getObject());
		
		//Double Type
		MultiTypeBox<Double> box3=new MultiTypeBox<>(42.5);
		box3.display();
		box3.setObject(50.5);
		System.out.println("Value :"+box3.getObject());

	}
	

}
