package codigo;
import static codigo.Tokens.*;
%%
%class Scanner
%type Tokens
%line
%column
%{
	
	public int linea() { return yyline + 1; }
	public int columna() {return yycolumn +1;}
%}
%init{
yyline = 0;
yycolumn = 0;
%init}

BLANCO = [ \t\r\n]
DIGITO = [0-9]
LETRA = [a-zA-Z]
IDENTIFICADOR = {LETRA}({LETRA}|{DIGITO{})*

%%
"main"	{ return TOK_MAIN;}
"int"		{ return TOK_INT;}
"boolean"	{ return TOK_BOOLEAN;}
"if"	{ return TOK_IF;}
"else"	{ return TOK_ELSE;}
"while"	{ return TOK_WHILE;}
"scanf"	{ return TOK_SCANF;}
"printf"	{ return TOK_PRINTF;}
"false"	{ return TOK_FALSE;}
"true"	{ return TOK_TRUE;}
";"	{ return TOK_PUNTOYCOMA;}
","	{ return TOK_COMA;}
"("	{ return TOK_PARENTESISIZQUIERDO;}
")"	{ return TOK_PARENTESISDERECHO ;}
"{"	{ return TOK_LLAVEIZQUIERDA;}
"}"	{ return TOK_LLAVEDERECHA;}
"="	{ return TOK_ASIGNACION ;}
"+"	{ return TOK_MAS;}
"-"	{ return TOK_MENOS;}
"/"	{ return TOK_DIVISION;}
"*"	{ return TOK_ASTERISCO;}
"&&"	{ return TOK_AND;}
"||"	{ return TOK_OR;}
"!"		{ return TOK_NOT;}
"=="	{ return TOK_IGUAL;}
"!="	{ return TOK_DISTINTO;}
"<="	{ return TOK_MENORIGUAL;}
">="	{ return TOK_MAYORIGUAL;}
"<"	{ return TOK_MENOR;}
">"	{ return TOK_MAYOR;}
{IDENTIFICADOR} {
					if (yylenght()>100)
					{
						return TOK_ERROR;
						
					} else {
					
						return TOK_IDENTIFICADOR;
					
					}
				}
"//".* {}
{BLANCO}+ {}
.	{ return TOK_ERROR;}
