package SwordToOffer.p1_arrayFind;

import org.junit.Test;

public class Solution {
    /**
     * 在一个二维数组中（每个一维数组的长度相同），
     * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，
     * 判断数组中是否含有该整数。
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {
        int rows = array.length;  //总行数
        int cols = 0;              //总列数
        if(rows>0)
            cols = array[0].length;
        int row = 0;              //行指针
        int col = cols-1;         //列指针

        while(col>=0 && row<=rows-1){
            if(array[row][col]>target){
                col--;
            }else if(array[row][col]<target){
                row++;
            }else {
                return true;
            }
        }

        return false;
    }

    @Test
    public void test00(){

    }
}
