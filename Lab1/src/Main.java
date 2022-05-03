import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter field size (x, y): ");
        int sizeX = scanner.nextInt(), sizeY = scanner.nextInt();
        var field = new Field(sizeX, sizeY);
        System.out.print("Enter spawn point (x, y): ");
        int x = scanner.nextInt(), y = scanner.nextInt();
        field.Fill(x, y);

        Unit.printUnits();
        System.out.print("Choose unit: ");
        int u = scanner.nextInt();
        Unit unit = Unit.getUnit(u - 1, field, x, y);
        unit.printControls();

        System.out.println("Collect bonuses (*), save them (!) and exit (@)");
        field.Print();

        char dir;
        while (scanner.hasNext()) {
            dir = scanner.next().charAt(0);

            if (dir == '@') {
                System.out.printf("Your saved bonuses %d\n", unit.bonuses);
                System.exit(0);
            }
            if (!unit.move(dir))
                System.out.println("Can't move");
            else
                field.Print();
        }
    }
}