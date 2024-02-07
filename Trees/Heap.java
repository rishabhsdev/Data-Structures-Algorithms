package Trees;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> items = new ArrayList<>();

    public void insert(int value) {
        items.add(value);
        int index = items.size() - 1;

        // int parentIndex = (index - 1) / 2;

        while (index > 0 && items.get(index) > items.get(findParent(index))) {
            swap(index, findParent(index));
            index = findParent(index);
            // index = (index - 1) / 2;
            // parentIndex = (index - 1) / 2;
        }

    }

    public void remove() {
        int maxLimit = ((items.size() - 1) / 2) - 1;
        items.set(0, items.get(items.size() - 1));

        items.remove(items.size() - 1);

        int index = 0;

        while ((index < maxLimit) && (items.get(index) < items.get(findLeftChild(index))
                || items.get(index) < items.get(findRightChild(index)))) {

            index = swap(index);
        }

        System.out.println(items);

        // 0 - 1, 2 || 1 - 3, 4 || 3 - 7, 8
    }

    private int findParent(int index) {
        return (index - 1) / 2;
    }

    private int findLeftChild(int index) {
        System.out.println("left runs");
        return index * 2 + 1;
    }

    private int findRightChild(int index) {
        System.out.println("right runs");
        return index * 2 + 2;
    }

    private int swap(int index) {
        if (items.get(findLeftChild(index)) < items.get(findRightChild(index))) {
            swap(index, findRightChild(index));

            return findRightChild(index);
        } else {
            swap(index, findLeftChild(index));
            return findLeftChild(index);
        }
    }

    private void swap(int index, int parentIndex) {
        int temp = items.get(index);
        items.set(index, items.get(parentIndex));
        items.set(parentIndex, temp);
    }
}
