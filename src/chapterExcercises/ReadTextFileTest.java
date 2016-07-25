package chapterExcercises;

public class ReadTextFileTest {

	public static void main(String[] args) {
		ReatTextFile application = new ReatTextFile();
		
		application.openFile();
		application.readRecords();
		application.closeFile();
	}
}
