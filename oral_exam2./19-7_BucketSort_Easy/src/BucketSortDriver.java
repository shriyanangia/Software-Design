/**
 * Main driver class that tests BucketSort.java
 *
 * @author snangia
 */
public class BucketSortDriver
{
    public static void main(String[] args)
    {
        /**
         * This method will automatically be called when BucketSortDriver is run.
         *
         * @param args Command line arguments.
         */
        BucketSort bucketSort =  new BucketSort();
        int [] arr = {80, 50, 30, 10, 90, 60, 0, 70, 40, 20, 50};

        bucketSort.sort(arr);

        for (int i: arr)
        {
            System.out.print(i + " ")
;        }
    }
}
