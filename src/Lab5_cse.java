import java.util.Scanner;

public class Lab5_cse
{
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int squirrels=sc.nextInt();
        int holes=sc.nextInt();
        int t=sc.nextInt();
        int v=sc.nextInt();
        int dist=t*v;
        int arr[][]= new int [squirrels][holes];
        float coord_squi[][]= new float[squirrels][2];
        float coord_holes[][]= new float[holes][2];

        for(int i=0; i<squirrels; i++)
        {
            coord_squi[i][0]=sc.nextInt();
            coord_squi[i][1]=sc.nextInt();
        }

        for(int i=0; i<holes; i++)
        {
            coord_holes[i][0]=sc.nextInt();
            coord_holes[i][1]=sc.nextInt();
        }

        for(int i=0; i<squirrels; i++)
        {
            for(int j=0; j<holes; j++)
            {
                double distance= Math.sqrt(Math.pow((coord_holes[j][0]-coord_squi[i][0]),2)+Math.pow((coord_holes[j][1]-coord_squi[i][1]),2));
                if(distance<=dist)
                {
                    arr[i][j]=1;
                }
            }
        }

        for(int i=0; i<squirrels; i++)
        {
            for(int j=0; j<holes; j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        int count=0;

        int squi_assigned[]= new int[holes];
        for(int i=0; i<holes; i++)
        {
            squi_assigned[i]=-1;
        }

        for(int i=0; i<squirrels; i++)
        {
            int found[]= new int[holes];
            int ans=matching(arr, squi_assigned, holes, i, found);
            if(ans==1)
                count++;
        }

        System.out.println(count);

    }

    static int matching(int arr[][], int squi_assigned[], int holes, int current, int found[])
    {
        int flag=0;
        for(int i=0; i<holes; i++)
        {
            flag=0;
            if(arr[current][i]==1 && squi_assigned[i]==-1 && found[i]==0)
            {
                squi_assigned[i]=current;
                found[i]=1;
                flag=1;
                break;
            }
            else if(arr[current][i]==1 && squi_assigned[i]!=-1 && found[i]==0)
            {
                int already_assi=squi_assigned[i];
                found[i]=1;
                int ans=matching(arr, squi_assigned, holes, already_assi, found);
                if(ans==1)
                {
                    squi_assigned[i]=current;
                    flag=1;
                    break;
                }
            }


        }
        return flag;
    }
}


// help was taken from https://www.geeksforgeeks.org/maximum-bipartite-matching/
// in order to apply the bipartite matching algorithm.