/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfs;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author HAQUE
 */
public class BFS {
    
    static Queue q = new LinkedList();
    
    static int [][]admat = new int[100][100];
    static int [] visit = new int[100];
    static int [] par = new int[100];
    static int [] cost = new int[100];
    BFS()
    {
        int i,j;
        for(i=0;i<100;i++)
        {
            for(j=0;j<100;j++)
            {
                admat[i][j]=0;
            }
            visit[i]=0;
            par[i]=-1;
            cost[i]=0;
        }
        
    }
    
    public static void prntpath(int ds,int src)
    {
        
        if(ds==src)
        {
            System.out.print(""+src);
            return;
            
        }
        else if(par[ds]==-1)
        {
            System.out.println("NO PATH");
        }
        
        else{
            
            prntpath(par[ds],0);
            
            System.out.print(" --> "+ds);
            
        }
    }
    
    
    

  

    public static void main(String[] args) {
        
        Scanner sc =new Scanner(System.in);
        
        int nod,edg,a,b,strt=0,dst,i,j;
        
        nod = sc.nextInt();
        edg = sc.nextInt();
        
        for(i=0;i<edg;i++)
        {
            a=sc.nextInt();
            b= sc.nextInt();
            admat[a][b]=1;
            admat[b][a]=1;
            
        }
        bfs(0,nod);
       
        dst = sc.nextInt();
        System.out.println(""+cost[dst]);
        prntpath(dst,0);
        System.out.println("");
        

       
    }
    
    
    public static  void bfs(int src,int nd)
    {
        int u,v,i,j;
        visit[src]=1;
        cost[src]=0;
        par[src]=0;
        q.add(src);
        while(!q.isEmpty())
        {
           u=(int) q.element();
           q.remove();
           for(i=0;i<nd;i++)
           {
               if(admat[u][i]==1 && visit[i]==0)
               {
                   cost[i]=cost[u]+1;
                   visit[i]=1;
                   q.add(i);
                   par[i]=u;
               }
           }
        }
    }
    
}
