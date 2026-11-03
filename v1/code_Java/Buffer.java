public class Buffer {
    private StringBuilder texte;

    public Buffer() {
        this.texte = new StringBuilder();
    }

    public void inserer(String ajout, int offset) {
        if (offset >= 0 && offset <= texte.length()) {
            texte.insert(offset, ajout);
        }
    }

    public void supprimer(int debut, int fin) {
        if (debut >= 0 && fin <= texte.length() && debut <= fin) {
            texte.delete(debut, fin);
        }
    }

    public String getTexte() {
        return texte.toString();
    }

    public String getSousTexte(int debut, int fin) {
        if (debut >= 0 && fin <= texte.length() && debut <= fin) {
            return texte.substring(debut, fin);
        }
        return "";
    }
}