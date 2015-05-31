// Generated from /home/arkady/Documents/devcompiler/compiler/src/main/java/Grammar.g4 by ANTLR 4.5

    import java.util.*;
    import java.io.*;

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
		RULE_forinit = 12, RULE_varibleDeclaration = 13, RULE_expression = 14, 
		RULE_expression1 = 15, RULE_primary = 16, RULE_expressionList = 17, RULE_ioFunctions = 18, 
		RULE_parameters = 19, RULE_parameter = 20, RULE_literal = 21;
	public static final String[] ruleNames = {
		"type", "methodtype", "start", "body", "methodDeclaration", "block", "blockStatement", 
		"statement", "ifstatement", "whilestatement", "forstatement", "declaration", 
		"forinit", "varibleDeclaration", "expression", "expression1", "primary", 
		"expressionList", "ioFunctions", "parameters", "parameter", "literal"
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
	    int id = 0;
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
	        code.add(loopEnd.get(loopEnd.size() - 1) + ":");
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
	        Scope scope = scopes.get(scopes.size() - 1);
	        if (scope.contains(name)){
	            return null;
	        } else {
	            Variable v = new Variable(type, "v" + (id++));
	            code.add(v.getType() + " " + v.getId());
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
	        return null;
	    }

	    public Variable registerFunction(String name, Type result, List<Variable> arguments) {
	        openScope();
	        Type[] types = new Type[arguments.size()];
	        for (int i = 0; i < types.length;i++) {
	            types[i] = arguments.get(i).getType();
	        }
	        Function function = new Function(name, result, types);
	        	        Functions.add(function);
	        	        code.add(function.getId() + ":");
	        	        Variable res = createTempVariable(function.getResult());
	        	        code.add("pop " + res);
	        	        Collections.reverse(arguments);
	        	        for (Variable variable: arguments) {
	        	            Variable v = createVariable(variable.getId(), variable.getType());
	        	            code.add("pop " + v.getId());
	        	        }

	        returnVariables.add(res);

	        return res;
	    }

	    public void endFunction() {
	        closeScope();
	        returnVariables.remove(returnVariables.size() - 1);
	    }


	    public Variable callFunction(String name, Variable... variables) {
	        return callFunction(name, Arrays.asList(variables));
	    }

	    public Variable callFunction(String name, List<Variable> variables) {
	        List<Type> types = new ArrayList<Type>();
	                    for (Variable v : variables) {
	                        types.add(v.getType());
	                    }
	        	        Function function = Functions.get(name, types);
	        	        for (Variable variable: variables) {
	        	            code.add("param " + variable.getId());
	        	        }

	        	        if (function.getResult() != Type.VoidType) {
	        	           Variable t = createTempVariable(function.getResult());
	        	           code.add("param &" + t.getId());
	        	           code.add("call " + function.getId());
	        	           return t;
	        	        } else {
	        	            code.add("param &void");
	        	            code.add("call " + function.getId());
	        	            return new Variable(Type.VoidType, "void");
	        	        }
	    }
	    public Variable getReturnVariable() {
	        return returnVariables.get(returnVariables.size() - 1);
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
			setState(50);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(44); 
				match(T__0);
				((TypeContext)_localctx).result =  Type.IntegerType;
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(46); 
				match(T__1);
				((TypeContext)_localctx).result =  Type.StringType;
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(48); 
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
			setState(57);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(52); 
				((MethodtypeContext)_localctx).type = type();
				((MethodtypeContext)_localctx).result =  ((MethodtypeContext)_localctx).type.result;
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(55); 
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
		public List<String> result;
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
			code.clear();pushScope();
			setState(60); 
			body();
			((StartContext)_localctx).result =  new ArrayList<String>(code);code.clear();
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
		public ExpressionContext e;
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
			setState(113);
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
				code.add("goto" + getLoopEnd());
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 8);
				{
				setState(105); 
				match(T__5);
				code.add("goto " + getLoopStart()); 
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 9);
				{
				setState(107); 
				match(T__6);
				setState(109);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__29) | (1L << T__30) | (1L << LPAREN) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << BooleanLiteral))) != 0)) {
					{
					setState(108); 
					((StatementContext)_localctx).e = expression();
					}
				}


				        Variable variable = ((StatementContext)_localctx).e == null ? (new Variable(Type.VoidType, "void")) : ((StatementContext)_localctx).e.var;
				        Variable returnVariable = getReturnVariable();
				        if (returnVariable == null) {
				            return null;
				        }
				        if (returnVariable.getType() != ((StatementContext)_localctx).e.var.getType()) {
				            return null;
				        }

				        code.add("*" + returnVariable + " = " + ((StatementContext)_localctx).e.var);
				        code.add("back");
				    
				setState(112); 
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
		public StatementContext s;
		public TerminalNode LPAREN() { return getToken(GrammarParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(GrammarParser.RPAREN, 0); }
		public List<TerminalNode> LBRACE() { return getTokens(GrammarParser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(GrammarParser.LBRACE, i);
		}
		public List<TerminalNode> RBRACE() { return getTokens(GrammarParser.RBRACE); }
		public TerminalNode RBRACE(int i) {
			return getToken(GrammarParser.RBRACE, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
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
			setState(115); 
			match(T__7);
			openScope();
			setState(117); 
			match(LPAREN);
			setState(118); 
			((IfstatementContext)_localctx).a = expression();
			Variable v = ((IfstatementContext)_localctx).a.var; String label = label(); code.add("!if " + v + " goto " + label);
			setState(120); 
			match(RPAREN);
			setState(121); 
			match(LBRACE);
			setState(122); 
			((IfstatementContext)_localctx).s = statement();
			 code.add(label +":"); 
			setState(124); 
			match(RBRACE);
			setState(132);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(125); 
				match(T__8);
				String labelF = label(); code.add("if " + v + " goto " + labelF);
				setState(127); 
				match(LBRACE);
				setState(128); 
				statement();
				code.add(labelF+ ":"); closeScope();
				setState(130); 
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
		public ExpressionContext e;
		public StatementContext s;
		public TerminalNode LPAREN() { return getToken(GrammarParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(GrammarParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
			setState(134); 
			match(T__9);
			openLoop();
			setState(136); 
			match(LPAREN);
			setState(137); 
			((WhilestatementContext)_localctx).e = expression();
			Variable v = ((WhilestatementContext)_localctx).e.var; code.add("!if " + v + " goto " + getLoopEnd()); 
			setState(139); 
			match(RPAREN);
			setState(140); 
			((WhilestatementContext)_localctx).s = statement();
			 code.add("goto " + getLoopStart()); closeLoop(); 
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
		public ExpressionContext e;
		public TerminalNode LPAREN() { return getToken(GrammarParser.LPAREN, 0); }
		public ForinitContext forinit() {
			return getRuleContext(ForinitContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(GrammarParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
			setState(143); 
			match(T__10);
			setState(144); 
			match(LPAREN);
			setState(145); 
			forinit();
			setState(146); 
			match(SEMI);
			 openLoop(); 
			setState(148); 
			((ForstatementContext)_localctx).e = expression();
			 Variable v = ((ForstatementContext)_localctx).e.var; code.add("!if " + v + " goto " + getLoopEnd()); 
			setState(150); 
			match(SEMI);
			List<String> save = code;
			    code = new ArrayList<String>();
			    
			setState(152); 
			expressionList();
			 List<String> temp = save;
			    save = code;
			    code = temp;
			    
			setState(154); 
			match(RPAREN);
			setState(155); 
			statement();
			code.addAll(save);
			    code.add("goto " + getLoopStart());
			    closeLoop();
			    
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
		public TypeContext type;
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
			setState(158); 
			((DeclarationContext)_localctx).type = type();
			setState(159); 
			varibleDeclaration(((DeclarationContext)_localctx).type.result);
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(160); 
				match(T__11);
				setState(161); 
				varibleDeclaration(((DeclarationContext)_localctx).type.result);
				}
				}
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(167); 
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
			setState(171);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(169); 
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
				setState(170); 
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
		public Type t;
		public Token Identifier;
		public ExpressionContext expression;
		public TerminalNode Identifier() { return getToken(GrammarParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VaribleDeclarationContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public VaribleDeclarationContext(ParserRuleContext parent, int invokingState, Type t) {
			super(parent, invokingState);
			this.t = t;
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

	public final VaribleDeclarationContext varibleDeclaration(Type t) throws RecognitionException {
		VaribleDeclarationContext _localctx = new VaribleDeclarationContext(_ctx, getState(), t);
		enterRule(_localctx, 26, RULE_varibleDeclaration);
		try {
			setState(180);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(173); 
				((VaribleDeclarationContext)_localctx).Identifier = match(Identifier);
				 createVariable((((VaribleDeclarationContext)_localctx).Identifier!=null?((VaribleDeclarationContext)_localctx).Identifier.getText():null), t); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(175); 
				((VaribleDeclarationContext)_localctx).Identifier = match(Identifier);
				setState(176); 
				match(T__12);
				setState(177); 
				((VaribleDeclarationContext)_localctx).expression = expression();

				        Variable a = createVariable((((VaribleDeclarationContext)_localctx).Identifier!=null?((VaribleDeclarationContext)_localctx).Identifier.getText():null), t);
				        Variable b = ((VaribleDeclarationContext)_localctx).expression.var;
				        code.add(a + " = " + b);
				    
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

	public static class ExpressionContext extends ParserRuleContext {
		public Variable var;
		public Token id;
		public Token op;
		public Expression1Context r;
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
		enterRule(_localctx, 28, RULE_expression);
		int _la;
		try {
			setState(191);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(182); 
				((ExpressionContext)_localctx).id = match(Identifier);
				Variable left = resolveVariable((((ExpressionContext)_localctx).id!=null?((ExpressionContext)_localctx).id.getText():null));
				setState(184);
				((ExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__12 || _la==T__13) ) {
					((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(185); 
				((ExpressionContext)_localctx).r = expression1(0);

				        Variable right = ((ExpressionContext)_localctx).r.var;
				        if ((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null).equals("+=")) {
				            code.add(left.getId() + " = " + left.getId() + " + " + right.getId());
				        } else {
				            code.add(left.getId() + " = " + right.getId());
				        }
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(188); 
				((ExpressionContext)_localctx).r = expression1(0);
				((ExpressionContext)_localctx).var =  ((ExpressionContext)_localctx).r.var;
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
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expression1, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			switch (_input.LA(1)) {
			case T__14:
			case T__15:
			case T__16:
				{
				setState(194);
				((Expression1Context)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16))) != 0)) ) {
					((Expression1Context)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(195); 
				((Expression1Context)_localctx).a = expression1(6);

				        Variable v = ((Expression1Context)_localctx).a.var;
				        code.add(v + " = " + (((Expression1Context)_localctx).op!=null?((Expression1Context)_localctx).op.getText():null) + " " + v);
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
				setState(198); 
				((Expression1Context)_localctx).primary = primary();
				((Expression1Context)_localctx).var =  ((Expression1Context)_localctx).primary.var;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(230);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(228);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new Expression1Context(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression1);
						setState(203);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(204);
						((Expression1Context)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) ) {
							((Expression1Context)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(205); 
						((Expression1Context)_localctx).b = expression1(6);

						                  Variable x = ((Expression1Context)_localctx).a.var;
						                  Variable y = ((Expression1Context)_localctx).b.var;
						                  Variable v = createTempVariable(x.getType());
						                  code.add(v + " = " + x + " " + (((Expression1Context)_localctx).op!=null?((Expression1Context)_localctx).op.getText():null) + " " + y);
						                  ((Expression1Context)_localctx).var =  v;
						              
						}
						break;
					case 2:
						{
						_localctx = new Expression1Context(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression1);
						setState(208);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(209);
						((Expression1Context)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__14 || _la==T__20) ) {
							((Expression1Context)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(210); 
						((Expression1Context)_localctx).b = expression1(5);

						                  Variable x = ((Expression1Context)_localctx).a.var;
						                  Variable y = ((Expression1Context)_localctx).b.var;
						                  Variable v = createTempVariable(x.getType());
						                  code.add(v + " = " + x + " " + (((Expression1Context)_localctx).op!=null?((Expression1Context)_localctx).op.getText():null) + " " + y);
						                  ((Expression1Context)_localctx).var =  v;
						              
						}
						break;
					case 3:
						{
						_localctx = new Expression1Context(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression1);
						setState(213);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(214);
						((Expression1Context)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26))) != 0)) ) {
							((Expression1Context)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(215); 
						((Expression1Context)_localctx).b = expression1(4);

						                  Variable x = ((Expression1Context)_localctx).a.var;
						                  Variable y = ((Expression1Context)_localctx).b.var;
						                  Variable v = createTempVariable(Type.BooleanType);
						                  code.add(v + " = " + x + " " + (((Expression1Context)_localctx).op!=null?((Expression1Context)_localctx).op.getText():null) + " " + y);
						                  ((Expression1Context)_localctx).var =  v;
						              
						}
						break;
					case 4:
						{
						_localctx = new Expression1Context(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression1);
						setState(218);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(219); 
						match(T__27);
						setState(220); 
						((Expression1Context)_localctx).b = expression1(3);

						                      Variable x = ((Expression1Context)_localctx).a.var;
						                      Variable y = ((Expression1Context)_localctx).b.var;
						                      Variable v = createTempVariable(Type.BooleanType);
						                      code.add(v + " = " + x + " && " + y);
						                      ((Expression1Context)_localctx).var =  v;
						               
						}
						break;
					case 5:
						{
						_localctx = new Expression1Context(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression1);
						setState(223);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(224); 
						match(T__28);
						setState(225); 
						((Expression1Context)_localctx).b = expression1(2);

						                  Variable x = ((Expression1Context)_localctx).a.var;
						                  Variable y = ((Expression1Context)_localctx).b.var;
						                  Variable v = createTempVariable(Type.BooleanType);
						                  code.add(v + " = " + x + " || " + y);
						                  ((Expression1Context)_localctx).var =  v;
						              
						}
						break;
					}
					} 
				}
				setState(232);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
		public ExpressionListContext expressionList;
		public IoFunctionsContext ioFunctions;
		public LiteralContext literal;
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
		enterRule(_localctx, 32, RULE_primary);
		try {
			setState(252);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(233); 
				((PrimaryContext)_localctx).Identifier = match(Identifier);
				((PrimaryContext)_localctx).var =  resolveVariable((((PrimaryContext)_localctx).Identifier!=null?((PrimaryContext)_localctx).Identifier.getText():null));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(235); 
				match(LPAREN);
				setState(236); 
				((PrimaryContext)_localctx).expression = expression();
				setState(237); 
				match(RPAREN);
				((PrimaryContext)_localctx).var =  ((PrimaryContext)_localctx).expression.var;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(240); 
				((PrimaryContext)_localctx).Identifier = match(Identifier);
				setState(241); 
				match(LPAREN);
				setState(242); 
				((PrimaryContext)_localctx).expressionList = expressionList();
				setState(243); 
				match(RPAREN);
				((PrimaryContext)_localctx).var =  callFunction((((PrimaryContext)_localctx).Identifier!=null?((PrimaryContext)_localctx).Identifier.getText():null), ((PrimaryContext)_localctx).expressionList.vars); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(246); 
				((PrimaryContext)_localctx).ioFunctions = ioFunctions();
				((PrimaryContext)_localctx).var =  ((PrimaryContext)_localctx).ioFunctions.var;
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(249); 
				((PrimaryContext)_localctx).literal = literal();
				 Variable t = createTempVariable(((PrimaryContext)_localctx).literal.result); code.add(t + " = " + (((PrimaryContext)_localctx).literal!=null?_input.getText(((PrimaryContext)_localctx).literal.start,((PrimaryContext)_localctx).literal.stop):null)); ((PrimaryContext)_localctx).var =  t;
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
		enterRule(_localctx, 34, RULE_expressionList);
		int _la;
		try {
			setState(267);
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
				setState(256); 
				((ExpressionListContext)_localctx).a = expression();
				_localctx.vars.add(((ExpressionListContext)_localctx).a.var);
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(258); 
					match(COMMA);
					setState(259); 
					((ExpressionListContext)_localctx).b = expression();
					_localctx.vars.add(((ExpressionListContext)_localctx).b.var);
					}
					}
					setState(266);
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
		public Variable var;
		public ExpressionContext expression;
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
		enterRule(_localctx, 36, RULE_ioFunctions);
		try {
			setState(279);
			switch (_input.LA(1)) {
			case T__29:
				enterOuterAlt(_localctx, 1);
				{
				setState(269); 
				match(T__29);
				setState(270); 
				match(LPAREN);
				setState(271); 
				match(RPAREN);
				 ((IoFunctionsContext)_localctx).var =  callFunction("read"); 
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 2);
				{
				setState(273); 
				match(T__30);
				setState(274); 
				match(LPAREN);
				setState(275); 
				((IoFunctionsContext)_localctx).expression = expression();
				setState(276); 
				match(RPAREN);
				 ((IoFunctionsContext)_localctx).var =  callFunction("write", ((IoFunctionsContext)_localctx).expression.var); 
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
		enterRule(_localctx, 38, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ParametersContext)_localctx).vars =  new ArrayList<Variable>();
			setState(282); 
			((ParametersContext)_localctx).a = parameter();
			_localctx.vars.add(((ParametersContext)_localctx).a.var);
			setState(290);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(284); 
				match(T__11);
				setState(285); 
				((ParametersContext)_localctx).b = parameter();
				_localctx.vars.add(((ParametersContext)_localctx).b.var);
				}
				}
				setState(292);
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
		enterRule(_localctx, 40, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293); 
			((ParameterContext)_localctx).type = type();
			setState(294); 
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
		public Type result;
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
		enterRule(_localctx, 42, RULE_literal);
		try {
			setState(303);
			switch (_input.LA(1)) {
			case IntegerLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(297); 
				match(IntegerLiteral);
				((LiteralContext)_localctx).result =  Type.IntegerType;
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(299); 
				match(StringLiteral);
				((LiteralContext)_localctx).result =  Type.StringType;
				}
				break;
			case BooleanLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(301); 
				match(BooleanLiteral);
				((LiteralContext)_localctx).result =  Type.BooleanType;
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 15: 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3.\u0134\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\5\2\65\n\2\3\3\3\3\3\3\3\3\3\3\5\3<\n\3\3\4\3\4\3\4\3\4\3\5\7\5C"+
		"\n\5\f\5\16\5F\13\5\3\5\3\5\3\6\3\6\3\6\3\6\5\6N\n\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\7\7W\n\7\f\7\16\7Z\13\7\3\7\3\7\3\b\3\b\5\b`\n\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tp\n\t\3\t\3\t\5\tt\n"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\5\n\u0087\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\7\r"+
		"\u00a5\n\r\f\r\16\r\u00a8\13\r\3\r\3\r\3\16\3\16\5\16\u00ae\n\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00b7\n\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\5\20\u00c2\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\5\21\u00cc\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\7\21\u00e7\n\21\f\21\16\21\u00ea\13\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\5\22\u00ff\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u0109\n"+
		"\23\f\23\16\23\u010c\13\23\5\23\u010e\n\23\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\5\24\u011a\n\24\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\7\25\u0123\n\25\f\25\16\25\u0126\13\25\3\26\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\5\27\u0132\n\27\3\27\2\3 \30\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,\2\7\3\2\17\20\3\2\21\23\3\2\24\26\4\2"+
		"\21\21\27\27\3\2\30\35\u0142\2\64\3\2\2\2\4;\3\2\2\2\6=\3\2\2\2\bD\3\2"+
		"\2\2\nI\3\2\2\2\fT\3\2\2\2\16_\3\2\2\2\20s\3\2\2\2\22u\3\2\2\2\24\u0088"+
		"\3\2\2\2\26\u0091\3\2\2\2\30\u00a0\3\2\2\2\32\u00ad\3\2\2\2\34\u00b6\3"+
		"\2\2\2\36\u00c1\3\2\2\2 \u00cb\3\2\2\2\"\u00fe\3\2\2\2$\u010d\3\2\2\2"+
		"&\u0119\3\2\2\2(\u011b\3\2\2\2*\u0127\3\2\2\2,\u0131\3\2\2\2./\7\3\2\2"+
		"/\65\b\2\1\2\60\61\7\4\2\2\61\65\b\2\1\2\62\63\7\5\2\2\63\65\b\2\1\2\64"+
		".\3\2\2\2\64\60\3\2\2\2\64\62\3\2\2\2\65\3\3\2\2\2\66\67\5\2\2\2\678\b"+
		"\3\1\28<\3\2\2\29:\7\6\2\2:<\b\3\1\2;\66\3\2\2\2;9\3\2\2\2<\5\3\2\2\2"+
		"=>\b\4\1\2>?\5\b\5\2?@\b\4\1\2@\7\3\2\2\2AC\5\n\6\2BA\3\2\2\2CF\3\2\2"+
		"\2DB\3\2\2\2DE\3\2\2\2EG\3\2\2\2FD\3\2\2\2GH\7\2\2\3H\t\3\2\2\2IJ\5\4"+
		"\3\2JK\7+\2\2KM\7%\2\2LN\5(\25\2ML\3\2\2\2MN\3\2\2\2NO\3\2\2\2OP\7&\2"+
		"\2PQ\b\6\1\2QR\5\f\7\2RS\b\6\1\2S\13\3\2\2\2TX\7\'\2\2UW\5\16\b\2VU\3"+
		"\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y[\3\2\2\2ZX\3\2\2\2[\\\7(\2\2\\\r"+
		"\3\2\2\2]`\5\30\r\2^`\5\20\t\2_]\3\2\2\2_^\3\2\2\2`\17\3\2\2\2at\7*\2"+
		"\2bc\5\36\20\2cd\7*\2\2dt\3\2\2\2et\5\22\n\2ft\5\26\f\2gt\5\24\13\2ht"+
		"\5\f\7\2ij\7\7\2\2jt\b\t\1\2kl\7\b\2\2lt\b\t\1\2mo\7\t\2\2np\5\36\20\2"+
		"on\3\2\2\2op\3\2\2\2pq\3\2\2\2qr\b\t\1\2rt\7*\2\2sa\3\2\2\2sb\3\2\2\2"+
		"se\3\2\2\2sf\3\2\2\2sg\3\2\2\2sh\3\2\2\2si\3\2\2\2sk\3\2\2\2sm\3\2\2\2"+
		"t\21\3\2\2\2uv\7\n\2\2vw\b\n\1\2wx\7%\2\2xy\5\36\20\2yz\b\n\1\2z{\7&\2"+
		"\2{|\7\'\2\2|}\5\20\t\2}~\b\n\1\2~\u0086\7(\2\2\177\u0080\7\13\2\2\u0080"+
		"\u0081\b\n\1\2\u0081\u0082\7\'\2\2\u0082\u0083\5\20\t\2\u0083\u0084\b"+
		"\n\1\2\u0084\u0085\7(\2\2\u0085\u0087\3\2\2\2\u0086\177\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\23\3\2\2\2\u0088\u0089\7\f\2\2\u0089\u008a\b\13\1"+
		"\2\u008a\u008b\7%\2\2\u008b\u008c\5\36\20\2\u008c\u008d\b\13\1\2\u008d"+
		"\u008e\7&\2\2\u008e\u008f\5\20\t\2\u008f\u0090\b\13\1\2\u0090\25\3\2\2"+
		"\2\u0091\u0092\7\r\2\2\u0092\u0093\7%\2\2\u0093\u0094\5\32\16\2\u0094"+
		"\u0095\7*\2\2\u0095\u0096\b\f\1\2\u0096\u0097\5\36\20\2\u0097\u0098\b"+
		"\f\1\2\u0098\u0099\7*\2\2\u0099\u009a\b\f\1\2\u009a\u009b\5$\23\2\u009b"+
		"\u009c\b\f\1\2\u009c\u009d\7&\2\2\u009d\u009e\5\20\t\2\u009e\u009f\b\f"+
		"\1\2\u009f\27\3\2\2\2\u00a0\u00a1\5\2\2\2\u00a1\u00a6\5\34\17\2\u00a2"+
		"\u00a3\7\16\2\2\u00a3\u00a5\5\34\17\2\u00a4\u00a2\3\2\2\2\u00a5\u00a8"+
		"\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a9\3\2\2\2\u00a8"+
		"\u00a6\3\2\2\2\u00a9\u00aa\7*\2\2\u00aa\31\3\2\2\2\u00ab\u00ae\5\30\r"+
		"\2\u00ac\u00ae\5$\23\2\u00ad\u00ab\3\2\2\2\u00ad\u00ac\3\2\2\2\u00ae\33"+
		"\3\2\2\2\u00af\u00b0\7+\2\2\u00b0\u00b7\b\17\1\2\u00b1\u00b2\7+\2\2\u00b2"+
		"\u00b3\7\17\2\2\u00b3\u00b4\5\36\20\2\u00b4\u00b5\b\17\1\2\u00b5\u00b7"+
		"\3\2\2\2\u00b6\u00af\3\2\2\2\u00b6\u00b1\3\2\2\2\u00b7\35\3\2\2\2\u00b8"+
		"\u00b9\7+\2\2\u00b9\u00ba\b\20\1\2\u00ba\u00bb\t\2\2\2\u00bb\u00bc\5 "+
		"\21\2\u00bc\u00bd\b\20\1\2\u00bd\u00c2\3\2\2\2\u00be\u00bf\5 \21\2\u00bf"+
		"\u00c0\b\20\1\2\u00c0\u00c2\3\2\2\2\u00c1\u00b8\3\2\2\2\u00c1\u00be\3"+
		"\2\2\2\u00c2\37\3\2\2\2\u00c3\u00c4\b\21\1\2\u00c4\u00c5\t\3\2\2\u00c5"+
		"\u00c6\5 \21\b\u00c6\u00c7\b\21\1\2\u00c7\u00cc\3\2\2\2\u00c8\u00c9\5"+
		"\"\22\2\u00c9\u00ca\b\21\1\2\u00ca\u00cc\3\2\2\2\u00cb\u00c3\3\2\2\2\u00cb"+
		"\u00c8\3\2\2\2\u00cc\u00e8\3\2\2\2\u00cd\u00ce\f\7\2\2\u00ce\u00cf\t\4"+
		"\2\2\u00cf\u00d0\5 \21\b\u00d0\u00d1\b\21\1\2\u00d1\u00e7\3\2\2\2\u00d2"+
		"\u00d3\f\6\2\2\u00d3\u00d4\t\5\2\2\u00d4\u00d5\5 \21\7\u00d5\u00d6\b\21"+
		"\1\2\u00d6\u00e7\3\2\2\2\u00d7\u00d8\f\5\2\2\u00d8\u00d9\t\6\2\2\u00d9"+
		"\u00da\5 \21\6\u00da\u00db\b\21\1\2\u00db\u00e7\3\2\2\2\u00dc\u00dd\f"+
		"\4\2\2\u00dd\u00de\7\36\2\2\u00de\u00df\5 \21\5\u00df\u00e0\b\21\1\2\u00e0"+
		"\u00e7\3\2\2\2\u00e1\u00e2\f\3\2\2\u00e2\u00e3\7\37\2\2\u00e3\u00e4\5"+
		" \21\4\u00e4\u00e5\b\21\1\2\u00e5\u00e7\3\2\2\2\u00e6\u00cd\3\2\2\2\u00e6"+
		"\u00d2\3\2\2\2\u00e6\u00d7\3\2\2\2\u00e6\u00dc\3\2\2\2\u00e6\u00e1\3\2"+
		"\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9"+
		"!\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00ec\7+\2\2\u00ec\u00ff\b\22\1\2"+
		"\u00ed\u00ee\7%\2\2\u00ee\u00ef\5\36\20\2\u00ef\u00f0\7&\2\2\u00f0\u00f1"+
		"\b\22\1\2\u00f1\u00ff\3\2\2\2\u00f2\u00f3\7+\2\2\u00f3\u00f4\7%\2\2\u00f4"+
		"\u00f5\5$\23\2\u00f5\u00f6\7&\2\2\u00f6\u00f7\b\22\1\2\u00f7\u00ff\3\2"+
		"\2\2\u00f8\u00f9\5&\24\2\u00f9\u00fa\b\22\1\2\u00fa\u00ff\3\2\2\2\u00fb"+
		"\u00fc\5,\27\2\u00fc\u00fd\b\22\1\2\u00fd\u00ff\3\2\2\2\u00fe\u00eb\3"+
		"\2\2\2\u00fe\u00ed\3\2\2\2\u00fe\u00f2\3\2\2\2\u00fe\u00f8\3\2\2\2\u00fe"+
		"\u00fb\3\2\2\2\u00ff#\3\2\2\2\u0100\u010e\b\23\1\2\u0101\u0102\b\23\1"+
		"\2\u0102\u0103\5\36\20\2\u0103\u010a\b\23\1\2\u0104\u0105\7)\2\2\u0105"+
		"\u0106\5\36\20\2\u0106\u0107\b\23\1\2\u0107\u0109\3\2\2\2\u0108\u0104"+
		"\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b"+
		"\u010e\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u0100\3\2\2\2\u010d\u0101\3\2"+
		"\2\2\u010e%\3\2\2\2\u010f\u0110\7 \2\2\u0110\u0111\7%\2\2\u0111\u0112"+
		"\7&\2\2\u0112\u011a\b\24\1\2\u0113\u0114\7!\2\2\u0114\u0115\7%\2\2\u0115"+
		"\u0116\5\36\20\2\u0116\u0117\7&\2\2\u0117\u0118\b\24\1\2\u0118\u011a\3"+
		"\2\2\2\u0119\u010f\3\2\2\2\u0119\u0113\3\2\2\2\u011a\'\3\2\2\2\u011b\u011c"+
		"\b\25\1\2\u011c\u011d\5*\26\2\u011d\u0124\b\25\1\2\u011e\u011f\7\16\2"+
		"\2\u011f\u0120\5*\26\2\u0120\u0121\b\25\1\2\u0121\u0123\3\2\2\2\u0122"+
		"\u011e\3\2\2\2\u0123\u0126\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2"+
		"\2\2\u0125)\3\2\2\2\u0126\u0124\3\2\2\2\u0127\u0128\5\2\2\2\u0128\u0129"+
		"\7+\2\2\u0129\u012a\b\26\1\2\u012a+\3\2\2\2\u012b\u012c\7,\2\2\u012c\u0132"+
		"\b\27\1\2\u012d\u012e\7-\2\2\u012e\u0132\b\27\1\2\u012f\u0130\7.\2\2\u0130"+
		"\u0132\b\27\1\2\u0131\u012b\3\2\2\2\u0131\u012d\3\2\2\2\u0131\u012f\3"+
		"\2\2\2\u0132-\3\2\2\2\30\64;DMX_os\u0086\u00a6\u00ad\u00b6\u00c1\u00cb"+
		"\u00e6\u00e8\u00fe\u010a\u010d\u0119\u0124\u0131";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}