package mid;

import java.util.HashMap;

public class LRU {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LRUCache cache = new LRUCache(2 /* �������� */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));     // ����  1
        cache.put(3, 3);    // �ò�����ʹ����Կ 2 ����
        System.out.println(cache.get(2));      // ���� -1 (δ�ҵ�)
        cache.put(4, 4);    // �ò�����ʹ����Կ 1 ����
        System.out.println(cache.get(1));       // ���� -1 (δ�ҵ�)
        System.out.println(cache.get(3));       // ����  3
        System.out.println(cache.get(4));       // ����  4
    }

    public static class LRUCache {
        public NodeDoubleLinkedList nodeList;
        public HashMap<Integer, Node> keyNodeMap;
        public HashMap<Node, Integer> nodeKeyMap;
        public int capacity;

        public LRUCache(int capacity) {
            if (capacity < 1) {
                throw new RuntimeException("should be more than 0");
            }
            this.capacity = capacity;
            keyNodeMap = new HashMap<>();
            nodeKeyMap = new HashMap<>();
            nodeList = new NodeDoubleLinkedList(capacity);
        }

        public int get(int key) {
            if (keyNodeMap.containsKey(key)) {
                Node node = this.keyNodeMap.get(key);
                nodeList.moveNodeToTail(node);
                return node.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (this.keyNodeMap.containsKey(key)) {
                Node node = keyNodeMap.get(key);
                node.value = value;
                nodeList.moveNodeToTail(node);
            } else {
                Node node = new Node(value);
                nodeList.addNode(node);
                this.keyNodeMap.put(key, node);
                this.nodeKeyMap.put(node, key);
                if (nodeKeyMap.size() == this.capacity + 1) {
                    this.removeMostUnusedCache();
                }
            }
        }

        private void removeMostUnusedCache() {
            Node res = nodeList.removeHead();
            int key = nodeKeyMap.get(res);
            this.keyNodeMap.remove(key);
            this.nodeKeyMap.remove(res);
        }

        class Node {
            public int value;
            public Node last;
            public Node next;

            public Node(int val) {
                this.value = val;
            }
        }

        class NodeDoubleLinkedList {
            public Node head;
            public Node tail;
            public int capacity;

            public NodeDoubleLinkedList(int capacity) {
                this.capacity = capacity;
                this.head = null;
                this.tail = null;
            }

            public void addNode(Node node) {
                if (node == null) {
                    return;
                }
                if (this.head == null) {
                    this.head = node;
                    this.tail = node;
                } else {
                    this.tail.next = node;
                    node.last = this.tail;
                    this.tail = node;
                }
            }

            public void moveNodeToTail(Node node) {
                if (node == this.tail) {
                    return;
                }
                if (node == this.head) {
                    this.head = node.next;
                    this.head.last = null;
                } else {
                    node.last.next = node.next;
                    node.next.last = node.last;
                }
                node.last = this.tail;
                node.next = null;
                this.tail.next = node;
                this.tail = node;
            }

            public Node removeHead() {
                if (this.head == null) {
                    return null;
                }
                Node res = this.head;
                if (this.head == this.tail) {
                    this.head = null;
                    this.tail = null;
                } else {
                    this.head = res.next;
                    res.next = null;
                    this.head.last = null;
                }
                return res;
            }
        }
    }

}
