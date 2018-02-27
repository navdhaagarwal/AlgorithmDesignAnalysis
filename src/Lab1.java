/**
 * Name-Navdha Agarwal
 * Roll no-2016250
 * Using the recursive algorithm, the new encoded string is created.
 * Then, the encoded string is checked for the given conditions. If
 * satisfied print valid else Invalid.
 */

import java.util.Scanner;

public class Lab1
{
    static  int len=0;
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int test= sc.nextInt();
        for(int t=0; t<test; t++)
        {
            String s=sc.next();
            len=s.length();
            String snew="";
            Lab1 obj= new Lab1();
            snew=obj.change(s,snew,len-1);
            //System.out.println(snew);
            int flag=0;

            for(int i=0; i<snew.length(); i++)
            {
                if(i==0 && snew.charAt(i)!='a')
                {
                    flag = 1;
                    break;
                }
                else if(snew.charAt(i)=='a')
                {
                    String ss=snew.substring(i+1);
                   // System.out.println(ss);
                    if(ss.length()>=2)
                    {
                        if(ss.charAt(0)!='a' && !ss.substring(0,2).equals("bb"))
                        {
                            flag=1;

                            //System.out.println(flag+" 11");
                            break;
                        }
                    }
                    else if (ss.length()==1)
                    {
                        if(ss.charAt(0)!='a') {
                            flag = 1;
                            break;
                        }
                    }
                }
                else if(snew.length()-i>=2 && snew.substring(i,i+2).equals("bb"))
                {
                    //System.out.println(i);
                    if(snew.length()-i>2 && snew.charAt(i+2)=='b') {
                        flag = 1;
                        break;
                    }
                    //System.out.println(flag+" 2");
                }

            }
            if(flag==1)
                System.out.println("Invalid");
            else
                System.out.println("Valid");


        }
    }

    public String change(String s, String snew, int l)
    {
        if(l==0)
            return snew;
        else
        {
            char ch1=s.charAt(0);
            char ch2=s.charAt(1);
            s=s.substring(1);
            if(Math.abs((int)ch1-(int)ch2)<=3)
            {
                if(snew.length()==0)
                    snew="aa";
                else
                {
                    if(snew.charAt(snew.length()-1)=='a')
                        snew=snew+"aa";
                    else
                        snew=snew+"bb";
                }
            }
            else if((int)ch1-(int)ch2<0)
            {
                snew=snew+"ab";
            }
            else
                snew=snew+"ba";

            snew=change(s,snew,l-1);
            return snew;

        }
    }

}
