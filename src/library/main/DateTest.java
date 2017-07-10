package library.main;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		SimpleDateFormat objFormat = new SimpleDateFormat("yyyy-MM-hh");
		Date date1 = new Date();
		try {
			date1 = objFormat.parse("2017-6-1");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(date1);
		Date date2 = new Date();
		System.out.println(date2);
		long day = (date2.getTime()-date1.getTime())/(1000*60*60*24);
		System.out.println(day);

	}

}
