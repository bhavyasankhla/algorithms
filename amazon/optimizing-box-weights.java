/**
https://stackoverflow.com/questions/66091385/optimizing-box-weights-algorithmn

A Fullfillment Associate has a set of items that need to be packed into two boxes. Given an integer array of the item weights (arr) to be packed, divide the item weights into two subsets, A and B, for packing into the associated boxes, while respecting the following conditions:

The intersection of A and B is null.
The union A and B is equal to the original array.
The number of elements in subset A is minimal.
The sum of A's weights is greater than the sum of B's weights.
Return the subset A in increasing order where the sum of A's weights is greater than the sum of B's weights. If more than one subset A exists, return the one with the maximal total weight.

Example:

n = 5

arr = [3, 7, 5, 6, 2]

The 2 subsets in arr that satisfy the conditions for A are (5, 7] and [6, 7]:

A is minimal (size 2)
Sum(A) = (5 + 7) = 12 > Sum(B) = (2+ 3+ 6) = 11
Sum(A) = (6 + 7) = 13 > Sum(B) = (2+ 3+ 5) = 10
The intersection of A and B is null and their union is equal to arr.
The subset A where the sum of its weight is maximal is [6, 7].
Function Description :

The minimalHeaviestSetA() function in the editor has the following parameter(s):

int arr[] : an integer array of the weights of each item in the set

Returns: int[]: an Integer array with the values of subset A

/*
* The function accepts INTEGER_ARRAY arr as parameter.
* The function is expected to return an INTEGER_ARRAY.
*/

function minimalHeaviestSetA(arr){
  let subsetA = [];
  
  return subsetA;
}

/**
------- Update ------
I figured out what tripped me up and what made it hard for me to understand what I was suppose to do. 
I now know what A is minimal (size 2) means and what maximal weight means.

Now that I understand it, this is how I coded it.

I sorted the array in descending order
then I pulled the first element from it and made it the first element in subsetA,
I also made it the initial sum for subsetA which I stored in a variable. 
Not that the first element is gone from the sortedArray it then becomes the first version of subsetB.  I summed the values and placed that into a variable

Then I calculated the sum of subsetB.
Next I ran a loop over the sortedArray and for each iteration i checked to see if the sum of subsetB was larger than the sum of subsetA.
if that is true, the current value in the sorted array gets added to subsetA, and I added the current value to the running sum of subsetA and I subtracted the value from the sum of subsetB;
I also broke out of the loop early when the sum of subsetA became larger
than the sum of subsetB

Then i sorted the result of subsetA before returning it from the function


I have a Python-based solution. Simple logic, Tested over all inputs. Code is kind of self-explanatory.

def minimalHeaviestSetA(arr):
    subsetA = []
    total_sum = sum(arr)
    arr.sort(reverse=True)
    Asum = 0
    while True:
        if Asum > total_sum:
            break
        else:
            A = arr.pop(0)
            subsetA.insert(0, A)
            total_sum -= A
            Asum += A
    return subsetA;

print(minimalHeaviestSetA([3, 7, 5, 6, 2]))
**/
