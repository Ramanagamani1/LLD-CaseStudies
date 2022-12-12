public class Client {
    public static void main(String[] args) {

          GelPen reynoldsTrimaxGelPen = PenFactory
                         .createGelPen()
                         .setCanChangeRefil(true)
                         .setRefil(new Refil())
                         .build();
          reynoldsTrimaxGelPen.setName("Trimax");
          reynoldsTrimaxGelPen.setCompany("Reynolds");

          BallPen ballPen = PenFactory
                           .createBallPen()
                          .setCanChangeRefil(true)
                          .setRefil(new Refil())
                          .build();
    }
}

/*
  PenFactory.createPen()
            .setRefil(x)
            .setRefillable(false);
 */
