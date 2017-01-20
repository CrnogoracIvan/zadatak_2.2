package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by androiddevelopment on 20.1.17..
 */

@DatabaseTable(tableName = "kontejner")
public class Kontejner {

    public static final String POLJE_OZNAKA = "oznaka";
    public static final String POLJE_OPIS = "opis";
    public static final String POLJE_TEZINA = "tezina";

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = POLJE_OZNAKA)
    private String oznaka;
    @DatabaseField(columnName = POLJE_OPIS)
    private String opis;
    @DatabaseField(columnName = POLJE_TEZINA)
    private Double tezina;

    @DatabaseField(foreign = true,foreignAutoRefresh = false)
    private Brod brod;

    //kons

    public Kontejner() {
    }

    public Kontejner(String oznaka, String opis, Double tezina) {
        this.oznaka = oznaka;
        this.opis = opis;
        this.tezina = tezina;
    }
// get set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Double getTezina() {
        return tezina;
    }

    public void setTezina(Double tezina) {
        this.tezina = tezina;
    }

    public Brod getBrod() {
        return brod;
    }

    public void setBrod(Brod brod) {
        this.brod = brod;
    }

    //toString


    @Override
    public String toString() {
        return "Kontejner: " + "id =" + id +  " oznaka  "+ oznaka + " opis =" + opis +  " tezina = " + tezina ;
    }
}
