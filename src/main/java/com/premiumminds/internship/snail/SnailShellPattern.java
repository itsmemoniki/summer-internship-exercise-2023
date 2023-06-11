package com.premiumminds.internship.snail;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by aamado on 05-05-2023.
 */
class SnailShellPattern implements ISnailShellPattern {
   private ExecutorService executor 
      = Executors.newSingleThreadExecutor();

  /**
   * Method to get snailshell pattern
   * 
   * @param matrix matrix of numbers to go through
   * @return order array of values thar represent a snail shell pattern
   */


  public Future<int[]> getSnailShell(int[][] matrix) {
    return executor.submit(() -> {
   
    
    /*top, bottom, left and right variables refers 
    to the four sides of the matrix*/
        
    int n = matrix.length;
    int top = 0;
    int bottom = n-1;
    int left = 0;
    int right = n-1;
    int direction = 0;
    int i;
    int j = 0;
    int[] snail_list = new int[n*n];


    while(top <= bottom && left <= right){

      if(direction == 0){for(i = left; i <= right; i++){snail_list[j] = (matrix[top][i]); j++;
                } top++; direction = 1;}
                
      else if(direction == 1){for(i = top; i <= bottom; i++){snail_list[j] = (matrix[i][right]); j++;
                } right--; direction = 2;}
                
      else if(direction == 2){for(i = right; i >= left; i--){snail_list[j] = (matrix[bottom][i]); j++;
                } bottom--; direction = 3;}
                
      else if(direction == 3){for(i = bottom; i >= top; i--){snail_list[j] = (matrix[i][left]); j++;
                } left++; direction = 0;}
    }


      return snail_list;
      });

  };
}
