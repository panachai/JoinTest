
public class JoinTest {

    public static void main(String[] args) {
        JoinClass jc1 = new JoinClass();
        JoinClass jc2 = new JoinClass();
        JoinClass jc3 = new JoinClass();
        jc1.setName("jc1");
        jc2.setName("jc2");
        jc3.setName("jc3");

        jc1.start();
        try {
            jc1.join(2000);
        } catch (InterruptedException ie) {

        }
        jc2.start();
        try {
            jc1.join();
        } catch (InterruptedException ie) {

        }
        jc3.start();
        try {
            jc1.join();
            jc2.join();
            jc3.join();
        } catch (InterruptedException ie) {
        }
        System.out.println("jc1 alive " + jc1.isAlive());
        System.out.println("main exit...");

    }
}

class JoinClass extends Thread {

    public void run() {
        System.out.println("Thread start : " + Thread.currentThread().getName());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ie) {

        }
        System.out.println("Thread stop : " + Thread.currentThread().getName());
    }
}
