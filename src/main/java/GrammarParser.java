// Generated from Grammar.g4 by ANTLR 4.5

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
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
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
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3))) != 0)) {
				{
				{
				setState(61);
				methodDeclaration();
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67);
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
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			((MethodDeclarationContext)_localctx).methodtype = methodtype();
			setState(70);
			((MethodDeclarationContext)_localctx).Identifier = match(Identifier);
			setState(71);
			match(LPAREN);
			setState(73);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2))) != 0)) {
				{
				setState(72);
				((MethodDeclarationContext)_localctx).a = parameters();
				}
			}

			setState(75);
			match(RPAREN);
			List<Variable> args = new ArrayList<Variable>();
			    if (((MethodDeclarationContext)_localctx).a != null) {
			        args = ((MethodDeclarationContext)_localctx).a.vars;
			    }
			    registerFunction((((MethodDeclarationContext)_localctx).Identifier!=null?((MethodDeclarationContext)_localctx).Identifier.getText():null), ((MethodDeclarationContext)_localctx).methodtype.result, args);
			    
			setState(77);
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
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(LBRACE);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__29) | (1L << T__30) | (1L << LPAREN) | (1L << LBRACE) | (1L << SEMI) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << BooleanLiteral))) != 0)) {
				{
				{
				setState(81);
				blockStatement();
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
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
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_blockStatement);
		try {
			setState(91);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
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
				setState(90);
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
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		int _la;
		try {
			setState(111);
			switch (_input.LA(1)) {
			case SEMI:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
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
				setState(94);
				expression();
				setState(95);
				match(SEMI);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				ifstatement();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 4);
				{
				setState(98);
				forstatement();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(99);
				whilestatement();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 6);
				{
				setState(100);
				block();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 7);
				{
				setState(101);
				match(T__4);
				code.add("goto" + getLoopEnd());
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 8);
				{
				setState(103);
				match(T__5);
				code.add("goto " + getLoopStart()); 
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
				    
				setState(110);
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
	}

	public final IfstatementContext ifstatement() throws RecognitionException {
		IfstatementContext _localctx = new IfstatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifstatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(T__7);
			openScope();
			setState(115);
			match(LPAREN);
			setState(116);
			((IfstatementContext)_localctx).a = expression();
			Variable v = ((IfstatementContext)_localctx).a.var; String label = label(); code.add("!if " + v + " goto " + label);
			setState(118);
			match(RPAREN);
			setState(119);
			match(LBRACE);
			setState(120);
			((IfstatementContext)_localctx).s = statement();
			 code.add(label +":"); 
			setState(122);
			match(RBRACE);
			setState(130);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(123);
				match(T__8);
				String labelF = label(); code.add("if " + v + " goto " + labelF);
				setState(125);
				match(LBRACE);
				setState(126);
				statement();
				code.add(labelF+ ":"); closeScope();
				setState(128);
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
	}

	public final WhilestatementContext whilestatement() throws RecognitionException {
		WhilestatementContext _localctx = new WhilestatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_whilestatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(T__9);
			openLoop();
			setState(134);
			match(LPAREN);
			setState(135);
			((WhilestatementContext)_localctx).e = expression();
			Variable v = ((WhilestatementContext)_localctx).e.var; code.add("!if " + v + " goto " + getLoopEnd()); 
			setState(137);
			match(RPAREN);
			setState(138);
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
	}

	public final ForstatementContext forstatement() throws RecognitionException {
		ForstatementContext _localctx = new ForstatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_forstatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(T__10);
			setState(142);
			match(LPAREN);
			setState(143);
			forinit();
			setState(144);
			match(SEMI);
			 openLoop(); 
			setState(146);
			((ForstatementContext)_localctx).e = expression();
			 Variable v = ((ForstatementContext)_localctx).e.var; code.add("!if " + v + " goto " + getLoopEnd()); 
			setState(148);
			match(SEMI);
			List<String> save = code;
			    code = new ArrayList<String>();
			    
			setState(150);
			expressionList();
			 List<String> temp = save;
			    save = code;
			    code = temp;
			    
			setState(152);
			match(RPAREN);
			setState(153);
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
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			((DeclarationContext)_localctx).type = type();
			setState(157);
			varibleDeclaration(((DeclarationContext)_localctx).type.result);
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(158);
				match(T__11);
				setState(159);
				varibleDeclaration(((DeclarationContext)_localctx).type.result);
				}
				}
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(165);
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
	}

	public final ForinitContext forinit() throws RecognitionException {
		ForinitContext _localctx = new ForinitContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_forinit);
		try {
			setState(169);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
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
				setState(168);
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
	}

	public final VaribleDeclarationContext varibleDeclaration(Type t) throws RecognitionException {
		VaribleDeclarationContext _localctx = new VaribleDeclarationContext(_ctx, getState(), t);
		enterRule(_localctx, 26, RULE_varibleDeclaration);
		try {
			setState(178);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				((VaribleDeclarationContext)_localctx).Identifier = match(Identifier);
				 createVariable((((VaribleDeclarationContext)_localctx).Identifier!=null?((VaribleDeclarationContext)_localctx).Identifier.getText():null), t); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				((VaribleDeclarationContext)_localctx).Identifier = match(Identifier);
				setState(174);
				match(T__12);
				setState(175);
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
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expression);
		int _la;
		try {
			setState(189);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(180);
				((ExpressionContext)_localctx).id = match(Identifier);
				Variable left = resolveVariable((((ExpressionContext)_localctx).id!=null?((ExpressionContext)_localctx).id.getText():null));
				setState(182);
				((ExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__12 || _la==T__13) ) {
					((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(183);
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
				setState(186);
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
			setState(199);
			switch (_input.LA(1)) {
			case T__14:
			case T__15:
			case T__16:
				{
				setState(192);
				((Expression1Context)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16))) != 0)) ) {
					((Expression1Context)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(193);
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
				setState(196);
				((Expression1Context)_localctx).primary = primary();
				((Expression1Context)_localctx).var =  ((Expression1Context)_localctx).primary.var;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(228);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(226);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new Expression1Context(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression1);
						setState(201);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(202);
						((Expression1Context)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) ) {
							((Expression1Context)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(203);
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
						setState(206);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(207);
						((Expression1Context)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__14 || _la==T__20) ) {
							((Expression1Context)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(208);
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
						setState(211);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(212);
						((Expression1Context)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26))) != 0)) ) {
							((Expression1Context)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(213);
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
						setState(216);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(217);
						match(T__27);
						setState(218);
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
						setState(221);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(222);
						match(T__28);
						setState(223);
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
				setState(230);
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
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_primary);
		try {
			setState(250);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(231);
				((PrimaryContext)_localctx).Identifier = match(Identifier);
				((PrimaryContext)_localctx).var =  resolveVariable((((PrimaryContext)_localctx).Identifier!=null?((PrimaryContext)_localctx).Identifier.getText():null));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(233);
				match(LPAREN);
				setState(234);
				((PrimaryContext)_localctx).expression = expression();
				setState(235);
				match(RPAREN);
				((PrimaryContext)_localctx).var =  ((PrimaryContext)_localctx).expression.var;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(238);
				((PrimaryContext)_localctx).Identifier = match(Identifier);
				setState(239);
				match(LPAREN);
				setState(240);
				((PrimaryContext)_localctx).expressionList = expressionList();
				setState(241);
				match(RPAREN);
				((PrimaryContext)_localctx).var =  callFunction((((PrimaryContext)_localctx).Identifier!=null?((PrimaryContext)_localctx).Identifier.getText():null), ((PrimaryContext)_localctx).expressionList.vars); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(244);
				((PrimaryContext)_localctx).ioFunctions = ioFunctions();
				((PrimaryContext)_localctx).var =  ((PrimaryContext)_localctx).ioFunctions.var;
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(247);
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
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expressionList);
		int _la;
		try {
			setState(265);
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
				setState(254);
				((ExpressionListContext)_localctx).a = expression();
				_localctx.vars.add(((ExpressionListContext)_localctx).a.var);
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(256);
					match(COMMA);
					setState(257);
					((ExpressionListContext)_localctx).b = expression();
					_localctx.vars.add(((ExpressionListContext)_localctx).b.var);
					}
					}
					setState(264);
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
	}

	public final IoFunctionsContext ioFunctions() throws RecognitionException {
		IoFunctionsContext _localctx = new IoFunctionsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_ioFunctions);
		try {
			setState(277);
			switch (_input.LA(1)) {
			case T__29:
				enterOuterAlt(_localctx, 1);
				{
				setState(267);
				match(T__29);
				setState(268);
				match(LPAREN);
				setState(269);
				match(RPAREN);
				 ((IoFunctionsContext)_localctx).var =  callFunction("read"); 
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 2);
				{
				setState(271);
				match(T__30);
				setState(272);
				match(LPAREN);
				setState(273);
				((IoFunctionsContext)_localctx).expression = expression();
				setState(274);
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
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ParametersContext)_localctx).vars =  new ArrayList<Variable>();
			setState(280);
			((ParametersContext)_localctx).a = parameter();
			_localctx.vars.add(((ParametersContext)_localctx).a.var);
			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(282);
				match(T__11);
				setState(283);
				((ParametersContext)_localctx).b = parameter();
				_localctx.vars.add(((ParametersContext)_localctx).b.var);
				}
				}
				setState(290);
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
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			((ParameterContext)_localctx).type = type();
			setState(292);
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
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_literal);
		try {
			setState(301);
			switch (_input.LA(1)) {
			case IntegerLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(295);
				match(IntegerLiteral);
				((LiteralContext)_localctx).result =  Type.IntegerType;
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(297);
				match(StringLiteral);
				((LiteralContext)_localctx).result =  Type.StringType;
				}
				break;
			case BooleanLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(299);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3.\u0132\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\5\2\65\n\2\3\3\3\3\3\3\3\3\3\3\5\3<\n\3\3\4\3\4\3\5\7\5A\n\5\f\5"+
		"\16\5D\13\5\3\5\3\5\3\6\3\6\3\6\3\6\5\6L\n\6\3\6\3\6\3\6\3\6\3\6\3\7\3"+
		"\7\7\7U\n\7\f\7\16\7X\13\7\3\7\3\7\3\b\3\b\5\b^\n\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tn\n\t\3\t\3\t\5\tr\n\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0085"+
		"\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\7\r\u00a3\n\r"+
		"\f\r\16\r\u00a6\13\r\3\r\3\r\3\16\3\16\5\16\u00ac\n\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\5\17\u00b5\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\5\20\u00c0\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u00ca\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21"+
		"\u00e5\n\21\f\21\16\21\u00e8\13\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00fd"+
		"\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u0107\n\23\f\23\16"+
		"\23\u010a\13\23\5\23\u010c\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\5\24\u0118\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u0121"+
		"\n\25\f\25\16\25\u0124\13\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\5\27\u0130\n\27\3\27\2\3 \30\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,\2\7\3\2\17\20\3\2\21\23\3\2\24\26\4\2\21\21\27\27\3\2\30"+
		"\35\u0140\2\64\3\2\2\2\4;\3\2\2\2\6=\3\2\2\2\bB\3\2\2\2\nG\3\2\2\2\fR"+
		"\3\2\2\2\16]\3\2\2\2\20q\3\2\2\2\22s\3\2\2\2\24\u0086\3\2\2\2\26\u008f"+
		"\3\2\2\2\30\u009e\3\2\2\2\32\u00ab\3\2\2\2\34\u00b4\3\2\2\2\36\u00bf\3"+
		"\2\2\2 \u00c9\3\2\2\2\"\u00fc\3\2\2\2$\u010b\3\2\2\2&\u0117\3\2\2\2(\u0119"+
		"\3\2\2\2*\u0125\3\2\2\2,\u012f\3\2\2\2./\7\3\2\2/\65\b\2\1\2\60\61\7\4"+
		"\2\2\61\65\b\2\1\2\62\63\7\5\2\2\63\65\b\2\1\2\64.\3\2\2\2\64\60\3\2\2"+
		"\2\64\62\3\2\2\2\65\3\3\2\2\2\66\67\5\2\2\2\678\b\3\1\28<\3\2\2\29:\7"+
		"\6\2\2:<\b\3\1\2;\66\3\2\2\2;9\3\2\2\2<\5\3\2\2\2=>\5\b\5\2>\7\3\2\2\2"+
		"?A\5\n\6\2@?\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2CE\3\2\2\2DB\3\2\2\2"+
		"EF\7\2\2\3F\t\3\2\2\2GH\5\4\3\2HI\7+\2\2IK\7%\2\2JL\5(\25\2KJ\3\2\2\2"+
		"KL\3\2\2\2LM\3\2\2\2MN\7&\2\2NO\b\6\1\2OP\5\f\7\2PQ\b\6\1\2Q\13\3\2\2"+
		"\2RV\7\'\2\2SU\5\16\b\2TS\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2WY\3\2"+
		"\2\2XV\3\2\2\2YZ\7(\2\2Z\r\3\2\2\2[^\5\30\r\2\\^\5\20\t\2][\3\2\2\2]\\"+
		"\3\2\2\2^\17\3\2\2\2_r\7*\2\2`a\5\36\20\2ab\7*\2\2br\3\2\2\2cr\5\22\n"+
		"\2dr\5\26\f\2er\5\24\13\2fr\5\f\7\2gh\7\7\2\2hr\b\t\1\2ij\7\b\2\2jr\b"+
		"\t\1\2km\7\t\2\2ln\5\36\20\2ml\3\2\2\2mn\3\2\2\2no\3\2\2\2op\b\t\1\2p"+
		"r\7*\2\2q_\3\2\2\2q`\3\2\2\2qc\3\2\2\2qd\3\2\2\2qe\3\2\2\2qf\3\2\2\2q"+
		"g\3\2\2\2qi\3\2\2\2qk\3\2\2\2r\21\3\2\2\2st\7\n\2\2tu\b\n\1\2uv\7%\2\2"+
		"vw\5\36\20\2wx\b\n\1\2xy\7&\2\2yz\7\'\2\2z{\5\20\t\2{|\b\n\1\2|\u0084"+
		"\7(\2\2}~\7\13\2\2~\177\b\n\1\2\177\u0080\7\'\2\2\u0080\u0081\5\20\t\2"+
		"\u0081\u0082\b\n\1\2\u0082\u0083\7(\2\2\u0083\u0085\3\2\2\2\u0084}\3\2"+
		"\2\2\u0084\u0085\3\2\2\2\u0085\23\3\2\2\2\u0086\u0087\7\f\2\2\u0087\u0088"+
		"\b\13\1\2\u0088\u0089\7%\2\2\u0089\u008a\5\36\20\2\u008a\u008b\b\13\1"+
		"\2\u008b\u008c\7&\2\2\u008c\u008d\5\20\t\2\u008d\u008e\b\13\1\2\u008e"+
		"\25\3\2\2\2\u008f\u0090\7\r\2\2\u0090\u0091\7%\2\2\u0091\u0092\5\32\16"+
		"\2\u0092\u0093\7*\2\2\u0093\u0094\b\f\1\2\u0094\u0095\5\36\20\2\u0095"+
		"\u0096\b\f\1\2\u0096\u0097\7*\2\2\u0097\u0098\b\f\1\2\u0098\u0099\5$\23"+
		"\2\u0099\u009a\b\f\1\2\u009a\u009b\7&\2\2\u009b\u009c\5\20\t\2\u009c\u009d"+
		"\b\f\1\2\u009d\27\3\2\2\2\u009e\u009f\5\2\2\2\u009f\u00a4\5\34\17\2\u00a0"+
		"\u00a1\7\16\2\2\u00a1\u00a3\5\34\17\2\u00a2\u00a0\3\2\2\2\u00a3\u00a6"+
		"\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a7\3\2\2\2\u00a6"+
		"\u00a4\3\2\2\2\u00a7\u00a8\7*\2\2\u00a8\31\3\2\2\2\u00a9\u00ac\5\30\r"+
		"\2\u00aa\u00ac\5$\23\2\u00ab\u00a9\3\2\2\2\u00ab\u00aa\3\2\2\2\u00ac\33"+
		"\3\2\2\2\u00ad\u00ae\7+\2\2\u00ae\u00b5\b\17\1\2\u00af\u00b0\7+\2\2\u00b0"+
		"\u00b1\7\17\2\2\u00b1\u00b2\5\36\20\2\u00b2\u00b3\b\17\1\2\u00b3\u00b5"+
		"\3\2\2\2\u00b4\u00ad\3\2\2\2\u00b4\u00af\3\2\2\2\u00b5\35\3\2\2\2\u00b6"+
		"\u00b7\7+\2\2\u00b7\u00b8\b\20\1\2\u00b8\u00b9\t\2\2\2\u00b9\u00ba\5 "+
		"\21\2\u00ba\u00bb\b\20\1\2\u00bb\u00c0\3\2\2\2\u00bc\u00bd\5 \21\2\u00bd"+
		"\u00be\b\20\1\2\u00be\u00c0\3\2\2\2\u00bf\u00b6\3\2\2\2\u00bf\u00bc\3"+
		"\2\2\2\u00c0\37\3\2\2\2\u00c1\u00c2\b\21\1\2\u00c2\u00c3\t\3\2\2\u00c3"+
		"\u00c4\5 \21\b\u00c4\u00c5\b\21\1\2\u00c5\u00ca\3\2\2\2\u00c6\u00c7\5"+
		"\"\22\2\u00c7\u00c8\b\21\1\2\u00c8\u00ca\3\2\2\2\u00c9\u00c1\3\2\2\2\u00c9"+
		"\u00c6\3\2\2\2\u00ca\u00e6\3\2\2\2\u00cb\u00cc\f\7\2\2\u00cc\u00cd\t\4"+
		"\2\2\u00cd\u00ce\5 \21\b\u00ce\u00cf\b\21\1\2\u00cf\u00e5\3\2\2\2\u00d0"+
		"\u00d1\f\6\2\2\u00d1\u00d2\t\5\2\2\u00d2\u00d3\5 \21\7\u00d3\u00d4\b\21"+
		"\1\2\u00d4\u00e5\3\2\2\2\u00d5\u00d6\f\5\2\2\u00d6\u00d7\t\6\2\2\u00d7"+
		"\u00d8\5 \21\6\u00d8\u00d9\b\21\1\2\u00d9\u00e5\3\2\2\2\u00da\u00db\f"+
		"\4\2\2\u00db\u00dc\7\36\2\2\u00dc\u00dd\5 \21\5\u00dd\u00de\b\21\1\2\u00de"+
		"\u00e5\3\2\2\2\u00df\u00e0\f\3\2\2\u00e0\u00e1\7\37\2\2\u00e1\u00e2\5"+
		" \21\4\u00e2\u00e3\b\21\1\2\u00e3\u00e5\3\2\2\2\u00e4\u00cb\3\2\2\2\u00e4"+
		"\u00d0\3\2\2\2\u00e4\u00d5\3\2\2\2\u00e4\u00da\3\2\2\2\u00e4\u00df\3\2"+
		"\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7"+
		"!\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ea\7+\2\2\u00ea\u00fd\b\22\1\2"+
		"\u00eb\u00ec\7%\2\2\u00ec\u00ed\5\36\20\2\u00ed\u00ee\7&\2\2\u00ee\u00ef"+
		"\b\22\1\2\u00ef\u00fd\3\2\2\2\u00f0\u00f1\7+\2\2\u00f1\u00f2\7%\2\2\u00f2"+
		"\u00f3\5$\23\2\u00f3\u00f4\7&\2\2\u00f4\u00f5\b\22\1\2\u00f5\u00fd\3\2"+
		"\2\2\u00f6\u00f7\5&\24\2\u00f7\u00f8\b\22\1\2\u00f8\u00fd\3\2\2\2\u00f9"+
		"\u00fa\5,\27\2\u00fa\u00fb\b\22\1\2\u00fb\u00fd\3\2\2\2\u00fc\u00e9\3"+
		"\2\2\2\u00fc\u00eb\3\2\2\2\u00fc\u00f0\3\2\2\2\u00fc\u00f6\3\2\2\2\u00fc"+
		"\u00f9\3\2\2\2\u00fd#\3\2\2\2\u00fe\u010c\b\23\1\2\u00ff\u0100\b\23\1"+
		"\2\u0100\u0101\5\36\20\2\u0101\u0108\b\23\1\2\u0102\u0103\7)\2\2\u0103"+
		"\u0104\5\36\20\2\u0104\u0105\b\23\1\2\u0105\u0107\3\2\2\2\u0106\u0102"+
		"\3\2\2\2\u0107\u010a\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109"+
		"\u010c\3\2\2\2\u010a\u0108\3\2\2\2\u010b\u00fe\3\2\2\2\u010b\u00ff\3\2"+
		"\2\2\u010c%\3\2\2\2\u010d\u010e\7 \2\2\u010e\u010f\7%\2\2\u010f\u0110"+
		"\7&\2\2\u0110\u0118\b\24\1\2\u0111\u0112\7!\2\2\u0112\u0113\7%\2\2\u0113"+
		"\u0114\5\36\20\2\u0114\u0115\7&\2\2\u0115\u0116\b\24\1\2\u0116\u0118\3"+
		"\2\2\2\u0117\u010d\3\2\2\2\u0117\u0111\3\2\2\2\u0118\'\3\2\2\2\u0119\u011a"+
		"\b\25\1\2\u011a\u011b\5*\26\2\u011b\u0122\b\25\1\2\u011c\u011d\7\16\2"+
		"\2\u011d\u011e\5*\26\2\u011e\u011f\b\25\1\2\u011f\u0121\3\2\2\2\u0120"+
		"\u011c\3\2\2\2\u0121\u0124\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2"+
		"\2\2\u0123)\3\2\2\2\u0124\u0122\3\2\2\2\u0125\u0126\5\2\2\2\u0126\u0127"+
		"\7+\2\2\u0127\u0128\b\26\1\2\u0128+\3\2\2\2\u0129\u012a\7,\2\2\u012a\u0130"+
		"\b\27\1\2\u012b\u012c\7-\2\2\u012c\u0130\b\27\1\2\u012d\u012e\7.\2\2\u012e"+
		"\u0130\b\27\1\2\u012f\u0129\3\2\2\2\u012f\u012b\3\2\2\2\u012f\u012d\3"+
		"\2\2\2\u0130-\3\2\2\2\30\64;BKV]mq\u0084\u00a4\u00ab\u00b4\u00bf\u00c9"+
		"\u00e4\u00e6\u00fc\u0108\u010b\u0117\u0122\u012f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}