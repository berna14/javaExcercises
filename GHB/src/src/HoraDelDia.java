import java.time.LocalTime;

public class HoraDelDia {

    public static void esDeDia() {

        LuzDelCarro luzDelCarro = new LuzDelCarro();

        LocalTime horaActual = LocalTime.now();
        LocalTime inicioHorarioDiurno = LocalTime.of(6, 0);
        LocalTime finHorarioDiurno = LocalTime.of(19, 0);

        if (horaActual.isAfter(inicioHorarioDiurno) && horaActual.isBefore(finHorarioDiurno)) {
            luzDelCarro.apagar();
        } else {
            luzDelCarro.encender();
        }


    }

}
