package compiler;

public class Token {
	enum TokenCode { ID, ASSIGN, SEMICOL, INT, ADD, SUB,
		MULT, LPAREN, RPAREN, PRINT, END, ERROR }

	
	String lexeme;
	TokenCode tCode;

}


