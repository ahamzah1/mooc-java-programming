
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {
        if (size % 2 == 0) {
            throw new IllegalArgumentException("Size must be an odd number");
        }

        MagicSquare magicSquare = new MagicSquare(size);

        int row = 0, col = size / 2;

        for (int num = 1; num <= size * size; num++) {
            magicSquare.placeValue(row, col, num);

            int newRow = (row - 1 + size) % size; // Move up
            int newCol = (col + 1) % size; // Move right

            if (magicSquare.readValue(newRow, newCol) != 0) { // If occupied, move down instead
                row = (row + 1) % size;
            } else {
                row = newRow;
                col = newCol;
            }
        }

        return magicSquare;
}

}
