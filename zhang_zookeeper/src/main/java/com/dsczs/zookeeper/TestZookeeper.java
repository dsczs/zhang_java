package com.dsczs.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

public class TestZookeeper {
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        //创建ZooKeeper实例
        ZooKeeper zk = new ZooKeeper("192.168.190.135:2181", 100, null);
        String path = "/dmc";

        //创建一个节点,模式是PERSISTENT
        zk.create(path, "1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("创建节点" + path + ",数据为：" + new String(zk.getData(path, null, null)));
        //修改节点数据
        zk.setData(path, "2".getBytes(), -1);
        System.out.println("修改节点" + path + ",数据为：" + new String(zk.getData(path, null, null)));
        //删除一个节点
        System.out.println(zk.exists(path, null));
        zk.delete(path, -1);
        //节点是否存在
        System.out.println(zk.exists(path, null));
    }
}
