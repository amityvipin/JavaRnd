import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateBatham {

	public static void main(String[] args) {
		
		String input = "8/9/17 8:9:2 AM";
		String output = formatDateTime(input);
		System.out.println(output);
		
		input = "8/9/17";
		output = formatDate(input);
		System.out.println(output);
	}

	private static String formatDate(String input) {
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern ( "M/d/yy" ,Locale.getDefault());
		LocalDate localDate = formatter1.parse ( input , LocalDate :: from );
		return localDate.format(DateTimeFormatter.ofPattern ( "MM/dd/yy" ,Locale.getDefault())).toString();
	
	}

	private static String formatDateTime(String input) {
		
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern ( "M/d/yy H:m:s a" ,Locale.getDefault());
		LocalDateTime localDate = formatter1.parse ( input , LocalDateTime :: from );
		return localDate.format(DateTimeFormatter.ofPattern ( "MM/dd/yy HH:mm:ss a" ,Locale.getDefault())).toString();
	}

}
