public class MyLinkedList implements NodeList {
    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem itemToAdd) {
        if (this.root == null) {
            // Since the list is empty set ItemToAss as List head
            this.root = itemToAdd;
            return true;
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = (currentItem.compareTo(itemToAdd));
            if (comparison < 0) {
                // Above: If itemToAdd > currentItem then comparison = 0
                // Below: So find End Record to put the itemToAdd After.
                if (currentItem.next() != null) { // Keep iterating while currentItem's next is not Null
                    currentItem = currentItem.next();
                } else { // Stop iterating once you find the free Node and Add like Swap Algorithm.
                    currentItem.setNext(itemToAdd); // Note you are not adding on currentItem but on it's empty next.
                    itemToAdd.setPrev(currentItem); // if you don't do this, the Add item's prev points to nothing: Doubly Link List bro
                    return true;
                }
            } else if (comparison > 0) {
                if (currentItem.prev() != null) {
                    currentItem = currentItem.prev().setNext(itemToAdd); // Take Next Pointer for Item before currentItem and point it to itemToAdd.
                    itemToAdd.setPrev(currentItem.prev()); // In turn point itemToAdd's Prev Pointer to currentItem's Prev Pointer
                    itemToAdd.setNext(currentItem); // Then point itemToAdd's Next Pointer to currentItem
                    currentItem.setPrev(itemToAdd); // Lastly point currentItems's Prev pointer to itemToAdd.
                } else {
                    itemToAdd.setNext(this.root);
                    this.root.setPrev(itemToAdd);
                    this.root = itemToAdd;
                }
            } else {
                System.out.println("Can't add " + itemToAdd.getValue() + " as it already exists.");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean remove(ListItem item) {
        return false;
    }

    @Override
    public void traverse(ListItem root) {

    }
}
