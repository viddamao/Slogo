package gui;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadAndWrite {

    public void write(String[] args, String path) {
	try {
	    File newTextFile = new File("src/images/thetextfile.txt");
	    FileWriter fw = new FileWriter(newTextFile);
	    for (String str : args) {
		fw.write(str);
	    }
	    fw.close();
	} catch (IOException iox) {
	    // do stuff with exception
	    iox.printStackTrace();
	}
    }

    public List<String> read(String source) throws IOException {
	Path path = Paths.get("src/images/thetextfile.txt");
	return Files.readAllLines(path);
    }
}