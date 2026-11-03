public class Selection {
    private int debut;
    private int fin;

    public Selection(int debut, int fin) {
        setIndex(debut, fin);
    }

    public int getDebut() {
        return debut;
    }

    public int getFin() {
        return fin;
    }

    public void setIndex(int debut, int fin) {
        this.debut = debut;
        this.fin = fin;
    }
}