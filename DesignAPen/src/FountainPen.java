import startegies.writestrategies.SmoothWriteBehavior;

public class FountainPen extends Pen{

    private Ink ink;
    private Tip tip;

    public FountainPen() {
        super(PenType.FOUNTAIN, new SmoothWriteBehavior());
    }

    public static class Builder {
        private Ink ink;
        private Tip tip;

        public Builder setInk(Ink ink) {
            this.ink = ink;
            return this;
        }

        public Builder setTip(Tip tip) {
            this.tip = tip;
            return this;
        }

        public FountainPen build() {
            FountainPen fountainPen = new FountainPen();
            fountainPen.ink = this.ink;
            fountainPen.tip = this.tip;
            return fountainPen;
        }

    }

    @Override
    public void write() {

    }

    @Override
    public Color getColor() {
        return ink.getColor();
    }
}
