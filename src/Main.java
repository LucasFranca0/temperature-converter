import exceptions.DomainException;
import entities.TemperatureConverter;

import java.util.InputMismatchException;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws DomainException {
        Locale.setDefault(Locale.US);
        TemperatureConverter converter = new TemperatureConverter();

        try {
            converter.setUnit();
            converter.setTemperature();
            converter.convert();
        } catch (DomainException e) {
            System.out.println("Error: " + e.getMessage());
            converter.setUnit();
        } catch (InputMismatchException e) {
            System.out.println("Error: valor inválido.");
        }
    }
}