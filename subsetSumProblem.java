package youtube;

import java.util.Arrays;

public class subsetSumProblem {
    public static void main(String[] args) {
        int arr [] = {1,2,6};
        int sum = 2;

        //we need to give response as YES or NO - if any subset from arr can have sum equals to given sum in question

        System.out.println(SubsetSum(arr,sum, arr.length));
        /*for(int i=0;i<10;i++)
        {
            for(int j=0;j<10;j++)
            {
                t[i][j] = false;
            }

        }
        System.out.println(MemSubsetSum(arr,sum, arr.length));
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<10;j++)
            {
                System.out.print(t[i][j]+" ");
            }
            System.out.println();
        }*/
        System.out.println(TopDownSubsetSum(arr,sum));
    }

    //using recursion
    public static Boolean SubsetSum(int arr[], int sum, int n)
    {
        if(n <= 0)
        {
            return false;
        }
        if(sum <= 0)
        {
            return true;
        }

        if(arr[n-1] <= sum)
        {
            return SubsetSum(arr,sum-arr[n-1],n-1) || SubsetSum(arr,sum,n-1);
        }
        else
        {
            return SubsetSum(arr,sum,n-1);
        }

    }

    static Boolean t[][] = new Boolean[10][10];
    //using memoized solution
    public static Boolean MemSubsetSum(int arr[], int sum, int n)
    {
        if(n <= 0)
        {
            return t[n][sum] = false;
        }
        if(sum <= 0)
        {
            return t[n][sum] = true;
        }

        if(arr[n-1] <= sum)
        {
            return t[n][sum] = MemSubsetSum(arr,sum-arr[n-1],n-1) || MemSubsetSum(arr,sum,n-1);
        }
        else
        {
            return t[n][sum] = MemSubsetSum(arr,sum,n-1);
        }



    }

    //using top down approach
    public static Boolean TopDownSubsetSum(int arr[], int sum)
    {
        Boolean ar[][] = new Boolean[arr.length+1][sum+1]; //i=70, j=6
        for(int i=0;i<ar.length;i++)
        {
            for(int j=0;j<ar[i].length;j++)
            {
                if(j==0)
                {
                    ar[i][j] = false;
                }
                if(i==0)
                {
                    ar[i][j] = true;
                }


            }
        }
        //initialization

        for(int i=1;i<ar.length;i++)
        {
            for(int j=1;j<ar[i].length;j++)
            {
                if(arr[i-1] <= j )
                {
                    ar[i][j] = ar[i-1][j-arr[i-1]] || ar[i-1][j];
                }
                else
                {
                    ar[i][j] = ar[i-1][j];
                }
            }

        }


        for(int i=0;i<ar.length;i++) {
            for (int j = 0; j < ar[i].length; j++) {
                System.out.print(ar[i][j]+" ");
            }
            System.out.println();
        }
        return ar[arr.length][sum];

    }



}
