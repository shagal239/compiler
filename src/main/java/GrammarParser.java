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
		T__31=32, WS=33, COMMENT=34, LINE_COMMENT=35, LPAREN=36, RPAREN=37, LBRACE=38, 
		RBRACE=39, COMMA=40, SEMI=41, Identifier=42, IntegerLiteral=43, StringLiteral=44, 
		BooleanLiteral=45;
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

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    List<Scope> scopes = new ArrayList<Scope>();
	    Scope functionVariables = new Scope();
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
	        Variable v = new Variable(type, "t" + tempId++);
	        code.add(v.declaration());
	        return v;

	    }

	    public Variable createVariable(String name, Type type) {
	        if (type != Type.FunctionType) {
	        	            Scope scope = scopes.get(scopes.size() - 1);
	        	            if (scope.contains(name)){
	        	                return null;
	        	            } else {
	        	                Variable v = new Variable(type, "v" + (id++));
	        	                code.add(v.declaration());
	        	                scope.addVariable(name, v);
	        	                return v;
	        	            }
	                    } else {
	                        Scope scope = scopes.get(scopes.size() - 1);
	                        if (scope.containsFunction(name)) {
	                            return null;
	                        } else {
	                            FunctionVariable v = new FunctionVariable("F" + (id++), type);
	                            code.add(v.declaration());
	                            scope.addFunction(name, v);
	                            return v;
	                        }
	                    }
	    }
	      public Variable callFuckingFunction(String name, List<Variable> variables) {
	                 Scope scope = scopes.get(scopes.size() - 1);
	                 FunctionVariable variable = scope.getFunction(name);
	                 for (Variable var : variables) {
	                 	                     if (var.type != Type.FunctionType) {
	                                              code.add("param " + var.getId());
	                                          } else {
	                                              code.add("fparam " + var.getId());
	                                          }
	                 	                 }

	                 if (variable.getType().returnType != Type.VoidType) {
	                     Variable t = createTempVariable(variable.getType().returnType);
	                     code.add("param &" + t.getId());
	                     code.add("call &" + variable.getId());
	                     return t;
	                 } else {
	                     code.add("param &void");
	                     code.add("call &" + variable.getId());
	                     return new Variable(Type.VoidType, "void");
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

	               scope = scopes.size() - 1;
	               while (scope >= 0) {
	                   Scope s = scopes.get(scope);
	                   Variable variable = s.getFunction(name);
	                   if (variable != null) {
	                       return variable;
	                   }
	                   scope--;
	               }

	   	        return null;
	   	    }

	    public Function registerFunction(String name, Type result, List<Variable> arguments) {
	        openScope();
	        Type[] types = new Type[arguments.size()];
	                    List<Type> typeList = new ArrayList<Type>();
	        	        for (int i = 0; i < types.length;i++) {
	        	            types[i] = arguments.get(i).getType();
	                        typeList.add(types[i]);
	        	        }
	        Function function = new Function(name, result, types);
	        	        Functions.add(function);
	        	        code.add(function.getId() + ":");
	        	        Variable res = createTempVariable(function.getResult());
	        	        code.add("pop " + res.getId());
	        	        Collections.reverse(arguments);
	        	        for (Variable variable: arguments) {
	        	            Variable v = createVariable(variable.getId(), variable.getType());
	        	            code.add("pop " + v.getId());
	        	        }

	        returnVariables.add(res);
	        Type t = Type.FunctionType;
	                    t.returnType = result;
	                    t.args = typeList;
	                    FunctionVariable variable = new FunctionVariable(name, t);
	                    scopes.get(scopes.size() - 2).addFunction(name, variable);
	        return function;
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
	                                            if (function == null) {
	                                                return callFuckingFunction(name, variables);
	                                            }
	        	        for (Variable var : variables) {
	                    	                     if (var.type != Type.FunctionType) {
	                                                 code.add("param " + var.getId());
	                                             } else {
	                                                 code.add("fparam " + var.getId());
	                                             }
	                    	                 }

	        	        if (function.getResult() != Type.VoidType) {
	        	           Variable t = createTempVariable(function.getResult());
	        	           if (t.getType() == Type.FunctionType) {
	        	               code.add("fparam &" + t.getId());
	                           code.add("call " + function.getId());
	        	           }
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
		public TypeContext r;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
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
			setState(55);
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
			case T__3:
				enterOuterAlt(_localctx, 4);
				{
				setState(50);
				match(T__3);
				setState(51);
				((TypeContext)_localctx).r = type();
				setState(52);
				match(T__4);
				((TypeContext)_localctx).result =  Type.FunctionType; _localctx.result.returnType = ((TypeContext)_localctx).r.result;
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
			setState(62);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				((MethodtypeContext)_localctx).type = type();
				((MethodtypeContext)_localctx).result =  ((MethodtypeContext)_localctx).type.result;
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				match(T__5);
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
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			code.clear();openScope();
			setState(65);
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
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__5))) != 0)) {
				{
				{
				setState(68);
				methodDeclaration();
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
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
		public Function func;
		public MethodtypeContext m;
		public MethodtypeContext methodtype;
		public Token Identifier;
		public ParametersContext a;
		public TerminalNode Identifier() { return getToken(GrammarParser.Identifier, 0); }
		public TerminalNode LPAREN() { return getToken(GrammarParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(GrammarParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MethodtypeContext methodtype() {
			return getRuleContext(MethodtypeContext.class,0);
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
			setState(76);
			((MethodDeclarationContext)_localctx).m = ((MethodDeclarationContext)_localctx).methodtype = methodtype();
			setState(77);
			((MethodDeclarationContext)_localctx).Identifier = match(Identifier);
			setState(78);
			match(LPAREN);
			setState(80);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3))) != 0)) {
				{
				setState(79);
				((MethodDeclarationContext)_localctx).a = parameters();
				}
			}

			setState(82);
			match(RPAREN);
			List<Variable> args = new ArrayList<Variable>();
			    if (((MethodDeclarationContext)_localctx).a != null) {
			        args = ((MethodDeclarationContext)_localctx).a.vars;
			    }
			    Function func = registerFunction((((MethodDeclarationContext)_localctx).Identifier!=null?((MethodDeclarationContext)_localctx).Identifier.getText():null), ((MethodDeclarationContext)_localctx).methodtype.result, args);
			    ((MethodDeclarationContext)_localctx).func =  func;
			    
			setState(84);
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
			setState(87);
			match(LBRACE);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__12) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__30) | (1L << T__31) | (1L << LPAREN) | (1L << LBRACE) | (1L << SEMI) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << BooleanLiteral))) != 0)) {
				{
				{
				setState(88);
				blockStatement();
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
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
			setState(98);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				declaration();
				}
				break;
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__11:
			case T__12:
			case T__16:
			case T__17:
			case T__18:
			case T__30:
			case T__31:
			case LPAREN:
			case LBRACE:
			case SEMI:
			case Identifier:
			case IntegerLiteral:
			case StringLiteral:
			case BooleanLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
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
			setState(118);
			switch (_input.LA(1)) {
			case SEMI:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				match(SEMI);
				}
				break;
			case T__16:
			case T__17:
			case T__18:
			case T__30:
			case T__31:
			case LPAREN:
			case Identifier:
			case IntegerLiteral:
			case StringLiteral:
			case BooleanLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				expression();
				setState(102);
				match(SEMI);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(104);
				ifstatement();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 4);
				{
				setState(105);
				forstatement();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 5);
				{
				setState(106);
				whilestatement();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 6);
				{
				setState(107);
				block();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 7);
				{
				setState(108);
				match(T__6);
				code.add("goto" + getLoopEnd());
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 8);
				{
				setState(110);
				match(T__7);
				code.add("goto " + getLoopStart()); 
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 9);
				{
				setState(112);
				match(T__8);
				setState(114);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__30) | (1L << T__31) | (1L << LPAREN) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral) | (1L << BooleanLiteral))) != 0)) {
					{
					setState(113);
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

				        code.add("*" + returnVariable.getId() + " = " + ((StatementContext)_localctx).e.var.getId());
				        code.add("back");
				    
				setState(117);
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
			setState(120);
			match(T__9);
			openScope();
			setState(122);
			match(LPAREN);
			setState(123);
			((IfstatementContext)_localctx).a = expression();
			Variable v = ((IfstatementContext)_localctx).a.var; String label = label(); code.add("!if " + v.getId() + " goto " + label);
			setState(125);
			match(RPAREN);
			setState(126);
			match(LBRACE);
			setState(127);
			((IfstatementContext)_localctx).s = statement();
			 code.add(label +":"); 
			setState(129);
			match(RBRACE);
			setState(137);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(130);
				match(T__10);
				String labelF = label(); code.add("if " + v.getId() + " goto " + labelF);
				setState(132);
				match(LBRACE);
				setState(133);
				statement();
				code.add(labelF+ ":"); closeScope();
				setState(135);
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
			setState(139);
			match(T__11);
			openLoop();
			setState(141);
			match(LPAREN);
			setState(142);
			((WhilestatementContext)_localctx).e = expression();
			Variable v = ((WhilestatementContext)_localctx).e.var; code.add("!if " + v.getId() + " goto " + getLoopEnd()); 
			setState(144);
			match(RPAREN);
			setState(145);
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
			setState(148);
			match(T__12);
			setState(149);
			match(LPAREN);
			setState(150);
			forinit();
			setState(151);
			match(SEMI);
			 openLoop(); 
			setState(153);
			((ForstatementContext)_localctx).e = expression();
			 Variable v = ((ForstatementContext)_localctx).e.var; code.add("!if " + v.getId() + " goto " + getLoopEnd()); 
			setState(155);
			match(SEMI);
			List<String> save = code;
			    code = new ArrayList<String>();
			    
			setState(157);
			expressionList();
			 List<String> temp = save;
			    save = code;
			    code = temp;
			    
			setState(159);
			match(RPAREN);
			setState(160);
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
			setState(163);
			((DeclarationContext)_localctx).type = type();
			setState(164);
			varibleDeclaration(((DeclarationContext)_localctx).type.result);
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(165);
				match(T__13);
				setState(166);
				varibleDeclaration(((DeclarationContext)_localctx).type.result);
				}
				}
				setState(171);
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
			setState(174);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				declaration();
				}
				break;
			case T__16:
			case T__17:
			case T__18:
			case T__30:
			case T__31:
			case LPAREN:
			case SEMI:
			case Identifier:
			case IntegerLiteral:
			case StringLiteral:
			case BooleanLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
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
			setState(183);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				((VaribleDeclarationContext)_localctx).Identifier = match(Identifier);
				 createVariable((((VaribleDeclarationContext)_localctx).Identifier!=null?((VaribleDeclarationContext)_localctx).Identifier.getText():null), t); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				((VaribleDeclarationContext)_localctx).Identifier = match(Identifier);
				setState(179);
				match(T__14);
				setState(180);
				((VaribleDeclarationContext)_localctx).expression = expression();

				        Variable a = createVariable((((VaribleDeclarationContext)_localctx).Identifier!=null?((VaribleDeclarationContext)_localctx).Identifier.getText():null), t);
				        Variable b = ((VaribleDeclarationContext)_localctx).expression.var;
				        code.add(a.getId() + " = " + b.getId());
				    
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
			setState(194);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(185);
				((ExpressionContext)_localctx).id = match(Identifier);
				Variable left = resolveVariable((((ExpressionContext)_localctx).id!=null?((ExpressionContext)_localctx).id.getText():null));
				setState(187);
				((ExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__14 || _la==T__15) ) {
					((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(188);
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
				setState(191);
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
			setState(204);
			switch (_input.LA(1)) {
			case T__16:
			case T__17:
			case T__18:
				{
				setState(197);
				((Expression1Context)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__17) | (1L << T__18))) != 0)) ) {
					((Expression1Context)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(198);
				((Expression1Context)_localctx).a = expression1(6);

				        Variable v = ((Expression1Context)_localctx).a.var;
				        code.add(v.getId() + " = " + (((Expression1Context)_localctx).op!=null?((Expression1Context)_localctx).op.getText():null) + " " + v.getId());
				        ((Expression1Context)_localctx).var =  v;
				    
				}
				break;
			case T__30:
			case T__31:
			case LPAREN:
			case Identifier:
			case IntegerLiteral:
			case StringLiteral:
			case BooleanLiteral:
				{
				setState(201);
				((Expression1Context)_localctx).primary = primary();
				((Expression1Context)_localctx).var =  ((Expression1Context)_localctx).primary.var;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(233);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(231);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new Expression1Context(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression1);
						setState(206);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(207);
						((Expression1Context)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__21))) != 0)) ) {
							((Expression1Context)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(208);
						((Expression1Context)_localctx).b = expression1(6);

						                  Variable x = ((Expression1Context)_localctx).a.var;
						                  Variable y = ((Expression1Context)_localctx).b.var;
						                  Variable v = createTempVariable(x.getType());
						                  code.add(v.getId() + " = " + x.getId() + " " + (((Expression1Context)_localctx).op!=null?((Expression1Context)_localctx).op.getText():null) + " " + y.getId());
						                  ((Expression1Context)_localctx).var =  v;
						              
						}
						break;
					case 2:
						{
						_localctx = new Expression1Context(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression1);
						setState(211);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(212);
						((Expression1Context)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__16 || _la==T__22) ) {
							((Expression1Context)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(213);
						((Expression1Context)_localctx).b = expression1(5);

						                  Variable x = ((Expression1Context)_localctx).a.var;
						                  Variable y = ((Expression1Context)_localctx).b.var;
						                  Variable v = createTempVariable(x.getType());
						                  code.add(v.getId() + " = " + x.getId() + " " + (((Expression1Context)_localctx).op!=null?((Expression1Context)_localctx).op.getText():null) + " " + y.getId());
						                  ((Expression1Context)_localctx).var =  v;
						              
						}
						break;
					case 3:
						{
						_localctx = new Expression1Context(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression1);
						setState(216);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(217);
						((Expression1Context)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27))) != 0)) ) {
							((Expression1Context)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(218);
						((Expression1Context)_localctx).b = expression1(4);

						                  Variable x = ((Expression1Context)_localctx).a.var;
						                  Variable y = ((Expression1Context)_localctx).b.var;
						                  Variable v = createTempVariable(Type.BooleanType);
						                  code.add(v.getId() + " = " + x.getId() + " " + (((Expression1Context)_localctx).op!=null?((Expression1Context)_localctx).op.getText():null) + " " + y.getId());
						                  ((Expression1Context)_localctx).var =  v;
						              
						}
						break;
					case 4:
						{
						_localctx = new Expression1Context(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression1);
						setState(221);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(222);
						match(T__28);
						setState(223);
						((Expression1Context)_localctx).b = expression1(3);

						                      Variable x = ((Expression1Context)_localctx).a.var;
						                      Variable y = ((Expression1Context)_localctx).b.var;
						                      Variable v = createTempVariable(Type.BooleanType);
						                      code.add(v.getId() + " = " + x.getId() + " && " + y.getId());
						                      ((Expression1Context)_localctx).var =  v;
						               
						}
						break;
					case 5:
						{
						_localctx = new Expression1Context(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression1);
						setState(226);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(227);
						match(T__29);
						setState(228);
						((Expression1Context)_localctx).b = expression1(2);

						                  Variable x = ((Expression1Context)_localctx).a.var;
						                  Variable y = ((Expression1Context)_localctx).b.var;
						                  Variable v = createTempVariable(Type.BooleanType);
						                  code.add(v.getId() + " = " + x.getId() + " || " + y.getId());
						                  ((Expression1Context)_localctx).var =  v;
						              
						}
						break;
					}
					} 
				}
				setState(235);
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
			setState(255);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(236);
				((PrimaryContext)_localctx).Identifier = match(Identifier);
				((PrimaryContext)_localctx).var =  resolveVariable((((PrimaryContext)_localctx).Identifier!=null?((PrimaryContext)_localctx).Identifier.getText():null));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(238);
				match(LPAREN);
				setState(239);
				((PrimaryContext)_localctx).expression = expression();
				setState(240);
				match(RPAREN);
				((PrimaryContext)_localctx).var =  ((PrimaryContext)_localctx).expression.var;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(243);
				((PrimaryContext)_localctx).Identifier = match(Identifier);
				setState(244);
				match(LPAREN);
				setState(245);
				((PrimaryContext)_localctx).expressionList = expressionList();
				setState(246);
				match(RPAREN);
				((PrimaryContext)_localctx).var =  callFunction((((PrimaryContext)_localctx).Identifier!=null?((PrimaryContext)_localctx).Identifier.getText():null), ((PrimaryContext)_localctx).expressionList.vars); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(249);
				((PrimaryContext)_localctx).ioFunctions = ioFunctions();
				((PrimaryContext)_localctx).var =  ((PrimaryContext)_localctx).ioFunctions.var;
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(252);
				((PrimaryContext)_localctx).literal = literal();
				 Variable t = createTempVariable(((PrimaryContext)_localctx).literal.result); code.add(t.getId() + " = " + (((PrimaryContext)_localctx).literal!=null?_input.getText(((PrimaryContext)_localctx).literal.start,((PrimaryContext)_localctx).literal.stop):null)); ((PrimaryContext)_localctx).var =  t;
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
			setState(270);
			switch (_input.LA(1)) {
			case RPAREN:
			case SEMI:
				enterOuterAlt(_localctx, 1);
				{
				((ExpressionListContext)_localctx).vars =  new ArrayList<Variable>();
				}
				break;
			case T__16:
			case T__17:
			case T__18:
			case T__30:
			case T__31:
			case LPAREN:
			case Identifier:
			case IntegerLiteral:
			case StringLiteral:
			case BooleanLiteral:
				enterOuterAlt(_localctx, 2);
				{
				  ((ExpressionListContext)_localctx).vars =  new ArrayList<Variable>(); 
				setState(259);
				((ExpressionListContext)_localctx).a = expression();
				_localctx.vars.add(((ExpressionListContext)_localctx).a.var);
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(261);
					match(COMMA);
					setState(262);
					((ExpressionListContext)_localctx).b = expression();
					_localctx.vars.add(((ExpressionListContext)_localctx).b.var);
					}
					}
					setState(269);
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
			setState(282);
			switch (_input.LA(1)) {
			case T__30:
				enterOuterAlt(_localctx, 1);
				{
				setState(272);
				match(T__30);
				setState(273);
				match(LPAREN);
				setState(274);
				match(RPAREN);
				 ((IoFunctionsContext)_localctx).var =  callFunction("read"); 
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				setState(276);
				match(T__31);
				setState(277);
				match(LPAREN);
				setState(278);
				((IoFunctionsContext)_localctx).expression = expression();
				setState(279);
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
			setState(285);
			((ParametersContext)_localctx).a = parameter();
			_localctx.vars.add(((ParametersContext)_localctx).a.var);
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(287);
				match(T__13);
				setState(288);
				((ParametersContext)_localctx).b = parameter();
				_localctx.vars.add(((ParametersContext)_localctx).b.var);
				}
				}
				setState(295);
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
		public TypeContext t;
		public Token i;
		public ParametersContext p;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(GrammarParser.Identifier, 0); }
		public TerminalNode LPAREN() { return getToken(GrammarParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(GrammarParser.RPAREN, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
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
		int _la;
		try {
			setState(311);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				((ParameterContext)_localctx).type = type();
				setState(297);
				((ParameterContext)_localctx).Identifier = match(Identifier);
				((ParameterContext)_localctx).var =  new Variable(((ParameterContext)_localctx).type.result, (((ParameterContext)_localctx).Identifier!=null?((ParameterContext)_localctx).Identifier.getText():null));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(300);
				match(T__3);
				setState(301);
				((ParameterContext)_localctx).t = type();
				setState(302);
				match(T__4);
				setState(303);
				((ParameterContext)_localctx).i = match(Identifier);
				setState(304);
				match(LPAREN);
				setState(306);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3))) != 0)) {
					{
					setState(305);
					((ParameterContext)_localctx).p = parameters();
					}
				}

				setState(308);
				match(RPAREN);

				        List<Type> args = new ArrayList<Type>();
				        for (Variable v : ((ParameterContext)_localctx).p.vars) {
				            args.add(v.getType());
				        }
				        Type type = Type.FunctionType;
				        type.returnType = ((ParameterContext)_localctx).t.result;
				        type.args = args;
				        Variable v = new FunctionVariable((((ParameterContext)_localctx).i!=null?((ParameterContext)_localctx).i.getText():null), type);
				        ((ParameterContext)_localctx).var =  v;
				    
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
			setState(319);
			switch (_input.LA(1)) {
			case IntegerLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(313);
				match(IntegerLiteral);
				((LiteralContext)_localctx).result =  Type.IntegerType;
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(315);
				match(StringLiteral);
				((LiteralContext)_localctx).result =  Type.StringType;
				}
				break;
			case BooleanLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(317);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3/\u0144\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\5\2:\n\2\3\3\3\3\3\3\3\3\3\3\5\3A\n\3\3\4\3\4"+
		"\3\4\3\4\3\5\7\5H\n\5\f\5\16\5K\13\5\3\5\3\5\3\6\3\6\3\6\3\6\5\6S\n\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\7\7\\\n\7\f\7\16\7_\13\7\3\7\3\7\3\b\3\b"+
		"\5\be\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t"+
		"u\n\t\3\t\3\t\5\ty\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\5\n\u008c\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\7\r\u00aa\n\r\f\r\16\r\u00ad\13\r\3\16\3\16\5\16\u00b1"+
		"\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00ba\n\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00c5\n\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\5\21\u00cf\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\7\21\u00ea\n\21\f\21\16\21\u00ed\13\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\5\22\u0102\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23"+
		"\u010c\n\23\f\23\16\23\u010f\13\23\5\23\u0111\n\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u011d\n\24\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\7\25\u0126\n\25\f\25\16\25\u0129\13\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0135\n\26\3\26\3\26\3\26\5\26\u013a"+
		"\n\26\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0142\n\27\3\27\2\3 \30\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\7\3\2\21\22\3\2\23\25\3\2"+
		"\26\30\4\2\23\23\31\31\4\2\7\7\32\36\u0155\29\3\2\2\2\4@\3\2\2\2\6B\3"+
		"\2\2\2\bI\3\2\2\2\nN\3\2\2\2\fY\3\2\2\2\16d\3\2\2\2\20x\3\2\2\2\22z\3"+
		"\2\2\2\24\u008d\3\2\2\2\26\u0096\3\2\2\2\30\u00a5\3\2\2\2\32\u00b0\3\2"+
		"\2\2\34\u00b9\3\2\2\2\36\u00c4\3\2\2\2 \u00ce\3\2\2\2\"\u0101\3\2\2\2"+
		"$\u0110\3\2\2\2&\u011c\3\2\2\2(\u011e\3\2\2\2*\u0139\3\2\2\2,\u0141\3"+
		"\2\2\2./\7\3\2\2/:\b\2\1\2\60\61\7\4\2\2\61:\b\2\1\2\62\63\7\5\2\2\63"+
		":\b\2\1\2\64\65\7\6\2\2\65\66\5\2\2\2\66\67\7\7\2\2\678\b\2\1\28:\3\2"+
		"\2\29.\3\2\2\29\60\3\2\2\29\62\3\2\2\29\64\3\2\2\2:\3\3\2\2\2;<\5\2\2"+
		"\2<=\b\3\1\2=A\3\2\2\2>?\7\b\2\2?A\b\3\1\2@;\3\2\2\2@>\3\2\2\2A\5\3\2"+
		"\2\2BC\b\4\1\2CD\5\b\5\2DE\b\4\1\2E\7\3\2\2\2FH\5\n\6\2GF\3\2\2\2HK\3"+
		"\2\2\2IG\3\2\2\2IJ\3\2\2\2JL\3\2\2\2KI\3\2\2\2LM\7\2\2\3M\t\3\2\2\2NO"+
		"\5\4\3\2OP\7,\2\2PR\7&\2\2QS\5(\25\2RQ\3\2\2\2RS\3\2\2\2ST\3\2\2\2TU\7"+
		"\'\2\2UV\b\6\1\2VW\5\f\7\2WX\b\6\1\2X\13\3\2\2\2Y]\7(\2\2Z\\\5\16\b\2"+
		"[Z\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2\2`a\7)\2\2"+
		"a\r\3\2\2\2be\5\30\r\2ce\5\20\t\2db\3\2\2\2dc\3\2\2\2e\17\3\2\2\2fy\7"+
		"+\2\2gh\5\36\20\2hi\7+\2\2iy\3\2\2\2jy\5\22\n\2ky\5\26\f\2ly\5\24\13\2"+
		"my\5\f\7\2no\7\t\2\2oy\b\t\1\2pq\7\n\2\2qy\b\t\1\2rt\7\13\2\2su\5\36\20"+
		"\2ts\3\2\2\2tu\3\2\2\2uv\3\2\2\2vw\b\t\1\2wy\7+\2\2xf\3\2\2\2xg\3\2\2"+
		"\2xj\3\2\2\2xk\3\2\2\2xl\3\2\2\2xm\3\2\2\2xn\3\2\2\2xp\3\2\2\2xr\3\2\2"+
		"\2y\21\3\2\2\2z{\7\f\2\2{|\b\n\1\2|}\7&\2\2}~\5\36\20\2~\177\b\n\1\2\177"+
		"\u0080\7\'\2\2\u0080\u0081\7(\2\2\u0081\u0082\5\20\t\2\u0082\u0083\b\n"+
		"\1\2\u0083\u008b\7)\2\2\u0084\u0085\7\r\2\2\u0085\u0086\b\n\1\2\u0086"+
		"\u0087\7(\2\2\u0087\u0088\5\20\t\2\u0088\u0089\b\n\1\2\u0089\u008a\7)"+
		"\2\2\u008a\u008c\3\2\2\2\u008b\u0084\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\23\3\2\2\2\u008d\u008e\7\16\2\2\u008e\u008f\b\13\1\2\u008f\u0090\7&\2"+
		"\2\u0090\u0091\5\36\20\2\u0091\u0092\b\13\1\2\u0092\u0093\7\'\2\2\u0093"+
		"\u0094\5\20\t\2\u0094\u0095\b\13\1\2\u0095\25\3\2\2\2\u0096\u0097\7\17"+
		"\2\2\u0097\u0098\7&\2\2\u0098\u0099\5\32\16\2\u0099\u009a\7+\2\2\u009a"+
		"\u009b\b\f\1\2\u009b\u009c\5\36\20\2\u009c\u009d\b\f\1\2\u009d\u009e\7"+
		"+\2\2\u009e\u009f\b\f\1\2\u009f\u00a0\5$\23\2\u00a0\u00a1\b\f\1\2\u00a1"+
		"\u00a2\7\'\2\2\u00a2\u00a3\5\20\t\2\u00a3\u00a4\b\f\1\2\u00a4\27\3\2\2"+
		"\2\u00a5\u00a6\5\2\2\2\u00a6\u00ab\5\34\17\2\u00a7\u00a8\7\20\2\2\u00a8"+
		"\u00aa\5\34\17\2\u00a9\u00a7\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3"+
		"\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\31\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae"+
		"\u00b1\5\30\r\2\u00af\u00b1\5$\23\2\u00b0\u00ae\3\2\2\2\u00b0\u00af\3"+
		"\2\2\2\u00b1\33\3\2\2\2\u00b2\u00b3\7,\2\2\u00b3\u00ba\b\17\1\2\u00b4"+
		"\u00b5\7,\2\2\u00b5\u00b6\7\21\2\2\u00b6\u00b7\5\36\20\2\u00b7\u00b8\b"+
		"\17\1\2\u00b8\u00ba\3\2\2\2\u00b9\u00b2\3\2\2\2\u00b9\u00b4\3\2\2\2\u00ba"+
		"\35\3\2\2\2\u00bb\u00bc\7,\2\2\u00bc\u00bd\b\20\1\2\u00bd\u00be\t\2\2"+
		"\2\u00be\u00bf\5 \21\2\u00bf\u00c0\b\20\1\2\u00c0\u00c5\3\2\2\2\u00c1"+
		"\u00c2\5 \21\2\u00c2\u00c3\b\20\1\2\u00c3\u00c5\3\2\2\2\u00c4\u00bb\3"+
		"\2\2\2\u00c4\u00c1\3\2\2\2\u00c5\37\3\2\2\2\u00c6\u00c7\b\21\1\2\u00c7"+
		"\u00c8\t\3\2\2\u00c8\u00c9\5 \21\b\u00c9\u00ca\b\21\1\2\u00ca\u00cf\3"+
		"\2\2\2\u00cb\u00cc\5\"\22\2\u00cc\u00cd\b\21\1\2\u00cd\u00cf\3\2\2\2\u00ce"+
		"\u00c6\3\2\2\2\u00ce\u00cb\3\2\2\2\u00cf\u00eb\3\2\2\2\u00d0\u00d1\f\7"+
		"\2\2\u00d1\u00d2\t\4\2\2\u00d2\u00d3\5 \21\b\u00d3\u00d4\b\21\1\2\u00d4"+
		"\u00ea\3\2\2\2\u00d5\u00d6\f\6\2\2\u00d6\u00d7\t\5\2\2\u00d7\u00d8\5 "+
		"\21\7\u00d8\u00d9\b\21\1\2\u00d9\u00ea\3\2\2\2\u00da\u00db\f\5\2\2\u00db"+
		"\u00dc\t\6\2\2\u00dc\u00dd\5 \21\6\u00dd\u00de\b\21\1\2\u00de\u00ea\3"+
		"\2\2\2\u00df\u00e0\f\4\2\2\u00e0\u00e1\7\37\2\2\u00e1\u00e2\5 \21\5\u00e2"+
		"\u00e3\b\21\1\2\u00e3\u00ea\3\2\2\2\u00e4\u00e5\f\3\2\2\u00e5\u00e6\7"+
		" \2\2\u00e6\u00e7\5 \21\4\u00e7\u00e8\b\21\1\2\u00e8\u00ea\3\2\2\2\u00e9"+
		"\u00d0\3\2\2\2\u00e9\u00d5\3\2\2\2\u00e9\u00da\3\2\2\2\u00e9\u00df\3\2"+
		"\2\2\u00e9\u00e4\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb"+
		"\u00ec\3\2\2\2\u00ec!\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00ef\7,\2\2\u00ef"+
		"\u0102\b\22\1\2\u00f0\u00f1\7&\2\2\u00f1\u00f2\5\36\20\2\u00f2\u00f3\7"+
		"\'\2\2\u00f3\u00f4\b\22\1\2\u00f4\u0102\3\2\2\2\u00f5\u00f6\7,\2\2\u00f6"+
		"\u00f7\7&\2\2\u00f7\u00f8\5$\23\2\u00f8\u00f9\7\'\2\2\u00f9\u00fa\b\22"+
		"\1\2\u00fa\u0102\3\2\2\2\u00fb\u00fc\5&\24\2\u00fc\u00fd\b\22\1\2\u00fd"+
		"\u0102\3\2\2\2\u00fe\u00ff\5,\27\2\u00ff\u0100\b\22\1\2\u0100\u0102\3"+
		"\2\2\2\u0101\u00ee\3\2\2\2\u0101\u00f0\3\2\2\2\u0101\u00f5\3\2\2\2\u0101"+
		"\u00fb\3\2\2\2\u0101\u00fe\3\2\2\2\u0102#\3\2\2\2\u0103\u0111\b\23\1\2"+
		"\u0104\u0105\b\23\1\2\u0105\u0106\5\36\20\2\u0106\u010d\b\23\1\2\u0107"+
		"\u0108\7*\2\2\u0108\u0109\5\36\20\2\u0109\u010a\b\23\1\2\u010a\u010c\3"+
		"\2\2\2\u010b\u0107\3\2\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010d"+
		"\u010e\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0103\3\2"+
		"\2\2\u0110\u0104\3\2\2\2\u0111%\3\2\2\2\u0112\u0113\7!\2\2\u0113\u0114"+
		"\7&\2\2\u0114\u0115\7\'\2\2\u0115\u011d\b\24\1\2\u0116\u0117\7\"\2\2\u0117"+
		"\u0118\7&\2\2\u0118\u0119\5\36\20\2\u0119\u011a\7\'\2\2\u011a\u011b\b"+
		"\24\1\2\u011b\u011d\3\2\2\2\u011c\u0112\3\2\2\2\u011c\u0116\3\2\2\2\u011d"+
		"\'\3\2\2\2\u011e\u011f\b\25\1\2\u011f\u0120\5*\26\2\u0120\u0127\b\25\1"+
		"\2\u0121\u0122\7\20\2\2\u0122\u0123\5*\26\2\u0123\u0124\b\25\1\2\u0124"+
		"\u0126\3\2\2\2\u0125\u0121\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125\3\2"+
		"\2\2\u0127\u0128\3\2\2\2\u0128)\3\2\2\2\u0129\u0127\3\2\2\2\u012a\u012b"+
		"\5\2\2\2\u012b\u012c\7,\2\2\u012c\u012d\b\26\1\2\u012d\u013a\3\2\2\2\u012e"+
		"\u012f\7\6\2\2\u012f\u0130\5\2\2\2\u0130\u0131\7\7\2\2\u0131\u0132\7,"+
		"\2\2\u0132\u0134\7&\2\2\u0133\u0135\5(\25\2\u0134\u0133\3\2\2\2\u0134"+
		"\u0135\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0137\7\'\2\2\u0137\u0138\b\26"+
		"\1\2\u0138\u013a\3\2\2\2\u0139\u012a\3\2\2\2\u0139\u012e\3\2\2\2\u013a"+
		"+\3\2\2\2\u013b\u013c\7-\2\2\u013c\u0142\b\27\1\2\u013d\u013e\7.\2\2\u013e"+
		"\u0142\b\27\1\2\u013f\u0140\7/\2\2\u0140\u0142\b\27\1\2\u0141\u013b\3"+
		"\2\2\2\u0141\u013d\3\2\2\2\u0141\u013f\3\2\2\2\u0142-\3\2\2\2\329@IR]"+
		"dtx\u008b\u00ab\u00b0\u00b9\u00c4\u00ce\u00e9\u00eb\u0101\u010d\u0110"+
		"\u011c\u0127\u0134\u0139\u0141";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}