package pl.edu.mimuw.gtimoszuk.db4o;

import java.io.File;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

/**
 * Utils class no test to be stored here
 * 
 * @author gtimoszuk
 * 
 */
public class BaseTest {

	protected static String DB4OFILENAME = "/tmp/testDB4Odb";

	protected static boolean freshDB = true;

	protected static ObjectContainer db = null;

	public static void dbSetup() {
		if (freshDB) {
			new File(DB4OFILENAME).delete();
		}
		db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),
				DB4OFILENAME);

	}

	public static void dbClose() {
		if (db != null) {
			db.close();
		}
	}

	protected static void listResult(List<?> result) {
		System.out.println(result.size());
		for (Object o : result) {
			System.out.println(o);
		}
	}
}