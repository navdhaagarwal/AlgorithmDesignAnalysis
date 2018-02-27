import java.util.Scanner;

public class Lab5
{
    static int graph[][];
    static int rick;
    static int rick_assigned[];
    static int found[];
    static int count=0;
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int students=sc.nextInt();
        rick=sc.nextInt();
        int speed=sc.nextInt();
        int time=sc.nextInt();
        int stud_coor[][]= new int[students][2];
        for(int i=0; i<students; i++)
        {
            stud_coor[i][0]=sc.nextInt();
            stud_coor[i][1]=sc.nextInt();
        }
        int rick_coor[][]= new int[rick][2];
        for(int i=0; i<rick; i++)
        {
            rick_coor[i][0]=sc.nextInt();
            rick_coor[i][1]=sc.nextInt();
        }
        int max_dist=speed*time;

        graph= new int[students][rick];
        for(int i=0; i<students; i++)
        {
            for(int j=0;j<rick; j++)
            {
                double distance= Math.sqrt(Math.pow((rick_coor[j][0]-stud_coor[i][0]),2)+Math.pow((rick_coor[j][1]-stud_coor[i][1]),2));
                if(distance<=max_dist)
                    graph[i][j]=1;
            }
        }

        rick_assigned= new int[rick];
        count=0;
        for(int i=0; i<rick; i++)
            rick_assigned[i]=-1;

        for(int i=0; i<students; i++)
        {
            found= new int[rick];
            if(matching(i)==true)
                count++;
        }

        System.out.println(count);

    }

    public static boolean matching(int current)
    {
        for(int j=0; j<rick; j++)
        {
            if(graph[current][j]==1 && found[j]==0)
            {
                found[j]=1;
                int flag=0;
                int current_student=rick_assigned[j];
                if(current_student==-1)
                    flag=1;
                else
                {
                    if(matching(current_student)==true)
                        flag=1;
                }
                if(flag==1)
                {
                    rick_assigned[j]=current;
                    return true;
                }
                else
                    continue;
            }
        }
        return false;
    }
}

// help was taken from https://www.geeksforgeeks.org/maximum-bipartite-matching/
// in order to apply the bipartite matching algorithm.
