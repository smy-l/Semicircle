package practice6_23.club.banyuan.node;

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
    public Node add(Object elem) {
        Node temp = this;
        if (getValue() == null) {
            temp.setValue(0);
        }
        temp.setValue((int) temp.getValue() + 1);


        while (temp.next != null) {
            temp = temp.next;
        }

        Node addNode = new Node();
        addNode.setValue(elem);
        addNode.setPrev(temp);
        temp.setNext(addNode);
        return this;
    }

    //删除
    public Node delete(Object elem) {
        Node del = search(elem);
        del.prev.setNext(del.getNext());
        del.next.setPrev(del.getPrev());
        setValue((int) getValue() - 1);
        return del;
    }

    //改
    public void modify(Object oldElem, Object newElem) {
        Node temp = search(oldElem);
        temp.setValue(newElem);
    }

    //查
    public Node search(Object elem) {
        Node temp = this;
        while (!temp.value.equals(elem) && temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        Node node = new Node();
        node.add(10);
        node.add(10101);
        for (int i = 0; i < 10; i++) {
            node.add(i);
        }

        node.delete(3);

        node.modify(10101, 20202);

        while (node != null) {
            System.out.print(node.getValue() + " ");
            node = node.next;
        }
    }
}
