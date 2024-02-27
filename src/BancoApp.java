import java.util.Scanner;

public class BancoApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Solicitar datos de entrada al usuario
        System.out.println("Ingrese el código del banco (o dejelo en blanco):");
        String codigoBanco = scanner.nextLine();
        System.out.println("Ingrese el código de sucursal:");
        String codigoSucursal = scanner.nextLine();
        System.out.println("Ingrese el número de cuenta:");
        String numeroCuenta = scanner.nextLine();
        System.out.println("Ingrese la clave personal:");
        String clavePersonal = scanner.nextLine();
        System.out.println("Ingrese la orden (Talonario, Movimientos o dejar en blanco para ambos):");
        String orden = scanner.nextLine();


        // Verificar condiciones de entrada
        if (!validarCodigoBanco(codigoBanco)) {
            System.out.println("Error: Código de banco no válido.");
            return;
        }

        if (!validarCodigoSucursal(codigoSucursal)) {
            System.out.println("Error: Código de sucursal no válido.");
            return;
        }
        if (!validarNumeroCuenta(numeroCuenta)) {
            System.out.println("Error: Número de cuenta no válido.");
            return;
        }
        if (!validarClavePersonal(clavePersonal)) {
            System.out.println("Error: Clave personal no válida.");
            return;
        }

        // Procesar la orden

        //Orden. Este valor se introducirá según la orden que se desee realizar.
        // Puede estar en blanco o ser Talonario o Movimientos.
        // En caso de que diga Talonario el usuario recibirá un talonario de cheques,
        // mientras que en caso de que diga Movimientos recibirá los movimientos del mes en curso.
        // Si este código está en blanco, el cliente recibirá los dos documentos.

        if (orden.equalsIgnoreCase("Talonario")) {
            System.out.println("Se ha solicitado un talonario de cheques.");
        } else if (orden.equalsIgnoreCase("Movimientos")) {
            System.out.println("Se han solicitado los movimientos del mes.");
        } else if (orden.isEmpty()) {
            System.out.println("Se han solicitado los movimientos del mes y el talonario de cheques.");
        } else {
            System.out.println("Error: Orden no válida.");
        }
    }




    // Funciones de validación de datos de entrada

    //Código del banco. En blanco o número de tres dígitos donde el primero de los tres tiene que ser mayor que 1.
    public static boolean validarCodigoBanco(String codigoBanco) {
        return codigoBanco.isEmpty() || (codigoBanco.length() == 3 && Character.isDigit(codigoBanco.charAt(0)) && codigoBanco.charAt(0) > '1');
    }

    //Código de sucursal. Un número de cuatro dígitos. El primero de ellos mayor de 0.
    public static boolean validarCodigoSucursal(String codigoSucursal) {
        return codigoSucursal.length() == 4 && Character.isDigit(codigoSucursal.charAt(0)) && codigoSucursal.charAt(0) > '0';
    }

    //Número de cuenta. Número de cinco dígitos.
    public static boolean validarNumeroCuenta(String numeroCuenta) {
        return numeroCuenta.length() == 5 && numeroCuenta.chars().allMatch(Character::isDigit);
    }

    //Clave personal. Valor alfanumérico de cinco posiciones.
    public static boolean validarClavePersonal(String clavePersonal) {
        String pattern= "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{5}$";
        return clavePersonal.matches(pattern);
    }
}

