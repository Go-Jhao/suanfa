package shangguigu.recursion;

/**
 * @BelongsProject: suanfa
 * @BelongsPackage: shangguigu.recursion
 * @Author: GuoJHao
 * @CreateTime: 2022-12-21  20:14
 * @Description: TODO
 * @Version: 1.0
 */
public class MiGong {
    public static void main(String[] args) {
        //先创建一个二维数组
        int[][] map = new int[8][7];

        //使用1表示墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(setWay(map, 1, 1));

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    //0表示没走过，
    //1表示墙
    //2表示走过
    //3表示已经走过，但走不通
    //终点：
    //在走迷宫时，需要制定一个策略（方法）下->右->上->左，如果走不通就回溯
    /**
     * @description:
     * @author: GuoJHao
     * @date: 2022/12/21 20:25
     * @param: [map, i, j]
     * @return: boolean
     **/
    public static boolean setWay(int[][] map,int i,int j){
        if (map[6][5]==2){
            return true;
        }else {
            if (map[i][j] == 0) {
                map[i][j] = 2;//假定是能走的

                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            }else {//是1 2 3时
                return false;
            }
        }
    }
}
