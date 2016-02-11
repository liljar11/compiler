package compiler;

public class Parser {
	
	private Token nextToken = null;
	private Lexer lexer = null;
	
	
	public Parser(Lexer myLexer) {
		lexer = myLexer;

	}
	
	public void parse() {
		
		nextToken = lexer.nextToken();
		Statements();
		
	}
	
	void Statements(){
		
		if(nextToken.tCode == Token.TokenCode.END){
			return;
		}
		
		else if(nextToken.tCode == Token.TokenCode.ERROR)
		{
			Error();
			//vilju exita
		}
	
		else{
			Statement();
			//otharfi a hafa semikommu compaire 
			Statements();
	
		}
		
	}
	
	void Statement(){
		if(nextToken.tCode == Token.TokenCode.ID){
			System.out.println("PUSH " + nextToken.lexeme);
			nextToken = lexer.nextToken();
	
				if(nextToken.tCode == Token.TokenCode.ASSIGN){
					
					nextToken = lexer.nextToken();{
	
					Expr();
					System.out.println("ASSIGN");
				} 
			}
				else {
					Error();
					}
		}
		else if(nextToken.tCode == Token.TokenCode.PRINT){
			nextToken = lexer.nextToken();
					if(nextToken.tCode == Token.TokenCode.ID){
						System.out.println("PUSH " + nextToken.lexeme);
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
			if (nextToken.tCode == Token.TokenCode.ADD){
					nextToken = lexer.nextToken();
					Expr();
					System.out.println("ADD");
			}
			if (nextToken.tCode == Token.TokenCode.SUB){
				nextToken = lexer.nextToken();
				Expr();
				System.out.println("SUB");

		}
	}
	
	void Term() {
		Factor();
		if(nextToken.tCode == Token.TokenCode.MULT)
		{
			nextToken = lexer.nextToken();
			Term();
			System.out.println("MULT");

		}
		Statements();
		
	}
	
	void Factor(){
		if(nextToken.tCode == Token.TokenCode.INT)
		{
			System.out.println("PUSH " + nextToken.lexeme);
			nextToken = lexer.nextToken();
		}
		if(nextToken.tCode == Token.TokenCode.ID)
		{
			System.out.println("PUSH " + nextToken.lexeme);
			nextToken = lexer.nextToken();
		}
		if(nextToken.tCode == Token.TokenCode.LPAREN){
			nextToken = lexer.nextToken();
			Expr();
				if(nextToken.tCode == Token.TokenCode.RPAREN)
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
