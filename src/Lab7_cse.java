import java.util.Scanner;

public class Lab7_cse
{
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int mod= 1000000007;
        int sum[]= new int[100001];
        int test=sc.nextInt();
        int n=sc.nextInt();
        for(int i=0; i<n; i++)
        {
            sum[i]=1;
        }
        for(int i=n; i<100001; i++)
        {
            sum[i]= (((sum[i-n]%mod) + (sum[i-1]%mod))%mod)%mod ;
        }
        int dp[]= new int[100001];
        dp[1] = 1;
        for(int i=2; i<100001; i++)
            dp[i]= (((sum[i]%mod) + (dp[i-1]%mod))%mod)%mod ;

        for(int t=0; t<test; t++)
        {
            int p=sc.nextInt();
            int q=sc.nextInt();
            int ans= ((dp[q] - dp[p-1])+mod)%mod;
            System.out.println(ans);
        }


    }
}
