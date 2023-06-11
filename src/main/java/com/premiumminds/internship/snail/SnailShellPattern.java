package com.premiumminds.internship.snail;

import java.util.ArrayList;
import java.util.List;
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
   
        
    int n = matrix.length;
    int C = 0;
    int B = n-1;
    int E = 0;
    int D = n-1;
    int dir = 0;
    int i;
    int j = 0;
    int[] snail_list = new int[n*n];

    while(C <= B && E <= D){

      if(dir == 0){for(i = E; i <= D; i++){snail_list[j] = (matrix[C][i]); j++;
                } C++; dir = 1;}
                
      else if(dir == 1){for(i = C; i <= B; i++){snail_list[j] = (matrix[i][D]); j++;
                }D--; dir = 2;}
                
      else if(dir == 2){for(i = D; i >= E; i--){snail_list[j] = (matrix[B][i]); j++;
                }B--; dir = 3;}
                
      else if(dir == 3){for(i = B; i >= C; i--){snail_list[j] = (matrix[i][E]); j++;
                }E++; dir = 0;}
    }
        
        
      return snail_list;
      });

  };
}
