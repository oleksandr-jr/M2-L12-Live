package E4;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        String st0 = "Object 0";
        String st1 = "Object 1";
        String st2 = "Object 2";

        SyncThread syncThread1 = new SyncThread(st0, st1);

        SyncThread syncThread2 = new SyncThread(st1, st2);

        SyncThread syncThread3 = new SyncThread(st2, st0);


        syncThread1.start();
        Thread.sleep(5000);

        syncThread2.start();
        Thread.sleep(5000);

        syncThread3.start();
        Thread.sleep(5000);
    }
}

class SyncThread extends Thread {
    private String st1;
    private String st2;

    public SyncThread(String st1, String st2) {
        this.st1 = st1;
        this.st2 = st2;
    }

    @Override
    public void run() {
        System.out.println(getName() + "пытается блокировать " + st1);

        synchronized (st1){
            System.out.println(getName() + " Заблокировал " + st1);
            work(); // 30s

            System.out.println(getName() + "пытается блокировать " + st2);
            try {
                synchronized (st2){
                    System.out.println(getName() + " Заблокировал " + st2);
                    work();
                }
            }catch (Exception e){
                System.out.println(e);
            }


            System.out.println(getName() + " снял блокировку с " + st2);
        }
        System.out.println(getName() + " снял блокировку с " + st1);
    }

    private void work() {
        try {
            sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
