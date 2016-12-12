package learn.algorithm.greedy;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 区间调度问题
 * （规则：每次选取结束时间最早的工作）
 * Created by Vigo on 16/12/12.
 */
public class IntervalSchedule {

    Map<Integer, Integer> jobs;


    /**
     * 按照工作结束时间t升序排列
     * @param s
     * @param t
     * @param N
     */
    public IntervalSchedule(int[]s, int []t , int N) {
        jobs = new TreeMap<Integer, Integer>();
        for (int i = 0; i < N; i++) {
            jobs.put(t[i], s[i]);
        }

    }

    public void solve(){
        int count = 0;
        int end = 0;// 所选工作结束时间
        Iterator it = jobs.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry map = (Map.Entry) it.next();
            Integer t = (Integer) map.getKey();
            Integer s = (Integer) map.getValue();
            if (end < s){
                count++;
                end = t;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        int n=5;
        int[] s={1,2,4,6,8};
        int[] t={3,5,7,9,10};
        IntervalSchedule intervalSchedule = new IntervalSchedule(s, t, n);
        intervalSchedule.solve();
    }

}
