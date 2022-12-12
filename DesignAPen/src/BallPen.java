import startegies.writestrategies.SmoothWriteBehavior;

public class BallPen extends Pen implements RefilPen{
    private Refil refil;
    private boolean canChangeRefil;

    private BallPen() {
        super(PenType.BALL, new SmoothWriteBehavior());
    }

    public static class Builder {
        private Refil refil;
        private boolean canChangeRefil;

        public Builder setRefil(Refil refil) {
            this.refil = refil;
            return this;
        }

        public Builder setCanChangeRefil(Boolean value) {
            this.canChangeRefil = value;
            return this;
        }

        public BallPen build() {
            BallPen ballPen = new BallPen();
            ballPen.refil = refil;
            ballPen.canChangeRefil = canChangeRefil;
            return ballPen;
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
