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
			System.out.println("PUSH " + lexer.nextToken());
			nextToken = lexer.nextToken();
				if(nextToken == TokenCode.ASSIGN){
					nextToken = lexer.nextToken();{
					Expr();
					System.out.println("ASSIGN");
				} 
			}
				else {
					Error();
					}
		}
		else if(nextToken == TokenCode.PRINT){
			nextToken = lexer.nextToken();
					if(nextToken == TokenCode.ID){
						System.out.println("PUSH " + lexer.nextToken());
						System.out.println("PRINT");
						nextToken = lexer.nextToken();
			}
					else {
						Error();
					}
		}
	}
	
	void Expr(){
		Term();
			if (nextToken == TokenCode.ADD){
					nextToken = lexer.nextToken();
					Expr();
					System.out.println("ADD");
			}
			if (nextToken == TokenCode.SUB){
				nextToken = lexer.nextToken();
				Expr();
				System.out.println("SUB");

		}
	}
	
	void Term() {
		Factor();
		if(nextToken == TokenCode.MULT)
		{
			nextToken = lexer.nextToken();
			Term();
			System.out.println("MULT");

		}
		Statements();
		
	}
	
	void Factor(){
		if(nextToken == TokenCode.INT)
		{
			System.out.println("PUSH " + lexer.nextToken());
			nextToken = lexer.nextToken();
		}
		if(nextToken == TokenCode.ID)
		{
			System.out.println("PUSH " + lexer.nextToken());
			nextToken = lexer.nextToken();
		}
		if(nextToken == TokenCode.LPAREN){
			nextToken = lexer.nextToken();
			Expr();
				if(nextToken == TokenCode.RPAREN)
				{
					nextToken = lexer.nextToken();
				} else {
					Error();
				}
				}
		else {
			Error();
		}
		
	}
	void Error(){
		System.out.println("Syntax error");
		System.exit(0);
		
	}
}
