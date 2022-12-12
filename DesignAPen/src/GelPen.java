import startegies.writestrategies.SmoothWriteBehavior;
import startegies.writestrategies.WriteBehavior;

public class GelPen extends Pen implements RefilPen{

    private Refil refil;
    private boolean canChangeRefil = false;

    private GelPen(WriteBehavior writeBehavior) {
        super(PenType.GEL,writeBehavior);
    }

    public static class Builder {
        private Refil refil;
        private boolean canChangeRefil = false;

        public Builder setRefil(Refil refil) {
            this.refil = refil;
            return this;
        }

        public Builder setCanChangeRefil(Boolean value) {
            this.canChangeRefil = value;
            return this;
        }

        public GelPen build() {
            GelPen gelPen = new GelPen(new SmoothWriteBehavior());
            gelPen.refil = this.refil;
            gelPen.canChangeRefil = canChangeRefil;
            return gelPen;
        }

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
        return this.refil;
    }

    @Override
    public boolean canChangeRefil() {
        return this.canChangeRefil;
    }

    @Override
    public void changeRefil(Refil newRefil) {

    }
}
