package learn.zk.configService;

import learn.zk.ConnectZookeeper;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;

import java.nio.charset.Charset;

/**
 * 对zk连接、读和写
 * Created by Vigo on 17/12/6.
 */
public class ActiveKeyValueStore extends ConnectZookeeper{

    private static final Charset CHARSET = Charset.forName("UTF-8");

    public void write(String path, String value) throws KeeperException, InterruptedException {
        Stat stat = zk.exists(path, this);
        if (stat == null){
            zk.create(path, value.getBytes(CHARSET), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.printf("Create Znode : %s\n", path);
        }else {
            zk.setData(path, value.getBytes(CHARSET), -1);
        }
    }

    public String read(String path, Watcher watcher) throws KeeperException, InterruptedException {
        byte[] data = zk.getData(path, watcher, null);
        return new String(data, CHARSET);
    }
}
