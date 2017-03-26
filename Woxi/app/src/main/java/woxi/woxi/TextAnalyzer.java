package woxi.woxi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TextAnalyzer {
	
    //health keywords for prelimiary check if voicemail is health related
	private String[] healthKeyWords = {"doctor", "dentist"};
    
    
	private String[] medKeyWords = {"pharmacy", "medication" ,  "prescription"};
	private String[] daysOfWeek = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};
	private String[] months = {"january", "febeurary", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"};
	
	
	public static String HEALTH = "HEALTH";
    
	public static String MED = "MED";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TextAnalyzer t = new TextAnalyzer();
		//String date = t.getDate("Coffee today");
        //System.out.println(date);
        
        //System.out.println(t.returnCVSPharmacyDEMO());
	}
    
    //checks one voicemail and return true if it is relating to health circumstance
    private boolean isHealthReminder(String in) {
        for (int i = 0; i < healthKeyWords.length; i++) {
            if(in.indexOf(healthKeyWords[i]) != -1) {
                return true;
            }
        }
        return false;
    }
    
    
    public static String[] returnCVSPharmacyDEMO(){
        
        String[] array = {"Pick up Medication from CVS", "12940 Saratoga Sunnyvale Rd, Saratoga, CA 95070" ,  "2017-04-02T09:00:00-07:00", "2017-04-02T17:00:00-17:00"};
        
        return array;
    
    }
    
	public String reminderType(String voiceData) {
		String type = "";
		String data = voiceData.toLowerCase();
		if(isHealthReminder(data)) {
			type = TextAnalyzer.HEALTH;
		} else if (isMedReminder(data)) {
			type = TextAnalyzer.MED;
		} 
		return type;
	}
	
	public String reminderType(String[] voiceData) {
		String type = "";
		String[] data = voiceData;//voiceData.toLowerCase();
		if(isHealthReminder(data)) {
			type = TextAnalyzer.HEALTH;
		} else if (isMedReminder(data)) {
			type = TextAnalyzer.MED;
		} 
		return type;
	}
	
	//checks an array of voicemails and return true if it is relating to health circumstance
	private boolean isHealthReminder(String[] in) {
		for(int j = 0; j < in.length; j++) {
			for (int i = 0; i < healthKeyWords.length; i++) {
				if(in[j].indexOf(healthKeyWords[i]) != -1) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isMedReminder(String[] in) {
		for(int j = 0; j < in.length; j++) {
			for (int i = 0; i < medKeyWords.length; i++) {
				if(in[j].indexOf(medKeyWords[i]) != -1) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isMedReminder(String in) {
		for (int i = 0; i < medKeyWords.length; i++) {
			if(in.indexOf(medKeyWords[i]) != -1) {
				return true;
			}
		}
		return false;
	}
	
    //turn voicemail string into an ArrayList of Strings
	public ArrayList<String> segmentWords(String in) {
		ArrayList<String> ret = new ArrayList<String>();
		int start = 0;
		int end = 0;
		while(true) {
			end = in.indexOf(" ", start);
			if(end < 0){
				end = in.length();
				ret.add(in.substring(start, end));
				break;
			}
			ret.add(in.substring(start, end));
			start = end + 1;
		}
		return ret;
	}
	
    //checks if a word is a day of the week
	private boolean isDateWord(String w) {
		for(int i = 0; i < daysOfWeek.length; i++) {
			if(w.indexOf(daysOfWeek[i]) != -1){
				return true;
			}
		}
		return false;
	}
	
    //checks if a word is a month
	private boolean isMonthWord(String w) {
		for(int i = 0; i < months.length; i++) {
			if(w.indexOf(months[i]) != -1){
				return true;
			}
		}
		return false;
	}
	
   
    //
	public String getDate(String in) {
		String ret = "";
		String data = in.toLowerCase();
        
		String day = "";
		String month = "";
		String date = "";
		String time = "";
        
		ArrayList<String> words = segmentWords(data);
		for(int i = 0; i < words.size(); i++) {
			String word = words.get(i);
			if(isDateWord(word)) {
				day = word;
				if(i + 2 < words.size() && words.get(i + 1).equals("the")) {
					date = words.get(i + 2);
				} else if(i + 2 < words.size() && words.get(i + 1).equals("at")) {
					time = words.get(i + 2);
				}
			}
			if(isMonthWord(word)) {
				month = word;
                
                //checks if they phrase is "1st  of January" or "2nd of March"
				if(i + 1 < words.size() && (words.get(i + 1).indexOf("st") != -1 || words.get(i + 1).indexOf("nd") != -1 || words.get(i + 1).indexOf("rd") != -1 || words.get(i + 1).indexOf("th") != -1)) {
					date = words.get(i + 1);
				}
			}
            if(word.equals("today")) {
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date d = new Date();
				int num = Integer.parseInt(dateFormat.format(d).substring(5, 7));
				month = months[num - 1];
				date = dateFormat.format(d).substring(8, 10);
                time = dateFormat.format(d).substring(11,19);
			}
		}
        //checks if no day or month is mentioned. if so sets day and month to today's time
		if(day.equals("") == false && month.equals("")) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date d = new Date();
			int num = Integer.parseInt(dateFormat.format(d).substring(5, 7));
			month = months[num - 1];
		}
		if(time.equals("")) {
			time = "8:00 AM";
		}
        
        
		ret = day + ", " + month + " " + date + " " + time;
		return ret;
	}
    

}
