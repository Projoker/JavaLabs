import java.util.HashMap;

public class Pawn extends Unit {
    Pawn(Field field, int x, int y) {
        this.field = field;
        this.x = x;
        this.y = y;
        this.background = this.field.swapCell(x, y, '$');
        controls = new HashMap<>() {{
            put('^', new top());
        }};
    }

    private class top implements mover {
        public boolean doMove() {
            if (!field.canMove(x, y - 1)) return false;

            y--;
            return true;
        }
    }
}
