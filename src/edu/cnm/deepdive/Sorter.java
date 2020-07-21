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

  public static void quickSort(int[] data) {
    quickSort(data, 0, data.length);
  }

  public static void quickSort(int[] data, int fromIndex, int toIndex) {
    if (toIndex > fromIndex + 1) {
      int pivot = data[fromIndex];
      int partitionIndex = fromIndex;
      for (int i = fromIndex + 1; i < toIndex ; i++) {
        int current = data[i];
        if(current <= pivot) {
          partitionIndex++;
          if(i > partitionIndex) {
            data[i] = data[partitionIndex];
            data[partitionIndex] = current;
          }
        }
      }
      data[fromIndex] = data[partitionIndex];
      data[partitionIndex] = pivot;
      quickSort(data, fromIndex, partitionIndex);
      quickSort(data, partitionIndex + 1, toIndex);
    }
  }

}
