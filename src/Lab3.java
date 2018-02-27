import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lab3
{
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int test=sc.nextInt();
        for(int t=0; t<test; t++)
        {
            int n=sc.nextInt();
            int tenant[][]= new int[n][n];
            int landlord[][]= new int [n][n];

            for(int i=0; i<n; i++) {
                int a=sc.nextInt();
                for (int j = 0; j < n; j++)
                    tenant[i][j] = sc.nextInt()-1;
            }

            for(int i=0; i<n; i++) {
                int a=sc.nextInt();
                for (int j = 0; j < n; j++)
                    landlord[i][j] = sc.nextInt()-1;
            }

            boolean tenant_matched[]= new boolean[n];
            boolean landlord_matched[]=new boolean[n];
            int partner_of_landlord[]= new int[n];
            int partner_of_tenant[]=new int[n];

            for(int i=0; i<n; i++)
            {
                partner_of_landlord[i]=-1;
                partner_of_tenant[i]=-1;
            }

            Queue<Integer> queue= new LinkedList<>();
            for(int i=0; i<n; i++)
                queue.add(i);

            while(!queue.isEmpty())
            {
                int i=queue.poll();
                for(int j=0; j<n; j++)
                {
                    if(tenant_matched[landlord[i][j]]==false)
                    {
                        partner_of_landlord[i]=landlord[i][j];
                        partner_of_tenant[landlord[i][j]]=i;
                        tenant_matched[landlord[i][j]]=true;
                        landlord_matched[i]=true;
                        break;
                    }
                    else
                    {
                        int current_tenant=landlord[i][j];
                        int current_partner_of_tenant=partner_of_tenant[current_tenant];
                        int found=0;
                        for(int k=0; k<n; k++)
                        {
                            //System.out.println(current_tenant);
                            if(tenant[current_tenant][k]==current_partner_of_tenant)
                            {
                                found=0;
                                break;

                            }
                            else if(tenant[current_tenant][k]==i && found==0)
                            {
                                //System.out.println("entered");
                                partner_of_landlord[i]=current_tenant;
                                partner_of_tenant[current_tenant]=i;
                                tenant_matched[current_tenant]=true;
                                landlord_matched[i]=true;
                                queue.add(current_partner_of_tenant);
                                landlord_matched[current_partner_of_tenant]=false;
                                partner_of_landlord[current_partner_of_tenant]=-1;
                                found=1;
                                break;
                            }

                        }
                        if(found==1)
                            break;
                    }
                }
                for(int y=0; y<n; y++)
                {
                    System.out.println((y)+" "+(partner_of_landlord[y]));
                }
                System.out.println();
            }
            for(int i=0; i<n; i++)
            {
                System.out.println((i+1)+" "+(partner_of_landlord[i]+1));
            }

        }
    }
}
