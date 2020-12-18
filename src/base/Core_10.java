package base;

/**
 * 并发
 * <p>
 * 线程：
 * 线程的6中状态：New新创建、Runnable可运行、Blocked被阻塞、Waiting等待、Timed waiting计时等待、Terminated被终止
 * 守护线程 t.setDaemon(true)
 * <p>
 * 同步
 * 锁对象
 * 条件对象
 * 读/写锁：rwl.readLock() rwl.writeLock()
 */
public class Core_10 {
    public static void main(String[] args) {
        String a = null;
        System.out.println(a);
    }
}

/**
 * 使用Runnable多线程编程
 */
class Thread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        // 实现Runnable的类需要用new Thread调用
        new Thread(new Thread2()).start();
    }
}

/**
 * 使用Thread直接多线程编程
 */
class ThreadDemo {
    public static void main(String[] args) throws Exception {
        // start和run
//        new TestThread0().run();  // 一直调用run，串行的
        new TestThread0().start();  // 并行执行，会执行以下的程序
        while (true) {
            System.out.println("main thread is running!");
            Thread.sleep(500);
        }
    }
}

class TestThread0 extends Thread {
    public void run() {
        while (true) {
            System.out.println("TestThread is running.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}