package javaapplication99;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class JavaApplication99 {

    
    public static void main(String[] args) {
         JFrame jf = new PlayGames();
         /*playstate1 a=new  playstate1();
         a.timestart = false;
		a.scor=0;
		a.HP =3;
		a.times = 100;
		a.startball=false;
		a.timestart=false;
         jf.add(a);*/
            jf.setSize(1000,800);
            jf.setTitle("FRIENDS");
            jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
            jf.setVisible(true);
            jf.setLocationRelativeTo(null);
    }
    
}
