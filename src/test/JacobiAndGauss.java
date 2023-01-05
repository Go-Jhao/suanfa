package test;

/**
 * @BelongsProject: suanfa
 * @BelongsPackage: test6
 * @Author: GuoJHao
 * @CreateTime: 2022-11-02  15:50
 * @Description: TODO
 * @Version: 1.0
 */
import java.util.Scanner;

public class JacobiAndGauss {
    static int n = 3;
    public static void main(String[] args) {
        float[][] A = { { 8,-3,2 }, { 4,11,-1 }, { 6,3,12 } };
        float[] B = { 20,33,36 };
        float e, m, temp, t;
        float y[] = { 0.0f, 0.0f, 0.0f };
        float x0[] = { 0.0f,0.0f, 0.0f };
        float[] x = { 0.0f, 0.0f, 0.0f };
        int N, i, j, k,sum1,sum2;
        System.out.println("精度e=");
        Scanner scan = new Scanner(System.in);
        e = scan.nextFloat();
        System.out.println("最大迭代次数N=");
        N = scan.nextInt();
        for (i = 0; i < n; i++) {
            System.out.println("x0" + "[" + i + "]=" + x0[i]);
        }

// Jacobi迭代过程
        for (k = 0; k < N; k++) {
            m = 0;
            for (i = 0; i < n; i++) {
                x[i] = B[i];
                for (j = 0; j < n; j++)
                    if (j != i) {
                        x[i] = x[i] - A[i][j] * x0[j];
                    }
                x[i] = x[i] / A[i][i];
                System.out.println("x[]" + x[i]);
                temp = Math.abs(x[i] - x0[i]);
                System.out.println("temp" + temp);

                if (temp > m)
                    m = temp;
            }
            System.out.print(k + 1 + "次迭代:");
            for (int i1 = 0; i1 < n; i1++) {
                System.out.println("x" + "[" + i1 + "]=" + x[i1]);
                x0[i1] = x[i1];
            }
            if (m < e) {
                sum1=k+1;
                System.out.println("Jacobi迭代结束");
                System.out.println("一共迭代了"+sum1);
                break;
            }
        }
        if (k > N)
            System.out.println("第" + k + "次迭代未找出满足精度的解 发散");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("以下是Gauss-Seidel迭代");
        System.out.println("-----------------------------------------------------------------------------");

// Gauss-Seidel迭代
        for (k = 0; k < N; k++) {
            m = 0;
            for (i = 0; i < n; i++) {
                t=y[i];
                y[i] = B[i];
                for (j = 0; j < n; j++)
                    if (j != i) {
                        y[i] = y[i] - A[i][j] * y[j];
                    }
                y[i] =y[i] / A[i][i];

                temp = Math.abs(y[i] - t);
                System.out.println("temp" + temp);

                if (temp > m)
                    m = temp;
            }

            System.out.print(k + 1 + "次迭代:");
            for (int i1 = 0; i1 < n; i1++) {
                System.out.println("x" + "[" + i1 + "]=" + y[i1]);

            }
            if (m < e) {
                sum2=k+1;
                System.out.println("Gauss-Seidel迭代结束");
                System.out.println("一共迭代了"+sum2);
                break;
            }
            if (k > N)
                System.out.println("第" + k + "次迭代未找出满足精度的解 发散");
        }





//        int iter = 1;
//        int exitflag = 1;
//        int w = 1;
//        float[] x1;
//        int[][] xs = new int[iter][n];
//        for(int xi =0;xi < 3;xi++){
//            xs[iter][i] = (int) x0[i];
//        }
//        int[][] err = new int[iter][1];
//        while (exitflag == 1){
//            x1 = x;
//        }
//        for (int l = 0; l < n; l++) {
//            int[][] jz1= new int[][]
//            x[l]=(1-w)*x0[l]+w*(B[k]-A[k,[1:l-1,l+1:n]]*x1([1:l-1,l+1:n]))/A[l,l];
//            x1[k]=x[k];
//        }
    }
}