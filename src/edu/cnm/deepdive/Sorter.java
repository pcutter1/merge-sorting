package edu.cnm.deepdive;

public class Sorter {

  public static void merge(int[] data) {
    merge(data, 0, data.length);
  }

  public static void merge(int[] data, int from, int to) {
    if (to > from + 1) {

      int midpoint = (from + to) / 2;
      merge(data, from, midpoint); // sort left pile.
      merge(data, midpoint, to); //sort right pile.

      int leftIndex = from;
      int rightIndex = midpoint;

      int[] merged = new int[to - from];
      int mergedIndex = 0;

      while (leftIndex < midpoint && rightIndex < to) {

        int leftValue = data[leftIndex];
        int rightValue = data[rightIndex];

        if(leftValue <= rightValue) {
          merged[mergedIndex] = leftValue;
          leftIndex++;
        } else {
          merged[mergedIndex] = rightValue;
          rightIndex++;
        }
        mergedIndex++;
      }

      if (leftIndex < midpoint) {
        System.arraycopy(data, leftIndex, merged, mergedIndex, midpoint - leftIndex);
      } else {
        System.arraycopy(data, rightIndex, merged, mergedIndex, to - rightIndex);
      }

      System.arraycopy(merged, 0, data, from, merged.length);

    }

  }

}
