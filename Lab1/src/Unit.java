import java.util.Map;

public abstract class Unit {
    Field field;
    int x;
    int y;
    char background;
    String text = "";
    int bonuses = 0;
    protected Map<Character, mover> controls;
    private static final Class<?>[] units = {Pawn.class, Rook.class, Bishop.class};

    static void printUnits() {
        System.out.print("Units: ");
        for (var i = 0; i < units.length; i++) {
            System.out.printf("%d) %s, ", i + 1, units[i].getSimpleName());
        }
        System.out.println();
    }

    static Unit getUnit(int i, Field field, int x, int y) {
        try {
            return (Unit) units[i].getDeclaredConstructor(Field.class, int.class, int.class).newInstance(field, x, y);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

        return null;
    }

    public void printControls() {
        System.out.print("Controls: ");
        for (var control : controls.keySet()) {
            System.out.printf("%s, ", control);
        }
        System.out.println();
    }

    public boolean move(char dir) {
        if (!controls.containsKey(dir)) return false;

        var oldX = x;
        var oldY = y;

        boolean hasMoved = controls.get(dir).doMove();

        if (hasMoved) {
            boolean clearCell = false;
            if (field.isBonus(x, y)) {
                text += "bonus";
                System.out.println("You collected one more bonus");
                clearCell = true;
            } else if (field.isSave(x, y)) {
                int cur = text.split("bonus", -1).length - 1;
                bonuses += cur;
                System.out.printf("You saved %d bonuses\n", cur);
                text = "";
                clearCell = true;
            }

            background = field.swapCell(oldX, oldY, background);
            background = field.swapCell(x, y, background);

            if (clearCell)
                background = '_';

            return true;
        }

        return false;
    }

    protected interface mover {
        boolean doMove();
    }
}
