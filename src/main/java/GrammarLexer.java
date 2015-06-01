// Generated from Grammar.g4 by ANTLR 4.5
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, WS=34, COMMENT=35, LINE_COMMENT=36, LPAREN=37, RPAREN=38, 
		LBRACE=39, RBRACE=40, COMMA=41, SEMI=42, Identifier=43, IntegerLiteral=44, 
		StringLiteral=45, BooleanLiteral=46;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
		"WS", "COMMENT", "LINE_COMMENT", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
		"COMMA", "SEMI", "Identifier", "IntegerLiteral", "StringLiteral", "BooleanLiteral"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'int'", "'string'", "'boolean'", "'function'", "'void'", "'break;'", 
		"'continue;'", "'return '", "'if'", "'else'", "'while'", "'for'", "', '", 
		"'='", "'+='", "'-'", "'!'", "'~'", "'*'", "'/'", "'%'", "'+'", "'=='", 
		"'!='", "'<'", "'>'", "'<='", "'>='", "'&&'", "'||'", "'read'", "'write'", 
		"'function<'", null, null, null, "'('", "')'", "'{'", "'}'", "','", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "WS", "COMMENT", 
		"LINE_COMMENT", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "COMMA", "SEMI", 
		"Identifier", "IntegerLiteral", "StringLiteral", "BooleanLiteral"
	};
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\60\u013a\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3"+
		" \3 \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"#\3#\3#\3#\3$\3$\3$\3$\7$\u00f5\n$\f$\16$\u00f8\13$\3$\3$\3$\3$\3$\3%"+
		"\3%\3%\3%\7%\u0103\n%\f%\16%\u0106\13%\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3"+
		")\3*\3*\3+\3+\3,\3,\7,\u0118\n,\f,\16,\u011b\13,\3-\3-\7-\u011f\n-\f-"+
		"\16-\u0122\13-\3-\5-\u0125\n-\3.\3.\7.\u0129\n.\f.\16.\u012c\13.\3.\3"+
		".\3/\3/\3/\3/\3/\3/\3/\3/\3/\5/\u0139\n/\3\u00f6\2\60\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K"+
		"\'M(O)Q*S+U,W-Y.[/]\60\3\2\t\5\2\13\f\17\17\"\"\4\2\f\f\17\17\6\2&&C\\"+
		"aac|\7\2&&\62;C\\aac|\3\2\63;\3\2\62;\4\2$$^^\u0140\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"+
		"\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2"+
		"?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3"+
		"\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2"+
		"\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\3_\3\2\2\2\5c\3\2\2\2\7j\3\2\2\2\t"+
		"r\3\2\2\2\13{\3\2\2\2\r\u0080\3\2\2\2\17\u0087\3\2\2\2\21\u0091\3\2\2"+
		"\2\23\u0099\3\2\2\2\25\u009c\3\2\2\2\27\u00a1\3\2\2\2\31\u00a7\3\2\2\2"+
		"\33\u00ab\3\2\2\2\35\u00ae\3\2\2\2\37\u00b0\3\2\2\2!\u00b3\3\2\2\2#\u00b5"+
		"\3\2\2\2%\u00b7\3\2\2\2\'\u00b9\3\2\2\2)\u00bb\3\2\2\2+\u00bd\3\2\2\2"+
		"-\u00bf\3\2\2\2/\u00c1\3\2\2\2\61\u00c4\3\2\2\2\63\u00c7\3\2\2\2\65\u00c9"+
		"\3\2\2\2\67\u00cb\3\2\2\29\u00ce\3\2\2\2;\u00d1\3\2\2\2=\u00d4\3\2\2\2"+
		"?\u00d7\3\2\2\2A\u00dc\3\2\2\2C\u00e2\3\2\2\2E\u00ec\3\2\2\2G\u00f0\3"+
		"\2\2\2I\u00fe\3\2\2\2K\u0109\3\2\2\2M\u010b\3\2\2\2O\u010d\3\2\2\2Q\u010f"+
		"\3\2\2\2S\u0111\3\2\2\2U\u0113\3\2\2\2W\u0115\3\2\2\2Y\u0124\3\2\2\2["+
		"\u0126\3\2\2\2]\u0138\3\2\2\2_`\7k\2\2`a\7p\2\2ab\7v\2\2b\4\3\2\2\2cd"+
		"\7u\2\2de\7v\2\2ef\7t\2\2fg\7k\2\2gh\7p\2\2hi\7i\2\2i\6\3\2\2\2jk\7d\2"+
		"\2kl\7q\2\2lm\7q\2\2mn\7n\2\2no\7g\2\2op\7c\2\2pq\7p\2\2q\b\3\2\2\2rs"+
		"\7h\2\2st\7w\2\2tu\7p\2\2uv\7e\2\2vw\7v\2\2wx\7k\2\2xy\7q\2\2yz\7p\2\2"+
		"z\n\3\2\2\2{|\7x\2\2|}\7q\2\2}~\7k\2\2~\177\7f\2\2\177\f\3\2\2\2\u0080"+
		"\u0081\7d\2\2\u0081\u0082\7t\2\2\u0082\u0083\7g\2\2\u0083\u0084\7c\2\2"+
		"\u0084\u0085\7m\2\2\u0085\u0086\7=\2\2\u0086\16\3\2\2\2\u0087\u0088\7"+
		"e\2\2\u0088\u0089\7q\2\2\u0089\u008a\7p\2\2\u008a\u008b\7v\2\2\u008b\u008c"+
		"\7k\2\2\u008c\u008d\7p\2\2\u008d\u008e\7w\2\2\u008e\u008f\7g\2\2\u008f"+
		"\u0090\7=\2\2\u0090\20\3\2\2\2\u0091\u0092\7t\2\2\u0092\u0093\7g\2\2\u0093"+
		"\u0094\7v\2\2\u0094\u0095\7w\2\2\u0095\u0096\7t\2\2\u0096\u0097\7p\2\2"+
		"\u0097\u0098\7\"\2\2\u0098\22\3\2\2\2\u0099\u009a\7k\2\2\u009a\u009b\7"+
		"h\2\2\u009b\24\3\2\2\2\u009c\u009d\7g\2\2\u009d\u009e\7n\2\2\u009e\u009f"+
		"\7u\2\2\u009f\u00a0\7g\2\2\u00a0\26\3\2\2\2\u00a1\u00a2\7y\2\2\u00a2\u00a3"+
		"\7j\2\2\u00a3\u00a4\7k\2\2\u00a4\u00a5\7n\2\2\u00a5\u00a6\7g\2\2\u00a6"+
		"\30\3\2\2\2\u00a7\u00a8\7h\2\2\u00a8\u00a9\7q\2\2\u00a9\u00aa\7t\2\2\u00aa"+
		"\32\3\2\2\2\u00ab\u00ac\7.\2\2\u00ac\u00ad\7\"\2\2\u00ad\34\3\2\2\2\u00ae"+
		"\u00af\7?\2\2\u00af\36\3\2\2\2\u00b0\u00b1\7-\2\2\u00b1\u00b2\7?\2\2\u00b2"+
		" \3\2\2\2\u00b3\u00b4\7/\2\2\u00b4\"\3\2\2\2\u00b5\u00b6\7#\2\2\u00b6"+
		"$\3\2\2\2\u00b7\u00b8\7\u0080\2\2\u00b8&\3\2\2\2\u00b9\u00ba\7,\2\2\u00ba"+
		"(\3\2\2\2\u00bb\u00bc\7\61\2\2\u00bc*\3\2\2\2\u00bd\u00be\7\'\2\2\u00be"+
		",\3\2\2\2\u00bf\u00c0\7-\2\2\u00c0.\3\2\2\2\u00c1\u00c2\7?\2\2\u00c2\u00c3"+
		"\7?\2\2\u00c3\60\3\2\2\2\u00c4\u00c5\7#\2\2\u00c5\u00c6\7?\2\2\u00c6\62"+
		"\3\2\2\2\u00c7\u00c8\7>\2\2\u00c8\64\3\2\2\2\u00c9\u00ca\7@\2\2\u00ca"+
		"\66\3\2\2\2\u00cb\u00cc\7>\2\2\u00cc\u00cd\7?\2\2\u00cd8\3\2\2\2\u00ce"+
		"\u00cf\7@\2\2\u00cf\u00d0\7?\2\2\u00d0:\3\2\2\2\u00d1\u00d2\7(\2\2\u00d2"+
		"\u00d3\7(\2\2\u00d3<\3\2\2\2\u00d4\u00d5\7~\2\2\u00d5\u00d6\7~\2\2\u00d6"+
		">\3\2\2\2\u00d7\u00d8\7t\2\2\u00d8\u00d9\7g\2\2\u00d9\u00da\7c\2\2\u00da"+
		"\u00db\7f\2\2\u00db@\3\2\2\2\u00dc\u00dd\7y\2\2\u00dd\u00de\7t\2\2\u00de"+
		"\u00df\7k\2\2\u00df\u00e0\7v\2\2\u00e0\u00e1\7g\2\2\u00e1B\3\2\2\2\u00e2"+
		"\u00e3\7h\2\2\u00e3\u00e4\7w\2\2\u00e4\u00e5\7p\2\2\u00e5\u00e6\7e\2\2"+
		"\u00e6\u00e7\7v\2\2\u00e7\u00e8\7k\2\2\u00e8\u00e9\7q\2\2\u00e9\u00ea"+
		"\7p\2\2\u00ea\u00eb\7>\2\2\u00ebD\3\2\2\2\u00ec\u00ed\t\2\2\2\u00ed\u00ee"+
		"\3\2\2\2\u00ee\u00ef\b#\2\2\u00efF\3\2\2\2\u00f0\u00f1\7\61\2\2\u00f1"+
		"\u00f2\7,\2\2\u00f2\u00f6\3\2\2\2\u00f3\u00f5\13\2\2\2\u00f4\u00f3\3\2"+
		"\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7"+
		"\u00f9\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fa\7,\2\2\u00fa\u00fb\7\61"+
		"\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\b$\2\2\u00fdH\3\2\2\2\u00fe\u00ff"+
		"\7\61\2\2\u00ff\u0100\7\61\2\2\u0100\u0104\3\2\2\2\u0101\u0103\n\3\2\2"+
		"\u0102\u0101\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105"+
		"\3\2\2\2\u0105\u0107\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u0108\b%\2\2\u0108"+
		"J\3\2\2\2\u0109\u010a\7*\2\2\u010aL\3\2\2\2\u010b\u010c\7+\2\2\u010cN"+
		"\3\2\2\2\u010d\u010e\7}\2\2\u010eP\3\2\2\2\u010f\u0110\7\177\2\2\u0110"+
		"R\3\2\2\2\u0111\u0112\7.\2\2\u0112T\3\2\2\2\u0113\u0114\7=\2\2\u0114V"+
		"\3\2\2\2\u0115\u0119\t\4\2\2\u0116\u0118\t\5\2\2\u0117\u0116\3\2\2\2\u0118"+
		"\u011b\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011aX\3\2\2\2"+
		"\u011b\u0119\3\2\2\2\u011c\u0120\t\6\2\2\u011d\u011f\t\7\2\2\u011e\u011d"+
		"\3\2\2\2\u011f\u0122\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121"+
		"\u0125\3\2\2\2\u0122\u0120\3\2\2\2\u0123\u0125\7\62\2\2\u0124\u011c\3"+
		"\2\2\2\u0124\u0123\3\2\2\2\u0125Z\3\2\2\2\u0126\u012a\7$\2\2\u0127\u0129"+
		"\n\b\2\2\u0128\u0127\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012a"+
		"\u012b\3\2\2\2\u012b\u012d\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u012e\7$"+
		"\2\2\u012e\\\3\2\2\2\u012f\u0130\7v\2\2\u0130\u0131\7t\2\2\u0131\u0132"+
		"\7w\2\2\u0132\u0139\7g\2\2\u0133\u0134\7h\2\2\u0134\u0135\7c\2\2\u0135"+
		"\u0136\7n\2\2\u0136\u0137\7u\2\2\u0137\u0139\7g\2\2\u0138\u012f\3\2\2"+
		"\2\u0138\u0133\3\2\2\2\u0139^\3\2\2\2\n\2\u00f6\u0104\u0119\u0120\u0124"+
		"\u012a\u0138\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}