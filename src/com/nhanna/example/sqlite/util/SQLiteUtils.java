package com.nhanna.example.sqlite.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;

public final class SQLiteUtils {

	/**
	 * Copy's the database in the calling application's package
	 * @param context - {@link Context}
	 * @param out - location of the copied database
	 * @param databaseName - name of the database 
	 * @return true if successful
	 * @throws IOException
	 */
	public static boolean copyPackageDatabase(Context context, String out, String databaseName) throws IOException {
		try {
			File outFile = new File(out);
			if(!outFile.exists()) {
				outFile.mkdir();
			}
			outFile = new File(out+"/"+databaseName);
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(context.getDatabasePath(databaseName)));
			outFile.createNewFile();
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outFile));
			
			byte buf[] = new byte[4096];
			int count;
			while((count = bis.read(buf)) != -1) {
				bos.write(buf, 0, count);
				bos.flush();
			}
			bos.close();
			bis.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
