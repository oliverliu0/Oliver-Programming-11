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

        for (int i = 0; i < new_array.length; i++) { //copy all elements from array to new_array, 
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
        int[] array = new int[0]; // Initialize an empty array

        boolean running = true;
        while (running) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add value to array");
            System.out.println("2. Delete last value from array");
            System.out.println("3. Insert value at a specific index");
            System.out.println("4. Display array");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add a value to the array
                    System.out.print("Enter the value to add: ");
                    int valueToAdd = scanner.nextInt();
                    array = addValue(array, valueToAdd);
                    System.out.println("Value added.");
                    break;
                case 2:
                    // Delete the last value from the array
                    array = deleteValue(array);
                    System.out.println("Last value deleted.");
                    break;
                case 3:
                    // Insert a value at a specific index
                    System.out.print("Enter the value to insert: ");
                    int valueToInsert = scanner.nextInt();
                    System.out.print("Enter the index to insert the value at: ");
                    int index = scanner.nextInt();
                    if (index < 0 || index > array.length) {
                        System.out.println("Invalid index.");
                    } else {
                        array = insertValue(array, valueToInsert, index);
                        System.out.println("Value inserted.");
                    }
                    break;
                case 4:
                    // Display the current array
                    System.out.print("Current array: ");
                    for (int i = 0; i < array.length; i++) {
                        System.out.print(array[i] + " ");
                    }
                    System.out.println();
                    break;
                case 5:
                    // Quit the program
                    System.out.println("Exiting the program.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}