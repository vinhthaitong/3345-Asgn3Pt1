import java.util.*;
import java.io.*;

public class sort{
    public static void main (String[] args){
        try{
            File file = new File("integers.txt");
            Scanner input = new Scanner(file);
            int[] RandomOrder = new int[50000];
            int[] InOrder = new int[50000];
            int[] ReverseOrder = new int[50000];
            while(input.hasNext()){
                for(int i = 0; i < RandomOrder.length; i++){
                    RandomOrder[i] = input.nextInt();
                    InOrder[i] = RandomOrder[i];
                    ReverseOrder[i] = RandomOrder[i];
                }
            }
            input.close();
            inOrderSort(InOrder);
            reverseOrderSort(ReverseOrder);
            for(int i = 0; i < RandomOrder.length; i++){
                System.out.println(RandomOrder[i] + " " + InOrder[i] + " " + ReverseOrder[i]);
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    public static void inOrderSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void reverseOrderSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] < key){
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}