public class Node extends ListItem {

    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return this.next;
    }

    @Override
    ListItem setNext(ListItem item) {
        this.next = item;
        return this.prev;
    }

    @Override
    ListItem prev() {
        return this.prev;
    }

    @Override
    ListItem setPrev(ListItem item) {
        this.prev = item;
        return this.prev;
    }

    @Override
    int compareTo(ListItem itemToCompare) {
        if(itemToCompare != null) {
            return ((String) super.getValue()).compareTo((String) itemToCompare.getValue());
        } else {
            return -1;
        }
    }
}
