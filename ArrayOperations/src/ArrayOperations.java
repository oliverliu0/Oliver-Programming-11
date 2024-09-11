public class ArrayOperations {

    public static int[] addValue(int[] array, int value) { //module for adding value into an array
        int[] newArray = new int[array.length + 1]; //Create new array with length increased by 1 because array aren't mutable

        for (int i = 0; i < array.length; i++) { //For loop to copy all the elements from array to newArray.
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = value; //Add the indicated value in the parameter into the last index of the newArray
        return newArray;
    }


    public static int[] deleteValue(int[] array) { //module for deleting the last value of an array
        if (array.length == 0) { //Special Case where original array length is 0 (can't have a negative array length)
            return array;
        }
        int[] new_array = new int[array.length - 1]; //create new array with length decreased by 1 (last element is ignored)

        for (int i = 0; i < new_array.length; i++) { //copy all elements from array to new_array,
            new_array[i] = array[i];
        }
        return new_array;

    }


    public static int[] insertValue(int[] array, int value, int index) { //module for inserting a value into a specific index in an array

        int[] new_Array = new int[array.length + 1]; //create a new array with a length increased by 1
        for (int i = 0; i < index; i++) { //copy all elements before the indicated index
            new_Array[i] = array[i];

        }
        new_Array[index] = value; //insert the value in the indicated index in the new_Array

        for (int i = index; i < array.length; i++) { //copy the rest of the elements after the indicated index
            new_Array[i+1] = array[i];
        }

        return new_Array;

    }

    public static void main(String[] args) { //test for the module
        int[] array = new int[3]; //create a simple array with length 3, with elements 1, 2, 3
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;

        // Test addValue method
        int[] newArray = addValue(array, 4);
        System.out.print("Array after adding value: ");
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " "); //print the addValue result
        }
        System.out.println();

        //testing deleteValue method
        int[] new_array = deleteValue(array);
        System.out.print("Array after deleting the last value: ");
        for (int i = 0; i < new_array.length; i++) {
            System.out.print(new_array[i] + " "); //print the deleteValue result
        }
        System.out.println();

        //testing the insertValue method
        int[] new_Array = insertValue(array, 99, 1);
        System.out.print("Array after inserting value: ");
        for (int i = 0; i < new_Array.length; i++) {
            System.out.print(new_Array[i] + " "); //print the insertValue result
        }
        System.out.println();

    }



}

