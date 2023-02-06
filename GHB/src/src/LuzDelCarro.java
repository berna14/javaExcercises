import lombok.experimental.UtilityClass;

public class LuzDelCarro {
    private boolean estaEncendida;

    void encender() {
        estaEncendida = true;
        System.out.println("Las luces del auto están encendidas.");

    }

    void apagar() {
        estaEncendida = false;
        System.out.println("Las luces del auto están apagadas.");
    }

}
