public class CopierCommand implements Command {
    private MoteurEdition moteur;
    private String ancienPressePapier;
    private String texteCopie;

    public CopierCommand(MoteurEdition moteur) {
        this.moteur = moteur;
        this.ancienPressePapier = moteur.getPressePapier().getContenu();
        this.texteCopie = moteur.getBuffer().getSousTexte(moteur.getSelection().getDebut(), moteur.getSelection().getFin());
    }

    @Override
    public void execute() {
        moteur.getPressePapier().setContenu(texteCopie);
    }

    @Override
    public void undo() {
        moteur.getPressePapier().setContenu(ancienPressePapier);
    }
}