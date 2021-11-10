package cn.tedu.ticket;

/*本类用于复写同步锁*/

public class Test1 {
    public static void main(String[] args) {
        a a1 = new a();
        Thread t1 = new Thread(a1);
        Thread t2 = new Thread(a1);
        Thread t3 = new Thread(a1);
        Thread t4 = new Thread(a1);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class a implements Runnable {
    int ticket = 100;
    Object o = new Object();
    @Override
    public  void run() {

        while (true) {
            synchronized (o) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "=" + ticket--);
                }
                if (ticket <= 0) break;
            }
        }
    }
}