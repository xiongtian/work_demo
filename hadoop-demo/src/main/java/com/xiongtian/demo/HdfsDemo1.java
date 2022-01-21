package com.xiongtian.demo;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.security.UserGroupInformation;

import java.io.IOException;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2021/12/20 10:31
 * @description：通过kerberos认证操作hdfs的demo
 */
public class HdfsDemo1 {

    public static void main(String[] args) throws IOException {
        String krb5file = "src/main/resource/kbr5.conf";
        String user = "asmp@csvm.COM";
        String keyPath = "src/main/resource/asmp.keytab";


        System.setProperty("java.security.krb5.conf", krb5file);

        Configuration conf = new Configuration();
        conf.set("fs.hdfs.impl", org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
        UserGroupInformation.setConfiguration(conf);
        UserGroupInformation.loginUserFromKeytab(user, keyPath);

    }
}
