package test.java;

/**
 * DO NOT DISTRIBUTE.
 *
 * This code is intended to support the education of students associated with the Tandy School of
 * Computer Science at the University of Tulsa. It is not intended for distribution and should
 * remain within private repositories that belong to Tandy faculty, students, and/or alumni.
 */
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import main.java.RadixSort;
import org.junit.Test;
import test.java.TUGrader.DisplayName;
import test.java.TUGrader.TestGroup;

public class RadixSortTest {

  @Test
  @TestGroup("sort")
  @DisplayName("sort(Integer[], int) should sort an array of 5-digit numbers in-place")
  public void testSortFiveDigitNumbersInPlace() {
    Integer[] arr = new Integer[] {67890, 23456, 90123, 45678, 34567, 89012, 78901, 12345, 56789};
    RadixSort.sort(arr, 5);
    assertThat(
        arr, is(arrayContaining(12345, 23456, 34567, 45678, 56789, 67890, 78901, 89012, 90123)));
  }

  @Test
  @TestGroup("sort")
  @DisplayName("sort(Integer[], int) should sort an array of numbers that have less than 5 digits")
  public void testSortFiveDigitNumbersWithLeadingZeroes() {
    Integer[] arr = new Integer[] {23456, 1234, 45678, 0, 34567, 567, 89, 12345, 56789};
    RadixSort.sort(arr, 5);
    assertThat(arr, is(arrayContaining(0, 89, 567, 1234, 12345, 23456, 34567, 45678, 56789)));
  }
}
