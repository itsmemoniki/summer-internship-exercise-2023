package com.premiumminds.internship.snail;

import static org.junit.Assert.assertArrayEquals;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;



/**
 * Created by aamado on 05-05-2023.
 */
@RunWith(JUnit4.class)
public class SnailShellPatternTest {

  /**
   * The corresponding implementations to test.
   *
   * If you want, you can make others :)
   *
   */


  public SnailShellPatternTest() {
  };

  @Test
  public void ScreenLockinPatternTestFirst3Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3 }, 
                       { 8, 9, 4 }, 
                       { 7, 6, 5 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    assertArrayEquals(result, expected);
  }


  @Test
  public void Test4x4()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2,  3,  4}, 
                       { 5, 6,  7,  8}, 
                       { 9, 10, 11, 12},
                       {13, 14, 15, 16} };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10};
    assertArrayEquals(result, expected);
  }


   @Test
  public void Test1x1()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = {{1}};
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = {1};
    assertArrayEquals(result, expected);
  }

  @Test
  public void Testemptymatrix()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = new int[0][0];
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = new int[0];
    assertArrayEquals(result, expected);
  }


 @Test
  public void Testsamenumbermatrix()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = {{ 2, 2},
                      { 2, 2}};
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = {2, 2, 2, 2};
    assertArrayEquals(result, expected);
  }

 @Test
  public void Testnegativenumbermatrix()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { -1, -2, -3 }, 
                       { -8, -9, -4 }, 
                       { -7, -6, -5 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { -1, -2, -3, -4, -5, -6, -7, -8, -9 };
    assertArrayEquals(result, expected);
  }


 @Test
  public void Testzeroaselement()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 0, 1}, 
                       { 1, 0}};
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 0, 1, 0, 1};
    assertArrayEquals(result, expected);
  }

}