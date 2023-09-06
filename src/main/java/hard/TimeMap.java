package hard;

/*
Design a time-based key-value data structure that can store multiple values for the same key
at different time stamps and retrieve the key's value at a certain timestamp.

Implement the TimeMap class:

TimeMap() Initializes the object of the data structure.
void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
String get(String key, int timestamp) Returns a value such that set was called previously,
with timestamp_prev <= timestamp.
If there are multiple such values, it returns the value associated with the largest timestamp_prev.
If there are no values, it returns "".

All the timestamps of set are strictly increasing.

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeMap {
    public TimeMap() {

    }

    HashMap<String, List<Node>> keyMap = new HashMap<>();

    public void set(String key, String value, int timestamp) {
        if (keyMap.containsKey(key)) {
            keyMap.get(key).add(new Node(timestamp, value));
        } else {
            List<Node> newList = new ArrayList<>();
            newList.add(new Node(timestamp, value));
            keyMap.put(key, newList);
        }
    }

    public String get(String key, int timestamp) {
        if (!keyMap.containsKey(key)) {
            return "";
        } else {
            return search(keyMap.get(key), timestamp);
        }
    }

    public String search(List<Node> nodelist, int maxTime) {
        int left = 0, right = nodelist.size() - 1;
        while (right > left) {
            int mid = (right - left) / 2 + left + 1;
            if (nodelist.get(mid).timestamp == maxTime) {
                return nodelist.get(mid).value;
            } else if (nodelist.get(mid).timestamp < maxTime) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return nodelist.get(left).timestamp > maxTime ? "" : nodelist.get(left).value;
    }
}

class Node {
    int timestamp;
    String value;
    public Node(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }

}

/*
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
