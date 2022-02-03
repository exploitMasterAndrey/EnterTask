package task5;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Task5 {
    public static void main(String[] args) {
        int n = 3;
        int k = 4;
        Safe[][] safe = new Safe[n + 1][k + 1];
        Item[] items = {new Item(2, 1200, "клавиатура"), new Item(1, 2500, "видеокарта"), new Item(4, 3500, "планшет")};
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < k + 1; j++) {
                if (i == 0 || j == 0) {
                    safe[i][j] = new Safe(new Item[]{}, 0);
                } else if (i == 1) {
                    safe[1][j] = items[0].getVolume() <= j ? new Safe(new Item[]{items[0]}, items[0].getValue()) : new Safe(new Item[]{}, 0);
                } else {
                    if (items[i - 1].getVolume() > j)
                        safe[i][j] = safe[i - 1][j];
                    else {
                        int newValue = items[i - 1].getValue() + safe[i - 1][j - items[i - 1].getVolume()].getCommonValue();
                        if (safe[i - 1][j].getCommonValue() > newValue)
                            safe[i][j] = safe[i - 1][j];
                        else {
                            safe[i][j] = new Safe(Stream.concat(Arrays.stream(new Item[]{items[i - 1]}),
                                    Arrays.stream(safe[i - 1][j - items[i - 1].getVolume()].getItems())).toArray(Item[]::new), newValue);
                        }
                    }
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                System.out.print(safe[i][j].getDescription() + " ");
            }
            System.out.print("\n");
        }
        List<Safe> lastColumn = Arrays.stream(safe).map(row -> row[row.length - 1]).collect(Collectors.toList());
        Safe safeMaxValue = lastColumn.stream().max(Comparator.comparing(Safe::getCommonValue)).orElse(new Safe(null, 0));
        System.out.println(safeMaxValue.getDescription());
    }
}