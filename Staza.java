package skijanje;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;


public class Staza {

    private List<Deonica> deonice = new ArrayList<>();

    private final String naziv;

    private double duzinaStaze = 0;

    private double maxNagib = 0;

    public Staza(String naziv) { this.naziv = naziv;}

    public void dodaj(Deonica novaDeonica) {
        deonice.add(novaDeonica);
        duzinaStaze += novaDeonica.duzina();
        maxNagib = Math.max(novaDeonica.nagib(), maxNagib);
    }

    public int broj() { return deonice.size();}

    public double duzina() { return duzinaStaze;}

    public double nagib() { return maxNagib;}


    public char oznaka() throws GOznaka {
        if (deonice.size() == 0) throw new GOznaka();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(Deonica d : deonice){
            hashMap.put(d.oznaka(), hashMap.containsKey(d.oznaka()) ? hashMap.get(d.oznaka()) + 1 : 1);
        }
        Map.Entry<Character,Integer> maxEntry = Collections.max(hashMap.entrySet(), Map.Entry.comparingByValue());
        return maxEntry.getKey();
    }

    public double brzina(double pocetnaBrzina) {
        double krajnjaBrzina = pocetnaBrzina;
        for (Deonica d : deonice) {
            krajnjaBrzina = d.brzina(krajnjaBrzina);
        }
        return krajnjaBrzina;
    }

    public double vreme(double pocetnaBrzina) {
        double krajnjaBrzina = pocetnaBrzina;
        double vreme = 0;
        for (Deonica d : deonice) {
            double tmpBrzina;
            tmpBrzina = d.brzina(krajnjaBrzina);
            vreme += d.vreme(krajnjaBrzina);
            krajnjaBrzina = tmpBrzina;
        }
        return vreme;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(naziv).append('|').append(deonice.size()).append('|').append(duzinaStaze);
        sb.append('|').append(maxNagib).append("\n[");
        int i=0;
        for(Deonica d : deonice){
            sb.append(d);
            i++;
            if(i != deonice.size()) sb.append(',');
        }
        sb.append(']');
        return sb.toString();
    }
}
