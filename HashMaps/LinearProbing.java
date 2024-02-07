package DataStructures.HashMaps;

import java.util.LinkedList;

public class LinearProbing {
    public class Entry {

        int key;
        String value;

        public Entry() {
        }

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

    }

    Entry[] entries = new Entry[5];

    public void put(int key, String value) {

        int index = hash(key);
        int previous = index - 1;

        while (entries[index] != null) {
            if (index > previous) {
                System.out.println("List full");
                break;
            } else if (index >= entries.length) {
                index = 0;
            }
            index++;
        }

        Entry entry = new Entry(key, value);
        entries[index] = entry;
    }

    public String get(int key) {

        int index = hash(key);
        int previous = index - 1;

        while (entries[index].key != key) {
            if (index > previous) {
                return "Not Found";
            } else if (index >= entries.length) {
                index = 0;
            }
            index++;
        }

        return entries[index].value;

    }

    public void remove(int key) {
        int index = hash(key);
        int previous = index - 1;

        while (entries[index].key != key) {
            if (index > previous) {
                return;
            } else if (index >= entries.length) {
                index = 0;
            }
            index++;
        }

        entries[index] = null;
    }

    private int hash(int key) {
        return key % entries.length;
    }
}
