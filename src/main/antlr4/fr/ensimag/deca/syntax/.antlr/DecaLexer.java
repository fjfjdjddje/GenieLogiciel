// Generated from /home/ensimag/Projet_GL/src/main/antlr4/fr/ensimag/deca/syntax/DecaLexer.g4 by ANTLR 4.8
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
		OBRACE=38, CBRACE=39, EXCLAM=40, SEMI=41, NEQ=42, GEQ=43, LEQ=44, AND=45, 
		OR=46, FLOAT=47, IDENT=48, DOT=49, INT=50, STRING=51, MULTI_LINE_STRING=52;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"FILENAME", "DIGITHEX", "NUMHEX", "FLOATHEX", "NUM", "SIGN", "EXP", "LETTER", 
			"DIGIT", "POSITIVE_DIGIT", "DEC", "FLOATDEC", "EOL", "STRING_CAR", "WS", 
			"COMMENT", "INCLUDE", "ELSE", "IF", "SPACE", "ELSEIF", "ASM", "CLASS", 
			"EXTENDS", "FALSE", "INSTANCEOF", "NEW", "NULL", "READINT", "READFLOAT", 
			"PRINT", "PRINTLN", "PRINTLNX", "PRINTX", "PROTECTED", "RETURN", "THIS", 
			"TRUE", "WHILE", "LT", "GT", "EQEQ", "EQUALS", "PLUS", "MINUS", "TIMES", 
			"SLASH", "PERCENT", "COMMA", "OPARENT", "CPARENT", "OBRACE", "CBRACE", 
			"EXCLAM", "SEMI", "NEQ", "GEQ", "LEQ", "AND", "OR", "FLOAT", "IDENT", 
			"DOT", "INT", "STRING", "MULTI_LINE_STRING"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'else'", "'if'", "' '", "'elseif'", "'asm'", 
			"'class'", "'extends'", "'false'", "'instanceof'", "'new'", "'null'", 
			"'readInt'", "'readFloat'", "'print'", "'println'", "'printlnx'", "'printx'", 
			"'protected'", "'return'", "'this'", "'true'", "'while'", "'<'", "'>'", 
			"'=='", "'='", "'+'", "'-'", "'*'", "'/'", "'%'", "','", "'('", "')'", 
			"'{'", "'}'", "'!'", "';'", "'!='", "'>='", "'<='", "'&&'", "'||'", null, 
			null, "'.'"
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
			"CBRACE", "EXCLAM", "SEMI", "NEQ", "GEQ", "LEQ", "AND", "OR", "FLOAT", 
			"IDENT", "DOT", "INT", "STRING", "MULTI_LINE_STRING"
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
		case 16:
			INCLUDE_action((RuleContext)_localctx, actionIndex);
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
	private void INCLUDE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			doInclude(getText());
			break;
		}
	}
	private void SPACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			skip();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\66\u01ec\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\3\2\3\2\3\2\6\2\u008b\n\2\r\2\16"+
		"\2\u008c\3\3\3\3\3\4\3\4\5\4\u0093\n\4\3\5\3\5\3\5\3\5\5\5\u0099\n\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u00a3\n\5\3\6\6\6\u00a6\n\6\r\6\16"+
		"\6\u00a7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\5\r\u00be\n\r\3\r\3\r\5\r\u00c2\n\r\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\7\21\u00cf\n\21\f\21\16\21\u00d2"+
		"\13\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u00da\n\21\f\21\16\21\u00dd"+
		"\13\21\5\21\u00df\n\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\7\22\u00ed\n\22\f\22\16\22\u00f0\13\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3"+
		"\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3"+
		" \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3"+
		"%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\3)\3*\3*\3+"+
		"\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63"+
		"\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\39\3:\3:\3:\3;\3"+
		";\3;\3<\3<\3<\3=\3=\3=\3>\3>\5>\u01b8\n>\3?\3?\5?\u01bc\n?\3?\3?\3?\7"+
		"?\u01c1\n?\f?\16?\u01c4\13?\3@\3@\3A\3A\3A\7A\u01cb\nA\fA\16A\u01ce\13"+
		"A\5A\u01d0\nA\3B\3B\3B\3B\3B\3B\7B\u01d8\nB\fB\16B\u01db\13B\3B\3B\3C"+
		"\3C\3C\3C\3C\3C\3C\7C\u01e6\nC\fC\16C\u01e9\13C\3C\3C\3\u00d0\2D\3\2\5"+
		"\2\7\2\t\2\13\2\r\2\17\2\21\2\23\2\25\2\27\2\31\2\33\2\35\2\37\3!\4#\5"+
		"%\6\'\7)\b+\t-\n/\13\61\f\63\r\65\16\67\179\20;\21=\22?\23A\24C\25E\26"+
		"G\27I\30K\31M\32O\33Q\34S\35U\36W\37Y [!]\"_#a$c%e&g\'i(k)m*o+q,s-u.w"+
		"/y\60{\61}\62\177\63\u0081\64\u0083\65\u0085\66\3\2\r\4\2/\60aa\5\2\62"+
		";CHch\4\2RRrr\4\2HHhh\5\2\"\"--//\4\2GGgg\4\2C\\c|\5\2\f\f$$^^\4\2\13"+
		"\f\17\17\3\2\f\f\4\2&&aa\2\u01f8\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2"+
		"\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I"+
		"\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2"+
		"\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2"+
		"\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o"+
		"\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2"+
		"\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085"+
		"\3\2\2\2\3\u008a\3\2\2\2\5\u008e\3\2\2\2\7\u0092\3\2\2\2\t\u0098\3\2\2"+
		"\2\13\u00a5\3\2\2\2\r\u00a9\3\2\2\2\17\u00ab\3\2\2\2\21\u00af\3\2\2\2"+
		"\23\u00b1\3\2\2\2\25\u00b3\3\2\2\2\27\u00b5\3\2\2\2\31\u00bd\3\2\2\2\33"+
		"\u00c3\3\2\2\2\35\u00c5\3\2\2\2\37\u00c7\3\2\2\2!\u00de\3\2\2\2#\u00e2"+
		"\3\2\2\2%\u00f6\3\2\2\2\'\u00fb\3\2\2\2)\u00fe\3\2\2\2+\u0101\3\2\2\2"+
		"-\u0108\3\2\2\2/\u010c\3\2\2\2\61\u0112\3\2\2\2\63\u011a\3\2\2\2\65\u0120"+
		"\3\2\2\2\67\u012b\3\2\2\29\u012f\3\2\2\2;\u0134\3\2\2\2=\u013c\3\2\2\2"+
		"?\u0146\3\2\2\2A\u014c\3\2\2\2C\u0154\3\2\2\2E\u015d\3\2\2\2G\u0164\3"+
		"\2\2\2I\u016e\3\2\2\2K\u0175\3\2\2\2M\u017a\3\2\2\2O\u017f\3\2\2\2Q\u0185"+
		"\3\2\2\2S\u0187\3\2\2\2U\u0189\3\2\2\2W\u018c\3\2\2\2Y\u018e\3\2\2\2["+
		"\u0190\3\2\2\2]\u0192\3\2\2\2_\u0194\3\2\2\2a\u0196\3\2\2\2c\u0198\3\2"+
		"\2\2e\u019a\3\2\2\2g\u019c\3\2\2\2i\u019e\3\2\2\2k\u01a0\3\2\2\2m\u01a2"+
		"\3\2\2\2o\u01a4\3\2\2\2q\u01a6\3\2\2\2s\u01a9\3\2\2\2u\u01ac\3\2\2\2w"+
		"\u01af\3\2\2\2y\u01b2\3\2\2\2{\u01b7\3\2\2\2}\u01bb\3\2\2\2\177\u01c5"+
		"\3\2\2\2\u0081\u01cf\3\2\2\2\u0083\u01d1\3\2\2\2\u0085\u01de\3\2\2\2\u0087"+
		"\u008b\5\21\t\2\u0088\u008b\5\23\n\2\u0089\u008b\t\2\2\2\u008a\u0087\3"+
		"\2\2\2\u008a\u0088\3\2\2\2\u008a\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\4\3\2\2\2\u008e\u008f\t\3\2\2"+
		"\u008f\6\3\2\2\2\u0090\u0093\5\5\3\2\u0091\u0093\3\2\2\2\u0092\u0090\3"+
		"\2\2\2\u0092\u0091\3\2\2\2\u0093\b\3\2\2\2\u0094\u0095\7\62\2\2\u0095"+
		"\u0099\7z\2\2\u0096\u0097\7\62\2\2\u0097\u0099\7Z\2\2\u0098\u0094\3\2"+
		"\2\2\u0098\u0096\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\5\7\4\2\u009b"+
		"\u009c\7\60\2\2\u009c\u009d\5\7\4\2\u009d\u009e\t\4\2\2\u009e\u009f\5"+
		"\r\7\2\u009f\u00a2\5\13\6\2\u00a0\u00a3\t\5\2\2\u00a1\u00a3\3\2\2\2\u00a2"+
		"\u00a0\3\2\2\2\u00a2\u00a1\3\2\2\2\u00a3\n\3\2\2\2\u00a4\u00a6\5\23\n"+
		"\2\u00a5\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8"+
		"\3\2\2\2\u00a8\f\3\2\2\2\u00a9\u00aa\t\6\2\2\u00aa\16\3\2\2\2\u00ab\u00ac"+
		"\t\7\2\2\u00ac\u00ad\5\r\7\2\u00ad\u00ae\5\13\6\2\u00ae\20\3\2\2\2\u00af"+
		"\u00b0\t\b\2\2\u00b0\22\3\2\2\2\u00b1\u00b2\4\62;\2\u00b2\24\3\2\2\2\u00b3"+
		"\u00b4\4\63;\2\u00b4\26\3\2\2\2\u00b5\u00b6\5\13\6\2\u00b6\u00b7\7\60"+
		"\2\2\u00b7\u00b8\5\13\6\2\u00b8\30\3\2\2\2\u00b9\u00be\5\27\f\2\u00ba"+
		"\u00bb\5\27\f\2\u00bb\u00bc\5\17\b\2\u00bc\u00be\3\2\2\2\u00bd\u00b9\3"+
		"\2\2\2\u00bd\u00ba\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00c2\t\5\2\2\u00c0"+
		"\u00c2\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c0\3\2\2\2\u00c2\32\3\2\2"+
		"\2\u00c3\u00c4\7\f\2\2\u00c4\34\3\2\2\2\u00c5\u00c6\n\t\2\2\u00c6\36\3"+
		"\2\2\2\u00c7\u00c8\t\n\2\2\u00c8\u00c9\b\20\2\2\u00c9 \3\2\2\2\u00ca\u00cb"+
		"\7\61\2\2\u00cb\u00cc\7,\2\2\u00cc\u00d0\3\2\2\2\u00cd\u00cf\13\2\2\2"+
		"\u00ce\u00cd\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d0\u00ce"+
		"\3\2\2\2\u00d1\u00d3\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00d4\7,\2\2\u00d4"+
		"\u00df\7\61\2\2\u00d5\u00d6\7\61\2\2\u00d6\u00d7\7\61\2\2\u00d7\u00db"+
		"\3\2\2\2\u00d8\u00da\n\13\2\2\u00d9\u00d8\3\2\2\2\u00da\u00dd\3\2\2\2"+
		"\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db"+
		"\3\2\2\2\u00de\u00ca\3\2\2\2\u00de\u00d5\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0"+
		"\u00e1\b\21\3\2\u00e1\"\3\2\2\2\u00e2\u00e3\7%\2\2\u00e3\u00e4\7k\2\2"+
		"\u00e4\u00e5\7p\2\2\u00e5\u00e6\7e\2\2\u00e6\u00e7\7n\2\2\u00e7\u00e8"+
		"\7w\2\2\u00e8\u00e9\7f\2\2\u00e9\u00ea\7g\2\2\u00ea\u00ee\3\2\2\2\u00eb"+
		"\u00ed\7\"\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2"+
		"\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f1\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1"+
		"\u00f2\7$\2\2\u00f2\u00f3\5\3\2\2\u00f3\u00f4\7$\2\2\u00f4\u00f5\b\22"+
		"\4\2\u00f5$\3\2\2\2\u00f6\u00f7\7g\2\2\u00f7\u00f8\7n\2\2\u00f8\u00f9"+
		"\7u\2\2\u00f9\u00fa\7g\2\2\u00fa&\3\2\2\2\u00fb\u00fc\7k\2\2\u00fc\u00fd"+
		"\7h\2\2\u00fd(\3\2\2\2\u00fe\u00ff\7\"\2\2\u00ff\u0100\b\25\5\2\u0100"+
		"*\3\2\2\2\u0101\u0102\7g\2\2\u0102\u0103\7n\2\2\u0103\u0104\7u\2\2\u0104"+
		"\u0105\7g\2\2\u0105\u0106\7k\2\2\u0106\u0107\7h\2\2\u0107,\3\2\2\2\u0108"+
		"\u0109\7c\2\2\u0109\u010a\7u\2\2\u010a\u010b\7o\2\2\u010b.\3\2\2\2\u010c"+
		"\u010d\7e\2\2\u010d\u010e\7n\2\2\u010e\u010f\7c\2\2\u010f\u0110\7u\2\2"+
		"\u0110\u0111\7u\2\2\u0111\60\3\2\2\2\u0112\u0113\7g\2\2\u0113\u0114\7"+
		"z\2\2\u0114\u0115\7v\2\2\u0115\u0116\7g\2\2\u0116\u0117\7p\2\2\u0117\u0118"+
		"\7f\2\2\u0118\u0119\7u\2\2\u0119\62\3\2\2\2\u011a\u011b\7h\2\2\u011b\u011c"+
		"\7c\2\2\u011c\u011d\7n\2\2\u011d\u011e\7u\2\2\u011e\u011f\7g\2\2\u011f"+
		"\64\3\2\2\2\u0120\u0121\7k\2\2\u0121\u0122\7p\2\2\u0122\u0123\7u\2\2\u0123"+
		"\u0124\7v\2\2\u0124\u0125\7c\2\2\u0125\u0126\7p\2\2\u0126\u0127\7e\2\2"+
		"\u0127\u0128\7g\2\2\u0128\u0129\7q\2\2\u0129\u012a\7h\2\2\u012a\66\3\2"+
		"\2\2\u012b\u012c\7p\2\2\u012c\u012d\7g\2\2\u012d\u012e\7y\2\2\u012e8\3"+
		"\2\2\2\u012f\u0130\7p\2\2\u0130\u0131\7w\2\2\u0131\u0132\7n\2\2\u0132"+
		"\u0133\7n\2\2\u0133:\3\2\2\2\u0134\u0135\7t\2\2\u0135\u0136\7g\2\2\u0136"+
		"\u0137\7c\2\2\u0137\u0138\7f\2\2\u0138\u0139\7K\2\2\u0139\u013a\7p\2\2"+
		"\u013a\u013b\7v\2\2\u013b<\3\2\2\2\u013c\u013d\7t\2\2\u013d\u013e\7g\2"+
		"\2\u013e\u013f\7c\2\2\u013f\u0140\7f\2\2\u0140\u0141\7H\2\2\u0141\u0142"+
		"\7n\2\2\u0142\u0143\7q\2\2\u0143\u0144\7c\2\2\u0144\u0145\7v\2\2\u0145"+
		">\3\2\2\2\u0146\u0147\7r\2\2\u0147\u0148\7t\2\2\u0148\u0149\7k\2\2\u0149"+
		"\u014a\7p\2\2\u014a\u014b\7v\2\2\u014b@\3\2\2\2\u014c\u014d\7r\2\2\u014d"+
		"\u014e\7t\2\2\u014e\u014f\7k\2\2\u014f\u0150\7p\2\2\u0150\u0151\7v\2\2"+
		"\u0151\u0152\7n\2\2\u0152\u0153\7p\2\2\u0153B\3\2\2\2\u0154\u0155\7r\2"+
		"\2\u0155\u0156\7t\2\2\u0156\u0157\7k\2\2\u0157\u0158\7p\2\2\u0158\u0159"+
		"\7v\2\2\u0159\u015a\7n\2\2\u015a\u015b\7p\2\2\u015b\u015c\7z\2\2\u015c"+
		"D\3\2\2\2\u015d\u015e\7r\2\2\u015e\u015f\7t\2\2\u015f\u0160\7k\2\2\u0160"+
		"\u0161\7p\2\2\u0161\u0162\7v\2\2\u0162\u0163\7z\2\2\u0163F\3\2\2\2\u0164"+
		"\u0165\7r\2\2\u0165\u0166\7t\2\2\u0166\u0167\7q\2\2\u0167\u0168\7v\2\2"+
		"\u0168\u0169\7g\2\2\u0169\u016a\7e\2\2\u016a\u016b\7v\2\2\u016b\u016c"+
		"\7g\2\2\u016c\u016d\7f\2\2\u016dH\3\2\2\2\u016e\u016f\7t\2\2\u016f\u0170"+
		"\7g\2\2\u0170\u0171\7v\2\2\u0171\u0172\7w\2\2\u0172\u0173\7t\2\2\u0173"+
		"\u0174\7p\2\2\u0174J\3\2\2\2\u0175\u0176\7v\2\2\u0176\u0177\7j\2\2\u0177"+
		"\u0178\7k\2\2\u0178\u0179\7u\2\2\u0179L\3\2\2\2\u017a\u017b\7v\2\2\u017b"+
		"\u017c\7t\2\2\u017c\u017d\7w\2\2\u017d\u017e\7g\2\2\u017eN\3\2\2\2\u017f"+
		"\u0180\7y\2\2\u0180\u0181\7j\2\2\u0181\u0182\7k\2\2\u0182\u0183\7n\2\2"+
		"\u0183\u0184\7g\2\2\u0184P\3\2\2\2\u0185\u0186\7>\2\2\u0186R\3\2\2\2\u0187"+
		"\u0188\7@\2\2\u0188T\3\2\2\2\u0189\u018a\7?\2\2\u018a\u018b\7?\2\2\u018b"+
		"V\3\2\2\2\u018c\u018d\7?\2\2\u018dX\3\2\2\2\u018e\u018f\7-\2\2\u018fZ"+
		"\3\2\2\2\u0190\u0191\7/\2\2\u0191\\\3\2\2\2\u0192\u0193\7,\2\2\u0193^"+
		"\3\2\2\2\u0194\u0195\7\61\2\2\u0195`\3\2\2\2\u0196\u0197\7\'\2\2\u0197"+
		"b\3\2\2\2\u0198\u0199\7.\2\2\u0199d\3\2\2\2\u019a\u019b\7*\2\2\u019bf"+
		"\3\2\2\2\u019c\u019d\7+\2\2\u019dh\3\2\2\2\u019e\u019f\7}\2\2\u019fj\3"+
		"\2\2\2\u01a0\u01a1\7\177\2\2\u01a1l\3\2\2\2\u01a2\u01a3\7#\2\2\u01a3n"+
		"\3\2\2\2\u01a4\u01a5\7=\2\2\u01a5p\3\2\2\2\u01a6\u01a7\7#\2\2\u01a7\u01a8"+
		"\7?\2\2\u01a8r\3\2\2\2\u01a9\u01aa\7@\2\2\u01aa\u01ab\7?\2\2\u01abt\3"+
		"\2\2\2\u01ac\u01ad\7>\2\2\u01ad\u01ae\7?\2\2\u01aev\3\2\2\2\u01af\u01b0"+
		"\7(\2\2\u01b0\u01b1\7(\2\2\u01b1x\3\2\2\2\u01b2\u01b3\7~\2\2\u01b3\u01b4"+
		"\7~\2\2\u01b4z\3\2\2\2\u01b5\u01b8\5\31\r\2\u01b6\u01b8\5\t\5\2\u01b7"+
		"\u01b5\3\2\2\2\u01b7\u01b6\3\2\2\2\u01b8|\3\2\2\2\u01b9\u01bc\5\21\t\2"+
		"\u01ba\u01bc\t\f\2\2\u01bb\u01b9\3\2\2\2\u01bb\u01ba\3\2\2\2\u01bc\u01c2"+
		"\3\2\2\2\u01bd\u01c1\5\21\t\2\u01be\u01c1\5\23\n\2\u01bf\u01c1\t\f\2\2"+
		"\u01c0\u01bd\3\2\2\2\u01c0\u01be\3\2\2\2\u01c0\u01bf\3\2\2\2\u01c1\u01c4"+
		"\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3~\3\2\2\2\u01c4"+
		"\u01c2\3\2\2\2\u01c5\u01c6\7\60\2\2\u01c6\u0080\3\2\2\2\u01c7\u01d0\7"+
		"\62\2\2\u01c8\u01cc\5\25\13\2\u01c9\u01cb\5\23\n\2\u01ca\u01c9\3\2\2\2"+
		"\u01cb\u01ce\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01d0"+
		"\3\2\2\2\u01ce\u01cc\3\2\2\2\u01cf\u01c7\3\2\2\2\u01cf\u01c8\3\2\2\2\u01d0"+
		"\u0082\3\2\2\2\u01d1\u01d9\7$\2\2\u01d2\u01d8\5\35\17\2\u01d3\u01d4\7"+
		"^\2\2\u01d4\u01d8\7$\2\2\u01d5\u01d6\7^\2\2\u01d6\u01d8\7^\2\2\u01d7\u01d2"+
		"\3\2\2\2\u01d7\u01d3\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d8\u01db\3\2\2\2\u01d9"+
		"\u01d7\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01dc\3\2\2\2\u01db\u01d9\3\2"+
		"\2\2\u01dc\u01dd\7$\2\2\u01dd\u0084\3\2\2\2\u01de\u01e7\7$\2\2\u01df\u01e6"+
		"\5\35\17\2\u01e0\u01e6\5\33\16\2\u01e1\u01e2\7^\2\2\u01e2\u01e6\7$\2\2"+
		"\u01e3\u01e4\7^\2\2\u01e4\u01e6\7^\2\2\u01e5\u01df\3\2\2\2\u01e5\u01e0"+
		"\3\2\2\2\u01e5\u01e1\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e6\u01e9\3\2\2\2\u01e7"+
		"\u01e5\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01ea\3\2\2\2\u01e9\u01e7\3\2"+
		"\2\2\u01ea\u01eb\7$\2\2\u01eb\u0086\3\2\2\2\31\2\u008a\u008c\u0092\u0098"+
		"\u00a2\u00a7\u00bd\u00c1\u00d0\u00db\u00de\u00ee\u01b7\u01bb\u01c0\u01c2"+
		"\u01cc\u01cf\u01d7\u01d9\u01e5\u01e7\6\3\20\2\3\21\3\3\22\4\3\25\5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}