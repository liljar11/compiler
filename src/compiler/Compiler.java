package compiler;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Compiler {

	public static void main(String[] args) {
		
		Lexer myLexer = new Lexer();
		Parser myParser = new Parser(myLexer);
		myParser.parse();
		
	}
	File inputfile = new File("input.txt");
	File outputfile = new File("output.l");
	
	FileReader fr = new FileReader(inputfile); //les file-inn inn i array
	char[] arr = new char[50];
	fr.read(arr);
	
	
	
	
	
	
	FileWriter writer = new FileWriter(outputfile); //les shittið inn i fileinn sem er sendur i interpreter
	writer.write("eitthvaðsniðugt");
	writer.flush();
	writer.close();
}
