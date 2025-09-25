import java.util.HashMap;

public class WarmestDataStructure implements WarmestDataStructureInterface {
    private final HashMap<String, Node> map = new HashMap<>();
    private final WarmestList list = new WarmestList();

    @Override
    public Integer put(String key, int value) {
        Node node = map.get(key);
        if (node != null) {
            int oldVal = node.value;
            node.value = value;
            list.moveToTail(node);
            return oldVal;
        } else {
            Node newNode = new Node(key, value);
            list.addToTail(newNode);
            map.put(key, newNode);
            return null;
        }
    }

    @Override
    public Integer remove(String key) {
        Node node = map.remove(key);
        if (node == null) return null;
        list.remove(node);
        return node.value;
    }

    @Override
    public Integer get(String key) {
        Node node = map.get(key);
        if (node == null) return null;
        list.moveToTail(node);
        return node.value;
    }

    @Override
    public String getWarmest() {
        Node tail = list.getTail();
        return tail == null ? null : tail.key;
    }
}
