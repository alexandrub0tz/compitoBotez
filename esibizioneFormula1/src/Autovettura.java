
/** 
 *  Tutte le autovetture hanno un identificativo,scuderia,pilota
 *  e un box e semaforo
 * @author Alexandru
 * 
*/
public class Autovettura extends Thread{
    private int identificativo;
    private String scuderia;
    private Pilota pilota;
    private Box box;
    private Semaforo semaforo;

    /**
     * 
     * @param identificativo un numero identificativo che ha l'autovettura
     * @param scuderia Se è appartente a Ferrare,Mercedes,RedBull etc...
     * @param pilota Colui che sta guidando l'autovettura
     * @param box una area dedicata dove le automobili cambiano le ruote
     * @param semaforo implementazione del semaforo per l'utilizzo di una risorsa condivisa una sola alla volta
     */
    public Autovettura(int identificativo, String scuderia, Pilota pilota,Box box, Semaforo semaforo) {
        super(pilota.getNome());
        this.identificativo = identificativo;
        this.scuderia = scuderia;
        this.pilota = pilota;
        this.box = box;
        this.semaforo = semaforo;
    }

    /**
     *  Esegue una gara di 10 giri in pista, ogni giro impega un tempo randoma da 1 a 4 secondi
     *  ogni 3 giri é previsto un cambio obbligatorio di pneumatici altrimenti si mette in attesa
     */
    public void run(){
        for(int i = 1; i <= 10; i++){
            int tempoGiro = (int) (Math.random()*4)+1;
            try {
                sleep(tempoGiro*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("GIRO-"+i+" Completato da " + pilota.getNome());

            if(i % 3 == 0){
                semaforo.P(Thread.currentThread().getName());
                if(box.getAutovettura() == null){
                    box.setAutovettura(this);
                    System.out.println("PIT-STOP " + pilota.getNome() + " sta cambiando le gomme in corso");
                    int tempoAttesa = (int) (Math.random()*5) + 1;
                    try {
                        sleep(tempoAttesa * 1000);
                        System.out.println("PIT-STOP " + pilota.getNome() + " Ha finito di cambiare le gomme");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    box.setAutovettura(null);
                    semaforo.V();
                }
           
          
             
            }
        }
    }



    
}
