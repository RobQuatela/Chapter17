package fileMatching;

public class FileMatchTest {

	public static void main(String[] args) {
		FileMatch app = new FileMatch();
		
		app.openOldMastFile();
		app.matchFiles();
		app.closeFile();
	}
}
