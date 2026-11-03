public class CouperCommand implements Command {
    private MoteurEdition moteur;
    private String texteCoupe;
    private int debutAncien, finAncienne;
    private String ancienPressePapier;

    public CouperCommand(MoteurEdition moteur) {
        this.moteur = moteur;
        this.debutAncien = moteur.getSelection().getDebut();
        this.finAncienne = moteur.getSelection().getFin();
        this.texteCoupe = moteur.getBuffer().getSousTexte(debutAncien, finAncienne);
        this.ancienPressePapier = moteur.getPressePapier().getContenu();
    }

    @Override
    public void execute() {
        moteur.getPressePapier().setContenu(texteCoupe);
        moteur.getBuffer().supprimer(debutAncien, finAncienne);
        moteur.getSelection().setIndex(debutAncien, debutAncien);
    }

    @Override
    public void undo() {
        moteur.getBuffer().inserer(texteCoupe, debutAncien);
        moteur.getSelection().setIndex(debutAncien, finAncienne);
        moteur.getPressePapier().setContenu(ancienPressePapier);
    }
}