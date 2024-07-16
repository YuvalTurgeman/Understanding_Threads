package Lesson2.Problem;

public class App {

    private int count = 0;

    public static void main(String [] args){
        App app = new App();
        app.dowork();


    }

    public void dowork(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i=0;i<10000;i++){
                    count++;
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i=0;i<10000;i++){
                    count++;
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join(); // join is asking the threads wait until t1 is finished
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            t2.join();  // join is asking the threads wait until t2 is finished
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Count is: " + count);
    }
}
