// Generated from /user/9/.base/boussemy/home/Projet_GL/src/main/antlr4/fr/ensimag/deca/syntax/DecaLexer.g4 by ANTLR 4.8
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
		THIS=23, TRUE=24, WHILE=25, LT=26, GT=27, EQEQ=28, EQUALS=29, PLUS=30, 
		MINUS=31, TIMES=32, SLASH=33, PERCENT=34, COMMA=35, OPARENT=36, CPARENT=37, 
		OBRACE=38, CBRACE=39, EXCLAM=40, SEMI=41, NEQ=42, LEQ=43, GEQ=44, AND=45, 
		OR=46, IDENT=47, FLOAT=48, DOT=49, INT=50, STRING=51, MULTI_LINE_STRING=52;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"FILENAME", "NUM", "SIGN", "EXP", "LETTER", "DIGIT", "POSITIVE_DIGIT", 
			"DIGITHEX", "NUMHEX", "DEC", "FLOATDEC", "FLOATHEX", "STRING_CAR", "EOL", 
			"WS", "COMMENT", "INCLUDE", "ELSE", "IF", "SPACE", "ELSEIF", "ASM", "CLASS", 
			"EXTENDS", "FALSE", "INSTANCEOF", "NEW", "NULL", "READINT", "READFLOAT", 
			"PRINT", "PRINTLN", "PRINTLNX", "PRINTX", "PROTECTED", "RETURN", "THIS", 
			"TRUE", "WHILE", "LT", "GT", "EQEQ", "EQUALS", "PLUS", "MINUS", "TIMES", 
			"SLASH", "PERCENT", "COMMA", "OPARENT", "CPARENT", "OBRACE", "CBRACE", 
			"EXCLAM", "SEMI", "NEQ", "LEQ", "GEQ", "AND", "OR", "IDENT", "FLOAT", 
			"DOT", "INT", "STRING", "MULTI_LINE_STRING"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'else'", "'if'", "' '", null, "'asm'", "'class'", 
			"'extends'", "'false'", "'instanceof'", "'new'", "'null'", "'readInt'", 
			"'readFloat'", "'print'", "'println'", "'printlnx'", "'printx'", "'protected'", 
			"'return'", "'this'", "'true'", "'while'", "'<'", "'>'", "'=='", "'='", 
			"'+'", "'-'", "'*'", "'/'", "'%'", "','", "'('", "')'", "'{'", "'}'", 
			"'!'", "';'", "'!='", "'>='", "'<='", "'&&'", "'||'", null, null, "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "COMMENT", "INCLUDE", "ELSE", "IF", "SPACE", "ELSEIF", "ASM", 
			"CLASS", "EXTENDS", "FALSE", "INSTANCEOF", "NEW", "NULL", "READINT", 
			"READFLOAT", "PRINT", "PRINTLN", "PRINTLNX", "PRINTX", "PROTECTED", "RETURN", 
			"THIS", "TRUE", "WHILE", "LT", "GT", "EQEQ", "EQUALS", "PLUS", "MINUS", 
			"TIMES", "SLASH", "PERCENT", "COMMA", "OPARENT", "CPARENT", "OBRACE", 
			"CBRACE", "EXCLAM", "SEMI", "NEQ", "LEQ", "GEQ", "AND", "OR", "IDENT", 
			"FLOAT", "DOT", "INT", "STRING", "MULTI_LINE_STRING"
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
		case 14:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		case 15:
			COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 19:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\66\u01f4\b\1\4\2"+
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
		"\6\3\u00a3\n\3\r\3\16\3\u00a4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\5\n\u00b7\n\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\5\f\u00c1\n\f\3\f\3\f\5\f\u00c5\n\f\3\r\3\r\3\r\3\r\5\r\u00cb\n\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3"+
		"\21\3\21\3\21\3\21\7\21\u00e0\n\21\f\21\16\21\u00e3\13\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u00f4"+
		"\n\22\f\22\16\22\u00f7\13\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3"+
		"\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3"+
		"\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3"+
		"\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\3)\3*\3*\3+\3+\3+\3,\3,\3-\3-\3.\3"+
		".\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3"+
		"\66\3\66\3\67\3\67\38\38\39\39\39\3:\3:\3:\3;\3;\3;\3<\3<\3<\3=\3=\3="+
		"\3>\3>\5>\u01c0\n>\3>\3>\3>\7>\u01c5\n>\f>\16>\u01c8\13>\3?\3?\5?\u01cc"+
		"\n?\3@\3@\3A\3A\3A\7A\u01d3\nA\fA\16A\u01d6\13A\5A\u01d8\nA\3B\3B\3B\3"+
		"B\3B\3B\7B\u01e0\nB\fB\16B\u01e3\13B\3B\3B\3C\3C\3C\3C\3C\3C\3C\7C\u01ee"+
		"\nC\fC\16C\u01f1\13C\3C\3C\3\u00e1\2D\3\2\5\2\7\2\t\2\13\2\r\2\17\2\21"+
		"\2\23\2\25\2\27\2\31\2\33\2\35\2\37\3!\4#\5%\6\'\7)\b+\t-\n/\13\61\f\63"+
		"\r\65\16\67\179\20;\21=\22?\23A\24C\25E\26G\27I\30K\31M\32O\33Q\34S\35"+
		"U\36W\37Y [!]\"_#a$c%e&g\'i(k)m*o+q,s-u.w/y\60{\61}\62\177\63\u0081\64"+
		"\u0083\65\u0085\66\3\2\f\5\2\"\"--//\4\2GGgg\4\2C\\c|\5\2\62;CHch\4\2"+
		"HHhh\4\2RRrr\5\2\"\"HHhh\5\2\f\f$$^^\4\2\13\f\17\17\4\2&&aa\2\u01ff\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2"+
		"\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2"+
		"C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3"+
		"\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2"+
		"\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2"+
		"i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3"+
		"\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081"+
		"\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\3\u009d\3\2\2\2\5\u00a2\3\2\2"+
		"\2\7\u00a6\3\2\2\2\t\u00a8\3\2\2\2\13\u00ac\3\2\2\2\r\u00ae\3\2\2\2\17"+
		"\u00b0\3\2\2\2\21\u00b2\3\2\2\2\23\u00b6\3\2\2\2\25\u00b8\3\2\2\2\27\u00c0"+
		"\3\2\2\2\31\u00ca\3\2\2\2\33\u00d4\3\2\2\2\35\u00d6\3\2\2\2\37\u00d8\3"+
		"\2\2\2!\u00db\3\2\2\2#\u00e9\3\2\2\2%\u00fc\3\2\2\2\'\u0101\3\2\2\2)\u0104"+
		"\3\2\2\2+\u0107\3\2\2\2-\u0110\3\2\2\2/\u0114\3\2\2\2\61\u011a\3\2\2\2"+
		"\63\u0122\3\2\2\2\65\u0128\3\2\2\2\67\u0133\3\2\2\29\u0137\3\2\2\2;\u013c"+
		"\3\2\2\2=\u0144\3\2\2\2?\u014e\3\2\2\2A\u0154\3\2\2\2C\u015c\3\2\2\2E"+
		"\u0165\3\2\2\2G\u016c\3\2\2\2I\u0176\3\2\2\2K\u017d\3\2\2\2M\u0182\3\2"+
		"\2\2O\u0187\3\2\2\2Q\u018d\3\2\2\2S\u018f\3\2\2\2U\u0191\3\2\2\2W\u0194"+
		"\3\2\2\2Y\u0196\3\2\2\2[\u0198\3\2\2\2]\u019a\3\2\2\2_\u019c\3\2\2\2a"+
		"\u019e\3\2\2\2c\u01a0\3\2\2\2e\u01a2\3\2\2\2g\u01a4\3\2\2\2i\u01a6\3\2"+
		"\2\2k\u01a8\3\2\2\2m\u01aa\3\2\2\2o\u01ac\3\2\2\2q\u01ae\3\2\2\2s\u01b1"+
		"\3\2\2\2u\u01b4\3\2\2\2w\u01b7\3\2\2\2y\u01ba\3\2\2\2{\u01bf\3\2\2\2}"+
		"\u01cb\3\2\2\2\177\u01cd\3\2\2\2\u0081\u01d7\3\2\2\2\u0083\u01d9\3\2\2"+
		"\2\u0085\u01e6\3\2\2\2\u0087\u0089\5\13\6\2\u0088\u0087\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008d\3\2"+
		"\2\2\u008c\u008e\5\r\7\2\u008d\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f"+
		"\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091\u0093\7\60"+
		"\2\2\u0092\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0092\3\2\2\2\u0094"+
		"\u0095\3\2\2\2\u0095\u0097\3\2\2\2\u0096\u0098\7/\2\2\u0097\u0096\3\2"+
		"\2\2\u0098\u0099\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\u009b\3\2\2\2\u009b\u009c\7a\2\2\u009c\u009e\3\2\2\2\u009d\u0088\3\2"+
		"\2\2\u009e\u009f\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"\4\3\2\2\2\u00a1\u00a3\5\r\7\2\u00a2\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2"+
		"\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\6\3\2\2\2\u00a6\u00a7\t"+
		"\2\2\2\u00a7\b\3\2\2\2\u00a8\u00a9\t\3\2\2\u00a9\u00aa\5\7\4\2\u00aa\u00ab"+
		"\5\5\3\2\u00ab\n\3\2\2\2\u00ac\u00ad\t\4\2\2\u00ad\f\3\2\2\2\u00ae\u00af"+
		"\4\62;\2\u00af\16\3\2\2\2\u00b0\u00b1\4\63;\2\u00b1\20\3\2\2\2\u00b2\u00b3"+
		"\t\5\2\2\u00b3\22\3\2\2\2\u00b4\u00b7\5\21\t\2\u00b5\u00b7\3\2\2\2\u00b6"+
		"\u00b4\3\2\2\2\u00b6\u00b5\3\2\2\2\u00b7\24\3\2\2\2\u00b8\u00b9\5\5\3"+
		"\2\u00b9\u00ba\7\60\2\2\u00ba\u00bb\5\5\3\2\u00bb\26\3\2\2\2\u00bc\u00c1"+
		"\5\25\13\2\u00bd\u00be\5\25\13\2\u00be\u00bf\5\t\5\2\u00bf\u00c1\3\2\2"+
		"\2\u00c0\u00bc\3\2\2\2\u00c0\u00bd\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c5"+
		"\t\6\2\2\u00c3\u00c5\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5"+
		"\30\3\2\2\2\u00c6\u00c7\7\62\2\2\u00c7\u00cb\7z\2\2\u00c8\u00c9\7\62\2"+
		"\2\u00c9\u00cb\7Z\2\2\u00ca\u00c6\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cc"+
		"\3\2\2\2\u00cc\u00cd\5\23\n\2\u00cd\u00ce\7\60\2\2\u00ce\u00cf\5\23\n"+
		"\2\u00cf\u00d0\t\7\2\2\u00d0\u00d1\5\7\4\2\u00d1\u00d2\5\5\3\2\u00d2\u00d3"+
		"\t\b\2\2\u00d3\32\3\2\2\2\u00d4\u00d5\n\t\2\2\u00d5\34\3\2\2\2\u00d6\u00d7"+
		"\7\f\2\2\u00d7\36\3\2\2\2\u00d8\u00d9\t\n\2\2\u00d9\u00da\b\20\2\2\u00da"+
		" \3\2\2\2\u00db\u00dc\7\61\2\2\u00dc\u00dd\7,\2\2\u00dd\u00e1\3\2\2\2"+
		"\u00de\u00e0\13\2\2\2\u00df\u00de\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00e2"+
		"\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e4\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4"+
		"\u00e5\7,\2\2\u00e5\u00e6\7\61\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\b\21"+
		"\3\2\u00e8\"\3\2\2\2\u00e9\u00ea\7%\2\2\u00ea\u00eb\7k\2\2\u00eb\u00ec"+
		"\7p\2\2\u00ec\u00ed\7e\2\2\u00ed\u00ee\7n\2\2\u00ee\u00ef\7w\2\2\u00ef"+
		"\u00f0\7f\2\2\u00f0\u00f1\7g\2\2\u00f1\u00f5\3\2\2\2\u00f2\u00f4\7\"\2"+
		"\2\u00f3\u00f2\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6"+
		"\3\2\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00f9\7$\2\2\u00f9"+
		"\u00fa\5\3\2\2\u00fa\u00fb\7$\2\2\u00fb$\3\2\2\2\u00fc\u00fd\7g\2\2\u00fd"+
		"\u00fe\7n\2\2\u00fe\u00ff\7u\2\2\u00ff\u0100\7g\2\2\u0100&\3\2\2\2\u0101"+
		"\u0102\7k\2\2\u0102\u0103\7h\2\2\u0103(\3\2\2\2\u0104\u0105\7\"\2\2\u0105"+
		"\u0106\b\25\4\2\u0106*\3\2\2\2\u0107\u0108\7g\2\2\u0108\u0109\7n\2\2\u0109"+
		"\u010a\7u\2\2\u010a\u010b\7g\2\2\u010b\u010c\3\2\2\2\u010c\u010d\5)\25"+
		"\2\u010d\u010e\7k\2\2\u010e\u010f\7h\2\2\u010f,\3\2\2\2\u0110\u0111\7"+
		"c\2\2\u0111\u0112\7u\2\2\u0112\u0113\7o\2\2\u0113.\3\2\2\2\u0114\u0115"+
		"\7e\2\2\u0115\u0116\7n\2\2\u0116\u0117\7c\2\2\u0117\u0118\7u\2\2\u0118"+
		"\u0119\7u\2\2\u0119\60\3\2\2\2\u011a\u011b\7g\2\2\u011b\u011c\7z\2\2\u011c"+
		"\u011d\7v\2\2\u011d\u011e\7g\2\2\u011e\u011f\7p\2\2\u011f\u0120\7f\2\2"+
		"\u0120\u0121\7u\2\2\u0121\62\3\2\2\2\u0122\u0123\7h\2\2\u0123\u0124\7"+
		"c\2\2\u0124\u0125\7n\2\2\u0125\u0126\7u\2\2\u0126\u0127\7g\2\2\u0127\64"+
		"\3\2\2\2\u0128\u0129\7k\2\2\u0129\u012a\7p\2\2\u012a\u012b\7u\2\2\u012b"+
		"\u012c\7v\2\2\u012c\u012d\7c\2\2\u012d\u012e\7p\2\2\u012e\u012f\7e\2\2"+
		"\u012f\u0130\7g\2\2\u0130\u0131\7q\2\2\u0131\u0132\7h\2\2\u0132\66\3\2"+
		"\2\2\u0133\u0134\7p\2\2\u0134\u0135\7g\2\2\u0135\u0136\7y\2\2\u01368\3"+
		"\2\2\2\u0137\u0138\7p\2\2\u0138\u0139\7w\2\2\u0139\u013a\7n\2\2\u013a"+
		"\u013b\7n\2\2\u013b:\3\2\2\2\u013c\u013d\7t\2\2\u013d\u013e\7g\2\2\u013e"+
		"\u013f\7c\2\2\u013f\u0140\7f\2\2\u0140\u0141\7K\2\2\u0141\u0142\7p\2\2"+
		"\u0142\u0143\7v\2\2\u0143<\3\2\2\2\u0144\u0145\7t\2\2\u0145\u0146\7g\2"+
		"\2\u0146\u0147\7c\2\2\u0147\u0148\7f\2\2\u0148\u0149\7H\2\2\u0149\u014a"+
		"\7n\2\2\u014a\u014b\7q\2\2\u014b\u014c\7c\2\2\u014c\u014d\7v\2\2\u014d"+
		">\3\2\2\2\u014e\u014f\7r\2\2\u014f\u0150\7t\2\2\u0150\u0151\7k\2\2\u0151"+
		"\u0152\7p\2\2\u0152\u0153\7v\2\2\u0153@\3\2\2\2\u0154\u0155\7r\2\2\u0155"+
		"\u0156\7t\2\2\u0156\u0157\7k\2\2\u0157\u0158\7p\2\2\u0158\u0159\7v\2\2"+
		"\u0159\u015a\7n\2\2\u015a\u015b\7p\2\2\u015bB\3\2\2\2\u015c\u015d\7r\2"+
		"\2\u015d\u015e\7t\2\2\u015e\u015f\7k\2\2\u015f\u0160\7p\2\2\u0160\u0161"+
		"\7v\2\2\u0161\u0162\7n\2\2\u0162\u0163\7p\2\2\u0163\u0164\7z\2\2\u0164"+
		"D\3\2\2\2\u0165\u0166\7r\2\2\u0166\u0167\7t\2\2\u0167\u0168\7k\2\2\u0168"+
		"\u0169\7p\2\2\u0169\u016a\7v\2\2\u016a\u016b\7z\2\2\u016bF\3\2\2\2\u016c"+
		"\u016d\7r\2\2\u016d\u016e\7t\2\2\u016e\u016f\7q\2\2\u016f\u0170\7v\2\2"+
		"\u0170\u0171\7g\2\2\u0171\u0172\7e\2\2\u0172\u0173\7v\2\2\u0173\u0174"+
		"\7g\2\2\u0174\u0175\7f\2\2\u0175H\3\2\2\2\u0176\u0177\7t\2\2\u0177\u0178"+
		"\7g\2\2\u0178\u0179\7v\2\2\u0179\u017a\7w\2\2\u017a\u017b\7t\2\2\u017b"+
		"\u017c\7p\2\2\u017cJ\3\2\2\2\u017d\u017e\7v\2\2\u017e\u017f\7j\2\2\u017f"+
		"\u0180\7k\2\2\u0180\u0181\7u\2\2\u0181L\3\2\2\2\u0182\u0183\7v\2\2\u0183"+
		"\u0184\7t\2\2\u0184\u0185\7w\2\2\u0185\u0186\7g\2\2\u0186N\3\2\2\2\u0187"+
		"\u0188\7y\2\2\u0188\u0189\7j\2\2\u0189\u018a\7k\2\2\u018a\u018b\7n\2\2"+
		"\u018b\u018c\7g\2\2\u018cP\3\2\2\2\u018d\u018e\7>\2\2\u018eR\3\2\2\2\u018f"+
		"\u0190\7@\2\2\u0190T\3\2\2\2\u0191\u0192\7?\2\2\u0192\u0193\7?\2\2\u0193"+
		"V\3\2\2\2\u0194\u0195\7?\2\2\u0195X\3\2\2\2\u0196\u0197\7-\2\2\u0197Z"+
		"\3\2\2\2\u0198\u0199\7/\2\2\u0199\\\3\2\2\2\u019a\u019b\7,\2\2\u019b^"+
		"\3\2\2\2\u019c\u019d\7\61\2\2\u019d`\3\2\2\2\u019e\u019f\7\'\2\2\u019f"+
		"b\3\2\2\2\u01a0\u01a1\7.\2\2\u01a1d\3\2\2\2\u01a2\u01a3\7*\2\2\u01a3f"+
		"\3\2\2\2\u01a4\u01a5\7+\2\2\u01a5h\3\2\2\2\u01a6\u01a7\7}\2\2\u01a7j\3"+
		"\2\2\2\u01a8\u01a9\7\177\2\2\u01a9l\3\2\2\2\u01aa\u01ab\7#\2\2\u01abn"+
		"\3\2\2\2\u01ac\u01ad\7=\2\2\u01adp\3\2\2\2\u01ae\u01af\7#\2\2\u01af\u01b0"+
		"\7?\2\2\u01b0r\3\2\2\2\u01b1\u01b2\7@\2\2\u01b2\u01b3\7?\2\2\u01b3t\3"+
		"\2\2\2\u01b4\u01b5\7>\2\2\u01b5\u01b6\7?\2\2\u01b6v\3\2\2\2\u01b7\u01b8"+
		"\7(\2\2\u01b8\u01b9\7(\2\2\u01b9x\3\2\2\2\u01ba\u01bb\7~\2\2\u01bb\u01bc"+
		"\7~\2\2\u01bcz\3\2\2\2\u01bd\u01c0\5\13\6\2\u01be\u01c0\t\13\2\2\u01bf"+
		"\u01bd\3\2\2\2\u01bf\u01be\3\2\2\2\u01c0\u01c6\3\2\2\2\u01c1\u01c5\5\13"+
		"\6\2\u01c2\u01c5\5\r\7\2\u01c3\u01c5\t\13\2\2\u01c4\u01c1\3\2\2\2\u01c4"+
		"\u01c2\3\2\2\2\u01c4\u01c3\3\2\2\2\u01c5\u01c8\3\2\2\2\u01c6\u01c4\3\2"+
		"\2\2\u01c6\u01c7\3\2\2\2\u01c7|\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c9\u01cc"+
		"\5\27\f\2\u01ca\u01cc\5\31\r\2\u01cb\u01c9\3\2\2\2\u01cb\u01ca\3\2\2\2"+
		"\u01cc~\3\2\2\2\u01cd\u01ce\7\60\2\2\u01ce\u0080\3\2\2\2\u01cf\u01d8\7"+
		"\62\2\2\u01d0\u01d4\5\17\b\2\u01d1\u01d3\5\r\7\2\u01d2\u01d1\3\2\2\2\u01d3"+
		"\u01d6\3\2\2\2\u01d4\u01d2\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d8\3\2"+
		"\2\2\u01d6\u01d4\3\2\2\2\u01d7\u01cf\3\2\2\2\u01d7\u01d0\3\2\2\2\u01d8"+
		"\u0082\3\2\2\2\u01d9\u01e1\7$\2\2\u01da\u01e0\5\33\16\2\u01db\u01dc\7"+
		"^\2\2\u01dc\u01e0\7$\2\2\u01dd\u01de\7^\2\2\u01de\u01e0\7^\2\2\u01df\u01da"+
		"\3\2\2\2\u01df\u01db\3\2\2\2\u01df\u01dd\3\2\2\2\u01e0\u01e3\3\2\2\2\u01e1"+
		"\u01df\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e4\3\2\2\2\u01e3\u01e1\3\2"+
		"\2\2\u01e4\u01e5\7$\2\2\u01e5\u0084\3\2\2\2\u01e6\u01ef\7$\2\2\u01e7\u01ee"+
		"\5\33\16\2\u01e8\u01ee\5\35\17\2\u01e9\u01ea\7^\2\2\u01ea\u01ee\7$\2\2"+
		"\u01eb\u01ec\7^\2\2\u01ec\u01ee\7^\2\2\u01ed\u01e7\3\2\2\2\u01ed\u01e8"+
		"\3\2\2\2\u01ed\u01e9\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ee\u01f1\3\2\2\2\u01ef"+
		"\u01ed\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0\u01f2\3\2\2\2\u01f1\u01ef\3\2"+
		"\2\2\u01f2\u01f3\7$\2\2\u01f3\u0086\3\2\2\2\31\2\u008a\u008f\u0094\u0099"+
		"\u009f\u00a4\u00b6\u00c0\u00c4\u00ca\u00e1\u00f5\u01bf\u01c4\u01c6\u01cb"+
		"\u01d4\u01d7\u01df\u01e1\u01ed\u01ef\5\3\20\2\3\21\3\3\25\4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}