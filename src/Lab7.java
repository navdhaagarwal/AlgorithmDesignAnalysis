import java.util.Arrays;
import java.util.Scanner;

public class Lab7 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int f = sc.nextInt();

        int male[] = new int[m];
        int female[] = new int[f];

        for (int i = 0; i < m; i++)
            male[i] = sc.nextInt();
        for (int i = 0; i < f; i++)
            female[i] = sc.nextInt();

        Arrays.sort(female);
        Arrays.sort(male);

        long arr[][]= new long[m+1][f+1];
        for(int i=0; i<m+1; i++)
        {
            for(int j=0; j<f+1; j++)
            {
                arr[i][j]= Long.MAX_VALUE;
            }
        }

        for(int i=0; i<f+1; i++)
        {
            arr[0][i]=0;
        }

        for(int i=1; i<=m; i++)
        {
            for(int j=i; j<=f; j++)
            {
                arr[i][j]=Math.min(arr[i][j-1],(arr[i-1][j-1]+Math.abs(female[j-1]-male[i-1])));
            }
        }
        System.out.println(arr[m][f]);

    }
}