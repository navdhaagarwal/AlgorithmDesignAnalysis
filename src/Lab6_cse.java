import java.util.Scanner;

public class Lab6_cse
{
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int test=sc.nextInt();
        for(int t=0; t<test; t++)
        {
            int time=sc.nextInt();
            int n=sc.nextInt();
            int arr[]= new int[n];
            for(int i=0; i<n; i++)
            {
                arr[i]=sc.nextInt();

            }

            int store[]= new int[n];
            int index=0;
            for(int i=0; i<n; i++)
            {
                int flag=0;
//                if(i>0)
//                {
//                    int prev=i-1;
//                    if(arr[prev]==arr[i]) {
//                        store[i] = store[prev];
//                        flag=1;
//                    }
//                }
                if(flag==0)
                {
                    int range = arr[i] + time-1;
                    int count = 0;
                    while (index < n && arr[index] <= range) {
                        index++;
                        count++;
                    }
                    if (i > 0)
                        store[i] = index-i;
                    else
                        store[i] = count;
                    count = 0;
                }
            }

//            for(int i=0; i<n; i++)
//            {
//                System.out.print(store[i]+" ");
//            }
//
//            System.out.println();
            int max=-1;
            int index_max=-1;
            //System.out.println(max+" "+ index_max);

            for(int i=0; i<n; i++)
            {
                if (store[i]>max)
                {
                    max=store[i];
                    index_max=i;
                }
            }

            System.out.println(max+" "+ arr[index_max]+" "+arr[index_max+max-1]);


        }


    }
}
