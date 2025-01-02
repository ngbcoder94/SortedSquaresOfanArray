/*
 * This is my class for the Leetcode problem Squares of sorted arra. 
 *
 * Author: Nick Burkett
 * Date: 12/30/24
 *
 * Status - SOLVED
 */
public class SortedSquaresOfAnArray{

        /*
         * Here is my function that I will create to solve the problem.
         * @param int[] nums - Array passed in that I will need to manipulate. 
         * @return int[] - Return the sorted array of squares.
         */
        public int[] squareAndSort(int[] nums){
                
                int x;                          //Create variable x to hold the value of nums[i].

                //For-loop to iterate over the array given. 
                for(int i = 0; i < nums.length; i++){
                         
                        x = nums[i];    //Grab the value at nums[i].
                        x = (x * x);    //Square the value of nums[i].

                        //Need to check if i is zero.
                        if(i == 0){
                                nums[i] = x;       //If we are at the first one, there is nothing to sort.
                        }
                        else{
                                /*Here is where the action is*/
                                int helper = i;          //Variable to save the current value of i. 
                                boolean boolVar = true;     //Bool var for while-loop below.
                                
                                //While-loop to sort.
                                while(boolVar){
                                        
                                        int tmpVar0 = 0;        //Initialize a tmp variable. 

                                        //First, I need to check if the current is less than the # in front of it AND the # in front is the first in the array.
                                        if(x < nums[i-1] && ((i-1) == 0)){

                                                //Need to flip between the current loc and the one in front of it.
                                                tmpVar0 = nums[i-1];       //Save the value in the location in front of the current (or to the left). 
                                                nums[i-1] = x;             //Update the new value of nums[i-1]. 
                                                nums[i] = tmpVar0;         //Update the new value of nums[i]. 
                                                
                                                boolVar = false;           //Update boolVar to false to kill the while-loop.
                                                i = helper;                //Update the value of i to the original (if altered).
                                        }
                                        else if(x < nums[i-1]){
                                                
                                                //Need to flip the current with the previous one. 
                                                tmpVar0 = nums[i-1];       //Save the value in the location to the left of the current. 
                                                nums[i-1] = x;             //Update the current value of nums[i-1]. 
                                                nums[i] = tmpVar0;         //Update the current value of nums[i]. 

                                                i -= 1;                    //Decrement i to check if I need to keep swaping further (current # might be small).
                                        }
                                        else{
                                                //Need to check if we are at the last index of the array. 
                                                if(helper == (nums.length - 1) && (i == (nums.length-1))){
                                                        
                                                        //If so, then I need to update the last value of the array correctly.
                                                        nums[helper] = x;   //Update nums[helper] correctly. 
                                                }
                                                else if(x >= nums[i-1]){
                                                        nums[i] = x;
                                                }

                                                i = helper;         //Update i to the correct value if changed.
                                                boolVar = false;    //Update boolVar to terminate the while-loop.
                                        }
                                }
                        }
                
                }
                
                /*
                int varX = nums.length;     //Save the length of nums for below.

                System.out.printf("[");
                for(int counter = 0; counter < nums.length; counter++){

                        //Check if i is the last one or not
                        if(counter != (varX-1)){
                                System.out.printf("%d, ", nums[counter]);      //Print out the array.
                        }
                        else{
                                System.out.printf("%d", nums[counter]);        //Print out the array.
                        } 
                }
                System.out.println("]");
                */

                for(int tmp = 0; tmp < nums.length; tmp++){
                        System.out.println(nums[tmp]);
                }

                return nums;    //Return the altered array that was passed in.
        }

        /*
         *  Main method for the class... I wll run my testing from here. 
         */
        public static void main(String[] args){
                
                int[] tmpArr = {-2, -1, 0, 1, 2, 3, 4, 5, 6};       //create an array of #s for testing. 
                
                SortedSquaresOfAnArray tmpObj = new SortedSquaresOfAnArray();       //Create an instance of SortedSquaresOfAnArray for testing.

                tmpObj.squareAndSort(tmpArr);
        }
}










