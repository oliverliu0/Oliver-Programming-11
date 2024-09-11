public class ArrayOperations {

    public static int[] addValue(int[] array, int value) { //Module for adding value into an array.
                                        //passes through the initial array and the value being added into the module
        //Create new array with length increased by 1 because array aren't mutable
        int[] newArray = new int[array.length + 1];

        for (int i = 0; i < array.length; i++) { //For loop to copy all the elements from array to newArray.
            newArray[i] = array[i];
        }
        //Add the indicated value in the parameter into the last index of the newArray
        newArray[newArray.length - 1] = value;
        return newArray;
    }


    public static int[] deleteValue(int[] array) { //module for deleting the last value of an array
        //deleting last value, therefore no need for a value parameter
        if (array.length == 0) { //Special Case where original array length is 0 (can't have a negative array length)
            return array;
        }
        //create new array with length decreased by 1 (last element is ignored)
        int[] new_array = new int[array.length - 1];

        for (int i = 0; i < new_array.length; i++) { //copy all elements from array to new_array,
            new_array[i] = array[i];
        }
        return new_array;

    }


    //module for inserting a value into a specific index in an array
    public static int[] insertValue(int[] array, int value, int index) {
        //need a third parameter to indicate the specific index the value is being added to inside the array

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

        int[] newArray = addValue(array, 4); //testing addValue module
        System.out.print("Array after adding value: ");
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " "); //print the addValue result
        }
        System.out.println();


        int[] new_array = deleteValue(array); //testing deleteValue module
        System.out.print("Array after deleting the last value: ");
        for (int i = 0; i < new_array.length; i++) {
            System.out.print(new_array[i] + " "); //print the deleteValue result
        }
        System.out.println();

        int[] new_Array = insertValue(array, 99, 1); //testing the insertValue module
        System.out.print("Array after inserting value: ");
        for (int i = 0; i < new_Array.length; i++) {
            System.out.print(new_Array[i] + " "); //print the insertValue result
        }
        System.out.println();

    }



}