//Using Anonymous classes to define the runnable interface

public class Application3 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() { // Our Own Run method for our own thread
				for (int i = 0; i < 8; i++) {
					System.out.println("Thread Running: " + i);
					try {
						Thread.sleep(500); // Pauses the run method for 500 ms. The value inside the bracket is 500ms.
					} catch (InterruptedException e) { // Interrupted exception usually occurs 
					                                   // due to lack of resources.
						e.printStackTrace();
					}
				}
			}
		});
		t1.start();
	 // t2.start();
	}
}
