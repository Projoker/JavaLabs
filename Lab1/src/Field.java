import java.util.Random;

public class Field {
    private final int sizeX;
    private final int sizeY;
    private char[][] data;

    public Field(int x, int y) {
        this.sizeX = x;
        this.sizeY = y;
    }

    public char swapCell(int x, int y, char val) {
        var old = data[y][x];
        data[y][x] = val;
        return old;
    }

    public boolean canMove(int x, int y) {
        return x >= 0 && y >= 0 && x < this.sizeX && y < this.sizeY && data[y][x] != '0';
    }

    public boolean isBonus(int x, int y) {
        return data[y][x] == '*';
    }

    public boolean isSave(int x, int y) {
        return data[y][x] == '!';
    }

    private static char genCell(Random rand) {
        var num = rand.nextInt(100);

        if (num < 20) return '0';
        else if (num < 40) return '*';
        else if (num < 50) return '!';
        else return '_';
    }

    public void Fill(int x, int y) {
        data = new char[sizeY][sizeX];
        Random rand = new Random();

        for (int i = 0; i < sizeY; i++)
            for (int j = 0; j < sizeX; j++)
                data[i][j] = genCell(rand);

        data[y][x] = 'o';
    }

    public void Print() {
        for (var row : data) {
            for (var el : row)
                System.out.print(el);
            System.out.println();
        }
    }
}
