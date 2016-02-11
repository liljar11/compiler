package compiler;

import compiler.Token.TokenCode;

public class Parser {
	
	private TokenCode nextToken = null;
	private Lexer lexer = null;
	
	
	public Parser(Lexer myLexer) {
		nextToken = lexer.nextToken();
		//parse();
		
		// TODO Auto-generated constructor stub
	}
	
	public void parse() {
		
		nextToken = lexer.nextToken();
		Statements();
		
	}
	
	void Statements(){
		
		if(nextToken == TokenCode.END){
			return;
		}
		
		else if(nextToken == TokenCode.ERROR)
		{
			Error();
			//viljum síðan pottþétt exita
		}
	
		else{
			Statement();
			//óþarfi að hafa semíkommu compaire
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
	void Error(){
		
	}
}
