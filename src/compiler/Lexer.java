package compiler;

import compiler.Token.TokenCode;
import java.util.Scanner;

import javax.sound.sampled.Line;

import java.util.LinkedList;

public class Lexer {
	private LinkedList<String> line;
	public TokenCode nextToken(){
	//vantar scanner sem tekur input	
		return TokenCode.ASSIGN;
	}
/*	public Token nextToken(){
		while(line.isEmpty()){
			this.nextLine();
	}*/
		String token = line.removeFirst();
		
	if (token.matches("\\+")) return new Token(token, TokenCode.ADD);
	else if(token.matches("\\-")) return new Token(token, TokenCode.SUB);
	else if(token.matches("\\*")) return new Token(token, TokenCode.MULT);
	else if(token.matches("\\(")) return new Token(token, TokenCode.LPAREN);
	else if(token.matches("\\)")) return new Token(token, TokenCode.RPAREN);
	else if(token.matches("\\=")) return new Token(token, TokenCode.ASSIGN);
	else if(token.matches("\\;")) return new Token(token, TokenCode.SEMICOL);
	else if(token.matches("print")) return new Token(token, TokenCode.PRINT);
	else if(token.matches("end")) return new Token(token, TokenCode.END);
	else if(token.matches("error")) return new Token(token, TokenCode.ERROR);
	else if(token.matches("id")) return new Token(token, TokenCode.ID);
	else if(token.matches("int")) return new Token(token, TokenCode.INT);
	
	//else if(to)
}

}