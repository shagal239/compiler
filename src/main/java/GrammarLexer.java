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
		T__31=32, WS=33, COMMENT=34, LINE_COMMENT=35, LPAREN=36, RPAREN=37, LBRACE=38, 
		RBRACE=39, COMMA=40, SEMI=41, Identifier=42, IntegerLiteral=43, StringLiteral=44, 
		BooleanLiteral=45;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "WS", "COMMENT", 
		"LINE_COMMENT", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "COMMA", "SEMI", 
		"Identifier", "IntegerLiteral", "StringLiteral", "BooleanLiteral"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'int'", "'string'", "'boolean'", "'function<'", "'>'", "'void'", 
		"'break;'", "'continue;'", "'return '", "'if'", "'else'", "'while'", "'for'", 
		"', '", "'='", "'+='", "'-'", "'!'", "'~'", "'*'", "'/'", "'%'", "'+'", 
		"'=='", "'!='", "'<'", "'<='", "'>='", "'&&'", "'||'", "'read'", "'write'", 
		null, null, null, "'('", "')'", "'{'", "'}'", "','", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "WS", "COMMENT", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2/\u012f\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 "+
		"\3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\7#\u00ea\n#\f#\16"+
		"#\u00ed\13#\3#\3#\3#\3#\3#\3$\3$\3$\3$\7$\u00f8\n$\f$\16$\u00fb\13$\3"+
		"$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\7+\u010d\n+\f+\16+\u0110"+
		"\13+\3,\3,\7,\u0114\n,\f,\16,\u0117\13,\3,\5,\u011a\n,\3-\3-\7-\u011e"+
		"\n-\f-\16-\u0121\13-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\3.\5.\u012e\n.\3\u00eb"+
		"\2/\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/\3\2\t\5\2\13\f\17\17\"\"\4\2\f"+
		"\f\17\17\6\2&&C\\aac|\7\2&&\62;C\\aac|\3\2\63;\3\2\62;\4\2$$^^\u0135\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2"+
		"\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U"+
		"\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\3]\3\2\2\2\5a\3\2\2\2\7h\3\2"+
		"\2\2\tp\3\2\2\2\13z\3\2\2\2\r|\3\2\2\2\17\u0081\3\2\2\2\21\u0088\3\2\2"+
		"\2\23\u0092\3\2\2\2\25\u009a\3\2\2\2\27\u009d\3\2\2\2\31\u00a2\3\2\2\2"+
		"\33\u00a8\3\2\2\2\35\u00ac\3\2\2\2\37\u00af\3\2\2\2!\u00b1\3\2\2\2#\u00b4"+
		"\3\2\2\2%\u00b6\3\2\2\2\'\u00b8\3\2\2\2)\u00ba\3\2\2\2+\u00bc\3\2\2\2"+
		"-\u00be\3\2\2\2/\u00c0\3\2\2\2\61\u00c2\3\2\2\2\63\u00c5\3\2\2\2\65\u00c8"+
		"\3\2\2\2\67\u00ca\3\2\2\29\u00cd\3\2\2\2;\u00d0\3\2\2\2=\u00d3\3\2\2\2"+
		"?\u00d6\3\2\2\2A\u00db\3\2\2\2C\u00e1\3\2\2\2E\u00e5\3\2\2\2G\u00f3\3"+
		"\2\2\2I\u00fe\3\2\2\2K\u0100\3\2\2\2M\u0102\3\2\2\2O\u0104\3\2\2\2Q\u0106"+
		"\3\2\2\2S\u0108\3\2\2\2U\u010a\3\2\2\2W\u0119\3\2\2\2Y\u011b\3\2\2\2["+
		"\u012d\3\2\2\2]^\7k\2\2^_\7p\2\2_`\7v\2\2`\4\3\2\2\2ab\7u\2\2bc\7v\2\2"+
		"cd\7t\2\2de\7k\2\2ef\7p\2\2fg\7i\2\2g\6\3\2\2\2hi\7d\2\2ij\7q\2\2jk\7"+
		"q\2\2kl\7n\2\2lm\7g\2\2mn\7c\2\2no\7p\2\2o\b\3\2\2\2pq\7h\2\2qr\7w\2\2"+
		"rs\7p\2\2st\7e\2\2tu\7v\2\2uv\7k\2\2vw\7q\2\2wx\7p\2\2xy\7>\2\2y\n\3\2"+
		"\2\2z{\7@\2\2{\f\3\2\2\2|}\7x\2\2}~\7q\2\2~\177\7k\2\2\177\u0080\7f\2"+
		"\2\u0080\16\3\2\2\2\u0081\u0082\7d\2\2\u0082\u0083\7t\2\2\u0083\u0084"+
		"\7g\2\2\u0084\u0085\7c\2\2\u0085\u0086\7m\2\2\u0086\u0087\7=\2\2\u0087"+
		"\20\3\2\2\2\u0088\u0089\7e\2\2\u0089\u008a\7q\2\2\u008a\u008b\7p\2\2\u008b"+
		"\u008c\7v\2\2\u008c\u008d\7k\2\2\u008d\u008e\7p\2\2\u008e\u008f\7w\2\2"+
		"\u008f\u0090\7g\2\2\u0090\u0091\7=\2\2\u0091\22\3\2\2\2\u0092\u0093\7"+
		"t\2\2\u0093\u0094\7g\2\2\u0094\u0095\7v\2\2\u0095\u0096\7w\2\2\u0096\u0097"+
		"\7t\2\2\u0097\u0098\7p\2\2\u0098\u0099\7\"\2\2\u0099\24\3\2\2\2\u009a"+
		"\u009b\7k\2\2\u009b\u009c\7h\2\2\u009c\26\3\2\2\2\u009d\u009e\7g\2\2\u009e"+
		"\u009f\7n\2\2\u009f\u00a0\7u\2\2\u00a0\u00a1\7g\2\2\u00a1\30\3\2\2\2\u00a2"+
		"\u00a3\7y\2\2\u00a3\u00a4\7j\2\2\u00a4\u00a5\7k\2\2\u00a5\u00a6\7n\2\2"+
		"\u00a6\u00a7\7g\2\2\u00a7\32\3\2\2\2\u00a8\u00a9\7h\2\2\u00a9\u00aa\7"+
		"q\2\2\u00aa\u00ab\7t\2\2\u00ab\34\3\2\2\2\u00ac\u00ad\7.\2\2\u00ad\u00ae"+
		"\7\"\2\2\u00ae\36\3\2\2\2\u00af\u00b0\7?\2\2\u00b0 \3\2\2\2\u00b1\u00b2"+
		"\7-\2\2\u00b2\u00b3\7?\2\2\u00b3\"\3\2\2\2\u00b4\u00b5\7/\2\2\u00b5$\3"+
		"\2\2\2\u00b6\u00b7\7#\2\2\u00b7&\3\2\2\2\u00b8\u00b9\7\u0080\2\2\u00b9"+
		"(\3\2\2\2\u00ba\u00bb\7,\2\2\u00bb*\3\2\2\2\u00bc\u00bd\7\61\2\2\u00bd"+
		",\3\2\2\2\u00be\u00bf\7\'\2\2\u00bf.\3\2\2\2\u00c0\u00c1\7-\2\2\u00c1"+
		"\60\3\2\2\2\u00c2\u00c3\7?\2\2\u00c3\u00c4\7?\2\2\u00c4\62\3\2\2\2\u00c5"+
		"\u00c6\7#\2\2\u00c6\u00c7\7?\2\2\u00c7\64\3\2\2\2\u00c8\u00c9\7>\2\2\u00c9"+
		"\66\3\2\2\2\u00ca\u00cb\7>\2\2\u00cb\u00cc\7?\2\2\u00cc8\3\2\2\2\u00cd"+
		"\u00ce\7@\2\2\u00ce\u00cf\7?\2\2\u00cf:\3\2\2\2\u00d0\u00d1\7(\2\2\u00d1"+
		"\u00d2\7(\2\2\u00d2<\3\2\2\2\u00d3\u00d4\7~\2\2\u00d4\u00d5\7~\2\2\u00d5"+
		">\3\2\2\2\u00d6\u00d7\7t\2\2\u00d7\u00d8\7g\2\2\u00d8\u00d9\7c\2\2\u00d9"+
		"\u00da\7f\2\2\u00da@\3\2\2\2\u00db\u00dc\7y\2\2\u00dc\u00dd\7t\2\2\u00dd"+
		"\u00de\7k\2\2\u00de\u00df\7v\2\2\u00df\u00e0\7g\2\2\u00e0B\3\2\2\2\u00e1"+
		"\u00e2\t\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\b\"\2\2\u00e4D\3\2\2\2"+
		"\u00e5\u00e6\7\61\2\2\u00e6\u00e7\7,\2\2\u00e7\u00eb\3\2\2\2\u00e8\u00ea"+
		"\13\2\2\2\u00e9\u00e8\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00ec\3\2\2\2"+
		"\u00eb\u00e9\3\2\2\2\u00ec\u00ee\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00ef"+
		"\7,\2\2\u00ef\u00f0\7\61\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\b#\2\2\u00f2"+
		"F\3\2\2\2\u00f3\u00f4\7\61\2\2\u00f4\u00f5\7\61\2\2\u00f5\u00f9\3\2\2"+
		"\2\u00f6\u00f8\n\3\2\2\u00f7\u00f6\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7"+
		"\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fc\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc"+
		"\u00fd\b$\2\2\u00fdH\3\2\2\2\u00fe\u00ff\7*\2\2\u00ffJ\3\2\2\2\u0100\u0101"+
		"\7+\2\2\u0101L\3\2\2\2\u0102\u0103\7}\2\2\u0103N\3\2\2\2\u0104\u0105\7"+
		"\177\2\2\u0105P\3\2\2\2\u0106\u0107\7.\2\2\u0107R\3\2\2\2\u0108\u0109"+
		"\7=\2\2\u0109T\3\2\2\2\u010a\u010e\t\4\2\2\u010b\u010d\t\5\2\2\u010c\u010b"+
		"\3\2\2\2\u010d\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f"+
		"V\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u0115\t\6\2\2\u0112\u0114\t\7\2\2"+
		"\u0113\u0112\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116"+
		"\3\2\2\2\u0116\u011a\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u011a\7\62\2\2"+
		"\u0119\u0111\3\2\2\2\u0119\u0118\3\2\2\2\u011aX\3\2\2\2\u011b\u011f\7"+
		"$\2\2\u011c\u011e\n\b\2\2\u011d\u011c\3\2\2\2\u011e\u0121\3\2\2\2\u011f"+
		"\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0122\3\2\2\2\u0121\u011f\3\2"+
		"\2\2\u0122\u0123\7$\2\2\u0123Z\3\2\2\2\u0124\u0125\7v\2\2\u0125\u0126"+
		"\7t\2\2\u0126\u0127\7w\2\2\u0127\u012e\7g\2\2\u0128\u0129\7h\2\2\u0129"+
		"\u012a\7c\2\2\u012a\u012b\7n\2\2\u012b\u012c\7u\2\2\u012c\u012e\7g\2\2"+
		"\u012d\u0124\3\2\2\2\u012d\u0128\3\2\2\2\u012e\\\3\2\2\2\n\2\u00eb\u00f9"+
		"\u010e\u0115\u0119\u011f\u012d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}