package security;

import org.junit.Test;

import java.io.File;
import java.security.SecureRandom;

public class SecureRandomDemo {

    @Test
    public void test00(){
        SecureRandom generater   = new SecureRandom();
        File diskPartition = File.listRoots()[0];
        long freePartitionSpace = diskPartition.getFreeSpace();
        generater.setSeed(freePartitionSpace); //使用系统空间作为随机数种子，能够在某种意义上做到随机


        System.out.println(generater.nextInt(50));
    }
}
