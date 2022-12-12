package startegies.writestrategies;

public class SmoothWriteBehavior implements WriteBehavior{

    @Override
    public void write() {
        System.out.println("Writing smoothly");
    }
}
