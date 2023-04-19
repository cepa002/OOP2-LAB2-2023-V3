package skijanje;

public abstract class Deonica {
    private final double duzina, nagib;

    public Deonica(double duzina, double nagib) {
        this.duzina = duzina;
        this.nagib = nagib;
    }

    public abstract char oznaka();

    public double duzina() {
        return duzina;
    }

    public double nagib() {
        return nagib;
    }

    public abstract double ubrzanje();

    public double brzina(double pocetnaBrzina) {
        return Math.sqrt(2 * ubrzanje() * duzina + Math.pow(pocetnaBrzina,2));
    }

    public double vreme(double pocetnaBrzina) {
        return (brzina(pocetnaBrzina) - pocetnaBrzina) / ubrzanje();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(oznaka()).append('(').append(duzina).append(',').append(nagib).append(')');
        return sb.toString();
    }
}
