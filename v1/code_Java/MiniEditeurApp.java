import java.util.Scanner;

public class MiniEditeurApp {
    public static void main(String[] args) {
        MoteurEdition moteur = new MoteurEdition();
        Scanner scanner = new Scanner(System.in);
        boolean enMarche = true;

        System.out.println("Mini-Éditeur V1 - Commandes : INSERER <texte>, SELECT <debut> <fin>, COPIER, COUPER, COLLER, QUITTER");

        while (enMarche) {
            System.out.println("Texte actuel : [" + moteur.getTexteBuffer() + "]");
            System.out.print("> ");
            String[] commande = scanner.nextLine().split(" ", 2);

            switch (commande[0].toUpperCase()) {
                case "INSERER":
                    moteur.getBuffer().inserer(commande[1], moteur.getSelection().getDebut());
                    break;
                case "SELECT":
                    String[] indices = commande[1].split(" ");
                    moteur.deplacerSelection(Integer.parseInt(indices[0]), Integer.parseInt(indices[1]));
                    break;
                case "COPIER":
                    moteur.copier();
                    break;
                case "COUPER":
                    moteur.couper();
                    break;
                case "COLLER":
                    moteur.coller();
                    break;
                case "QUITTER":
                    enMarche = false;
                    break;
                default:
                    System.out.println("Commande inconnue.");
            }
        }
        scanner.close();
    }
}