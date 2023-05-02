public class Modelo {

    public Peon peonB1;
    public Peon peonB2;
    public Peon peonB3;
    public Peon peonB4;
    public Torre torreB1;
    public Torre torreB2;
    public Caballo caballoB1;
    public Caballo caballoB2;
    public Alfil alfilB1;
    public Alfil alfilB2;
    public Reina reinaB1;
    public Rey reyB;


    public Peon peonN1;
    public Peon peonN2;
    public Peon peonN3;
    public Peon peonN4;
    public Torre torreN1;
    public Torre torreN2;
    public Caballo caballoN1;
    public Caballo caballoN2;
    public Alfil alfilN1;
    public Alfil alfilN2;
    public Reina reinaN1;
    public Rey reyN;

    public boolean crearPiezas() {

        // Instanciamos peones blancos
        this.peonB1 = new Peon();
        this.peonB2 = new Peon();
        this.peonB3 = new Peon();
        this.peonB4 = new Peon();
        // Instanciamos torres blancas
        this.torreB1 = new Torre();
        this.torreB2 = new Torre();
        // Instanciamos caballos blancos
        this.caballoB1 = new Caballo();
        this.caballoB2 = new Caballo();
        // Instanciamos alfiles blancos
        this.alfilB1 = new Alfil();
        this.alfilB2 = new Alfil();
        // Instanciamos reina blanca
        this.reinaB1 = new Reina();
        // Instanciamos rey blanco
        this.reyB = new Rey();

        // Instanciamos peones negros
        this.peonN1 = new Peon();
        this.peonN2 = new Peon();
        this.peonN3 = new Peon();
        this.peonN4 = new Peon();
        // Instanciamos torres negras
        this.torreN1 = new Torre();
        this.torreN2 = new Torre();
        // Instanciamos caballos negros
        this.caballoN1 = new Caballo();
        this.caballoN2 = new Caballo();
        // Instanciamos alfiles negros
        this.alfilN1 = new Alfil();
        this.alfilN2 = new Alfil();
        // Instanciamos reina negra
        this.reinaN1 = new Reina();
        // Instanciamos rey negro
        this.reyN = new Rey();

        return true;
    }

    public boolean iniciarPartida() {

        return true;
    }

    public boolean terminarPartida() {

        return true;
    }

}
