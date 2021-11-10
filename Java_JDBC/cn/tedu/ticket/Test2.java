package cn.tedu.ticket;

public class Test2 {
    public static void main(String[] args) {
        testRannablt ts = new testRannablt();
        Thread th = new Thread(ts);
        Thread th1 = new Thread(ts);
        Thread th2 = new Thread(ts);
        th.start();
        th1.start();
        th2.start();
    }
}
class testRannablt implements Runnable{

    int tickets = 100;
    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName()+"="+tickets--);
        if(tickets<=0)break;
        }
    }
}