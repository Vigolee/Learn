package learn.rubic.rubic_core.model;

/**
 * 加载算法需要的信息
 * Created by Vigo on 16/8/30.
 */
public class AlgorithmInfo {

    private String jar_path;

    private String run_class;

    public AlgorithmInfo(String jar_path, String run_class) {
        this.jar_path = jar_path;
        this.run_class = run_class;
    }

    public String getJar_path() {
        return jar_path;
    }

    public String getRun_class() {
        return run_class;
    }
}
