/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author lldua
 */
public class ValidadorDataAntigo {
    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("dd/MM/yyyy");

    static {
        // Isso é crucial! Impede que o SimpleDateFormat faça parse de datas inválidas como "31/02/2000"
        DATE_FORMATTER.setLenient(false);
    }

    public static boolean isValidBirthDate(String dateString) {
        // 1. Verificar se a datastring não é nula ou vazia
        if (dateString == null || dateString.trim().isEmpty()) {
            return false;
        }

        Date birthUtilDate;
        try {
            // Tenta fazer o parse da string para um java.util.Date
            birthUtilDate = DATE_FORMATTER.parse(dateString.trim());
        } catch (ParseException e) {
            // 2. A data não está em um formato válido ou não é uma data real (ex: 31/02/2000)
            return false;
        }

        Calendar today = Calendar.getInstance(); // Data de hoje
        Calendar birthCalendar = Calendar.getInstance();
        birthCalendar.setTime(birthUtilDate); // Seta a data de nascimento no calendário

        // 3. A data não pode ser futura
        // Se a data de nascimento (hora, minuto, segundo ignorados) é depois de hoje, é inválida.
        // Comparar apenas a data (sem tempo) é mais preciso aqui.
        // Para isso, você pode zerar as horas/minutos/segundos de 'today'
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);

        birthCalendar.set(Calendar.HOUR_OF_DAY, 0);
        birthCalendar.set(Calendar.MINUTE, 0);
        birthCalendar.set(Calendar.SECOND, 0);
        birthCalendar.set(Calendar.MILLISECOND, 0);


        if (birthCalendar.after(today)) {
            return false;
        }

        // 4. Verificar se a pessoa tem pelo menos 18 anos
        Calendar eighteenYearsAgo = Calendar.getInstance();
        eighteenYearsAgo.add(Calendar.YEAR, -18); // Data 18 anos atrás a partir de hoje

        if (birthCalendar.after(eighteenYearsAgo)) {
            return false; // Se a data de nascimento for DEPOIS de 18 anos atrás (ou seja, a pessoa é MENOR de 18)
        }

        // 5. Verificar se a data não é muito antiga (ex: mais de 100 anos atrás)
        Calendar hundredYearsAgo = Calendar.getInstance();
        hundredYearsAgo.add(Calendar.YEAR, -100); // Data 100 anos atrás a partir de hoje

        if (birthCalendar.before(hundredYearsAgo)) {
            return false; // Se a data de nascimento for ANTES de 100 anos atrás
        }

        // Se passou por todas as validações, a data é válida
        return true;
    }
}
