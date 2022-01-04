// Generated from /user/2/.base/hassouk/home/Projet_GL/src/main/antlr4/fr/ensimag/deca/syntax/DecaLexer.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DecaLexer extends AbstractDecaLexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, COMMENT=2, INCLUDE=3, ELSE=4, IF=5, SPACE=6, ELSEIF=7, ASM=8, CLASS=9, 
		EXTENDS=10, FALSE=11, INSTANCEOF=12, NEW=13, NULL=14, READINT=15, READFLOAT=16, 
		PRINT=17, PRINTLN=18, PRINTLNX=19, PRINTX=20, PROTECTED=21, RETURN=22, 
		THIS=23, TRUE=24, WHILE=25, LOWER=26, HIGHER=27, EQUALS=28, PLUS=29, MINUS=30, 
		TIMES=31, BACKSLASH=32, PERCENTAGE=33, DOT=34, COMMA=35, OPARENT=36, CPARENT=37, 
		OBRACE=38, CBRACE=39, EXCLAMATION_POINT=40, SEMI=41, DOUBLE_EQUAL=42, 
		NEQ=43, LEQ=44, GEQ=45, AND=46, OR=47, IDENT=48, INT=49, FLOATDEC=50, 
		FLOAT=51, STRING=52, MULTI_LINE_STRING=53;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"FILENAME", "WS", "COMMENT", "INCLUDE", "ELSE", "IF", "SPACE", "ELSEIF", 
			"ASM", "CLASS", "EXTENDS", "FALSE", "INSTANCEOF", "NEW", "NULL", "READINT", 
			"READFLOAT", "PRINT", "PRINTLN", "PRINTLNX", "PRINTX", "PROTECTED", "RETURN", 
			"THIS", "TRUE", "WHILE", "LOWER", "HIGHER", "EQUALS", "PLUS", "MINUS", 
			"TIMES", "BACKSLASH", "PERCENTAGE", "DOT", "COMMA", "OPARENT", "CPARENT", 
			"OBRACE", "CBRACE", "EXCLAMATION_POINT", "SEMI", "DOUBLE_EQUAL", "NEQ", 
			"LEQ", "GEQ", "AND", "OR", "LETTER", "DIGIT", "IDENT", "POSITIVE_DIGIT", 
			"INT", "NUM", "SIGN", "EXP", "DEC", "FLOATDEC", "DIGITHEX", "NUMHEX", 
			"FLOATHEX", "FLOAT", "STRING_CAR", "STRING", "EOL", "MULTI_LINE_STRING"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'else'", "'if'", "' '", null, "'asm'", "'class'", 
			"'extends'", "'false'", "'instanceof'", "'new'", "'null'", "'readInt'", 
			"'readFloat'", "'print'", "'println'", "'printlnx'", "'printx'", "'protected'", 
			"'return'", "'this'", "'true'", "'while'", "'<'", "'>'", "'='", "'+'", 
			"'-'", "'*'", "'/'", "'%'", "'.'", "','", "'('", "')'", "'{'", "'}'", 
			"'!'", "';'", "'=='", "'!='", "'>='", "'<='", "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "COMMENT", "INCLUDE", "ELSE", "IF", "SPACE", "ELSEIF", "ASM", 
			"CLASS", "EXTENDS", "FALSE", "INSTANCEOF", "NEW", "NULL", "READINT", 
			"READFLOAT", "PRINT", "PRINTLN", "PRINTLNX", "PRINTX", "PROTECTED", "RETURN", 
			"THIS", "TRUE", "WHILE", "LOWER", "HIGHER", "EQUALS", "PLUS", "MINUS", 
			"TIMES", "BACKSLASH", "PERCENTAGE", "DOT", "COMMA", "OPARENT", "CPARENT", 
			"OBRACE", "CBRACE", "EXCLAMATION_POINT", "SEMI", "DOUBLE_EQUAL", "NEQ", 
			"LEQ", "GEQ", "AND", "OR", "IDENT", "INT", "FLOATDEC", "FLOAT", "STRING", 
			"MULTI_LINE_STRING"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}




	public DecaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DecaLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 1:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		case 2:
			COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 6:
			SPACE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			              skip();
			          
			break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			 skip(); 
			break;
		}
	}
	private void SPACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			skip();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\67\u01f2\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\3\2\6\2\u0089\n\2\r\2\16\2\u008a"+
		"\3\2\6\2\u008e\n\2\r\2\16\2\u008f\3\2\6\2\u0093\n\2\r\2\16\2\u0094\3\2"+
		"\6\2\u0098\n\2\r\2\16\2\u0099\3\2\3\2\6\2\u009e\n\2\r\2\16\2\u009f\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\7\4\u00a9\n\4\f\4\16\4\u00ac\13\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u00bd\n\5\f\5\16"+
		"\5\u00c0\13\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3"+
		"!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3"+
		",\3,\3-\3-\3-\3.\3.\3.\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62"+
		"\3\63\3\63\3\64\3\64\5\64\u018f\n\64\3\64\3\64\3\64\7\64\u0194\n\64\f"+
		"\64\16\64\u0197\13\64\3\65\3\65\3\66\3\66\3\66\7\66\u019e\n\66\f\66\16"+
		"\66\u01a1\13\66\5\66\u01a3\n\66\3\67\6\67\u01a6\n\67\r\67\16\67\u01a7"+
		"\38\38\39\39\39\39\3:\3:\3:\3:\3;\3;\3;\3;\5;\u01b8\n;\3;\3;\3<\3<\3="+
		"\3=\5=\u01c0\n=\3>\3>\3>\3>\5>\u01c6\n>\3>\3>\3>\3>\3>\3>\3>\3>\3?\3?"+
		"\5?\u01d2\n?\3@\3@\3A\3A\3A\3A\3A\3A\7A\u01dc\nA\fA\16A\u01df\13A\3A\3"+
		"A\3B\3B\3C\3C\3C\3C\3C\3C\3C\7C\u01ec\nC\fC\16C\u01ef\13C\3C\3C\3\u00aa"+
		"\2D\3\2\5\3\7\4\t\5\13\6\r\7\17\b\21\t\23\n\25\13\27\f\31\r\33\16\35\17"+
		"\37\20!\21#\22%\23\'\24)\25+\26-\27/\30\61\31\63\32\65\33\67\349\35;\36"+
		"=\37? A!C\"E#G$I%K&M\'O(Q)S*U+W,Y-[.]/_\60a\61c\2e\2g\62i\2k\63m\2o\2"+
		"q\2s\2u\64w\2y\2{\2}\65\177\2\u0081\66\u0083\2\u0085\67\3\2\13\4\2\13"+
		"\f\17\17\4\2C\\c|\4\2&&aa\5\2\"\"--//\4\2GGgg\5\2\"\"HHhh\5\2\62;CHch"+
		"\4\2RRrr\5\2\f\f$$^^\2\u01fd\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2"+
		"\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2"+
		"\2_\3\2\2\2\2a\3\2\2\2\2g\3\2\2\2\2k\3\2\2\2\2u\3\2\2\2\2}\3\2\2\2\2\u0081"+
		"\3\2\2\2\2\u0085\3\2\2\2\3\u009d\3\2\2\2\5\u00a1\3\2\2\2\7\u00a4\3\2\2"+
		"\2\t\u00b2\3\2\2\2\13\u00c5\3\2\2\2\r\u00ca\3\2\2\2\17\u00cd\3\2\2\2\21"+
		"\u00d0\3\2\2\2\23\u00d9\3\2\2\2\25\u00dd\3\2\2\2\27\u00e3\3\2\2\2\31\u00eb"+
		"\3\2\2\2\33\u00f1\3\2\2\2\35\u00fc\3\2\2\2\37\u0100\3\2\2\2!\u0105\3\2"+
		"\2\2#\u010d\3\2\2\2%\u0117\3\2\2\2\'\u011d\3\2\2\2)\u0125\3\2\2\2+\u012e"+
		"\3\2\2\2-\u0135\3\2\2\2/\u013f\3\2\2\2\61\u0146\3\2\2\2\63\u014b\3\2\2"+
		"\2\65\u0150\3\2\2\2\67\u0156\3\2\2\29\u0158\3\2\2\2;\u015a\3\2\2\2=\u015c"+
		"\3\2\2\2?\u015e\3\2\2\2A\u0160\3\2\2\2C\u0162\3\2\2\2E\u0164\3\2\2\2G"+
		"\u0166\3\2\2\2I\u0168\3\2\2\2K\u016a\3\2\2\2M\u016c\3\2\2\2O\u016e\3\2"+
		"\2\2Q\u0170\3\2\2\2S\u0172\3\2\2\2U\u0174\3\2\2\2W\u0176\3\2\2\2Y\u0179"+
		"\3\2\2\2[\u017c\3\2\2\2]\u017f\3\2\2\2_\u0182\3\2\2\2a\u0185\3\2\2\2c"+
		"\u0188\3\2\2\2e\u018a\3\2\2\2g\u018e\3\2\2\2i\u0198\3\2\2\2k\u01a2\3\2"+
		"\2\2m\u01a5\3\2\2\2o\u01a9\3\2\2\2q\u01ab\3\2\2\2s\u01af\3\2\2\2u\u01b7"+
		"\3\2\2\2w\u01bb\3\2\2\2y\u01bf\3\2\2\2{\u01c5\3\2\2\2}\u01d1\3\2\2\2\177"+
		"\u01d3\3\2\2\2\u0081\u01d5\3\2\2\2\u0083\u01e2\3\2\2\2\u0085\u01e4\3\2"+
		"\2\2\u0087\u0089\5c\62\2\u0088\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u008e\5e"+
		"\63\2\u008d\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u008d\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091\u0093\7\60\2\2\u0092\u0091\3"+
		"\2\2\2\u0093\u0094\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\u0097\3\2\2\2\u0096\u0098\7/\2\2\u0097\u0096\3\2\2\2\u0098\u0099\3\2"+
		"\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\u009c\7a\2\2\u009c\u009e\3\2\2\2\u009d\u0088\3\2\2\2\u009e\u009f\3\2"+
		"\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\4\3\2\2\2\u00a1\u00a2"+
		"\t\2\2\2\u00a2\u00a3\b\3\2\2\u00a3\6\3\2\2\2\u00a4\u00a5\7\61\2\2\u00a5"+
		"\u00a6\7,\2\2\u00a6\u00aa\3\2\2\2\u00a7\u00a9\13\2\2\2\u00a8\u00a7\3\2"+
		"\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00ab\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab"+
		"\u00ad\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00ae\7,\2\2\u00ae\u00af\7\61"+
		"\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\b\4\3\2\u00b1\b\3\2\2\2\u00b2\u00b3"+
		"\7%\2\2\u00b3\u00b4\7k\2\2\u00b4\u00b5\7p\2\2\u00b5\u00b6\7e\2\2\u00b6"+
		"\u00b7\7n\2\2\u00b7\u00b8\7w\2\2\u00b8\u00b9\7f\2\2\u00b9\u00ba\7g\2\2"+
		"\u00ba\u00be\3\2\2\2\u00bb\u00bd\7\"\2\2\u00bc\u00bb\3\2\2\2\u00bd\u00c0"+
		"\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c1\3\2\2\2\u00c0"+
		"\u00be\3\2\2\2\u00c1\u00c2\7$\2\2\u00c2\u00c3\5\3\2\2\u00c3\u00c4\7$\2"+
		"\2\u00c4\n\3\2\2\2\u00c5\u00c6\7g\2\2\u00c6\u00c7\7n\2\2\u00c7\u00c8\7"+
		"u\2\2\u00c8\u00c9\7g\2\2\u00c9\f\3\2\2\2\u00ca\u00cb\7k\2\2\u00cb\u00cc"+
		"\7h\2\2\u00cc\16\3\2\2\2\u00cd\u00ce\7\"\2\2\u00ce\u00cf\b\b\4\2\u00cf"+
		"\20\3\2\2\2\u00d0\u00d1\7g\2\2\u00d1\u00d2\7n\2\2\u00d2\u00d3\7u\2\2\u00d3"+
		"\u00d4\7g\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\5\17\b\2\u00d6\u00d7\7k"+
		"\2\2\u00d7\u00d8\7h\2\2\u00d8\22\3\2\2\2\u00d9\u00da\7c\2\2\u00da\u00db"+
		"\7u\2\2\u00db\u00dc\7o\2\2\u00dc\24\3\2\2\2\u00dd\u00de\7e\2\2\u00de\u00df"+
		"\7n\2\2\u00df\u00e0\7c\2\2\u00e0\u00e1\7u\2\2\u00e1\u00e2\7u\2\2\u00e2"+
		"\26\3\2\2\2\u00e3\u00e4\7g\2\2\u00e4\u00e5\7z\2\2\u00e5\u00e6\7v\2\2\u00e6"+
		"\u00e7\7g\2\2\u00e7\u00e8\7p\2\2\u00e8\u00e9\7f\2\2\u00e9\u00ea\7u\2\2"+
		"\u00ea\30\3\2\2\2\u00eb\u00ec\7h\2\2\u00ec\u00ed\7c\2\2\u00ed\u00ee\7"+
		"n\2\2\u00ee\u00ef\7u\2\2\u00ef\u00f0\7g\2\2\u00f0\32\3\2\2\2\u00f1\u00f2"+
		"\7k\2\2\u00f2\u00f3\7p\2\2\u00f3\u00f4\7u\2\2\u00f4\u00f5\7v\2\2\u00f5"+
		"\u00f6\7c\2\2\u00f6\u00f7\7p\2\2\u00f7\u00f8\7e\2\2\u00f8\u00f9\7g\2\2"+
		"\u00f9\u00fa\7q\2\2\u00fa\u00fb\7h\2\2\u00fb\34\3\2\2\2\u00fc\u00fd\7"+
		"p\2\2\u00fd\u00fe\7g\2\2\u00fe\u00ff\7y\2\2\u00ff\36\3\2\2\2\u0100\u0101"+
		"\7p\2\2\u0101\u0102\7w\2\2\u0102\u0103\7n\2\2\u0103\u0104\7n\2\2\u0104"+
		" \3\2\2\2\u0105\u0106\7t\2\2\u0106\u0107\7g\2\2\u0107\u0108\7c\2\2\u0108"+
		"\u0109\7f\2\2\u0109\u010a\7K\2\2\u010a\u010b\7p\2\2\u010b\u010c\7v\2\2"+
		"\u010c\"\3\2\2\2\u010d\u010e\7t\2\2\u010e\u010f\7g\2\2\u010f\u0110\7c"+
		"\2\2\u0110\u0111\7f\2\2\u0111\u0112\7H\2\2\u0112\u0113\7n\2\2\u0113\u0114"+
		"\7q\2\2\u0114\u0115\7c\2\2\u0115\u0116\7v\2\2\u0116$\3\2\2\2\u0117\u0118"+
		"\7r\2\2\u0118\u0119\7t\2\2\u0119\u011a\7k\2\2\u011a\u011b\7p\2\2\u011b"+
		"\u011c\7v\2\2\u011c&\3\2\2\2\u011d\u011e\7r\2\2\u011e\u011f\7t\2\2\u011f"+
		"\u0120\7k\2\2\u0120\u0121\7p\2\2\u0121\u0122\7v\2\2\u0122\u0123\7n\2\2"+
		"\u0123\u0124\7p\2\2\u0124(\3\2\2\2\u0125\u0126\7r\2\2\u0126\u0127\7t\2"+
		"\2\u0127\u0128\7k\2\2\u0128\u0129\7p\2\2\u0129\u012a\7v\2\2\u012a\u012b"+
		"\7n\2\2\u012b\u012c\7p\2\2\u012c\u012d\7z\2\2\u012d*\3\2\2\2\u012e\u012f"+
		"\7r\2\2\u012f\u0130\7t\2\2\u0130\u0131\7k\2\2\u0131\u0132\7p\2\2\u0132"+
		"\u0133\7v\2\2\u0133\u0134\7z\2\2\u0134,\3\2\2\2\u0135\u0136\7r\2\2\u0136"+
		"\u0137\7t\2\2\u0137\u0138\7q\2\2\u0138\u0139\7v\2\2\u0139\u013a\7g\2\2"+
		"\u013a\u013b\7e\2\2\u013b\u013c\7v\2\2\u013c\u013d\7g\2\2\u013d\u013e"+
		"\7f\2\2\u013e.\3\2\2\2\u013f\u0140\7t\2\2\u0140\u0141\7g\2\2\u0141\u0142"+
		"\7v\2\2\u0142\u0143\7w\2\2\u0143\u0144\7t\2\2\u0144\u0145\7p\2\2\u0145"+
		"\60\3\2\2\2\u0146\u0147\7v\2\2\u0147\u0148\7j\2\2\u0148\u0149\7k\2\2\u0149"+
		"\u014a\7u\2\2\u014a\62\3\2\2\2\u014b\u014c\7v\2\2\u014c\u014d\7t\2\2\u014d"+
		"\u014e\7w\2\2\u014e\u014f\7g\2\2\u014f\64\3\2\2\2\u0150\u0151\7y\2\2\u0151"+
		"\u0152\7j\2\2\u0152\u0153\7k\2\2\u0153\u0154\7n\2\2\u0154\u0155\7g\2\2"+
		"\u0155\66\3\2\2\2\u0156\u0157\7>\2\2\u01578\3\2\2\2\u0158\u0159\7@\2\2"+
		"\u0159:\3\2\2\2\u015a\u015b\7?\2\2\u015b<\3\2\2\2\u015c\u015d\7-\2\2\u015d"+
		">\3\2\2\2\u015e\u015f\7/\2\2\u015f@\3\2\2\2\u0160\u0161\7,\2\2\u0161B"+
		"\3\2\2\2\u0162\u0163\7\61\2\2\u0163D\3\2\2\2\u0164\u0165\7\'\2\2\u0165"+
		"F\3\2\2\2\u0166\u0167\7\60\2\2\u0167H\3\2\2\2\u0168\u0169\7.\2\2\u0169"+
		"J\3\2\2\2\u016a\u016b\7*\2\2\u016bL\3\2\2\2\u016c\u016d\7+\2\2\u016dN"+
		"\3\2\2\2\u016e\u016f\7}\2\2\u016fP\3\2\2\2\u0170\u0171\7\177\2\2\u0171"+
		"R\3\2\2\2\u0172\u0173\7#\2\2\u0173T\3\2\2\2\u0174\u0175\7=\2\2\u0175V"+
		"\3\2\2\2\u0176\u0177\7?\2\2\u0177\u0178\7?\2\2\u0178X\3\2\2\2\u0179\u017a"+
		"\7#\2\2\u017a\u017b\7?\2\2\u017bZ\3\2\2\2\u017c\u017d\7@\2\2\u017d\u017e"+
		"\7?\2\2\u017e\\\3\2\2\2\u017f\u0180\7>\2\2\u0180\u0181\7?\2\2\u0181^\3"+
		"\2\2\2\u0182\u0183\7(\2\2\u0183\u0184\7(\2\2\u0184`\3\2\2\2\u0185\u0186"+
		"\7~\2\2\u0186\u0187\7~\2\2\u0187b\3\2\2\2\u0188\u0189\t\3\2\2\u0189d\3"+
		"\2\2\2\u018a\u018b\4\62;\2\u018bf\3\2\2\2\u018c\u018f\5c\62\2\u018d\u018f"+
		"\t\4\2\2\u018e\u018c\3\2\2\2\u018e\u018d\3\2\2\2\u018f\u0195\3\2\2\2\u0190"+
		"\u0194\5c\62\2\u0191\u0194\5e\63\2\u0192\u0194\t\4\2\2\u0193\u0190\3\2"+
		"\2\2\u0193\u0191\3\2\2\2\u0193\u0192\3\2\2\2\u0194\u0197\3\2\2\2\u0195"+
		"\u0193\3\2\2\2\u0195\u0196\3\2\2\2\u0196h\3\2\2\2\u0197\u0195\3\2\2\2"+
		"\u0198\u0199\4\63;\2\u0199j\3\2\2\2\u019a\u01a3\7\62\2\2\u019b\u019f\5"+
		"i\65\2\u019c\u019e\5e\63\2\u019d\u019c\3\2\2\2\u019e\u01a1\3\2\2\2\u019f"+
		"\u019d\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u01a3\3\2\2\2\u01a1\u019f\3\2"+
		"\2\2\u01a2\u019a\3\2\2\2\u01a2\u019b\3\2\2\2\u01a3l\3\2\2\2\u01a4\u01a6"+
		"\5e\63\2\u01a5\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a7"+
		"\u01a8\3\2\2\2\u01a8n\3\2\2\2\u01a9\u01aa\t\5\2\2\u01aap\3\2\2\2\u01ab"+
		"\u01ac\t\6\2\2\u01ac\u01ad\5o8\2\u01ad\u01ae\5m\67\2\u01aer\3\2\2\2\u01af"+
		"\u01b0\5m\67\2\u01b0\u01b1\7\60\2\2\u01b1\u01b2\5m\67\2\u01b2t\3\2\2\2"+
		"\u01b3\u01b8\5s:\2\u01b4\u01b5\5s:\2\u01b5\u01b6\5q9\2\u01b6\u01b8\3\2"+
		"\2\2\u01b7\u01b3\3\2\2\2\u01b7\u01b4\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9"+
		"\u01ba\t\7\2\2\u01bav\3\2\2\2\u01bb\u01bc\t\b\2\2\u01bcx\3\2\2\2\u01bd"+
		"\u01c0\5w<\2\u01be\u01c0\3\2\2\2\u01bf\u01bd\3\2\2\2\u01bf\u01be\3\2\2"+
		"\2\u01c0z\3\2\2\2\u01c1\u01c2\7\62\2\2\u01c2\u01c6\7z\2\2\u01c3\u01c4"+
		"\7\62\2\2\u01c4\u01c6\7Z\2\2\u01c5\u01c1\3\2\2\2\u01c5\u01c3\3\2\2\2\u01c6"+
		"\u01c7\3\2\2\2\u01c7\u01c8\5y=\2\u01c8\u01c9\7\60\2\2\u01c9\u01ca\5y="+
		"\2\u01ca\u01cb\t\t\2\2\u01cb\u01cc\5o8\2\u01cc\u01cd\5m\67\2\u01cd\u01ce"+
		"\t\7\2\2\u01ce|\3\2\2\2\u01cf\u01d2\5u;\2\u01d0\u01d2\5{>\2\u01d1\u01cf"+
		"\3\2\2\2\u01d1\u01d0\3\2\2\2\u01d2~\3\2\2\2\u01d3\u01d4\n\n\2\2\u01d4"+
		"\u0080\3\2\2\2\u01d5\u01dd\7$\2\2\u01d6\u01dc\5\177@\2\u01d7\u01d8\7^"+
		"\2\2\u01d8\u01dc\7$\2\2\u01d9\u01da\7^\2\2\u01da\u01dc\7^\2\2\u01db\u01d6"+
		"\3\2\2\2\u01db\u01d7\3\2\2\2\u01db\u01d9\3\2\2\2\u01dc\u01df\3\2\2\2\u01dd"+
		"\u01db\3\2\2\2\u01dd\u01de\3\2\2\2\u01de\u01e0\3\2\2\2\u01df\u01dd\3\2"+
		"\2\2\u01e0\u01e1\7$\2\2\u01e1\u0082\3\2\2\2\u01e2\u01e3\7\f\2\2\u01e3"+
		"\u0084\3\2\2\2\u01e4\u01ed\7$\2\2\u01e5\u01ec\5\177@\2\u01e6\u01ec\5\u0083"+
		"B\2\u01e7\u01e8\7^\2\2\u01e8\u01ec\7$\2\2\u01e9\u01ea\7^\2\2\u01ea\u01ec"+
		"\7^\2\2\u01eb\u01e5\3\2\2\2\u01eb\u01e6\3\2\2\2\u01eb\u01e7\3\2\2\2\u01eb"+
		"\u01e9\3\2\2\2\u01ec\u01ef\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ed\u01ee\3\2"+
		"\2\2\u01ee\u01f0\3\2\2\2\u01ef\u01ed\3\2\2\2\u01f0\u01f1\7$\2\2\u01f1"+
		"\u0086\3\2\2\2\30\2\u008a\u008f\u0094\u0099\u009f\u00aa\u00be\u018e\u0193"+
		"\u0195\u019f\u01a2\u01a7\u01b7\u01bf\u01c5\u01d1\u01db\u01dd\u01eb\u01ed"+
		"\5\3\3\2\3\4\3\3\b\4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}