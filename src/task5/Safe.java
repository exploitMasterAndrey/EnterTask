package task5;
import java.util.Arrays;
import java.util.stream.Collectors;
public class Safe {
    private Item[] items;
    private int commonValue;

    public Safe(Item[] things, int commonValue) {
        this.items = things;
        this.commonValue = commonValue;
    }
    public Item[] getItems() {
        return items;
    }
    public int getCommonValue() {
        return commonValue;
    }
    public String getDescription() {
        if (items == null) return "";
        else return Arrays.stream(items).map(Item::getName).collect(Collectors.joining("+")) + "-" + getCommonValue();
    }
}