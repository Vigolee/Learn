package learn.zk;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.List;

/**
 * 列出组成员
 * Created by Vigo on 17/12/5.
 */
public class ListGroup extends ConnectZookeeper{

    public void list(String groupName) throws KeeperException, InterruptedException {
        String path = "/" + groupName;
        try {
            List<String> children = zk.getChildren(path, false);
            if (children.isEmpty()){
                System.out.printf("No members in group %s\n", groupName);
                System.exit(1);
            }
            for (String child : children){
                System.out.println(child);
            }
        }catch (KeeperException.NoNodeException e){
            System.out.printf("Group %s does not exist\n", groupName);
        }
    }

    public static void main(String[] args) throws InterruptedException, KeeperException, IOException {
        ListGroup listGroup = new ListGroup();
        listGroup.connect(Config.host);
        listGroup.list("zoo");
        listGroup.close();
    }
}
