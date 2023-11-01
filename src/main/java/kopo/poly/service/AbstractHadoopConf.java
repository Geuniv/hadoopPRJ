package kopo.poly.service;


import org.apache.hadoop.conf.Configuration;

/**
 * 하둡 접속을 위한 공통 설정을 추상한 객체로 정의
 */
public abstract class AbstractHadoopConf {

    String namenodeHost = "192.168.242.137";

    String namenodePort = "9000";

    String yarnPort = "8080";

    /*
     * 하둡 접속 설정
     * */
    public Configuration getHadoopConfiguration() {

        Configuration conf = new Configuration();

        // fs.defaultFS 설정 값 : hdfs://192.168.2.136:9000
        conf.set("fs.defaultFS", "hdfs://" + namenodeHost + ":" + namenodePort);

        // yarn 주소 설정
        conf.set("yarn.resourcemanager.address", namenodeHost + ":" + yarnPort);

        return conf;
    }
}
