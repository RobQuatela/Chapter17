package fileMatching;

public class CreateFilesTest {

	public static void main(String[] args) {
		CreateFiles oldMast = new CreateFiles();
		CreateFiles trans = new CreateFiles();
		
		//oldMast.openOldMastFile();
		//oldMast.writeOldMastFile();
		//oldMast.closeFile();
		
		trans.openTransFile();
		trans.writeTransFile();
		trans.closeFile();
	}
}
