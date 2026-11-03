public class InsererCommand implements Command {
    private MoteurEdition moteur;
    private String texte;
    private int offset;

    public InsererCommand(MoteurEdition moteur, String texte) {
        this.moteur = moteur;
        this.texte = texte;
        this.offset = moteur.getSelection().getDebut(); 
    }

    @Override
    public void execute() {
        moteur.getBuffer().inserer(texte, offset);
        // On utilise getSelection().setIndex au lieu de deplacerSelection
        moteur.getSelection().setIndex(offset + texte.length(), offset + texte.length());
    }

    @Override
    public void undo() {
        moteur.getBuffer().supprimer(offset, offset + texte.length());
        moteur.getSelection().setIndex(offset, offset);
    }
}