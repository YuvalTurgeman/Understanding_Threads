package Lesson1.Second;

//Example for implementing Runnable interface.

class Runner implements Runnable{

    public void run(){
        for(int i=0; i<10;i++){
            System.out.println("Hello " + i);

            try {
                Thread.sleep(1000); //Thread.sleep throws an Interrupted Exception which is a checked Exception, therefor we have to put code block with Thread.sleep in try & catch blocks
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

public class App {

    public static void main(String [] args){

        Runner runner1 = new Runner();  // uses default ctor in Object class
        Thread t1 = new Thread(runner1);    //wrapping the Runnable object with a Thread Object in order to inherit the start() method and other methods in Thread's API.
        t1.start();    //activation of a thread will be performed with the method start, not run. if we will activate with run, it will run in the main thread of the app, and starts activates as a different thread.  !!!!

        //in order to prove that t1.start() works on a different thread, we will create a t2 with runner2 and activate both of them at the same time,
        //if they are running one after the other, we will expect to see all of runner1 prints before runner2's.
        //if they are running concurrently, we will see mixed prints, let's go:

        Runner runner2 = new Runner();
        Thread t2 = new Thread(runner2);
        t2.start();

    }
}