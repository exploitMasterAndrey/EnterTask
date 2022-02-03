package task5;
public class Item {
    private int volume;
    private int value;
    private String name;
    public Item(int volume, int value, String name) {
        this.volume = volume;
        this.value = value;
        this.name = name;
    }
    public int getVolume() {
        return volume;
    }
    public int getValue() {
        return value;
    }
    public String getName() {
        return name;
    }
}