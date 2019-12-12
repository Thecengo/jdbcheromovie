import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        MenuOlusturucu.genelMenuMetniOlustur();

        Secici.genelMenuSecimYap(scanner);

    }






}
