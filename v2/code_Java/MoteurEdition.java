public class MoteurEdition {
    private Buffer buffer;
    private Selection selection;
    private PressePapier pressePapier;

    public MoteurEdition() {
        this.buffer = new Buffer();
        this.selection = new Selection(0, 0);
        this.pressePapier = new PressePapier();
    }

    public Buffer getBuffer() { return buffer; }
    public Selection getSelection() { return selection; }
    public PressePapier getPressePapier() { return pressePapier; }
    public String getTexteBuffer() { return buffer.getTexte(); }
}