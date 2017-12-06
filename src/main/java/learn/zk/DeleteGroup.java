package learn.zk;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.List;

/**
 * 删除组（不支持递归删除）
 * Created by Vigo on 17/12/5.
 */
public class DeleteGroup extends ConnectZookeeper {

    public void delete(String groupName) throws KeeperException, InterruptedException {
        String path = "/" + groupName;
        try {
            List<String> children = zk.getChildren(path, false);
            for (String child : children){
                // -1代表绕过版本检测
                zk.delete(path + "/" + child, -1);
            }
            zk.delete(path, -1);
        }catch (KeeperException.NoNodeException e){
            System.out.printf("Group %s does not exist\n", groupName);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        DeleteGroup deleteGroup = new DeleteGroup();
        deleteGroup.connect(Config.host);
        deleteGroup.delete("zoo");
        deleteGroup.close();
    }
}
