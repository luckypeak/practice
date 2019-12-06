import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;
        DLinkedNode(int key){
            this.key = key;
        }
    }

    Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    int size = 0;
    DLinkedNode head, tail;

    public LRUCache(int capacity) {
        size = capacity;
        head = new DLinkedNode(0);
        head.pre = null;
        tail = new DLinkedNode(0);
        tail.next = null;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        DLinkedNode node = cache.get(key);
        moveToHead(node);
        return node.value;
    }
    private void removeNode(DLinkedNode node){
        DLinkedNode pre = node.pre;
        DLinkedNode next = node.next;
        pre.next =next;
        next.pre = pre;
    }

    private void addNode(DLinkedNode node){
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }
    private void moveToHead(DLinkedNode node){

        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail(){
        DLinkedNode res = tail.pre;
        removeNode(res);
        return res;
    }
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);


        if (node == null){
            DLinkedNode newNode = new DLinkedNode(key);
            newNode.value = value;
            addNode(newNode);
            cache.put(key, newNode);
            if (cache.size() >= size) {
                DLinkedNode popTail = popTail();
                cache.remove(popTail.key);
            }
        } else {
            node.value = value;
            moveToHead(node);
        }


    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.get(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(2,3);
        cache.put(4,1);
        cache.get(1);
        cache.get(2);

    }
}
