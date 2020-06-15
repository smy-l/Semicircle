package practice6_15.club.banyuan.classPractice6_15;

public class Practice {
    public static void main(String[] args) {
        int[] arr1 = new int[0xFFFFFF];
        int[] arr2 = new int[0xFFFFFF];
        long start1 = System.currentTimeMillis();
        System.arraycopy(arr1, 0, arr2, 0, 0xFFFFFF);
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 0xFFFFFF; i++) {
            arr1[i] = arr2[i];
        }
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2);
    }
}
