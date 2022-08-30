package youtube;
import java.util.*;


public class ZeroOneKnapsack {

    public static void main(String[] args) {

        int[] wt = new int[]{1, 2, 3, 8, 7, 4};
        int[] val = new int []{20, 5, 10, 40, 15, 25};
        int capacity = 10;
        System.out.println(knapsack(wt,val,capacity,wt.length));

    }

    //recursive solution
    public static int knapsack(int[] wt, int[] val, int capacity , int n) // here n is the current item in array
    {

        //condition to satisfy the smallest input
        if(n == 0 || capacity == 0)
        {
            return 0;
        }

        //my choice diagram
        if(wt[n-1] <= capacity)
        {
                //lelo condition + sum profit
                // , karke mat lo condition
            return Math.max ( val[n-1] + knapsack(wt,val,capacity-wt[n-1],n-1), knapsack(wt,val,capacity,n-1 ));
        }
        else
        {
            //le hi nahi sakte condition
            return knapsack(wt,val,capacity,n-1 );
        }


    }

    //memoized solution
    public static int MemoizedKnapSack(int wt[], int []val, int capacity, int n)
    {
        return 0;
    }


}
