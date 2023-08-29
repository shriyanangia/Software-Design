
import java.util.ArrayList;
import java.util.Collections;

public class BucketSort
{
    public void sort(int[] input)
    {
        /**
         * This method creates an array with each array slot used as a bucket
         * It inserts elements from the array into the bucket, according to range of the bucket
         * elements of each bucket are sorted
         * @param input integer array
         * @return no return value
         */
        int numBuckets = max(input) - min(input) +1;    //number of buckets

        ArrayList<Integer>[] bucket = new ArrayList[numBuckets];    //making an array of buckets

        for (int i=0; i<numBuckets; i++)
        {
            bucket[i] = new ArrayList<>();  //adding an array to each bucket
        }

        //adding elements into the buckets
        for (int i=0; i<numBuckets; i++)
        {
            int bucketIndex = input[i] *numBuckets;
            bucket[bucketIndex].add((input[i]));
        }

        //sorting the elements of each bucket
        for (int i=0; i<numBuckets;i++) {
            Collections.sort(bucket[i]);
        }

        //getting the sorted array
        int index = 0;
        for (int i=0; i<numBuckets;i++)
        {
            int tempsize = bucket[i].size();
            for (int j=0;j<tempsize; j++)
            {
                input[index++] = bucket[i].get(j);
            }
        }

    }

    /**
     * This method calculates the min value of an array
     * @param input integer array
     * @return max int value of input array
     */
    private int max(int[] input)
    {
        int maxNum = input[0];
        for (int value: input)
        {
            if (value>maxNum)
            {
                maxNum = value;
            }
        }
        return maxNum;
    }

    /**
     * This method calculates the min value of an array
     * @param input integer array
     * @return min int value of input array
     */
    private int min(int[] input)
    {
        int minNum = input[0];
        for (int value: input)
        {
            if (value<minNum)
            {
                minNum = value;
            }
        }
        return minNum;
    }



}