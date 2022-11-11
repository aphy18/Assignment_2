class ThreadPause {
  // method to pause the string 
  // here we will pass the time in seconds
  public void wait(int sec) {
    try {
      Thread.currentThread().sleep(sec * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
 }
 
 // main code 
 public class Main {
  public static void main(String args[]) {
    ThreadPause TP = new ThreadPause();
    System.out.println("Waiting 1 second...");
    TP.wait(1);
 
    System.out.println("Done");
    System.out.println("Waiting 10 seconds...");
    TP.wait(10);
 
    System.out.println("Done");
  }
 }
 