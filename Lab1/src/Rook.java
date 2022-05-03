import java.util.HashMap;

public class Rook extends Unit {
    Rook(Field field, int x, int y) {
        this.field = field;
        this.x = x;
        this.y = y;
        this.background = this.field.swapCell(x, y, '#');
        controls = new HashMap<>() {{
            put('<', new left());
            put('>', new right());
            put('^', new top());
            put('|', new bottom());
        }};
    }

    private class left implements mover {
        public boolean doMove() {
            if (!field.canMove(x - 1, y)) return false;

            x--;
            return true;
        }
    }

    private class top implements mover {
        public boolean doMove() {
            if (!field.canMove(x, y - 1)) return false;

            y--;
            return true;
        }
    }

    private class right implements mover {
        public boolean doMove() {
            if (!field.canMove(x + 1, y)) return false;

            x++;
            return true;
        }
    }

    private class bottom implements mover {
        public boolean doMove() {
            if (!field.canMove(x, y + 1)) return false;

            y++;
            return true;
        }
    }
}
