package HomeWork5;

import java.util.Arrays;

public class HomeWork {
    static final int size = 10000000;
    static final int half = size / 2;
    static float[] arr = new float[size];

    public static void main(String[] args) {

        arrNumber();
        arrBreak();

    }

    public static void arrNumber() {

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float)
                    (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                            Math.cos(0.4f + i / 2));
        }
        long b = System.currentTimeMillis();

        System.out.println(b - a);
    }


    public static void arrBreak() {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long start = System.currentTimeMillis();
        float[] arrLeft = new float[half];
        float[] arrRight = new float[half];
        System.arraycopy(arr, 0, arrLeft, 0, half);
        System.arraycopy(arr, half, arrRight, 0, half);
        long c = System.currentTimeMillis();
        Thread thread1 = new Thread(() -> {

            for (int i = 0; i < arrLeft.length; i++) {
                arrLeft[i] = (float) (arrLeft[i] * Math.sin(0.2f + i / 5) *
                        Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread thread2 = new Thread(() -> {
            {
                for (int i = 0; i < arrRight.length; i++) {
                    arrRight[i] = (float) (arrRight[i] * Math.sin(0.2f + (half + i) / 5) *
                            Math.cos(0.2f + (half + i) / 5) * Math.cos(0.4f + (half + i) / 2));
                }
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long x = System.currentTimeMillis();
        float[] newArr = new float[size];
        System.arraycopy(arrLeft, 0, newArr, 0, half);
        System.arraycopy(arrRight, 0, newArr, half, half);
        long n = System.currentTimeMillis();
        System.out.println(n - start);

    }
}

