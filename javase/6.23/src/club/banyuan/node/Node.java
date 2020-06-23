package club.banyuan.node;

public class Node {

    private Node prev;
    private Node next;

    private Object value;

    public Node() {

    }

    public Node(Node prev, Node next, Object value) {
        this.prev = prev;
        this.next = next;
        this.value = value;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    //增加
    public Node add(Object elem, Node node) {
        if(node.getValue() == null){
            node.setValue(0);
        }
        node.setValue((int)(node.getValue()) + 1);


        while (node.next != null) {
            node = node.next;
        }

        Node addNode = new Node();
        addNode.setValue(elem);
        addNode.setPrev(node);
        node.setNext(addNode);
        return this;
    }

    //删除
    public Node delete(Object elem, Node node) {
        Node del = search(elem, node);
        del.prev.setNext(del.getNext());
        del.next.setPrev(del.getPrev());
        return del;
    }

    //改
    public void modify(Object oldElem, Object newElem, Node node) {
        Node temp = search(oldElem, node);
        temp.setValue(newElem);
    }

    //查
    public Node search(Object elem, Node node) {
        if (node.value.equals(elem)) {
            return node;
        }
        return search(elem, node.next);
    }

    public static void main(String[] args) {
        Node node = new Node();
        node.add(10, node);
        node.add(10101, node);
        for (int i = 0; i < 10; i++) {
            node.add(i,node);
        }

        node.delete(3,node);

        node.modify(10101,20202,node);

        while (node != null) {
            System.out.print(node.getValue() + " ");
            node = node.next;
        }
    }
}
