public class ItemModel {
    private int id;
    private String nazwa;
    private int ilosc;

    public ItemModel(int id, String nazwa, int ilosc) {
        this.id = id;
        this.nazwa = nazwa;
        this.ilosc = ilosc;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
}