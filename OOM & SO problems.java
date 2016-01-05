/**
* OutOfMemory error on heap
*/
class SomeObj{
}
class CreateHeapOOM{
	public static void main(String[] args){
		ArrayList<SomeObj> list = new ArrayList<SomeObj>();
		while(true){
			list.add(new SomeObj());
		}
	}
}

/**
* StackOverflow error on Java Stacks
*/
class CreateStackSO{
	private int a = 0;
	private void someMethod(){
			a++;
			someMethod();
		
	}
	
	public static void main(String[] args){
		CreateStackSO myInstance = new CreateStackSO();
		myInstance.someMethod();
	}
}

/**
* OutOfMemory error on Java Stacks
*/
class CreateStackOO{
	private void someMethod(){
		while(true){
		}
	}
	public void createThread(){
		while(true){
			Thread myThread = new Thread(new Runnable(){
				public void run(){
					someMethod();
				}
			});
			myThread.start();
		}
	}
	public static void main(String[] args){
		CreateStackOO a = new CreateStackOO();
		a.createThread();
	}
}