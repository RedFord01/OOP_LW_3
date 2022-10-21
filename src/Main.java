import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введіть розмір масиву:");
        int n = input.nextInt();
        int[] array = new int[n];
        System.out.println("Введений масив:");
        for (int i = 0; i < n; i++) {
            array[i] = (int) (Math.random()*10);
            System.out.print(array[i] + " ");
        }
        System.out.println("\nНомер максимального елементу: " + getMaxElNum(array));
        System.out.println("Добуток елементів між нулями: " + getProduct(array));
    }
    // Пошук номера максимального елемента масиву
    private static int getMaxElNum (int[] arr) {
        int max = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        return index + 1;
    }
    //Пошук добутку елементів масиву, розташованих між першим і другим нульовими елементами.
    private static int getProduct (int[] arr) {
        int ind1 = -1;
        int ind2 = -1;
        int counter = 0;
        int p = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && ind2 == -1) {
                ind1 = i;
            }
            if(arr[i] == 0) {
                ind2 = i;
                counter++;
            }
            if(counter >= 2) {
                break;
            }
        }
        for (int i = ind1+1; i < ind2 ; i++) {
            p *= arr[i];
        }
        return p;
    }
}