package com.Junifer.mazes.tests;

import org.junit.Test;
import com.Junifer.mazes.MazeApp;
import static org.junit.Assert.assertEquals;


public class MazeJuniferImplTest {

    public MazeApp mazeApp; 


    //......................................................................
    //Check the result of the maze content in the file example.txt
    //......................................................................

    /**
     * - The correct functionality is checked according value of (x,y) location of the end
     * - It must be equal maze[8][8]="E", it will  indicated that there is a solution
     * 
     */
    @Test
    public void testAppSolvingMaze_example() throws Exception {
    	
    	mazeApp = new MazeApp();
 		mazeApp.appSolvingMaze("/example.txt");
 		assertEquals(mazeApp.maze[8][8], "E");
		
     }

    //......................................................................
    //Check the result of the maze content in the file small.txt
    //......................................................................

    /**
     * - The correct functionality is checked according value of (x,y) location of the end
     * - It must be equal maze[4][3]="E", it will  indicated that there is a solution
     * 
     */
    @Test
    public void testAppSolvingMaze_small() throws Exception {
    	
    	mazeApp = new MazeApp();
    	mazeApp.appSolvingMaze("/small.txt");
    	assertEquals(mazeApp.maze[4][3], "E");
    }

    //......................................................................
    //Check the result of the maze content in the file small_noWayOut.txt
    //......................................................................

    /**
     * - The correct functionality is checked according value of (x,y) location of the end
     * - It must be equal maze[4][3]="N", it will  indicated that there isn´t a solution
     * 
     */

    @Test
    public void testAppSolvingMaze_imput3() throws Exception {
    	
    	mazeApp = new MazeApp();
    	mazeApp.appSolvingMaze("/small_noWayOut.txt");
    	assertEquals(mazeApp.maze[4][3], "N");

       }

    //......................................................................
    //Check the result of the maze content in the file sparse_medium.txt
    //......................................................................

    /**
     * - The correct functionality is checked according value of (x,y) location of the end
     * - It must be equal maze[19][19]="E", it will  indicated that there is a solution.
     *       
     */
    @Test
    public void testAppSolvingMaze_sparse_medium() throws Exception {
    	
    	mazeApp = new MazeApp();
    	mazeApp.appSolvingMaze("/sparse_medium.txt");
    	assertEquals(mazeApp.maze[19][19], "E");
    	
    }

    //......................................................................
    //Check the result of the maze content in the file medium_input.txt
    //......................................................................

    /**
     * - The correct functionality is checked according value of (x,y) location of the end
     * - It must be equal maze[19][21]="E", it will  indicated that there is a solution
     *    
     */

    @Test
    public void testAppSolvingMaze_medium_input() throws Exception {
    	
    	mazeApp = new MazeApp();
    	mazeApp.appSolvingMaze("/medium_input.txt");
    	assertEquals(mazeApp.maze[19][21], "E");
       
    }

    //......................................................................
    //Check the result of the maze content in the file input.txt
    //......................................................................

    /**
     * - The correct functionality is checked according value of (x,y) location of the end
     * - It must be equal maze[3][3]="E", it will  indicated that there is a solution
     *      
     */

    @Test
    public void testAppSolvingMaze_input() throws Exception {
    	
    	mazeApp = new MazeApp();
    	mazeApp.appSolvingMaze("/input.txt");
    	assertEquals(mazeApp.maze[3][3], "E");
      
    }
    
    //......................................................................
    //Check the result of the maze content in the file large_input.txt 
    //......................................................................

    /**
     * - The correct functionality is checked according value of (x,y) location of the end
     * - It must be equal maze[99][159]="E", it will  indicated that there is a solution
     * 
     */

    @Test
    public void testAppSolvingMaze_large_input() throws Exception {
    	
    	mazeApp = new MazeApp();
    	mazeApp.appSolvingMaze("/large_input.txt");
    	assertEquals(mazeApp.maze[99][159], "E");
      
    }
    
    
}
