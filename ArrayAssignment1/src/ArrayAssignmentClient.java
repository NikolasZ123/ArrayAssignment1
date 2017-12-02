
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zbaraszewski-n
 */
public class ArrayAssignmentClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        //constants
        int LENGTH = 1000;

        //variables
        int[] array = new int[LENGTH];
        int [] frequency = new int[100];
        
        int counter = 0;
        int counterTwo = 0;
        int counterThree = 0;
        int arrayLength;
        
        int range1 = 0;
        int range2 = 0;
        int rangeDifference = 0;
        int rangeSum = 0;
        
        String frequencyList = "";
        
        String input;
        String line;
        
        String[] tokens;
        String delimiter = "[ ]";
        
        BufferedReader fin = null;
        
        try{
        fin = new BufferedReader(new FileReader("numbers.txt"));
        }
        catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"file not found");
        }
        
        
        
        
        
        //******* GENERATING RANDOM NUMBERS*******
        ArrayAssignment.generateArray();
        
        line = fin.readLine();
        
            while (line != null) {
                
                array[counter] = Integer.parseInt(line);
                counter++;
                
                line=fin.readLine();  
                
            }
            
        arrayLength = counter;
        
        
        
        
        
        //******* FINDING FREQUENCY OF EACH NUMBER AND LOADING IT INTO ARRAY  
            
        //for each possible value (1-100)
        for (int i=0; i<100; i++) {
            
            //starts at 1 cuase lowest value is 1
            counterTwo++;
             
            //for each number in the array (there a 1000 numbers) / basically we are checking every value in array[]
            for (int p=0; p<arrayLength; p++) {
               
                //if that number is equal to counterTwo (counterTwo goes from 1-100)
                if(array[p] == (counterTwo)) {
                
                    //frequency [0] tracks 1 [1] tracks [2]
                    //if it is equal increase frequency by 1
                    frequency[i]++;
                
                }//end of array p = counter
            
            }//end of p<1000
        }//end of it all <:o
      
        
        
        
        
        //******* FINDING FREQUENCY OF A SINGLE NUMBER*******    
          
        
        //getting initial input
        input = JOptionPane.showInputDialog(null, "Enter a number you would like to see the frequency of.\nEnter -1 to leave");
          
        
        while (input != null && Integer.parseInt(input)!= -1) {
                
            if (Integer.parseInt(input)>=(1) && Integer.parseInt(input)<=(100)){ //Making sure user entered a valid number
                    JOptionPane.showMessageDialog(null, "The number " +input +" appears " +frequency[(Integer.parseInt(input)-1)] +" times");
            } else {
                    JOptionPane.showMessageDialog(null, "That number can't be generated, so it appears 0 times");    
            }//end of if
            
        input = JOptionPane.showInputDialog(null, "Enter a number you would like to see the frequency of.\nEnter -1 to leave");
                
        }//end of while
          
        
        
        
        
        //******* FINDING COMBINED FREQUENCY OF A RANGE OF NUMBERS   
            
        
        //getting initial input
        input = JOptionPane.showInputDialog(null, "Enter two numbers and find the frequency of all numbers between them and including them.\nEnter -1 to leave.");
            
            
        //splitting so we can check if -1
        tokens = input.split(delimiter);
            
            
        //while it isnt 01
        while (Integer.parseInt(tokens[0]) != -1){
                
            //reset our sum
            rangeSum = 0;
                
            //split and calculate everything
            tokens = input.split(delimiter);
            range1 = Integer.parseInt(tokens[0]);           
            range2 = Integer.parseInt(tokens[1]);
            rangeDifference = (range2-range1)+1;
                
                //checking to see if their numbers were in bounds
                if( (range1 >= 1) && (range1 <= 100) && (range2>= 1) && (range2 <=100) ){

                    //rangedifference tells us how many array indexes we will check
                    //range1-1 tells us which frequency[] we need to check first, then we increment it by i, until we reach range difference
                    for (int i=0; i<rangeDifference; i++){
                
                        rangeSum += frequency[(range1-1)+i];
                
                    }
                    
                       //printing the value of rangeSum after the calculation has finished
                        JOptionPane.showMessageDialog(null, "The numbers " +range1 +" to " +range2 +" appear " +rangeSum +" times");
                    
                } else {
                    JOptionPane.showMessageDialog(null,"One of your ranges was out of bounds");
                }    
                  
            //getting new input
            input = JOptionPane.showInputDialog(null, "Enter two numbers and find the frequency of all numbers between them and including them.\nEnter -1 to leave.");
            
            //splitting it so we can check if it -1
            tokens = input.split(delimiter);
            
        }//end of entire while

        
        
        
        
        //******* FINDING RANGE OF FREQUENCIES*******
        
        
        //getting initial input
        input = JOptionPane.showInputDialog(null, "Enter which frequency you want to see\nEnter -1 to leave.");

        
        while ((Integer.parseInt(input)) != -1) {
            
            //reseting frequencyList and counterThree
            frequencyList = "";
            counterThree = 0;
        
            for (int i=0; i<100; i++){
            
                
            
                if((frequency[i]) == (Integer.parseInt(input))){
                
                    counterThree++;
                    frequencyList +=(i) +", ";
            
                }
        
            }
           
        //if no numbers appear x times, then an alternate message will be displayed
        if (counterThree !=0){
            JOptionPane.showMessageDialog(null, "The numbers: \n" +frequencyList +"\nappear " +input +" times.");
        } else {
            JOptionPane.showMessageDialog(null, "No numbers appear " +input +" times.");
        }
 
        input = JOptionPane.showInputDialog(null, "Enter which frequency you want to see\nEnter -1 to leave.");
        
        }
        
        
        
        
        
            System.out.println("End of Processing");
            
    }
    
}


