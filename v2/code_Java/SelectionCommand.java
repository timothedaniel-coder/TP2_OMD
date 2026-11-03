public class SelectionCommand implements Command {
    private MoteurEdition moteur;
    private int ancienDebut, ancienneFin;
    private int nouveauDebut, nouvelleFin;

    public SelectionCommand(MoteurEdition moteur, int nouveauDebut, int nouvelleFin) {
        this.moteur = moteur;
        this.ancienDebut = moteur.getSelection().getDebut();
        this.ancienneFin = moteur.getSelection().getFin();
        this.nouveauDebut = nouveauDebut;
        this.nouvelleFin = nouvelleFin;
    }

    @Override
    public void execute() {
        moteur.getSelection().setIndex(nouveauDebut, nouvelleFin);
    }

    @Override
    public void undo() {
        moteur.getSelection().setIndex(ancienDebut, ancienneFin);
    }
}