import java.util.*;

class MyHashMap<K, V> {
    private class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 10;
    private Entry<K, V>[] table;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        table = new Entry[SIZE];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    public void put(K key, V value) {
        int index = hash(key);
        Entry<K, V> node = table[index];

        if (node == null) {
            table[index] = new Entry<>(key, value);
        } else {
            while (true) {
                if (node.key.equals(key)) {
                    node.value = value;
                    return;
                }
                if (node.next == null) break;
                node = node.next;
            }
            node.next = new Entry<>(key, value);
        }
    }

    public V get(K key) {
        int index = hash(key);
        Entry<K, V> node = table[index];
        while (node != null) {
            if (node.key.equals(key))
                return node.value;
            node = node.next;
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        Entry<K, V> node = table[index];
        Entry<K, V> prev = null;

        while (node != null) {
            if (node.key.equals(key)) {
                if (prev == null)
                    table[index] = node.next;
                else
                    prev.next = node.next;
                return;
            }
            prev = node;
            node = node.next;
        }
    }
}
