public class Semaforo {
    private int stato;

    public Semaforo(int stato) {
        this.stato = stato;
    }

    public synchronized void P(String s){
        while(stato == 0){
            try {
                System.out.println(s + " in attesa al box");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stato = 0;
    }


    public synchronized void V(){
        stato = 1;
        notify();
    }

}
