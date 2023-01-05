package shangguigu.recursion;

/**
 * @BelongsProject: suanfa
 * @BelongsPackage: shangguigu.recursion
 * @Author: GuoJHao
 * @CreateTime: 2022-12-21  22:14
 * @Description: TODO
 * @Version: 1.0
 */
public class MiGongByMySelf {
    public static boolean setWay(int[][] map,int i,int j){
        if (map[6][5] == 2){
            return true;
        }else {
            if (map[i][j] == 0){
                map[i][j] = 2;
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
            }else {
                return false;
            }
        }
    }
}
