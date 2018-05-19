<h1> Java and Hbase Example</h1>

<p> This repository is a very simple example on how to perform CRUD operation in HBase using Java.</p>
<p> Since I use pseudo distributed mode on my HBase's setup, so that hadoop and zookeeper are needed. If your HBase's setup is in standalone one, you don't need install and setup that stack</p>

<h3>Prerequisites</h3>
<p>1. <a href="http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html">JDK 1.8</a></p>
<p>2. <a href="http://www.apache.org/dyn/closer.cgi/hadoop/common/hadoop-3.1.0/hadoop-3.1.0.tar.gz">Apache Hadoop-3.1.0</a></p>
<p>3. <a href="http://www-us.apache.org/dist/zookeeper/zookeeper-3.4.12/">Apache Zookeeper-3.4.12</a></p>
<p>4. <a href="http://www.apache.org/dyn/closer.lua/hbase/2.0.0/hbase-2.0.0-bin.tar.gz">Apache HBase-2.0.0</a></p>
<p>5. <a href="https://maven.apache.org">Maven</a></p>

<h3>Steps to run the project</h3>
<h4>Pseudo Distributed Mode</h4>
<p>1. /hadoop-3.1.0/sbin/start-dfs.sh</p>
<p>2. /hadoop-3.1.0/sbin/start-yarn.sh</p>
<p>3. /zookeeper-3.4.12/bin/zkServer.sh start</p>
<p>4. /hbase-2.0.0/bin/start-hbase.sh</p>
<p>5. Run the particular class of the example</p>

<h4>Standalone Mode</h4>
<p>1. /hbase-2.0.0/bin/start-hbase.sh</p>
<p>2. Run the particular class of the example</p>
