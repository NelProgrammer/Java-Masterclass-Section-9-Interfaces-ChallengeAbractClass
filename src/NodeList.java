import java.util.List;

public interface NodeList {
    ListItem getRoot();
    boolean addItem(ListItem item);
    boolean remove(ListItem item);
    void traverse(ListItem root);
}
