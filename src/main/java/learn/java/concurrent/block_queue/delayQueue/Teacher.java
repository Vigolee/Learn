package learn.java.concurrent.block_queue.delayQueue;

import java.util.concurrent.DelayQueue;

/**
 * 监控队列
 * Created by Vigo on 16/6/14.
 */
public class Teacher implements Runnable {

    private DelayQueue<Student> students;

    public Teacher(DelayQueue<Student> students) {
        this.students = students;
    }

    public void run() {
        while (!Thread.interrupted()) {
            try {
                students.take().submitPaper();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
