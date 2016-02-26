# Dubbo
学习Dubbo

# 启动 Zookeeper
解压：tar -zxvf zookeeper-3.4.6.tar.gz
配置：进入conf目录重命名 mv zoo_sample.cfg zoo.cfg
      修改zoo.cfg文件 dataDir=/home/cheng/zookeeper-3.4.6/data
启动：进入bin目录 ./zkServer.sh start
      [root@localhost bin]# ./zkServer.sh start
      JMX enabled by default
      Using config: /home/cheng/zookeeper-3.4.6/bin/../conf/zoo.cfg
      Starting zookeeper ... STARTED
查看是否启动：进入bin目录 ./zkServer.sh status
      [root@localhost bin]#  ./zkServer.sh status
      JMX enabled by default
      Using config: /home/cheng/zookeeper-3.4.6/bin/../conf/zoo.cfg
      Mode: standalone

停止：进入bin目录 ./zkServer.sh stop



1. 启动ZK服务:       sh bin/zkServer.sh start
2. 查看ZK服务状态:   sh bin/zkServer.sh status
3. 停止ZK服务:       sh bin/zkServer.sh stop
4. 重启ZK服务:       sh bin/zkServer.sh restart


使用delete命令可以删除指定znode. 当该znode拥有子znode时, 必须先删除其所有子znode, 否则操作将失败. rmr命令可用于代替delete命令, rmr是一个递归删除命令, 如果发生指定节点拥有子节点时, rmr命令会首先删除子节点.