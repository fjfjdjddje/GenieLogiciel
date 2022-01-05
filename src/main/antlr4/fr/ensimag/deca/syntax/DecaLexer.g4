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
<<<<<<< HEAD
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

=======
>>>>>>> 4e705c63745e859b5c2fa3df6512261794a3e4ca
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
<<<<<<< HEAD
LT : '<';
GT : '>';
EQEQ : '==';
=======
LOWER : '<';
HIGHER : '>';
>>>>>>> 4e705c63745e859b5c2fa3df6512261794a3e4ca
EQUALS : '=';
PLUS : '+';
MINUS : '-';
TIMES : '*';
<<<<<<< HEAD
SLASH : '/';
PERCENT : '%';
=======
BACKSLASH : '/';
PERCENTAGE : '%';
DOT : '.';
>>>>>>> 4e705c63745e859b5c2fa3df6512261794a3e4ca
COMMA : ',';
OPARENT : '(';
CPARENT : ')';
OBRACE : '{';
CBRACE : '}';
<<<<<<< HEAD
EXCLAM : '!';
SEMI : ';';
=======
EXCLAMATION_POINT : '!';
SEMI : ';';
DOUBLE_EQUAL : '==';
>>>>>>> 4e705c63745e859b5c2fa3df6512261794a3e4ca
NEQ : '!=';
LEQ : '>=';
GEQ : '<=';
AND : '&&';
OR : '||';
<<<<<<< HEAD
IDENT : (LETTER | '$' | '_')(LETTER | DIGIT | '$' | '_')*;
FLOAT : FLOATDEC | FLOATHEX;
DOT : '.';
INT : '0' | POSITIVE_DIGIT DIGIT*;
STRING : '"' (STRING_CAR | '\\"' | '\\\\')* '"';
=======
fragment LETTER :'a'..'z' | 'A'..'Z';
fragment DIGIT : '0'..'9';
IDENT : (LETTER | '$' | '_')(LETTER | DIGIT | '$' | '_')*;
fragment POSITIVE_DIGIT : '1'..'9';
INT : '0' | POSITIVE_DIGIT DIGIT*;
fragment NUM : DIGIT+;
fragment SIGN : '+' | '-' | ' ';
fragment EXP : ('E' | 'e') SIGN NUM;
fragment DEC : NUM '.' NUM;
FLOATDEC : (DEC | DEC EXP) ('F' | 'f' | ' ');
fragment DIGITHEX : '0'..'9' | 'A'..'F' | 'a'..'f';
fragment NUMHEX : DIGITHEX|;
fragment FLOATHEX : ('0x' | '0X') NUMHEX '.' NUMHEX ('P' | 'p') SIGN NUM ('F' | 'f' | ' ');
FLOAT : FLOATDEC | FLOATHEX;
fragment STRING_CAR : ~('\n'|'"'|'\\');
STRING : '"' (STRING_CAR | '\\"' | '\\\\')* '"';
fragment EOL : '\n';
>>>>>>> 4e705c63745e859b5c2fa3df6512261794a3e4ca
MULTI_LINE_STRING : '"' (STRING_CAR | EOL | '\\"' | '\\\\')* '"';
