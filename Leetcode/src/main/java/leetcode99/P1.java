package leetcode99;


public class P1 {

    //获取单个数量
    public int getSingal(int num){
        return num==0?0:6+(num-1)*4;
    }
    public int surfaceArea(int[][] grid) {
        int sum =0;
        //获取总数
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j <grid[0].length; j++) {
                sum+=getSingal(grid[i][j]);
            }
        }
        //System.out.println(sum);
        //遍历相邻取小 * 2
        //先横
        for (int i = 0; i < grid.length; i++) {
            //可能越界
            for (int j = 1; j <grid[0].length; j++) {
                sum-=2*Math.min(grid[i][j-1],grid[i][j]);
            }
        }
        //System.out.println(sum);
        //后竖
        for (int j =0;j<grid[0].length;j++){
            for (int i =1;i<grid.length;i++){
                sum-=2*Math.min(grid[i-1][j],grid[i][j]);
            }
        }
        //System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        P1 p =new P1();
        int [][] grid = new int[][]{{1,2},{3,4}};
        int [][] grid2 = new int[][]{{2}};
        int [][] grid3 = new int[][]{{1,0},{0,2}};

        int a = p.surfaceArea(grid3);
        System.out.println(a);
    }

}
