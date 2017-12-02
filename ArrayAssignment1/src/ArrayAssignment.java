
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
public class ArrayAssignment {
    
    //constants
    public static int LENGTH = 1000;
    
    //variables
    
    
    //things
    public static void generateArray() throws IOException{
        
        PrintWriter fout = null;
        try {
            fout = new PrintWriter(new BufferedWriter(new FileWriter("numbers.txt")));
        } catch (FileNotFoundException e){
            System.out.println("file not found");
        }
        
        for (int i=0; i<LENGTH; i++) {
            fout.println((int)(Math.random() * 100 + 1));
        }
        
        
        fout.close();
    }
    

    
    
    
    
    
    
    
    
    
    
}
