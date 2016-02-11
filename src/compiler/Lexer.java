package compiler;

import java.util.Scanner;
import java.util.regex.Pattern;


public class Lexer {
	String in;
	String input = null; 
	Scanner sc = new Scanner(System.in);
	Token token = new Token();
	String regexInt = "[0-9]+";
	String regexChar = "[A-Za-z]+";

	public Token nextToken() {
		
		//whilelykkja scanner.hasnext()
		//ifsettningar t um allt
		if(sc.hasNext()){

	if(sc.hasNext(Pattern.compile(regexInt))){
		token.tCode = Token.TokenCode.INT;
		
	}
	else if(sc.hasNext(Pattern.compile(regexChar))){
		token.tCode = Token.TokenCode.ID;
		

	}
	else if(sc.hasNext("\\+"))
	{
		token.tCode = Token.TokenCode.ADD;
	}
	else if(sc.hasNext("\\-"))
	{
		token.tCode = Token.TokenCode.SUB;
	}
	else if(sc.hasNext("\\*"))
	{
		token.tCode = Token.TokenCode.MULT;
	}
	else if(sc.hasNext("\\="))
	{
		token.tCode = Token.TokenCode.ASSIGN;
	}
	else if(sc.hasNext("\\("))
	{
		token.tCode = Token.TokenCode.LPAREN;
	}
	else if(sc.hasNext("\\)"))
	{
		token.tCode = Token.TokenCode.RPAREN;
	}
	else if(sc.hasNext("\\;"))
	{
		token.tCode = Token.TokenCode.SEMICOL;
	}
	else if(sc.hasNext("end"))
	{
		token.tCode = Token.TokenCode.END;	
	}
	else if(sc.hasNext("print"))
	{
		token.tCode = Token.TokenCode.PRINT;
	}
	else{
		token.tCode = Token.TokenCode.ERROR;
	}
}
//	token.lexeme = sc.nextLine();
		return token;
	
			
}}

		
	




