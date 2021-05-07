import java.util.Scanner;

//Jump Search Comparisons
public class Search {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        int step = (int) Math.sqrt(num);

        for (int i : arr) {
            System.out.print(step(arr, step, i) + " ");
        }

    }

    public static int step(int[] arr, int step, int target){

        int currentRight = 0;
        int prevRight = 0;

        int count = 0;

        if (arr[currentRight] == target) {
            return 1;
        }

        while (currentRight < arr.length - 1) {

            currentRight = Math.min(arr.length - 1, currentRight + step);
            count++;

            if (arr[currentRight] >= target) {
                break;
            }

            prevRight = currentRight;
        }

        return backwardSearch(arr, target, prevRight, currentRight,count);

    }

    public static int backwardSearch(int[] array, int target, int leftExcl, int rightIncl, int count) {
        for (int i = rightIncl; i > leftExcl; i--) {
            count++;
            if (array[i] == target) {
                return count;
            }
        }
        return -1;
    }
}


