package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 * <p>
 * https://leetcode.com/problems/lru-cache/
 *
 * @author Cheryl Tang
 */
public class Problem146 extends Problem {

  @Override
  public void runTestCases() {
    LRUCache lruCache = new LRUCache(2);
    lruCache.put(1, 1); // cache is {1=1}
    lruCache.put(2, 2); // cache is {1=1, 2=2}
    lruCache.get(1);    // return 1
    lruCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    lruCache.get(2);    // returns -1 (not found)
    lruCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    lruCache.get(1);    // return -1 (not found)
    lruCache.get(3);    // return 3
    lruCache.get(4);    // return 4
  }
}

/**
 * This solution uses a Doubly Linked List of CacheEntry and a Hashmap for the cache. The time
 * complexity is O(1) for both put and get since all operations are done in a constant time. The
 * space complexity is O(n) where n is the LRUCache capacity because the space is used only for an
 * ordered dictionary with at most capacity + 1 elements.
 */
class LRUCache {

  private final int _capacity;
  private final Map<Integer, CacheEntry> _cache = new HashMap<>();
  private CacheEntry _lru;
  private CacheEntry _mru;

  public LRUCache(int capacity) {
    _capacity = capacity;

    _lru = new CacheEntry(0, 0);
    _mru = new CacheEntry(0, 0);

    _lru.setNext(_mru);
    _mru.setPrev(_lru);
  }

  public int get(int key) {
    if (_cache.containsKey(key)) {
      CacheEntry cacheEntry = _cache.get(key);

      removeCacheEntry(cacheEntry);
      insertCacheEntry(cacheEntry);

      return cacheEntry.getValue();
    }

    return -1;
  }

  public void put(int key, int value) {
    if (_cache.containsKey(key)) {
      removeCacheEntry(_cache.get(key));
    }

    _cache.put(key, new CacheEntry(key, value));

    insertCacheEntry(_cache.get(key));

    if (_cache.size() > _capacity) {
      CacheEntry lru = _lru.getNext();

      removeCacheEntry(lru);

      _cache.remove(lru.getKey());
    }
  }

  public void insertCacheEntry(CacheEntry cacheEntry) {
    CacheEntry prev = _mru.getPrev();
    CacheEntry next = _mru;

    prev.setNext(cacheEntry);
    next.setPrev(cacheEntry);

    cacheEntry.setNext(next);
    cacheEntry.setPrev(prev);
  }

  public void removeCacheEntry(CacheEntry cacheEntry) {
    CacheEntry prev = cacheEntry.getPrev();
    CacheEntry next = cacheEntry.getNext();

    prev.setNext(next);
    next.setPrev(prev);
  }

  class CacheEntry {

    private final int _key;
    private final int _value;
    private CacheEntry _next;
    private CacheEntry _prev;

    public CacheEntry(int key, int value) {
      _key = key;
      _value = value;
    }

    public int getKey() {
      return _key;
    }

    public int getValue() {
      return _value;
    }

    public CacheEntry getNext() {
      return _next;
    }

    public void setNext(CacheEntry cacheEntry) {
      _next = cacheEntry;
    }

    public CacheEntry getPrev() {
      return _prev;
    }

    public void setPrev(CacheEntry cacheEntry) {
      _prev = cacheEntry;
    }
  }
}

