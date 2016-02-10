package compiler;

import compiler.Token.TokenCode;

public class Parser {
	TokenCode nextToken;
	Lexer lexer;
	public Parser(Lexer myLexer) {
		nextToken = lexer.nextToken();
		//parse();
		
		// TODO Auto-generated constructor stub
	}
	
	public void parse() {
		
		Statements();
		
	}
	
	void Statements(){
		
		if(nextToken == TokenCode.END){
			nextToken = lexer.nextToken();
		}
		
		Statement();
		if(nextToken == TokenCode.SEMICOL)
		{
			nextToken = lexer.nextToken();
			Statements();
		}
		
		
	}
	
	void Statement(){
		if(nextToken == TokenCode.ID){
			nextToken = lexer.nextToken();
			if(nextToken == TokenCode.ASSIGN){
				nextToken = lexer.nextToken();{
					Expr();
				}
			}
		}
		else if(nextToken == TokenCode.PRINT){
			nextToken = lexer.nextToken();
			if(nextToken == TokenCode.ID){
				nextToken = lexer.nextToken();
				Statements();
			}
		}
	}
	
	void Expr(){
		Term();
		if (nextToken == TokenCode.ADD){
			nextToken = lexer.nextToken();
			Expr();
		}
		if (nextToken == TokenCode.SUB){
			nextToken = lexer.nextToken();
			Expr();
		}
	}
	
	void Term() {
		Factor();
		if(nextToken == TokenCode.MULT)
		{
			nextToken = lexer.nextToken();
			Term();
		}
		Statements();
		
	}
	
	void Factor(){
		if(nextToken == TokenCode.INT)
		{
			nextToken = lexer.nextToken();
		}
		if(nextToken == TokenCode.ID)
		{
			nextToken = lexer.nextToken();
		}
		if(nextToken == TokenCode.LPAREN){
			nextToken = lexer.nextToken();
			Expr();
			if(nextToken == TokenCode.RPAREN)
			{
				nextToken = lexer.nextToken();
			}
		}
		
		
	}
}
