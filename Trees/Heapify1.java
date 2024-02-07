package Trees;

public class Heapify1 {

    public static void heapify(int[] array) {

        for (int i = 0; i < array.length; i++) {
            heapify(array, i);
        }
    }

    private static void heapify(int[] array, int index) {

        int largerIndex = index;

        int leftChildIndex = index * 2 + 1;

        if (leftChildIndex < array.length && array[leftChildIndex] > array[largerIndex]) {
            largerIndex = leftChildIndex;
        }

        int rightChildIndex = index * 2 + 2;
        if (rightChildIndex < array.length && array[rightChildIndex] > array[largerIndex]) {
            largerIndex = rightChildIndex;
        }

        if (index == largerIndex) {
            return;
        }

        swap(array, index, largerIndex);
    }

    private static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
