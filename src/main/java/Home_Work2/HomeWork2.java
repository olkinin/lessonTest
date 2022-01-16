package main.java.Home_Work2;


public class HomeWork2 {
    public static void main(String[] args) {
        String arr[][] = new String[][]{
                {"5", "6", "1", "4"},
                {"3", "2", "1", "5"},
             //   {"1", "5", "3", "3"},
                {"4", "n", "1", "1"}

        };

        arrayCheck(arr);

    }

    public static void arrayCheck(String[][] arr) {

        try {
            int n = 0;
            int k = 0;
            for (int i = 0; i < arr.length; i++)
                for (int j = 0; j < arr.length; j++) {
                    n = i + 1;
                    k = j + 1;
                }
            if (n != 4 && k != 4) {
                throw new MyArraySizeException("Массив неподходящей длинны");
            }else{newArray(arr);}
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }
    }

    public static void newArray(String[][]arr){

        try {Integer[][] arrInt = new Integer[4][4];
            int sum = 0;
            for (int i = 0; i < arr.length; i++)
                 for (int j = 0; j < arr.length; j++) {

                    arrInt[i][j] = Integer.parseInt(arr[i][j]);
                    sum = sum + arrInt[i][j];
                }System.out.println("Сумма = " +sum);
        } catch (
                NumberFormatException e) { throw new MyArrayDataException("Недопустимый символ");
        }
    }
}


