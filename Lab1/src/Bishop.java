import java.util.HashMap;

public class Bishop extends Unit {
    Bishop(Field field, int x, int y) {
        this.field = field;
        this.x = x;
        this.y = y;
        this.background = this.field.swapCell(x, y, '&');
        controls = new HashMap<>() {{
            put('\\', new leftTop());
            put('/', new rightTop());
            put('<', new leftBottom());
            put('>', new rightBottom());
        }};
    }

    private class leftTop implements mover {
        public boolean doMove() {
            if (!field.canMove(x - 1, y - 1)) return false;

            x--;
            y--;
            return true;
        }
    }

    private class leftBottom implements mover {
        public boolean doMove() {
            if (!field.canMove(x - 1, y + 1)) return false;

            x--;
            y++;
            return true;
        }
    }

    private class rightTop implements mover {
        public boolean doMove() {
            if (!field.canMove(x + 1, y - 1)) return false;

            x++;
            y--;
            return true;
        }
    }

    private class rightBottom implements mover {
        public boolean doMove() {
            if (!field.canMove(x + 1, y + 1)) return false;

            x++;
            y++;
            return true;
        }
    }
}
