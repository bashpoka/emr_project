import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class simpleTester {
	private static final int constDay = 10;
	private static final int constMonth = 11;
	private static final int constYear = 12;
	
	private static String getBirth_date_with_choice(String birth_date, int choice) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date parsed;

		if(choice == 1) {
			SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
			try {
				parsed = format.parse(birth_date);
				return dayFormat.format(parsed);
			} catch (ParseException e) {}
		} else if (choice == 2) {
			SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
			try {
				parsed = format.parse(birth_date);
				return monthFormat.format(parsed);
			} catch (ParseException e) {}
		} else {
			SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");	
			try {
				parsed = format.parse(birth_date);
				return yearFormat.format(parsed);			
			} catch (ParseException e) {}		
		}
		
		return null;
	}
	
	
	private static String returnDateMonthYear(String dateString, int choice) {
		switch (choice) {
		case constDay:
			return dateString.substring(0, 2);
		case constMonth:
			String month = dateString.substring(3, 6).toLowerCase();
			switch (month) {
			case "jan":
				month = "January";
				break;
			case "feb":
				month = "February";
				break;
			case "mar":
				month = "March";
				break;
			case "apr":
				month = "April";
				break;
			case "may":
				month = "May";
				break;
			case "jun":
				month = "June";
				break;
			case "jul":
				month = "July";
				break;
			case "aug":
				month = "August";
				break;
			case "sep":
				month = "September";
				break;
			case "oct":
				month = "October";
				break;
			case "nov":
				month = "November";
				break;
			case "dec":
				month = "December";
				break;
			default:
				break;
			}
			return month;
		case constYear:
			int year = Integer.parseInt(dateString.substring(7, 9));
			return year>=70 ? "19"+dateString.substring(7, 9) : "20"+dateString.substring(7, 9);		
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(returnDateMonthYear("30-Aug-2015", constMonth));

	}

}
