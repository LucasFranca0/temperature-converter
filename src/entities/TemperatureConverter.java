package entities;

import Exceptions.DomainException;

import java.util.Scanner;

import static java.lang.Double.NaN;

public class TemperatureConverter {
    private char unit;
    private double temperature;
    private final Scanner scan = new Scanner(System.in);

    public void setTemperature() {
        System.out.print("Insert the temperature (number only): ");
        double temperature = scan.nextDouble();
        this.temperature = temperature;
    }

    public void setUnit() throws DomainException {
        System.out.print("Insert the unit (C, F or K): ");
        char unit = scan.next().toUpperCase().charAt(0);
        if (unit != 'C' && unit != 'F' && unit != 'K') {
            throw new DomainException("Invalid unit");
        }
        this.unit = unit;
    }

    public void convert() {
        switch (this.unit) {
            case 'C' -> CelsiusConverter.convert(this.temperature);
            case 'F' -> FahrenheitConverter.convert(this.temperature);
            case 'K' -> KelvinConverter.convert(this.temperature);
        }
    }

    protected static void showConversions(double celsiusTemperature, double fahrenheitTemperature,
                                          double kelvinTemperature) {
        System.out.println("\nThe converted values are: ");
        System.out.printf("Celsius: %.2f ºC \n", celsiusTemperature);
        System.out.printf("Fahrenheit: %.2f ºF\n", fahrenheitTemperature);
        System.out.printf("Kelvin: %.2f ºK \n", kelvinTemperature);
    }
}
