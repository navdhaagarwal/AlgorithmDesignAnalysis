import java.util.Arrays;
import java.util.Scanner;

public class Lab6
{
    static int n;
    static int k;
    static int arr[];
    static boolean sum[][];
     public static  void main(String args[])
     {
         Scanner sc= new Scanner(System.in);
         int test=sc.nextInt();
         for(int t=0; t<test; t++)
         {
             n=sc.nextInt();
             k=sc.nextInt();
             arr= new int[n];
             for(int i=0; i<n; i++)
             {
                 arr[i]=sc.nextInt();
             }
             int max_sum=0;

             for(int i=0; i<n; i++)
             {
                 max_sum=max_sum+arr[i];
             }
             Arrays.sort(arr);
             sum= new boolean[n+1][max_sum+1];
             int count=0;
             for(int i=0; i<=n; i++)
             {
                 sum[i][0]=true;
             }
             for (int i=1; i<= n; i++) {
                 int current = arr[i - 1];
                 sum[i][current] = true;
                 if (current == k)
                     count++;
                 for (int j = 1; j <= max_sum; j++) {
                     if (sum[i - 1][j] == true)
                     {

                         sum[i][j] = true;
//                         if (k == j)
//                             count++;
                         int new_sum = j + arr[i - 1];
                         sum[i][new_sum] = true;
                         if (k == new_sum)
                             count++;
                     }
                 }


//                 for(int r=0; r<=n; r++)
//                 {
//                     for(int c=0; c<=max_sum; c++)
//                     {
//                         System.out.print(sum[r][c]+" ");
//                     }
//                     System.out.println();
//                 }
//                 System.out.println();
//
//                 System.out.println(count);
             }
             //System.out.println(count);

             if(count==0)
             {
                 System.out.println("IMPOSSIBLE");
             }
             else if(count==1)
             {
                 count_guns(n-1,k);
                 System.out.println(no_guns);
             }
             else
             {
                 System.out.println("AMBIGIOUS");
             }

         }
     }
     static int no_guns=0;
     static void count_guns(int index, int weight)
     {
            if(index==0)
            {
                if(weight==0)
                    return;
                else if(weight!=0 && sum[0][weight]==true)
                    no_guns++;
                return;
            }

            if(sum[index-1][weight]==true)
            {
                count_guns(index-1, weight);
            }
            if(weight>=arr[index] && sum[index-1][weight-arr[index]]==true)
            {
                no_guns++;
                count_guns(index-1, weight-arr[index]);
            }
     }
}
