package Coding.Collection;

import java.time.DayOfWeek;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class AdditionalMapExerciseTest {

  /**
   * e.g.
   * ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
   *
   * put(K key, V value)
   * putIfAbsent(K key, V value)
   * putAll(Map<? extends K, ? extends V> m)
   */

  public void learn_ConcurrentHashMap() {
    ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
    map.put(1, 1);
    map.putIfAbsent(2, 2);
    Map<Integer, Integer> map1 = new HashMap<>();
    map1.put(1, 1);
    map1.putIfAbsent(2, 2);
    map.putAll(map1);
  }

  /**
   * e.g.
   * Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
   *
   * put(K key, V value)
   * putIfAbsent(K key, V value)
   */

  public void learn_IdentityHashMap() {
    Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
    map.put(DayOfWeek.MONDAY, 1);
    map.putIfAbsent(DayOfWeek.WEDNESDAY, 3);
  }

  /**
   * e.g.
   * EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
   *
   * put(K key, V value)
   * putIfAbsent(K key, V value)
   */

  public void learn_EnumMap() {
    EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
    enumMap.put(DayOfWeek.MONDAY, 1);
    enumMap.putIfAbsent(DayOfWeek.TUESDAY, 2);
  }
}
