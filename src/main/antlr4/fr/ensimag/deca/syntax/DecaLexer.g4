lexer grammar DecaLexer;

options {
   language=Java;
   // Tell ANTLR to make the generated lexer class extend the
   // the named class, which is where any supporting code and
   // variables will be placed.
   superClass = AbstractDecaLexer;
}

@members {
}

// Deca lexer rules.
fragment FILENAME : (LETTER + DIGIT + '.' + '-' + '_')+;
fragment NUM : DIGIT+;
fragment SIGN : '+' | '-' | ' ';
fragment EXP : ('E' | 'e') SIGN NUM;
fragment LETTER :'a'..'z' | 'A'..'Z';
fragment DIGIT : '0'..'9';
fragment POSITIVE_DIGIT : '1'..'9';
fragment DIGITHEX : '0'..'9' | 'A'..'F' | 'a'..'f';
fragment NUMHEX : DIGITHEX|;
fragment DEC : NUM '.' NUM;
fragment FLOATDEC : (DEC | DEC EXP) ('F' | 'f' | );
fragment FLOATHEX : ('0x' | '0X') NUMHEX '.' NUMHEX ('P' | 'p') SIGN NUM ('F' | 'f' | ' ');
fragment STRING_CAR : ~('\n'|'"'|'\\');
fragment EOL : '\n';

WS  :   ( '\t'
        | '\r'
        | '\n'
        ) {
              skip();
          }
    ;
COMMENT : '/*' .*? '*/'{ skip(); };
INCLUDE : '#include' (' ')* '"' FILENAME '"';
ELSE : 'else';
IF : 'if';
SPACE : ' ' {skip();};
ELSEIF : 'else' SPACE 'if';
ASM : 'asm';
CLASS : 'class';
EXTENDS : 'extends';
FALSE : 'false';
INSTANCEOF : 'instanceof';
NEW : 'new';
NULL : 'null';
READINT : 'readInt';
READFLOAT : 'readFloat';
PRINT : 'print';
PRINTLN : 'println';
PRINTLNX : 'printlnx';
PRINTX : 'printx';
PROTECTED : 'protected';
RETURN : 'return';
THIS : 'this';
TRUE : 'true';
WHILE : 'while';
LT : '<';
GT : '>';
EQEQ : '==';
EQUALS : '=';
PLUS : '+';
MINUS : '-';
TIMES : '*';
SLASH : '/';
PERCENT : '%';
COMMA : ',';
OPARENT : '(';
CPARENT : ')';
OBRACE : '{';
CBRACE : '}';
EXCLAM : '!';
SEMI : ';';
NEQ : '!=';
LEQ : '>=';
GEQ : '<=';
AND : '&&';
OR : '||';
IDENT : (LETTER | '$' | '_')(LETTER | DIGIT | '$' | '_')*;
FLOAT : FLOATDEC | FLOATHEX;
DOT : '.';
INT : '0' | POSITIVE_DIGIT DIGIT*;
STRING : '"' (STRING_CAR | '\\"' | '\\\\')* '"';
MULTI_LINE_STRING : '"' (STRING_CAR | EOL | '\\"' | '\\\\')* '"';
