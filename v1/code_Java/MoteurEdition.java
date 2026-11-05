public class MoteurEdition {
    private Buffer buffer;
    private Selection selection;
    private PressePapier pressePapier;

    public MoteurEdition() {
        this.buffer = new Buffer();
        this.selection = new Selection(0, 0);
        this.pressePapier = new PressePapier();
    }

    public void deplacerSelection(int debut, int fin) {
        selection.setIndex(debut, fin);
    }

    public void copier() {
        String texteSelectionne = buffer.getSousTexte(selection.getDebut(), selection.getFin());
        pressePapier.setContenu(texteSelectionne);
    }

    public void couper() {
        copier(); // Copie de la sélection dans le presse-papier
        buffer.supprimer(selection.getDebut(), selection.getFin()); // Effacement de la sélection
        selection.setIndex(selection.getDebut(), selection.getDebut()); // Réinitialise la sélection
    }

    public void coller() {
        String contenu = pressePapier.getContenu();
        if (contenu != null && !contenu.isEmpty()) {
            // Remplacement de la sélection par le presse-papier
            buffer.supprimer(selection.getDebut(), selection.getFin());
            buffer.inserer(contenu, selection.getDebut());
            // Mise à jour de la sélection après insertion
            int nouvelIndex = selection.getDebut() + contenu.length();
            selection.setIndex(nouvelIndex, nouvelIndex);
        }
    }

    public String getTexteBuffer() {
        return buffer.getTexte();
    }

    public Buffer getBuffer() {
        return buffer;
    }

    public Selection getSelection() {
        return selection;
    }
}