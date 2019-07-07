package file;

import org.junit.Test;

import java.io.File;

public class FileDemos {
    /**
     * 获取系统内存信息
     */
    @Test
    public void getSystemMemory(){
        File[] disks  = File.listRoots(); //获取所有分区
        File diskPartition = disks[0];//默认获取第一个分区

        long totalCapacity = diskPartition.getTotalSpace();
        long freePartitionSpace = diskPartition.getFreeSpace();
        long usablePatitionSpace = diskPartition.getUsableSpace();
        System.out.println(String.format("%s-%s-%s",totalCapacity,freePartitionSpace,usablePatitionSpace));
    }
}
