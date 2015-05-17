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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, WS=6, COMMENT=7, LINE_COMMENT=8, 
		LPAREN=9, RPAREN=10, LBRACE=11, RBRACE=12, COMMA=13, SEMI=14, Identifier=15, 
		IntegerLiteral=16, StringLiteral=17, BooleanLiteral=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "WS", "COMMENT", "LINE_COMMENT", 
		"LPAREN", "RPAREN", "LBRACE", "RBRACE", "COMMA", "SEMI", "Identifier", 
		"IntegerLiteral", "StringLiteral", "BooleanLiteral"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'int'", "'string'", "'boolean'", "'void'", "', '", null, null, 
		null, "'('", "')'", "'{'", "'}'", "','", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "WS", "COMMENT", "LINE_COMMENT", "LPAREN", 
		"RPAREN", "LBRACE", "RBRACE", "COMMA", "SEMI", "Identifier", "IntegerLiteral", 
		"StringLiteral", "BooleanLiteral"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\24\u0090\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\7\bK\n\b\f\b\16\bN\13\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\7\tY\n\t\f\t\16\t\\\13\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r"+
		"\3\r\3\16\3\16\3\17\3\17\3\20\3\20\7\20n\n\20\f\20\16\20q\13\20\3\21\3"+
		"\21\7\21u\n\21\f\21\16\21x\13\21\3\21\5\21{\n\21\3\22\3\22\7\22\177\n"+
		"\22\f\22\16\22\u0082\13\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\5\23\u008f\n\23\3L\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\3\2\t\5\2\13\f\17"+
		"\17\"\"\4\2\f\f\17\17\6\2&&C\\aac|\7\2&&\62;C\\aac|\3\2\63;\3\2\62;\4"+
		"\2$$^^\u0096\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5+\3\2\2\2\7\62\3\2\2\2\t:\3\2"+
		"\2\2\13?\3\2\2\2\rB\3\2\2\2\17F\3\2\2\2\21T\3\2\2\2\23_\3\2\2\2\25a\3"+
		"\2\2\2\27c\3\2\2\2\31e\3\2\2\2\33g\3\2\2\2\35i\3\2\2\2\37k\3\2\2\2!z\3"+
		"\2\2\2#|\3\2\2\2%\u008e\3\2\2\2\'(\7k\2\2()\7p\2\2)*\7v\2\2*\4\3\2\2\2"+
		"+,\7u\2\2,-\7v\2\2-.\7t\2\2./\7k\2\2/\60\7p\2\2\60\61\7i\2\2\61\6\3\2"+
		"\2\2\62\63\7d\2\2\63\64\7q\2\2\64\65\7q\2\2\65\66\7n\2\2\66\67\7g\2\2"+
		"\678\7c\2\289\7p\2\29\b\3\2\2\2:;\7x\2\2;<\7q\2\2<=\7k\2\2=>\7f\2\2>\n"+
		"\3\2\2\2?@\7.\2\2@A\7\"\2\2A\f\3\2\2\2BC\t\2\2\2CD\3\2\2\2DE\b\7\2\2E"+
		"\16\3\2\2\2FG\7\61\2\2GH\7,\2\2HL\3\2\2\2IK\13\2\2\2JI\3\2\2\2KN\3\2\2"+
		"\2LM\3\2\2\2LJ\3\2\2\2MO\3\2\2\2NL\3\2\2\2OP\7,\2\2PQ\7\61\2\2QR\3\2\2"+
		"\2RS\b\b\2\2S\20\3\2\2\2TU\7\61\2\2UV\7\61\2\2VZ\3\2\2\2WY\n\3\2\2XW\3"+
		"\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[]\3\2\2\2\\Z\3\2\2\2]^\b\t\2\2^"+
		"\22\3\2\2\2_`\7*\2\2`\24\3\2\2\2ab\7+\2\2b\26\3\2\2\2cd\7}\2\2d\30\3\2"+
		"\2\2ef\7\177\2\2f\32\3\2\2\2gh\7.\2\2h\34\3\2\2\2ij\7=\2\2j\36\3\2\2\2"+
		"ko\t\4\2\2ln\t\5\2\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2p \3\2\2\2"+
		"qo\3\2\2\2rv\t\6\2\2su\t\7\2\2ts\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2"+
		"w{\3\2\2\2xv\3\2\2\2y{\7\62\2\2zr\3\2\2\2zy\3\2\2\2{\"\3\2\2\2|\u0080"+
		"\7$\2\2}\177\n\b\2\2~}\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080"+
		"\u0081\3\2\2\2\u0081\u0083\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0084\7$"+
		"\2\2\u0084$\3\2\2\2\u0085\u0086\7v\2\2\u0086\u0087\7t\2\2\u0087\u0088"+
		"\7w\2\2\u0088\u008f\7g\2\2\u0089\u008a\7h\2\2\u008a\u008b\7c\2\2\u008b"+
		"\u008c\7n\2\2\u008c\u008d\7u\2\2\u008d\u008f\7g\2\2\u008e\u0085\3\2\2"+
		"\2\u008e\u0089\3\2\2\2\u008f&\3\2\2\2\n\2LZovz\u0080\u008e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}