/**
 * Created by user on 6/2/17.
 */
import java.util.*;

public class MySort {
    public static void main(String[] args) {
        // generate array with random size(up to 30) and numbers(from 0 to 100)

        Random rand = new Random();
        int size = rand.nextInt(30);
        ArrayList<Integer> myArray = new ArrayList<Integer>(size);
        for (int j = 0; j<size; j++) {
            int n = rand.nextInt(100);
            myArray.add(n);
        }
        int capacity = myArray.size();
        System.out.println("We generate array with capacity " + capacity + " and it is:" + myArray);


        //create array which will store sorted values
        ArrayList<Integer> SortedArray = new ArrayList<Integer>();
        //SortedArray.ensureCapacity(100); //способ задать емкость


        //sorting array
        for ( int k = capacity; k > 0; k-- ) {
            //searching for min value in our array
            int min = Collections.min(myArray);
            // copy min value to our sorted array
            SortedArray.add(0, min);
            //delete our found min value by index
            int position = myArray.indexOf(min);
            myArray.remove(position);
        }
        //repeat cycle till the checking all values from our array
        //выводим отсортированный массив
       // System.out.println("sorted array is : " + SortedArray.toString());
        String output = "";
        for (int i = 0; i < SortedArray.size(); i++) {
            output += SortedArray.get(i) + " ";
        }

        System.out.println("Sorted array by descent(bigger to smaller) order: " + output);
        //debug System.out.println("next myArray is: " + myArray + ". Его длина стала " + myArray.size());
    }

}
