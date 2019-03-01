package main;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.ImageIcon;

public class Assets {
	
	public static String file(String file) {
		Path currentRelativePath = Paths.get("");
		String parent = currentRelativePath.toAbsolutePath().toString();
		
		String assetsDir = parent+"\\assets\\";
		
		String fileDir = assetsDir + file;
		
		if(new ImageIcon(fileDir).getImage().getWidth(null) <= 0) {
			return "No such file";
		}
		
		return fileDir;
	}

}
