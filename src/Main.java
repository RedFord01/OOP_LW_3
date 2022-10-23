import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введіть розмір одномірного масиву:");
        int sz = input.nextInt();
        int[] array = new int[sz];

        System.out.println("Введений масив:");
        for (int i = 0; i < sz; i++) {
            array[i] = (int) (Math.random()*10);
            System.out.print(array[i] + " ");
        }

        System.out.println("\nВведіть кількість рядків матриці:");
        int m = input.nextInt();
        System.out.println("Введіть кількість стовпців матриці:");
        int n = input.nextInt();

        int[][] matrix = new int[m][];
        System.out.println("Введена матриця:");
        for (int i = 0; i < m; i++) {
            matrix[i] = new int[n];
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) (Math.random()*20 - 11);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }

        System.out.println("\nНомер максимального елементу: " + getMaxElNum(array));
        System.out.println("Добуток елементів між нулями: " + getProduct(array));
        System.out.println("Сума елементів: " + getSum(matrix, m, n));
        getStrNum(matrix, m, n);
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
            if(counter == 2) {
                break;
            }
        }
        for (int i = ind1+1; i < ind2 ; i++) {
            p *= arr[i];
        }
        return p;
    }
    //Пошук суми у рядках які містять хоча б один від'ємний елемент
    private static int getSum(int[][] arr, int m, int n) {
        int sum = 0;
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] < 0) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                for (int j = 0; j < n; j++) {
                    sum += arr[i][j];
                }
            }
        }
        return sum;
    }
    // Визначення номерів рядків елементи яких впорядковані за зростанням
    private static void getStrNum (int[][] arr, int m , int n) {
        System.out.println("Номер впорядкованого/-их рядка/-ів: ");
        for (int i = 0; i < m; i++) {
            boolean ordered = true;
            for (int j = 1; j < n && ordered; j++)
                ordered=(arr[i][j - 1] < arr[i][j]);
            if (ordered)
                System.out.print(i + 1 + " "); // оскільки нам треба номер, а не індекс – додаємо 1
        }
    }
}