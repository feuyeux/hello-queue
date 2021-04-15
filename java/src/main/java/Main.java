import median.Solution;

//java -XX:+UseZGC -classpath /Users/erichan/cooding/feuyeux/hello-queue/java/target/classes Main
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("output[4.5]=" + s.findMedianSortedArrays(new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8}));
        System.out.println("output[4.5]=" + s.findMedianSortedArrays(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6, 8}));
        System.out.println("output[3.0]=" + s.findMedianSortedArrays(new int[]{1, 2, 3, 4}, new int[]{4}));
        System.out.println("output[2.5]=" + s.findMedianSortedArrays(new int[]{}, new int[]{1, 2, 3, 4}));
        System.out.println("output[0]=" + s.findMedianSortedArrays(new int[]{0, 0, 0, 0, 0}, new int[]{-1, 0, 0, 0, 0, 0, 1}));
        System.out.println("output[2.5]=" + s.findMedianSortedArrays(new int[]{}, new int[]{2, 3}));
        System.out.println("output[2]=" + s.findMedianSortedArrays(new int[]{}, new int[]{2}));
        System.out.println("output[1]=" + s.findMedianSortedArrays(new int[]{1,1}, new int[]{1,2}));
    }
}
