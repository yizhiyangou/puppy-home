import java.util.Arrays;

public class PageRank {
    static int[][] link = new int[][]{
            {0, 1, 1},
            {1, 0, 0},
            {0, 1, 0}
    };
    static double damp = 0.85;
    static int[] in = new int[link.length];
    static int[] out = new int[link.length];
    static double[] pr = new double[link.length];

    public static void main(String[] args) {
        for (int m = 0; m < 3; m++) {
            for (int n = m; n < 3; n++) {
                for (int l = 0; l < 3; l++) {
                    in[m] += link[l][n];
                    out[m] += link[n][l];
                }
                break;
            }
        }
        System.out.println("in:" + Arrays.toString(in));
        System.out.println("out" + Arrays.toString(out));

        for (int a = 0; a < link.length; a++) {
            pr[a] = 0.333;
        }
        System.out.println("初始值：" + Arrays.toString(pr));

        for (int b = 0; b <= 99; b++) {
            for (int x = 0; x < link.length; x++) {
                double num = 0;
                for (int y = 0; y < link.length; y++) {
                    if ((x != y) && (out[y] != 0) && link[y][x] != 0) {
                        //System.out.println(pr[x]+"+"+out[y]);
                        //System.out.println(y+"+"+x+"满足条件");
                        num += pr[y] / out[y];
                    }
                }
                //System.out.println(num);
                pr[x] = (1 - damp) / link.length + damp * num;
            }
            System.out.println(Arrays.toString(pr));
        }
    }
}

