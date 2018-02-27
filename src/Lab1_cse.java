import java.util.Scanner;

public class Lab1_cse
{
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int test=sc.nextInt();
        for(int t=0; t<test; t++)
        {
            int n=sc.nextInt();
            int m=sc.nextInt();
            Lab1_cse obj= new Lab1_cse();
            int flag=obj.pens(n,m,0);
            if(flag==-1)
                System.out.println("No Sleep");
            else
            {
                System.out.println(flag);
            }

        }
    }

    int pens(int n, int m, int hrs)
    {
        if(m==1)
            return -1;
        else if(n<m)
        {
            hrs = hrs + n;
            return hrs;
        }
        else
        {
            n=n-m;
            hrs=hrs+m;
            n=n+1;
            hrs=pens(n,m,hrs);
            return hrs;
        }
    }
}
