import java.util.Scanner;

public class Lab4_cse
{
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int lift=sc.nextInt();
        Node1 arr[]= new Node1[n];
        for(int i=0; i<n; i++)
        {
            Node1 ptr= new Node1(i+1);
            arr[i]=ptr;
        }
        int a,b;
        for(int i=0; i<lift; i++)
        {
            a=sc.nextInt();
            b=sc.nextInt();
            Node1 ptr=arr[a-1].link;
            Node1 newptr=new Node1(b);
            newptr.lift_no=b-a;
            arr[a-1].link=newptr;
            newptr.link=ptr;

            ptr=arr[b-1].link;
            newptr=new Node1(a);
            newptr.lift_no=b-a;
            arr[b-1].link=newptr;
            newptr.link=ptr;

        }

//        for(int i=0; i<n; i++)
//        {
//            Node1 ptr=arr[i].link;
//            System.out.print(i+1+" ");
//            while(ptr!=null) {
//                System.out.print(ptr.val + " ");
//                ptr=ptr.link;
//            }
//            System.out.println();
//        }

        int visited[]= new int[n];
        int time[]= new int[n];


        dfs(1,visited, arr,time,0);

    }
    public static void dfs(int v, int visited[], Node1 arr[],int time[], int count_time)
    {
        System.out.println(count_time);
        visited[v-1]=1;
        Node1 ptr= arr[v-1].link;

        if(v==15) {
            System.out.println(count_time);
            return;
        }
        if(ptr==null) {
            System.out.println("fd");
            return;
        }

        while(ptr!=null)
        {
            int value=ptr.val;
            if(visited[value-1]==0)
            {
                if(v>value)
                {
                    int time_stamp=v-value;
                    if((Math.floor(count_time%time_stamp)%2)==1)
                        count_time=time_stamp*((int)Math.floor(count_time%time_stamp)+2);
                    count_time+=time_stamp;
                }
                else {
                    int time_stamp=value-v;
                    if((Math.floor(count_time%time_stamp)%2)==1)
                        count_time=time_stamp*((int)Math.floor(count_time%time_stamp)+1);
                    count_time+=time_stamp;

                }
                dfs(value, visited,arr, time, count_time);
                //ptr=ptr.link;
            }
            ptr=ptr.link;
        }
    }
}

class Node1
{
    int val;
    int min_time;
    int lift_no;
    Node1 link;
    Node1(int val)
    {
        this.val=val;
        this.min_time=0;
    }

}
