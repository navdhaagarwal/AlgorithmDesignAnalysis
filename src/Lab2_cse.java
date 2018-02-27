import java.util.Scanner;

public class Lab2_cse
{
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int test=sc.nextInt();
        for(int t=0; t<test; t++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            Node arr[]= new Node[n*m];
            for(int i=0; i<n*m; i++)
            {
                Node ptr= new Node(i+1, -1);
                arr[i]=ptr;
            }
            int count=0;
            for(int i=0; i<n; i++)
            {
                for(int j=0; j<m; j++)
                {
                    count++;
                    int input=sc.nextInt();
                    Node ptr1=null;
                    if(j<n-1)
                    {
                        Node ptr= new Node(count,input );
                        ptr1=arr[i*n+j+1].link;
                        arr[i*n+j+1].link=ptr;
                        ptr.link=ptr1;
                    }
                    if(j>0)
                    {
                        Node ptr= new Node(count,input );
                        ptr1=arr[i*n+j-1].link;
                        arr[i*n+j-1].link=ptr;
                        ptr.link=ptr1;
                    }
                    if(i>0)
                    {
                        Node ptr= new Node(count,input );
                        ptr1=arr[i*(n-1)+j].link;
                        arr[i*(n-1)+j].link=ptr;
                        ptr.link=ptr1;
                    }
                    if(i<n-1)
                    {
                        Node ptr= new Node(count,input );
                        ptr1=arr[i*(n+1)+j].link;
                        arr[i*(n+1)+j].link=ptr;
                        ptr.link=ptr1;
                    }

                }
            }

            for(int i=0; i< n*m; i++)
            {
                Node ptr=arr[i];
                while(ptr!=null)
                {
                    System.out.println(ptr.val);
                    ptr=ptr.link;
                }
                System.out.println();
            }

            int dist[]= new int[n*m+1];
            for(int i=0; i<= n*m; i++)
            {
                dist[i]=Integer.MAX_VALUE;
            }
            int visited[]= new int[n*m+1];

            for(int i=0; i< n*m; i++)
            {
                visited[arr[i].val]=1;
                Node ptr=arr[i].link;
                while(ptr!=null)
                {
                    if(visited[ptr.val]==0)
                    {

                    }
                }
            }


        }
    }
}

class Node
{
    int weigth;
    int val;
    Node link;
    Node(int v, int w)
    {
        this.weigth=w;
        this.val=v;
    }
}
