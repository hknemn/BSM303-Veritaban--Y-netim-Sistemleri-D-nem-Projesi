package business;

import entities.Country;
import java.util.ArrayList;

public class Predict {

    private ArrayList<Country> countries;
    private ArrayList<Country> predictCountries;
    private LinearRegression lr;
    private double[] x = new double[10];
    private double[] y = new double[10];

    public Predict(ArrayList<Country> countries) {
        this.countries = countries;
        predictCountries = new ArrayList<>();
        xValues();
        yValues();
    }

    private void xValues() {
        double year = 2012;
        for (int i = 0; i < x.length; i++) {
            x[i] = year;
            year++;
        }
    }

    private void yValues() {
        for (Country country : countries) {
            y[0] = country.getY2012();
            y[1] = country.getY2013();
            y[2] = country.getY2014();
            y[3] = country.getY2015();
            y[4] = country.getY2016();
            y[5] = country.getY2017();
            y[6] = country.getY2018();
            y[7] = country.getY2019();
            y[8] = country.getY2020();
            y[9] = country.getY2021();
            lr = new LinearRegression(x, y);
            predictCountries.add(new Country(country.getId(), country.getName(), country.getCode(), (int) lr.predict(2024), (int) lr.predict(2025), (int) lr.predict(2026), (int) lr.predict(2030), (int) lr.predict(2035), (int) lr.predict(2040)));
        }
    }

    public ArrayList<Country> getPredictCountries() {
        return this.predictCountries;
    }
}
