package shangguigu.sparsearray;

public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始数组
        //0：表示没有棋子，1：表示黑子 2：表示白子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //输出原始的二维数组
        System.out.println("原始的二维数组：-*-----*");
        for (int[] row : chessArr1) {
            for (int data:row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }



        //将二维数组转稀疏数组
        //1，先遍历数组得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }

        //2,创建相应的稀疏数组
        int sparseArray[][] = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArray[0][0] = chessArr1.length;
        sparseArray[0][1] = chessArr1.length;
        sparseArray[0][2] = sum;


        //遍历二维数组，将非零的值存放到aparseArray中
        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr1[i][j];
                }
            }
        }


        //输出稀疏数组
        System.out.println();
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }
        System.out.println();




        //将稀疏数组恢复成原始的二维数组

        int chessArr2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }



        System.out.println("还原后的二维数组：-*-----*");
        for (int[] row : chessArr2) {
            for (int data:row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        }





}
