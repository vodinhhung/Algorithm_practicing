package tutorial.javabasic.enumbasic;

public class timetable {
	public static String getjob(Weekday weekDay) {
		if (weekDay == Weekday.SAMEDI||weekDay == Weekday.DIMANCHE) {
			return "Nothing";
		}
		else return "Coding";
	}
}
