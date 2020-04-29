package diffi;

import java.util.HashMap;
import java.util.PriorityQueue;

public class LFU {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LFUCache cache = new LFUCache(2 /* capacity (��������) */);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // ���� 1
        cache.put(3, 3);    // ȥ�� key 2
        cache.get(2);       // ���� -1 (δ�ҵ�key 2)
        cache.get(3);       // ���� 3
        cache.put(4, 4);    // ȥ�� key 1
        cache.get(1);       // ���� -1 (δ�ҵ� key 1)
        cache.get(3);       // ���� 3
        cache.get(4);       // ���� 4


    }

}

class Node implements Comparable<Node> {
    int key;
    int time;
    int freq;
    int val;

    public Node(int key, int val, int time) {
        this.key = key;
        this.val = val;
        this.time = time;
        this.freq = 1;
    }

    public int compareTo(Node node) {
        int diff = freq - node.freq;
        return diff != 0 ? diff : time - node.time;
    }
}

class LFUCache {
    PriorityQueue<Node> heap;
    HashMap<Integer, Node> map;
    int time;
    int size;
    int capacity;

    public LFUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        if (capacity > 0) {
            heap = new PriorityQueue<>();
        }
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.freq++;
            node.time = this.time++;
            heap.remove(node);
            heap.offer(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = map.get(key);
        if (node == null) {
            if (size == capacity) {
                map.remove(heap.peek().key);
                heap.poll();
                size--;
            }
            Node newNode = new Node(key, value, time++);
            map.put(key, newNode);
            heap.offer(newNode);
            size++;
            return;
        }
        node.val = value;
        node.freq++;
        node.time = this.time++;
        heap.remove(node);
        heap.offer(node);
    }
}