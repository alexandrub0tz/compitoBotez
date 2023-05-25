public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("è iniziata la gara!");

        Semaforo semaforo = new Semaforo(1);
        Box box = new Box();

        Pilota p1 = new Pilota("mario");
        Pilota p2 = new Pilota("luigi");
        Pilota p3 = new Pilota("francesco");
        Pilota p4 = new Pilota("rossi");
        Pilota p5 = new Pilota("bianchi");

        Autovettura a1 = new Autovettura(0, "ferrari", p1, box, semaforo);
        Autovettura a2 = new Autovettura(1, "Mclaren", p2, box, semaforo);
        Autovettura a3 = new Autovettura(2, "Martin Aston", p3, box, semaforo);
        Autovettura a4 = new Autovettura(3, "lamborghini", p4, box, semaforo);
        Autovettura a5 = new Autovettura(4, "Mercedes", p5, box, semaforo);

        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();

        a1.join();
        a2.join();
        a3.join();
        a4.join();
        a5.join();

        System.out.println("gara termina");



    }
}
