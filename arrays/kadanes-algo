// Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
//https://practice.geeksforgeeks.org/problems/kadanes-algorithm/0

// IF all nums are -ve, the below is the perfect soln 

int[] a = {-1, -2, -3 ,-4};

int maxSum = arr[0];
int tempMax = arr[0];

for( i = 1; i < arr.length; i++) {
    tempMax=Math.max(arr[i],tempMax+arr[i]);
    maxSum=Math.max(maxSum,tempMax);
}

System.out.println(maxSum);


// IF atleast one number is positive, then below soln is ok

int[] a = {1, 2, 3, -2, 5};

int maxSum = -1;
int tempMax = 0;

for(int i =0; i < a.length; i++) {
    tempMax += a[i];
    if(tempMax<=0) {
        tempMax=0;
    } else {
        maxSum = Math.max(maxSum, tempMax);
    }
}
