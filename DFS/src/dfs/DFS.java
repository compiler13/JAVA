/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfs;



import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author HAQUE
 */
public class DFS {
    
     Stack st = new Stack();

    static int [][]met =new int[100][100];
    static int [] vst = new int[100];
    static int []par = new int [100];
    
    DFS()
    {
        int i,j;
        
        for(i=0;i<100;i++)
        {
            vst[i]=0;
            par[i]=-1;
            for(j=0;j<100;j++)
            {
                
                met[i][j]=0;
            }
        }
        
    }
    
    
    public static void pathprnt(int gol,int src)
    {
        
        if(gol==src)
        {
            System.out.print(""+src);
            return;
            
        }
        else if(par[gol]==-1)
        {
            System.out.println("NO PATH");
        }
        
        else{
            
            pathprnt(par[gol],0);
            
            System.out.print(" --> "+gol);
            
        }
        
    }
    public static void main(String[] args) {
       
        
        Scanner in = new Scanner(System.in);
        
        int nod,cn,srt=0,goal,i,j,a,b;
        
        nod = in.nextInt();
        cn = in.nextInt();
        for(i=0;i<cn;i++)
        {
          a= in.nextInt();
          b= in.nextInt();
          met[a][b]=1;
          met[b][a]=1;
        }
        goal = in.nextInt();
        dfs(cn,0);
        pathprnt(goal,0);
        System.out.println("");
    }
    
    
    public static void dfs(int nd, int src)
    {
         int u,i;
         u=src;
         vst[u]=1;
         
         for(i=0;i<nd;i++)
         {
             
             if(met[u][i]==1 && vst[i]!=1)
             {
                 par[i]=u;
                 dfs(nd,i);
                  System.out.println(""+par[i]);
             }
         }
         
        
    }
    
}
