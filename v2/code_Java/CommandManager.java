import java.util.Stack;

public class CommandManager {
    private Stack<Command> historyStack;
    private Stack<Command> redoStack;

    public CommandManager() {
        this.historyStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    public void executeCommand(Command c) {
        c.execute();
        historyStack.push(c);
        redoStack.clear(); // Toute nouvelle action efface l'historique des "refaire"
    }

    public void undo() {
        if (!historyStack.isEmpty()) {
            Command c = historyStack.pop();
            c.undo();
            redoStack.push(c);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            Command c = redoStack.pop();
            c.execute();
            historyStack.push(c);
        }
    }
}