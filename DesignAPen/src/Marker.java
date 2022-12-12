import startegies.writestrategies.SmoothWriteBehavior;

public class Marker extends Pen implements RefilPen{
    public Marker() {
        super(PenType.MARKER, new SmoothWriteBehavior());
    }

    @Override
    public void write() {

    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public Refil getRefil() {
        return null;
    }

    @Override
    public boolean canChangeRefil() {
        return false;
    }

    @Override
    public void changeRefil(Refil newRefil) {

    }
}
