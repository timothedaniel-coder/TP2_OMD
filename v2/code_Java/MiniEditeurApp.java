import java.util.Scanner;

public class MiniEditeurApp {
    public static void main(String[] args) {
        MoteurEdition moteur = new MoteurEdition();
        CommandManager manager = new CommandManager();
        Scanner scanner = new Scanner(System.in);
        boolean enMarche = true;

        System.out.println("Mini-Éditeur V2 - Commandes : INSERER <texte>, SELECT <debut> <fin>, COPIER, COUPER, COLLER, UNDO, REDO, QUITTER");

        while (enMarche) {
            System.out.println("Texte actuel : [" + moteur.getTexteBuffer() + "]");
            System.out.print("> ");
            String[] commande = scanner.nextLine().split(" ", 2);

            try {
                switch (commande[0].toUpperCase()) {
                    case "INSERER":
                        if (commande.length > 1) manager.executeCommand(new InsererCommand(moteur, commande[1]));
                        break;
                    case "SELECT":
                        if (commande.length > 1) {
                            String[] indices = commande[1].split(" ");
                            manager.executeCommand(new SelectionCommand(moteur, Integer.parseInt(indices[0]), Integer.parseInt(indices[1])));
                        }
                        break;
                    case "COPIER":
                        manager.executeCommand(new CopierCommand(moteur));
                        break;
                    case "COUPER":
                        manager.executeCommand(new CouperCommand(moteur));
                        break;
                    case "COLLER":
                        manager.executeCommand(new CollerCommand(moteur));
                        break;
                    case "UNDO":
                        manager.undo();
                        break;
                    case "REDO":
                        manager.redo();
                        break;
                    case "QUITTER":
                        enMarche = false;
                        break;
                    default:
                        System.out.println("Commande inconnue.");
                }
            } catch (Exception e) {
                System.out.println("Erreur de syntaxe. Veuillez réessayer.");
            }
        }
        scanner.close();
    }
}