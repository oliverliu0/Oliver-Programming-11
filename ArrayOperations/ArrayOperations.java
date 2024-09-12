import java.util.Scanner;
public class ArrayOperations {

    public static int[] addValue(int[] array, int value) { //Module for adding value into an array.
        //passes through the initial array and the value being added into the module
        int[] newArray = new int[array.length + 1]; //Create new array with length increased by 1 because array aren't mutable
    
        for (int i = 0; i < array.length; i++) { //For loop to copy all the elements from array to newArray.
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = value; //Add the indicated value in the parameter into the last index of the newArray
        return newArray;
    }
    

    public static int[] deleteValue(int[] array) { //module for deleting the last value of an array
        //deleting last value, therefore no need for a value parameter
        if (array.length == 0) { //Special Case where original array length is 0 (can't have a negative array length)
            return array;
        }
        int[] new_array = new int[array.length - 1]; //create new array with length decreased by 1 (last element is ignored)

        for (int i = 0; i < new_array.length; i++) { //copy all elements from array to new_array.
            new_array[i] = array[i];
        }
        return new_array;

        }
        
        
    public static int[] insertValue(int[] array, int value, int index) { //module for inserting a value into a specific index in an array
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {2, 3, 5}; // Example array
        boolean quit = false;

        while (!quit) { //if user types quit, the system will end
            System.out.println("\nChoose an option:"); //ask user which module to use
            System.out.println("1. Add a value to the end");
            System.out.println("2. Delete the last value");
            System.out.println("3. Insert a value at a specific position");
            System.out.println("4. Print the current array");
            System.out.println("5. Quit");

            int choice = scanner.nextInt(); //user inputs the option number

            if (choice == 1) { //if user select option 1, the system will run addValue module
                System.out.print("Enter value to add: ");
                int addvalue = scanner.nextInt();
                arr = addValue(arr, addvalue);
            } else if (choice == 2) { //if option 2, deleteValue module
                arr = deleteValue(arr);
            } else if (choice == 3) { //if option 3, insertValue module
                System.out.print("Enter index to insert at: "); //ask for specific index to insert into array
                int index = scanner.nextInt();
                System.out.print("Enter value to insert: "); //ask for specific value to insert into array
                int insertValue = scanner.nextInt();
                try {
                    arr = insertValue(arr, insertValue, index);
                } catch (IllegalArgumentException e) { //catching errors such as index out of bounds
                    System.out.println("Invalid index, please try again.");
                }
            } else if (choice == 4){
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i] + " "); //print out the new arrays
                }
                System.out.println();
            } else if (choice == 5) {
                quit = true; //option to quit
            } else {
                System.out.println("Invalid choice, please choose again.");
            }
        }

        System.out.println("Program ended.");
        scanner.close();
    }

    

}
