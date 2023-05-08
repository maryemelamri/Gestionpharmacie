package mon.projet.pharmacy.Gestionpharmacie.services.util;

public class StringUtil {
    public static boolean isNotEmpty(Object value) {
        return value!= null && !value.toString().isEmpty();
    }
}
