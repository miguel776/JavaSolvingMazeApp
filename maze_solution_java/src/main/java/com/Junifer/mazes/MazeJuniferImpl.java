package com.Junifer.mazes;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/** 
 *  - This class implement the "MazeJunifer" interface and provide the functionality of Load the file.txt, Solve a maze 
 *    and Formatted the result to show in the console.
 *  
 */


public class MazeJuniferImpl implements MazeJunifer{
	
	private  int rm;
	private  int cm;
	private  int Rstart;
	private  int Cstart;
	private  int Rend;
	private  int Cend;

	
	 /**
     * Load the file.txt
     *
     *  - Load the file.txt
	 *  - Constructs an array with the contents of the maze (String[][] maze)
     *  - Gets the number of rows(fm) and columns(cm)
     *  - Gets the location of the start (x,y) --> (Cstart, Rstart). 
     *  - Gets the location of the end   (x,y) --> (Cend, Rend).  
     *
     * @param  String file - Location of the file containing the input data.
     * @return A matrix "maze" that content the maze without solving.
     */
	public  String[][] loadDataFile(String file) {
		
		String[][] maze = null;
        String cadena;
        String delimiters= " ";
        
		try {
			 
			 //Load the file.txt
			 InputStream inputStream = this.getClass().getResourceAsStream(file);
	         BufferedReader b = new BufferedReader(new InputStreamReader(inputStream));
	         
	            
	         //Gets the number of rows(fm) and columns(cm)
	         cadena= b.readLine();
	         String[] sizeMaze = cadena.split(delimiters);	            
	         rm = Integer.parseInt(sizeMaze[1]);
	         cm =Integer.parseInt(sizeMaze[0]);	
	            
	         //Gets the location of the start (x,y) --> (Cstart, Fstart).           
	         cadena= b.readLine();
	         String[] init = cadena.split(delimiters);		            
	         Rstart = Integer.parseInt(init[1]); 
	         Cstart = Integer.parseInt(init[0]); 
	            
	         //Gets the location of the end   (x,y) --> (Cend, Fend)	      
	         cadena= b.readLine();
	         String[] end = cadena.split(delimiters);	            
	         Rend = Integer.parseInt(end[1]); 
	         Cend = Integer.parseInt(end[0]); 
	            
	         //Constructs an array with the contents of the maze (String[][] maze)
	         maze = new String[rm][cm];
	          
	         int i=0;
	         while((cadena = b.readLine())!=null) {	            	
	            maze[i]=cadena.split(delimiters);
	            	i++;	            	
	         }

	         b.close();
	            
	      } catch (Exception e) {
	            e.printStackTrace();
	      }
		return maze;
	}
	
	 /**
     * Solve the maze
     *
     *  - The implemented algorithm traverses the paths of the labyrinth, marks with an "X" its route, 
     *    when it makes mistakes it goes backwards and marks with "w" the wrong way to not happen again.
     *  - The algorithm is able to get to the end if there is a solution, otherwise, it will  indicated that there isn´t.
     *  - if there is a solution, the registre of maze[Rend][Cend]="E".
     *  - if there isn´t a solution, the registre of maze[Rend][Cend]="N".
     *  - According the data input maze[Rend][Cend] have to be the location of the end .
     *  
     * @param  A matrix "maze" that content the maze without solving.
     * @return A matrix "maze" that content the maze solves.
     */
	public  String[][] solvemazes(String[][] maze) {
		
		int i,j;
		
        i=Rstart;
        j=Cstart;
        while(true) {
         	
         	String wayEast  = maze[i][j+1];        	  
         	String waySouth = maze[i+1][j];	            
         	String wayWest  = maze[i][j-1];            	
         	String wayNorth = maze[i-1][j];
         	
         	if(i==Rend&&j==Cend){
	            	System.out.print("\n\n OUTPUT:");
	            	maze[Rstart][Cstart]="S";
	            	maze[i][j]="E";
	            	break;
         	}
         	if(wayEast.equals("0")){
         			maze[i][j]="X";
	            	j++;
	            		
         	}else if(waySouth.equals("0")){
	            	maze[i][j]="X";
	            	i++;
	            
	        }else if(wayWest.equals("0")){
	            	maze[i][j]="X";
	            	j--;
	           
	        }else if(wayNorth.equals("0")){
	            	maze[i][j]="X";
	            	i--;		  
	           
	        }else if(wayEast.equals("X")){
	            	maze[i][j]="W";
	            	j++;
	            
	        }else if(waySouth.equals("X")){
	            	maze[i][j]="W";
	            	i++;
	            
	        }else if(wayWest.equals("X")){
	            	maze[i][j]="W";
	            	j--;
	            
	        }else if(wayNorth.equals("X")){
	            	maze[i][j]="W";
	            	i--;		  
	        }else{
	            	System.out.print("\n\n THERE IS NOT A SOLUTION");
	            	maze[Rstart][Cstart]="S";
	            	maze[Rend][Cend]="N";
	            	break;
	       }		           		           
        }
        return maze;		
	}
	
	 /**
     * Formatted to show in the console
     *
     *  - the maze with a path from start to end walls marked by '#', passages marked by ' ', 
     *    path marked by 'X', start/end marked by 'S'/'E' 
     *    
     * @param   A matrix "maze" that content the maze solves.
     * @return  A matrix "mazeFormats" that content the maze solves and Formatted. 
     */
	public  String[][] formatOUT(String[][] maze) {
		
		String[][] mazeFormats = new String[rm][cm];
		
		for (int i = 0; i < rm; i++) {
			for (int j = 0; j < cm; j++) {
				
				if(maze[i][j].equals("1")){
					mazeFormats[i][j]="#";         	
	            		
				}else if(maze[i][j].equals("0")||maze[i][j].equals("W")){
					mazeFormats[i][j]=" ";

				}else{
					mazeFormats[i][j]=maze[i][j];
	            	
	            }				
			}
		}
		return mazeFormats;
		
	}
	
	 /**
     * Show the maze in console.
     *
     *  - Scroll through the array and display the result in the console
     *
     * @param A matrix "mazeFormats" that content the maze solves and Formatted. 
     */
	public  void showMaze(String[][] maze) {
		
		for (int i = 0; i < rm; i++) {
			System.out.println();
			for (int j = 0; j < cm; j++) {
				System.out.print(" " + maze[i][j] + " ");
			}
		}
	}
}