// Generated from /home/arkady/Documents/devcompiler/compiler/src/main/java/Grammar.g4 by ANTLR 4.5
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		WS=32, COMMENT=33, LINE_COMMENT=34, LPAREN=35, RPAREN=36, LBRACE=37, RBRACE=38, 
		COMMA=39, SEMI=40, Identifier=41, IntegerLiteral=42, StringLiteral=43, 
		BooleanLiteral=44;
	public static final int
		RULE_type = 0, RULE_methodtype = 1, RULE_start = 2, RULE_body = 3, RULE_methodDeclaration = 4, 
		RULE_block = 5, RULE_blockStatement = 6, RULE_statement = 7, RULE_ifstatement = 8, 
		RULE_whilestatement = 9, RULE_forstatement = 10, RULE_declaration = 11, 
		RULE_forinit = 12, RULE_varibleDeclaration = 13, RULE_emptyexpression = 14, 
		RULE_expression = 15, RULE_expression1 = 16, RULE_primary = 17, RULE_expressionList = 18, 
		RULE_ioFunctions = 19, RULE_parameters = 20, RULE_parameter = 21, RULE_literal = 22;
	public static final String[] ruleNames = {
		"type", "methodtype", "start", "body", "methodDeclaration", "block", "blockStatement", 
		"statement", "ifstatement", "whilestatement", "forstatement", "declaration", 
		"forinit", "varibleDeclaration", "emptyexpression", "expression", "expression1", 
		"primary", "expressionList", "ioFunctions", "parameters", "parameter", 
		"literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'int'", "'string'", "'boolean'", "'void'", "'break;'", "'continue;'", 
		"'return '", "'if'", "'else'", "'while'", "'for'", "', '", "'='", "'+='", 
		"'-'", "'!'", "'~'", "'*'", "'/'", "'%'", "'+'", "'=='", "'!='", "'<'", 
		"'>'", "'<='", "'>='", "'&&'", "'||'", "'read'", "'write'", null, null, 
		null, "'('", "')'", "'{'", "'}'", "','", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "WS", "COMMENT", "LINE_COMMENT", 
		"LPAREN", "RPAREN", "LBRACE", "RBRACE", "COMMA", "SEMI", "Identifier", 
		"IntegerLiteral", "StringLiteral", "BooleanLiteral"
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
	@NotNull
	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    List<Scope> scopes = new ArrayList<Scope>();
	    List<Variable> returnVariables = new ArrayList<Variable>();
	    List<String> loopStart = new ArrayList<String>();
	    List<String> loopEnd = new ArrayList<String>();
	    List<String> code = new ArrayList<String>();
	    int tempId = 0;
	    int labelId = 0;

	    public String label(){
	        return "loop" + (labelId++);
	    }


	    public String newLabel() {
	        code.add("l" + labelId + ":");
	        return label();
	    }

	    public void openScope(){
	        scopes.add(new Scope());
	    }

	    public void closeScope(){
	        scopes.remove(scopes.size() - 1);
	    }

	    public void openLoop() {
	        openScope();
	        loopStart.add(label());
	        loopEnd.add(label());
	        code.add(loopStart.get(loopStart.size() - 1) + ":");
	    }

	    public void closeLoop() {
	        openScope();
	        code.add(loopEnds.get(loopEnds.size() - 1) + ":");
	        loopStart.remove(loopStart.size() - 1);
	        loopEnd.remove(loopEnd.size() - 1);
	    }

	    public String getLoopStart() {
	        return loopStart.get(loopStart.size() - 1);
	    }

	    public String getLoopEnd() {
	        return loopEnd.get(loopEnd.size() - 1);
	    }

	    public Variable createTempVariable(Type type) {
	        if (type == Type.VoidType) {
	            return Variable.Void;
	        }
	        code.add(type + " t" + tempId);
	        return new Variable(type, "t" + tempId++);
	    }

	    public Variable createVariable(String name, Type type) {
	        Map<String, Variable> lastScope = variables.get(variables.size() - 1);
	        if (lastScope.containsKey(name)) {
	             throw new CompilationError("The variable with name " + name + " is already in the scope.");
	        }
	        Scope scope = scopes.get(scopes.size() - 1);
	        if (scope.contains(name)){
	            return null;
	        } else {
	            Variable v = new Variable(type, "v" + (id++));
	            code.add(v.getType() + " " + v.getName());
	            scope.addVariable(v);
	            return v;
	        }
	    }

	    public Variable resolveVariable(String name) {
	        int scope = scopes.size() - 1;
	        while (scope >= 0) {
	            Scope s = scopes.get(scope);
	             Variable variable = s.get(name);
	             if (variable != null) {
	                return variable;
	             }
	             scope--;
	        }
	    }

	    public Variable registerFunction(String name, Type result, List<Variable> arguments) {
	        openScope();
	        Type[] types = new Type[arguments.size()];
	        for (int i = 0; i < types.length;i++) {
	            types[i] = arguments.get(i).getType();
	        }
	        Functions.add(new Function(name, result, types));
	        code.add(function.getName() + ":");
	        Variable res = createTempVariable(function.getResultType());
	        code.add("pop " + res);
	        Collections.reverse(arguments);
	        for (Variable variable: arguments) {
	            Variable v = createVariable(variable.getName(), variable.getType());
	            code.add("pop " + v.getName());
	        }

	        returnVariables.add(res);

	        return res;
	    }

	    public void endFunction() {
	        endScope();
	        returnVariables.remove(returnVariables.size() - 1);
	    }

	    public Variable callFunction(String name, List<Variable> variables) {
	        Function function = Functions.get(name, variables);
	        for (Variable variable: variables) {
	            code.add("param " + variable.getName());
	        }

	        if (function.getResult() != VoidType.instance) {
	           Variable t = createTempVariable(function.getResultType());
	           code.add("param &" + t.getName());
	           code.add("call " + function.getName());
	           return t;
	        } else {
	            code.add("param &void");
	            code.add("call " + function.getName());
	            return new Variable("void", VoidType.instance);
	        }
	    }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class TypeContext extends ParserRuleContext {
		public Type result;
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_type);
		try {
			setState(52);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(46); 
				match(T__0);
				((TypeContext)_localctx).result =  Type.IntegerType;
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(48); 
				match(T__1);
				((TypeContext)_localctx).result =  Type.StringType;
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(50); 
				match(T__2);
				((TypeContext)_localctx).result =  Type.BooleanType;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodtypeContext extends ParserRuleContext {
		public Type result;
		public TypeContext type;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public MethodtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodtype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterMethodtype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitMethodtype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitMethodtype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodtypeContext methodtype() throws RecognitionException {
		MethodtypeContext _localctx = new MethodtypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_methodtype);
		try {
			setState(59);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(54); 
				((MethodtypeContext)_localctx).type = type();
				((MethodtypeContext)_localctx).result =  ((MethodtypeContext)_localctx).type.result;
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(57); 
				match(T__3);
				((MethodtypeContext)_localctx).result =  Type.VoidType;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StartContext extends ParserRuleContext {
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61); 
			body();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BodyContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public List<MethodDeclarationContext> methodDeclaration() {
			return getRuleContexts(MethodDeclarationContext.class);
		}
		public MethodDeclarationContext methodDeclaration(int i) {
			return getRuleContext(MethodDeclarationContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3))) != 0)) {
				{
				{
				setState(63); 
				methodDeclaration();
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69); 
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclarationContext extends ParserRuleContext {
		public MethodtypeContext methodtype;
		public Token Identifier;
		public ParametersContext a;
		public MethodtypeContext methodtype() {
			return getRuleContext(MethodtypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(GrammarParser.Identifier, 0); }
		public TerminalNode LPAREN() { return getToken(GrammarParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(GrammarParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitMethodDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitMethodDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71); 
			((MethodDeclarationContext)_localctx).methodtype = methodtype();
			setState(72); 
			((MethodDeclarationContext)_localctx).Identifier = match(Identifier);
			setState(73); 
			match(LPAREN);
			setState(75);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2))) != 0)) {
				{
				setState(74); 
				((MethodDeclarationContext)_localctx).a = parameters();
				}
			}

			setState(77); 
			match(RPAREN);
			List<Variable> args = new ArrayList<Variable>();
			    if (((MethodDeclarationContext)_localctx).a != null) {
			        args = ((MethodDeclarationContext)_localctx).a.vars;
			    }
			    registerFunction((((MethodDeclarationContext)_localctx).Identifier!=null?((MethodDeclarationContext)_localctx).Identifier.getText():null), ((MethodDeclarationContext)_localctx).methodtype.result, args);
			    
			setState(79); 
			block();

			        endFunction();
			        code.add("back");
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(GrammarParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(GrammarParser.RBRACE, 0); }
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82); 
			match(LBRACE);
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__29) | (1L << T__30) | (1L << LPAREN) | (1L << LBRACE) | (1L << SEMI) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << BooleanLiteral))) != 0)) {
				{
				{
				setState(83); 
				blockStatement();
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89); 
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStatementContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_blockStatement);
		try {
			setState(93);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(91); 
				declaration();
				}
				break;
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__9:
			case T__10:
			case T__14:
			case T__15:
			case T__16:
			case T__29:
			case T__30:
			case LPAREN:
			case LBRACE:
			case SEMI:
			case Identifier:
			case IntegerLiteral:
			case StringLiteral:
			case BooleanLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(92); 
				statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IfstatementContext ifstatement() {
			return getRuleContext(IfstatementContext.class,0);
		}
		public ForstatementContext forstatement() {
			return getRuleContext(ForstatementContext.class,0);
		}
		public WhilestatementContext whilestatement() {
			return getRuleContext(WhilestatementContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		int _la;
		try {
			setState(110);
			switch (_input.LA(1)) {
			case SEMI:
				enterOuterAlt(_localctx, 1);
				{
				setState(95); 
				match(SEMI);
				}
				break;
			case T__14:
			case T__15:
			case T__16:
			case T__29:
			case T__30:
			case LPAREN:
			case Identifier:
			case IntegerLiteral:
			case StringLiteral:
			case BooleanLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(96); 
				expression();
				setState(97); 
				match(SEMI);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(99); 
				ifstatement();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 4);
				{
				setState(100); 
				forstatement();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(101); 
				whilestatement();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 6);
				{
				setState(102); 
				block();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 7);
				{
				setState(103); 
				match(T__4);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 8);
				{
				setState(104); 
				match(T__5);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 9);
				{
				setState(105); 
				match(T__6);
				setState(107);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__29) | (1L << T__30) | (1L << LPAREN) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << BooleanLiteral))) != 0)) {
					{
					setState(106); 
					expression();
					}
				}

				setState(109); 
				match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfstatementContext extends ParserRuleContext {
		public ExpressionContext a;
		public TerminalNode LPAREN() { return getToken(GrammarParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(GrammarParser.RPAREN, 0); }
		public List<TerminalNode> LBRACE() { return getTokens(GrammarParser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(GrammarParser.LBRACE, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> RBRACE() { return getTokens(GrammarParser.RBRACE); }
		public TerminalNode RBRACE(int i) {
			return getToken(GrammarParser.RBRACE, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IfstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterIfstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitIfstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitIfstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfstatementContext ifstatement() throws RecognitionException {
		IfstatementContext _localctx = new IfstatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifstatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112); 
			match(T__7);
			setState(113); 
			match(LPAREN);
			setState(114); 
			((IfstatementContext)_localctx).a = expression();

			setState(116); 
			match(RPAREN);
			setState(117); 
			match(LBRACE);
			setState(118); 
			statement();
			setState(119); 
			match(RBRACE);
			setState(125);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(120); 
				match(T__8);
				setState(121); 
				match(LBRACE);
				setState(122); 
				statement();
				setState(123); 
				match(RBRACE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhilestatementContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(GrammarParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(GrammarParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhilestatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whilestatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterWhilestatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitWhilestatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitWhilestatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhilestatementContext whilestatement() throws RecognitionException {
		WhilestatementContext _localctx = new WhilestatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_whilestatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127); 
			match(T__9);
			setState(128); 
			match(LPAREN);
			setState(129); 
			expression();
			setState(130); 
			match(RPAREN);
			setState(131); 
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForstatementContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(GrammarParser.LPAREN, 0); }
		public ForinitContext forinit() {
			return getRuleContext(ForinitContext.class,0);
		}
		public EmptyexpressionContext emptyexpression() {
			return getRuleContext(EmptyexpressionContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(GrammarParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterForstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitForstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitForstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForstatementContext forstatement() throws RecognitionException {
		ForstatementContext _localctx = new ForstatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_forstatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133); 
			match(T__10);
			setState(134); 
			match(LPAREN);
			setState(135); 
			forinit();
			setState(136); 
			match(SEMI);
			setState(137); 
			emptyexpression();
			setState(138); 
			match(SEMI);
			setState(139); 
			expressionList();
			setState(140); 
			match(RPAREN);
			setState(141); 
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<VaribleDeclarationContext> varibleDeclaration() {
			return getRuleContexts(VaribleDeclarationContext.class);
		}
		public VaribleDeclarationContext varibleDeclaration(int i) {
			return getRuleContext(VaribleDeclarationContext.class,i);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143); 
			type();
			setState(144); 
			varibleDeclaration();
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(145); 
				match(T__11);
				setState(146); 
				varibleDeclaration();
				}
				}
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(152); 
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForinitContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ForinitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forinit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterForinit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitForinit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitForinit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForinitContext forinit() throws RecognitionException {
		ForinitContext _localctx = new ForinitContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_forinit);
		try {
			setState(156);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(154); 
				declaration();
				}
				break;
			case T__14:
			case T__15:
			case T__16:
			case T__29:
			case T__30:
			case LPAREN:
			case SEMI:
			case Identifier:
			case IntegerLiteral:
			case StringLiteral:
			case BooleanLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(155); 
				expressionList();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VaribleDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(GrammarParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VaribleDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varibleDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterVaribleDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitVaribleDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitVaribleDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VaribleDeclarationContext varibleDeclaration() throws RecognitionException {
		VaribleDeclarationContext _localctx = new VaribleDeclarationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_varibleDeclaration);
		try {
			setState(162);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(158); 
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(159); 
				match(Identifier);
				setState(160); 
				match(T__12);
				setState(161); 
				expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EmptyexpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public EmptyexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterEmptyexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitEmptyexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitEmptyexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyexpressionContext emptyexpression() throws RecognitionException {
		EmptyexpressionContext _localctx = new EmptyexpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_emptyexpression);
		try {
			setState(166);
			switch (_input.LA(1)) {
			case SEMI:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__14:
			case T__15:
			case T__16:
			case T__29:
			case T__30:
			case LPAREN:
			case Identifier:
			case IntegerLiteral:
			case StringLiteral:
			case BooleanLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(165); 
				expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Variable var;
		public Token Operators;
		public TerminalNode Identifier() { return getToken(GrammarParser.Identifier, 0); }
		public Expression1Context expression1() {
			return getRuleContext(Expression1Context.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expression);
		int _la;
		try {
			setState(172);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(168); 
				match(Identifier);
				setState(169);
				((ExpressionContext)_localctx).Operators = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__12 || _la==T__13) ) {
					((ExpressionContext)_localctx).Operators = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(170); 
				expression1(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(171); 
				expression1(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expression1Context extends ParserRuleContext {
		public Variable var;
		public Expression1Context a;
		public Token op;
		public PrimaryContext primary;
		public Expression1Context b;
		public List<Expression1Context> expression1() {
			return getRuleContexts(Expression1Context.class);
		}
		public Expression1Context expression1(int i) {
			return getRuleContext(Expression1Context.class,i);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public Expression1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterExpression1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitExpression1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitExpression1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expression1Context expression1() throws RecognitionException {
		return expression1(0);
	}

	private Expression1Context expression1(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expression1Context _localctx = new Expression1Context(_ctx, _parentState);
		Expression1Context _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expression1, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			switch (_input.LA(1)) {
			case T__14:
			case T__15:
			case T__16:
				{
				setState(175);
				((Expression1Context)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16))) != 0)) ) {
					((Expression1Context)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(176); 
				expression1(6);

				        Variable v = expression1.var;
				        ((Expression1Context)_localctx).var =  v;
				    
				}
				break;
			case T__29:
			case T__30:
			case LPAREN:
			case Identifier:
			case IntegerLiteral:
			case StringLiteral:
			case BooleanLiteral:
				{
				setState(179); 
				((Expression1Context)_localctx).primary = primary();
				_localctx.var = ((Expression1Context)_localctx).primary.var
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(203);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(201);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new Expression1Context(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression1);
						setState(184);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(185);
						((Expression1Context)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) ) {
							((Expression1Context)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(186); 
						((Expression1Context)_localctx).b = expression1(6);

						                  Variable l = ((Expression1Context)_localctx).a.var;
						                  Variable r = ((Expression1Context)_localctx).b.var;

						              
						}
						break;
					case 2:
						{
						_localctx = new Expression1Context(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression1);
						setState(189);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(190);
						((Expression1Context)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__14 || _la==T__20) ) {
							((Expression1Context)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(191); 
						expression1(5);
						}
						break;
					case 3:
						{
						_localctx = new Expression1Context(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression1);
						setState(192);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(193);
						((Expression1Context)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26))) != 0)) ) {
							((Expression1Context)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(194); 
						expression1(4);
						}
						break;
					case 4:
						{
						_localctx = new Expression1Context(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression1);
						setState(195);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(196); 
						match(T__27);
						setState(197); 
						expression1(3);
						}
						break;
					case 5:
						{
						_localctx = new Expression1Context(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression1);
						setState(198);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(199); 
						match(T__28);
						setState(200); 
						expression1(2);
						}
						break;
					}
					} 
				}
				setState(205);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public Variable var;
		public Token Identifier;
		public ExpressionContext expression;
		public TerminalNode Identifier() { return getToken(GrammarParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public IoFunctionsContext ioFunctions() {
			return getRuleContext(IoFunctionsContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_primary);
		try {
			setState(220);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(206); 
				((PrimaryContext)_localctx).Identifier = match(Identifier);
				((PrimaryContext)_localctx).var =  resolveVariable((((PrimaryContext)_localctx).Identifier!=null?((PrimaryContext)_localctx).Identifier.getText():null));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(208); 
				match(LPAREN);
				setState(209); 
				((PrimaryContext)_localctx).expression = expression();
				setState(210); 
				match(RPAREN);
				((PrimaryContext)_localctx).var =  ((PrimaryContext)_localctx).expression.var;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(213); 
				match(Identifier);
				setState(214); 
				match(LPAREN);
				setState(215); 
				expressionList();
				setState(216); 
				match(RPAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(218); 
				ioFunctions();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(219); 
				literal();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionListContext extends ParserRuleContext {
		public List<Variable> vars;
		public ExpressionContext a;
		public ExpressionContext b;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expressionList);
		int _la;
		try {
			setState(235);
			switch (_input.LA(1)) {
			case RPAREN:
			case SEMI:
				enterOuterAlt(_localctx, 1);
				{
				((ExpressionListContext)_localctx).vars =  new ArrayList<Variable>();
				}
				break;
			case T__14:
			case T__15:
			case T__16:
			case T__29:
			case T__30:
			case LPAREN:
			case Identifier:
			case IntegerLiteral:
			case StringLiteral:
			case BooleanLiteral:
				enterOuterAlt(_localctx, 2);
				{
				  ((ExpressionListContext)_localctx).vars =  new ArrayList<Variable>(); 
				setState(224); 
				((ExpressionListContext)_localctx).a = expression();
				_localctx.vars.add(((ExpressionListContext)_localctx).a.var);
				setState(232);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(226); 
					match(COMMA);
					setState(227); 
					((ExpressionListContext)_localctx).b = expression();
					_localctx.vars.add(((ExpressionListContext)_localctx).b.var);
					}
					}
					setState(234);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IoFunctionsContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(GrammarParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IoFunctionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ioFunctions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterIoFunctions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitIoFunctions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitIoFunctions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IoFunctionsContext ioFunctions() throws RecognitionException {
		IoFunctionsContext _localctx = new IoFunctionsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_ioFunctions);
		try {
			setState(246);
			switch (_input.LA(1)) {
			case T__29:
				enterOuterAlt(_localctx, 1);
				{
				setState(237); 
				match(T__29);
				setState(238); 
				match(LPAREN);
				setState(239); 
				match(Identifier);
				setState(240); 
				match(RPAREN);
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 2);
				{
				setState(241); 
				match(T__30);
				setState(242); 
				match(LPAREN);
				setState(243); 
				expression();
				setState(244); 
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametersContext extends ParserRuleContext {
		public List<Variable> vars;
		public ParameterContext a;
		public ParameterContext b;
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ParametersContext)_localctx).vars =  new ArrayList<Variable>();
			setState(249); 
			((ParametersContext)_localctx).a = parameter();
			_localctx.vars.add(((ParametersContext)_localctx).a.var);
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(251); 
				match(T__11);
				setState(252); 
				((ParametersContext)_localctx).b = parameter();
				_localctx.vars.add(((ParametersContext)_localctx).b.var);
				}
				}
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterContext extends ParserRuleContext {
		public Variable var;
		public TypeContext type;
		public Token Identifier;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(GrammarParser.Identifier, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260); 
			((ParameterContext)_localctx).type = type();
			setState(261); 
			((ParameterContext)_localctx).Identifier = match(Identifier);
			((ParameterContext)_localctx).var =  new Variable(((ParameterContext)_localctx).type.result, (((ParameterContext)_localctx).Identifier!=null?((ParameterContext)_localctx).Identifier.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(GrammarParser.IntegerLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(GrammarParser.StringLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(GrammarParser.BooleanLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << StringLiteral) | (1L << BooleanLiteral))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16: 
			return expression1_sempred((Expression1Context)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression1_sempred(Expression1Context _localctx, int predIndex) {
		switch (predIndex) {
		case 0: 
			return precpred(_ctx, 5);
		case 1: 
			return precpred(_ctx, 4);
		case 2: 
			return precpred(_ctx, 3);
		case 3: 
			return precpred(_ctx, 2);
		case 4: 
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3.\u010d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\5\2\67\n\2\3\3\3\3\3\3\3\3\3\3\5\3>\n\3\3\4\3\4\3\5\7\5"+
		"C\n\5\f\5\16\5F\13\5\3\5\3\5\3\6\3\6\3\6\3\6\5\6N\n\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\7\7W\n\7\f\7\16\7Z\13\7\3\7\3\7\3\b\3\b\5\b`\n\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tn\n\t\3\t\5\tq\n\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0080\n\n\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\7\r\u0096\n\r\f\r\16\r\u0099\13\r\3\r\3\r\3\16\3\16\5\16\u009f\n"+
		"\16\3\17\3\17\3\17\3\17\5\17\u00a5\n\17\3\20\3\20\5\20\u00a9\n\20\3\21"+
		"\3\21\3\21\3\21\5\21\u00af\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\5\22\u00b9\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u00cc\n\22\f\22\16\22\u00cf\13\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\5\23\u00df\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u00e9\n"+
		"\24\f\24\16\24\u00ec\13\24\5\24\u00ee\n\24\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\5\25\u00f9\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\7\26\u0102\n\26\f\26\16\26\u0105\13\26\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\2\3\"\31\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\2\b\3\2"+
		"\17\20\3\2\21\23\3\2\24\26\4\2\21\21\27\27\3\2\30\35\3\2,.\u0119\2\66"+
		"\3\2\2\2\4=\3\2\2\2\6?\3\2\2\2\bD\3\2\2\2\nI\3\2\2\2\fT\3\2\2\2\16_\3"+
		"\2\2\2\20p\3\2\2\2\22r\3\2\2\2\24\u0081\3\2\2\2\26\u0087\3\2\2\2\30\u0091"+
		"\3\2\2\2\32\u009e\3\2\2\2\34\u00a4\3\2\2\2\36\u00a8\3\2\2\2 \u00ae\3\2"+
		"\2\2\"\u00b8\3\2\2\2$\u00de\3\2\2\2&\u00ed\3\2\2\2(\u00f8\3\2\2\2*\u00fa"+
		"\3\2\2\2,\u0106\3\2\2\2.\u010a\3\2\2\2\60\61\7\3\2\2\61\67\b\2\1\2\62"+
		"\63\7\4\2\2\63\67\b\2\1\2\64\65\7\5\2\2\65\67\b\2\1\2\66\60\3\2\2\2\66"+
		"\62\3\2\2\2\66\64\3\2\2\2\67\3\3\2\2\289\5\2\2\29:\b\3\1\2:>\3\2\2\2;"+
		"<\7\6\2\2<>\b\3\1\2=8\3\2\2\2=;\3\2\2\2>\5\3\2\2\2?@\5\b\5\2@\7\3\2\2"+
		"\2AC\5\n\6\2BA\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2EG\3\2\2\2FD\3\2\2"+
		"\2GH\7\2\2\3H\t\3\2\2\2IJ\5\4\3\2JK\7+\2\2KM\7%\2\2LN\5*\26\2ML\3\2\2"+
		"\2MN\3\2\2\2NO\3\2\2\2OP\7&\2\2PQ\b\6\1\2QR\5\f\7\2RS\b\6\1\2S\13\3\2"+
		"\2\2TX\7\'\2\2UW\5\16\b\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y[\3"+
		"\2\2\2ZX\3\2\2\2[\\\7(\2\2\\\r\3\2\2\2]`\5\30\r\2^`\5\20\t\2_]\3\2\2\2"+
		"_^\3\2\2\2`\17\3\2\2\2aq\7*\2\2bc\5 \21\2cd\7*\2\2dq\3\2\2\2eq\5\22\n"+
		"\2fq\5\26\f\2gq\5\24\13\2hq\5\f\7\2iq\7\7\2\2jq\7\b\2\2km\7\t\2\2ln\5"+
		" \21\2ml\3\2\2\2mn\3\2\2\2no\3\2\2\2oq\7*\2\2pa\3\2\2\2pb\3\2\2\2pe\3"+
		"\2\2\2pf\3\2\2\2pg\3\2\2\2ph\3\2\2\2pi\3\2\2\2pj\3\2\2\2pk\3\2\2\2q\21"+
		"\3\2\2\2rs\7\n\2\2st\7%\2\2tu\5 \21\2uv\b\n\1\2vw\7&\2\2wx\7\'\2\2xy\5"+
		"\20\t\2y\177\7(\2\2z{\7\13\2\2{|\7\'\2\2|}\5\20\t\2}~\7(\2\2~\u0080\3"+
		"\2\2\2\177z\3\2\2\2\177\u0080\3\2\2\2\u0080\23\3\2\2\2\u0081\u0082\7\f"+
		"\2\2\u0082\u0083\7%\2\2\u0083\u0084\5 \21\2\u0084\u0085\7&\2\2\u0085\u0086"+
		"\5\20\t\2\u0086\25\3\2\2\2\u0087\u0088\7\r\2\2\u0088\u0089\7%\2\2\u0089"+
		"\u008a\5\32\16\2\u008a\u008b\7*\2\2\u008b\u008c\5\36\20\2\u008c\u008d"+
		"\7*\2\2\u008d\u008e\5&\24\2\u008e\u008f\7&\2\2\u008f\u0090\5\20\t\2\u0090"+
		"\27\3\2\2\2\u0091\u0092\5\2\2\2\u0092\u0097\5\34\17\2\u0093\u0094\7\16"+
		"\2\2\u0094\u0096\5\34\17\2\u0095\u0093\3\2\2\2\u0096\u0099\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u0097\3\2"+
		"\2\2\u009a\u009b\7*\2\2\u009b\31\3\2\2\2\u009c\u009f\5\30\r\2\u009d\u009f"+
		"\5&\24\2\u009e\u009c\3\2\2\2\u009e\u009d\3\2\2\2\u009f\33\3\2\2\2\u00a0"+
		"\u00a5\7+\2\2\u00a1\u00a2\7+\2\2\u00a2\u00a3\7\17\2\2\u00a3\u00a5\5 \21"+
		"\2\u00a4\u00a0\3\2\2\2\u00a4\u00a1\3\2\2\2\u00a5\35\3\2\2\2\u00a6\u00a9"+
		"\3\2\2\2\u00a7\u00a9\5 \21\2\u00a8\u00a6\3\2\2\2\u00a8\u00a7\3\2\2\2\u00a9"+
		"\37\3\2\2\2\u00aa\u00ab\7+\2\2\u00ab\u00ac\t\2\2\2\u00ac\u00af\5\"\22"+
		"\2\u00ad\u00af\5\"\22\2\u00ae\u00aa\3\2\2\2\u00ae\u00ad\3\2\2\2\u00af"+
		"!\3\2\2\2\u00b0\u00b1\b\22\1\2\u00b1\u00b2\t\3\2\2\u00b2\u00b3\5\"\22"+
		"\b\u00b3\u00b4\b\22\1\2\u00b4\u00b9\3\2\2\2\u00b5\u00b6\5$\23\2\u00b6"+
		"\u00b7\b\22\1\2\u00b7\u00b9\3\2\2\2\u00b8\u00b0\3\2\2\2\u00b8\u00b5\3"+
		"\2\2\2\u00b9\u00cd\3\2\2\2\u00ba\u00bb\f\7\2\2\u00bb\u00bc\t\4\2\2\u00bc"+
		"\u00bd\5\"\22\b\u00bd\u00be\b\22\1\2\u00be\u00cc\3\2\2\2\u00bf\u00c0\f"+
		"\6\2\2\u00c0\u00c1\t\5\2\2\u00c1\u00cc\5\"\22\7\u00c2\u00c3\f\5\2\2\u00c3"+
		"\u00c4\t\6\2\2\u00c4\u00cc\5\"\22\6\u00c5\u00c6\f\4\2\2\u00c6\u00c7\7"+
		"\36\2\2\u00c7\u00cc\5\"\22\5\u00c8\u00c9\f\3\2\2\u00c9\u00ca\7\37\2\2"+
		"\u00ca\u00cc\5\"\22\4\u00cb\u00ba\3\2\2\2\u00cb\u00bf\3\2\2\2\u00cb\u00c2"+
		"\3\2\2\2\u00cb\u00c5\3\2\2\2\u00cb\u00c8\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd"+
		"\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce#\3\2\2\2\u00cf\u00cd\3\2\2\2"+
		"\u00d0\u00d1\7+\2\2\u00d1\u00df\b\23\1\2\u00d2\u00d3\7%\2\2\u00d3\u00d4"+
		"\5 \21\2\u00d4\u00d5\7&\2\2\u00d5\u00d6\b\23\1\2\u00d6\u00df\3\2\2\2\u00d7"+
		"\u00d8\7+\2\2\u00d8\u00d9\7%\2\2\u00d9\u00da\5&\24\2\u00da\u00db\7&\2"+
		"\2\u00db\u00df\3\2\2\2\u00dc\u00df\5(\25\2\u00dd\u00df\5.\30\2\u00de\u00d0"+
		"\3\2\2\2\u00de\u00d2\3\2\2\2\u00de\u00d7\3\2\2\2\u00de\u00dc\3\2\2\2\u00de"+
		"\u00dd\3\2\2\2\u00df%\3\2\2\2\u00e0\u00ee\b\24\1\2\u00e1\u00e2\b\24\1"+
		"\2\u00e2\u00e3\5 \21\2\u00e3\u00ea\b\24\1\2\u00e4\u00e5\7)\2\2\u00e5\u00e6"+
		"\5 \21\2\u00e6\u00e7\b\24\1\2\u00e7\u00e9\3\2\2\2\u00e8\u00e4\3\2\2\2"+
		"\u00e9\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ee"+
		"\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00e0\3\2\2\2\u00ed\u00e1\3\2\2\2\u00ee"+
		"\'\3\2\2\2\u00ef\u00f0\7 \2\2\u00f0\u00f1\7%\2\2\u00f1\u00f2\7+\2\2\u00f2"+
		"\u00f9\7&\2\2\u00f3\u00f4\7!\2\2\u00f4\u00f5\7%\2\2\u00f5\u00f6\5 \21"+
		"\2\u00f6\u00f7\7&\2\2\u00f7\u00f9\3\2\2\2\u00f8\u00ef\3\2\2\2\u00f8\u00f3"+
		"\3\2\2\2\u00f9)\3\2\2\2\u00fa\u00fb\b\26\1\2\u00fb\u00fc\5,\27\2\u00fc"+
		"\u0103\b\26\1\2\u00fd\u00fe\7\16\2\2\u00fe\u00ff\5,\27\2\u00ff\u0100\b"+
		"\26\1\2\u0100\u0102\3\2\2\2\u0101\u00fd\3\2\2\2\u0102\u0105\3\2\2\2\u0103"+
		"\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104+\3\2\2\2\u0105\u0103\3\2\2\2"+
		"\u0106\u0107\5\2\2\2\u0107\u0108\7+\2\2\u0108\u0109\b\27\1\2\u0109-\3"+
		"\2\2\2\u010a\u010b\t\7\2\2\u010b/\3\2\2\2\30\66=DMX_mp\177\u0097\u009e"+
		"\u00a4\u00a8\u00ae\u00b8\u00cb\u00cd\u00de\u00ea\u00ed\u00f8\u0103";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}