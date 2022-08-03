package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 706. Design HashMap
 * <p>
 * https://leetcode.com/problems/design-hashmap/
 *
 * @author Cheryl Tang
 */
public class Problem706 extends Problem {

  @Override
  public void runTestCases() {
    MyHashMap myHashMap = new MyHashMap();
    myHashMap.put(1, 1); // The map is now [[1,1]]
    myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
    myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
    myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
    myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
    myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
    myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
    myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
  }

  /**
   * This solution uses a modulo with a prime number (2069) for the hashing function: 'key % 2069'.
   * This is used to organize storage space as an array where each element is indexed with the
   * output value of the hash function. Collisions are handled by using a bucket to hold all values
   * at that address.
   * <p>
   * The time complexity for each of the methods is O(N/K) where N is the number of all possible
   * keys and K is the number of predefined buckets in the hashmap, which is 2069 for this. In the
   * ideal case, the keys are evenly distributed in all buckets. As a result, on average, we could
   * consider the size of the bucket is N/K. Since in the worst case we need to iterate through a
   * bucket to find the desire value, the time complexity of each method is O(N/K).
   * <p>
   * The space complexity is O(K+M) where K  is the number of predefined buckets in the hashmap and
   * M is the number of unique keys that have been inserted into the hashmap.
   */
  class MyHashMap {

    private final List<Bucket> _hashTable;
    private final int _keySpace;


    public MyHashMap() {
      _keySpace = 2069;
      _hashTable = new ArrayList<>();

      for (int i = 0; i < _keySpace; i++) {
        _hashTable.add(new Bucket());
      }
    }

    public void put(int key, int value) {
      _hashTable.get(key % _keySpace).update(key, value);
    }

    public int get(int key) {
      return _hashTable.get(key % _keySpace).get(key);
    }

    public void remove(int key) {
      _hashTable.get(key % _keySpace).remove(key);
    }
  }

  class Entry<K, V> {

    public K _key;
    public V _value;

    public Entry(K key, V value) {
      _key = key;
      _value = value;
    }
  }

  class Bucket {

    private final List<Entry<Integer, Integer>> _bucket;

    public Bucket() {
      _bucket = new LinkedList<>();
    }

    public int get(int key) {
      for (Entry<Integer, Integer> entry : _bucket) {
        if (entry._key.equals(key)) {
          return entry._value;
        }
      }

      return -1;
    }

    public void update(int key, int value) {
      boolean found = false;

      for (Entry<Integer, Integer> entry : _bucket) {
        if (entry._key.equals(key)) {
          entry._value = value;

          found = true;
        }
      }

      if (!found) {
        _bucket.add(new Entry<>(key, value));
      }
    }

    public void remove(int key) {
      for (Entry<Integer, Integer> entry : _bucket) {
        if (entry._key.equals(key)) {
          _bucket.remove(entry);
          break;
        }
      }
    }
  }
}
