package calculadora;

import java_cup.runtime.*;

%%

%cup
                                             
%line
%column

%{
	public int linea() { return yyline + 1; }
	public int columna() {return yycolumn + 1;}
%}

DIGITO = [0-9]
BLANCO = [ \t\r\n]
ENTERO = {DIGITO}+

%%
"("	{ return new Symbol(sym.TOK_PARI);}
")"	{ return new Symbol(sym.TOK_PARD);}
"+"	{ return new Symbol(sym.TOK_MAS);}
"-"	{ return new Symbol(sym.TOK_MENOS);}
"/"	{ return new Symbol(sym.TOK_DIVISION);}
"*"	{ return new Symbol(sym.TOK_PRODUCTO);}

{ENTERO}	{	
				return new Symbol(sym.TOK_CONSTANTE);
			}
{BLANCO}+	{}
.		{
			System.out.println("****Error morfológico en [lin " + linea() + ", col " + columna() + "]:SÍMBOLO NO PERMITIDO (" + yytext() + ")");				
			return new Symbol(sym.TOK_ERROR);
		}				