package com.robin.springboot.demo.ElasticSearch.config;


import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TransportClient {
    @Value("${spring.data.elasticsearch.cluster-name}")
    private static String clusterName;
    @Value("${spring.data.elasticsearch.cluster-nodes}")
    private static String host;
    @Value("${spring.data.elasticsearch.properties.port}")
    private static Integer port;


    /** 构建Settings 对象 */
    private static Settings settings = Settings.builder().put("cluster.name", clusterName).build();
    /** TransportClient 对象, 用于连接ES集群 */
    private static volatile TransportClient client;

    /**
     * 同步synchronized(*.class)代码块的作用和synchronized static方法作用一样,
     * 对当前对应的*.class 进行持锁, static方法和.class 一样都是锁的该类本身,同一个监听器
     * @return
     */
    public static TransportClient getClient(){
//        if(client == null){
//            synchronized (TransportClient.class){
//                client = new TransportClient(settings);
//                try {
//                    String[] allHost = host.split(",");
//                    for (String str:allHost) {
//                        client.addTransportAddresses(new TransportAddress(InetAddress.getByName(str), port));
//                    }
//                } catch (UnknownHostException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        return client;
    }
}
