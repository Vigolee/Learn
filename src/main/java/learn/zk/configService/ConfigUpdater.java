package learn.zk.configService;

import learn.zk.Config;
import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 更新zk节点
 * Created by Vigo on 17/12/6.
 */
public class ConfigUpdater {

    protected static final String PATH = "/config";

    private ActiveKeyValueStore store;

    private Random random = new Random();

    public ConfigUpdater(String hosts) throws IOException, InterruptedException {
        store = new ActiveKeyValueStore();
        store.connect(hosts);
    }

    public void run() throws KeeperException, InterruptedException {
        while (true){
            String value = random.nextInt(100) + "";
            store.write(PATH, value);
            System.out.printf("Set %s to %s\n", PATH, value);
            TimeUnit.SECONDS.sleep(random.nextInt(10));
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ConfigUpdater configUpdater = new ConfigUpdater(Config.host);
        configUpdater.run();
    }
}
