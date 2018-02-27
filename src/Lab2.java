import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lab2
{
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int test=sc.nextInt();
        for(int t=0; t<test; t++)
        {
            int n=sc.nextInt();
            int arr[]= new int[n];
            for(int i=0; i<n; i++)
                arr[i]=sc.nextInt();

            int jump[]= new int[n];
            Queue<Integer> queue= new LinkedList<>();
            queue.add(0);
            while(!queue.isEmpty())
            {
                int current=queue.poll();
                if(current+1==n || current+arr[current]==n)
                {
                    System.out.println(jump[current]+1);
                    break;
                }
                if(current+1<n && jump[current+1]==0)
                {
                    queue.add(current + 1);
                    jump[current+1]=1+jump[current];
                }
                if(current+arr[current]<n &&current+arr[current]>0 && jump[current+arr[current]]==0)
                {
                    queue.add(current + arr[current]);
                    jump[current+arr[current]]=1+jump[current];
                }

            }
        }
    }

}

