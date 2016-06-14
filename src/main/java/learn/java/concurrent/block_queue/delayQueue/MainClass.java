package learn.java.concurrent.block_queue.delayQueue;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.DelayQueue;

/**
 * 主类
 * Created by Vigo on 16/6/14.
 */
public class MainClass {

    private static final int STUDENT_NUM = 20;

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(STUDENT_NUM + 1);
        DelayQueue< Student> students = new DelayQueue<Student>();
        Random random = new Random();
        for (int i = 0; i < STUDENT_NUM; i++) {
            students.put(new Student((i+1), 30 + random.nextInt(120),countDownLatch));
        }
        Thread teacherThread =new Thread(new Teacher(students));
        students.put(new End(120, countDownLatch, students, teacherThread));
        teacherThread.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" 考试时间到，全部交卷！");
    }
}
