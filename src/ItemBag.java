import java.util.ArrayList;
import java.util.List;

/**
 * Generic container for items on a cell.
 * Demonstrates a custom generic class (not just a generic Collection usage).
 */
public class ItemBag<T extends Item> {
    private final List<T> items;

    public ItemBag() {
        this.items = new ArrayList<>();
    }

    public void add(T item) {
        items.add(item);
    }

    public boolean remove(T item) {
        return items.remove(item);
    }

    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public java.util.List<T> getItems() {
        return java.util.Collections.unmodifiableList(items);
    }
};