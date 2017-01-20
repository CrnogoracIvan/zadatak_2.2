package zadaci;

import model.Brod;

import java.util.List;
import java.util.Random;

/**
 * Created by androiddevelopment on 20.1.17..
 */
public class BrodNit extends Thread {

    private Brod brod;

    public Brod getBrod() {
        return brod;
    }

    public void setBrod(Brod brod) {
        this.brod = brod;
    }

    public BrodNit() {

    }

    public BrodNit(Brod brod) {
        this.brod = brod;

    }

    public void run() {

        System.out.println("Brod je napustio luku");
        //brod putuje izmedju 2.5 i 5 sekundi

        Random random = new Random();

        try {
            sleep(random.nextInt(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

           do {
               synchronized (Luka.brojPristiglihBrodova){

                   Luka.brojPristiglihBrodova += 1;
                   System.out.println("Brod je stigao na odrediste.");
               }
           } while (Luka.brojPristiglihBrodova < Luka.brojBrodova - 1);




    }



}
