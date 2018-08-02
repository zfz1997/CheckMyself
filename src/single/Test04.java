package single;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * ����̹߳����ź�����������
 * @author ���
 *
 */
class AppContext {
    public static final int NUM_OF_FORKS = 5;   // ��������(��Դ)
    public static final int NUM_OF_PHILO = 5;   // ��ѧ������(�߳�)

    public static Semaphore[] forks;    // ���ӵ��ź���
    public static Semaphore counter;    // ��ѧ�ҵ��ź���

    static {
        forks = new Semaphore[NUM_OF_FORKS];

        for (int i = 0, len = forks.length; i < len; ++i) {
            forks[i] = new Semaphore(1);    // ÿ�����ӵ��ź���Ϊ1
        }

        counter = new Semaphore(NUM_OF_PHILO - 1);  // �����N����ѧ�ң����ֻ����N-1��ͬʱȡ����
    }

    /**
     * ȡ�ò���
     * @param index �ڼ�����ѧ��
     * @param leftFirst �Ƿ���ȡ����ߵĲ���
     * @throws InterruptedException
     */
    public static void putOnFork(int index, boolean leftFirst) throws InterruptedException {
        if(leftFirst) {
            forks[index].acquire();
            forks[(index + 1) % NUM_OF_PHILO].acquire();
        }
        else {
            forks[(index + 1) % NUM_OF_PHILO].acquire();
            forks[index].acquire();
        }
    }

    /**
     * �Żز���
     * @param index �ڼ�����ѧ��
     * @param leftFirst �Ƿ��ȷŻ���ߵĲ���
     * @throws InterruptedException
     */
    public static void putDownFork(int index, boolean leftFirst) throws InterruptedException {
        if(leftFirst) {
            forks[index].release();
            forks[(index + 1) % NUM_OF_PHILO].release();
        }
        else {
            forks[(index + 1) % NUM_OF_PHILO].release();
            forks[index].release();
        }
    }
}

/**
 * ��ѧ��
 * @author ���
 *
 */
class Philosopher implements Runnable {
    private int index;      // ���
    private String name;    // ����

    public Philosopher(int index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public void run() {
        while(true) {
            try {
                AppContext.counter.acquire();
                boolean leftFirst = index % 2 == 0;
                AppContext.putOnFork(index, leftFirst);
                System.out.println(name + "���ڳ�������棨ͨ�ķۣ�...");   // ȡ���������ӾͿ��Խ�ʳ
                Thread.sleep(2000);
                AppContext.putDownFork(index, leftFirst);
                AppContext.counter.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Test04 {

    public static void main(String[] args) {
        String[] names = { "���", "����", "������", "���", "��Ī��" };   // 5λ��ѧ�ҵ�����
//      ExecutorService es = Executors.newFixedThreadPool(AppContext.NUM_OF_PHILO); // �����̶���С���̳߳�
//      for(int i = 0, len = names.length; i < len; ++i) {
//          es.execute(new Philosopher(i, names[i]));   // �����߳�
//      }
//      es.shutdown();
        for(int i = 0, len = names.length; i < len; ++i) {
            new Thread(new Philosopher(i, names[i])).start();
        }
    }

}