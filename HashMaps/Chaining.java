package DataStructures.HashMaps;

import java.util.LinkedList;

public class Chaining {

    public class Entry {

        int key;
        String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

    }

    LinkedList<Entry>[] entries = new LinkedList[5];

    public void put(int key, String value) {

        int index = hash(key);

        if (entries[index] == null) {
            entries[index] = new LinkedList<Entry>();
        }

        for (Entry entry : entries[index]) {
            if (entry.key == key) {
                entry.value = value;
            }
        }

        Entry entry = new Entry(key, value);
        entries[index].addLast(entry);
    }

    public String get(int key) {

        int index = hash(key);

        for (Entry entry : entries[index]) {
            if (entry.key == key) {
                return entry.value;
            }
        }

        return "Not Found";
    }

    public void remove(int key) {
        int index = hash(key);

        for (Entry entry : entries[index]) {
            if (entry.key == key) {
                entries[index].remove(entry);
                return;
            }
        }
    }

    private int hash(int key) {
        return key % entries.length;
    }
}
