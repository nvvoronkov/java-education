package lesson.four.generic;

public class Map<K, V extends Human> {
    private K key;
    private V value;

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

}
