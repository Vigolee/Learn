package learn.java.concurrent.block_queue.delayQueue;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * 关闭监控线程，强制结束
 * Created by Vigo on 16/6/14.
 */
public class End extends Student {
    private DelayQueue<Student> students;

    private Thread teacher;

    private CountDownLatch countDownLatch;


    public End(long work_time, CountDownLatch countDownLatch, DelayQueue<Student> students, Thread teacher) {
        super(0, work_time, countDownLatch);
        this.students = students;
        this.teacher = teacher;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void submitPaper() {
        teacher.interrupt(); // 关闭控制线程

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            student.setIsForce(true);
            student.submitPaper();
        }
        countDownLatch.countDown();
    }

    public static void main(String[] args) {
        System.out.println(TimeUnit.NANOSECONDS.convert(1L, TimeUnit.SECONDS));
    }
}
