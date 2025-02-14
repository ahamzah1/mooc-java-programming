
import java.util.ArrayList;
import java.util.Collections;

public class MagicSquare {

    private int[][] square;

    // ready constructor
    public MagicSquare(int size) {
        if (size < 2) {
            size = 2;
        }
        
        this.square = new int[size][size];
    }

    // implement these three methods
    public ArrayList<Integer> sumsOfRows() {
        int size = this.square.length;
        ArrayList<Integer> res = new ArrayList<>();
        for(int row = 0; row<size;row++){
            int sum = 0;
            for(int column = 0; column<size;column++){
                sum += this.square[row][column];
            }
            res.add(sum);
        }
        return res;
    }

    public ArrayList<Integer> sumsOfColumns() {
        int size = this.square.length;
        ArrayList<Integer> res = new ArrayList<>();
        for(int row = 0; row<size;row++){
            int sum = 0;
            for(int column = 0; column<size;column++){
                sum += this.square[column][row];
            }
            res.add(sum);
        }
        return res;
    }

    public ArrayList<Integer> sumsOfDiagonals() {
        int size = this.square.length;
        ArrayList<Integer> res = new ArrayList<>();
        int sum = 0;
        int sum_2 = 0;
        for(int row = 0; row<size;row++){
            sum += this.square[row][row];
            sum_2 += this.square[row][size-row-1];
        }
        res.add(sum_2);
        res.add(sum);
        return res;
    }

    // ready-made helper methods -- don't touch these
    public boolean isMagicSquare() {
        return sumsAreSame() && allNumbersDifferent();
    }

    public ArrayList<Integer> giveAllNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                numbers.add(square[row][col]);
            }
        }

        return numbers;
    }

    public boolean allNumbersDifferent() {
        ArrayList<Integer> numbers = giveAllNumbers();

        Collections.sort(numbers);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) == numbers.get(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean sumsAreSame() {
        ArrayList<Integer> sums = new ArrayList<>();
        sums.addAll(sumsOfRows());
        sums.addAll(sumsOfColumns());
        sums.addAll(sumsOfDiagonals());

        if (sums.size() < 3) {
            return false;
        }

        for (int i = 1; i < sums.size(); i++) {
            if (sums.get(i - 1) != sums.get(i)) {
                return false;
            }
        }

        return true;
    }

    public int readValue(int x, int y) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return - 1;
        }

        return this.square[y][x];
    }

    public void placeValue(int x, int y, int value) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return;
        }

        this.square[y][x] = value;
    }

    public int getWidth() {
        return this.square.length;
    }

    public int getHeight() {
        return this.square.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                result.append(square[row][col]).append("\t");
            }

            result.append("\n");
        }

        return result.toString();
    }
}
