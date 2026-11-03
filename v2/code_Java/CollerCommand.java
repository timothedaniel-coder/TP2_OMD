public class CollerCommand implements Command {
    private MoteurEdition moteur;
    private String texteRemplace;
    private int debutAncien, finAncienne;
    private String texteColle;

    public CollerCommand(MoteurEdition moteur) {
        this.moteur = moteur;
        this.debutAncien = moteur.getSelection().getDebut();
        this.finAncienne = moteur.getSelection().getFin();
        this.texteRemplace = moteur.getBuffer().getSousTexte(debutAncien, finAncienne);
        this.texteColle = moteur.getPressePapier().getContenu();
    }

    @Override
    public void execute() {
        if (texteColle != null && !texteColle.isEmpty()) {
            moteur.getBuffer().supprimer(debutAncien, finAncienne);
            moteur.getBuffer().inserer(texteColle, debutAncien);
            int nouvelIndex = debutAncien + texteColle.length();
            moteur.getSelection().setIndex(nouvelIndex, nouvelIndex);
        }
    }

    @Override
    public void undo() {
        if (texteColle != null && !texteColle.isEmpty()) {
            int finColle = debutAncien + texteColle.length();
            moteur.getBuffer().supprimer(debutAncien, finColle);
            moteur.getBuffer().inserer(texteRemplace, debutAncien);
            moteur.getSelection().setIndex(debutAncien, finAncienne);
        }
    }
}