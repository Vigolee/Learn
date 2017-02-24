package learn.java.concurrent.block_queue.delayQueue;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 学生类
 * Created by Vigo on 16/6/14.
 */
public class Student implements Delayed{

    private int student_id;

    /** 提交试卷时间 */
    private long submit_time;

    /** 做题花费时间 */
    private long work_time;

    /** 是否强制收卷 */
    private boolean isForce = false;

    /** 控制线程 */
    private CountDownLatch countDownLatch;

    public Student(int student_id, long work_time, CountDownLatch countDownLatch) {
        this.student_id = student_id;
        this.work_time = work_time;
        this.submit_time = TimeUnit.NANOSECONDS.convert(work_time, TimeUnit.SECONDS) + System.nanoTime();
        this.countDownLatch = countDownLatch;
    }

    /**
     * 提交考卷
     */
    public void submitPaper() {
        if (isForce) {
            System.out.println("student " + student_id + " submit paper using " + work_time);
        }else { // 强制提交
            System.out.println("student " + student_id + " submit paper at 120 and wants using " + work_time);
        }
        countDownLatch.countDown();
    }

    /**
     * 设置强制收卷
     * @param isForce
     */
    public void setIsForce(boolean isForce) {
        this.isForce = isForce;
    }

    /**
     * @param unit
     * @return 当前元素还需要延时多长时间,单位纳秒
     */
    public long getDelay(TimeUnit unit) {
        return unit.convert(submit_time - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    /**
     * 指定元素顺序
     * ！！！！！！此处，按照降序排列，因为优先级大小与元素大小相反
     * @param o
     * @return
     */
    public int compareTo(Delayed o) {
        if (o == null || ! (o instanceof Student))
            return 1;
        if (o == this)
            return 0;
        Student student = (Student) o;
        if (this.work_time > student.work_time) {
            return 1;
        } else if (this.work_time < student.work_time) {
            return -1;
        }else {
            return 0;
        }
    }
}
