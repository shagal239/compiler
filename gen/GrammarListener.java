// Generated from /home/arkady/Documents/devcompiler/compiler/src/main/java/Grammar.g4 by ANTLR 4.5
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull GrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull GrammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#methodtype}.
	 * @param ctx the parse tree
	 */
	void enterMethodtype(@NotNull GrammarParser.MethodtypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#methodtype}.
	 * @param ctx the parse tree
	 */
	void exitMethodtype(@NotNull GrammarParser.MethodtypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(@NotNull GrammarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(@NotNull GrammarParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(@NotNull GrammarParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(@NotNull GrammarParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(@NotNull GrammarParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(@NotNull GrammarParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull GrammarParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull GrammarParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(@NotNull GrammarParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(@NotNull GrammarParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull GrammarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull GrammarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void enterIfstatement(@NotNull GrammarParser.IfstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void exitIfstatement(@NotNull GrammarParser.IfstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#whilestatement}.
	 * @param ctx the parse tree
	 */
	void enterWhilestatement(@NotNull GrammarParser.WhilestatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#whilestatement}.
	 * @param ctx the parse tree
	 */
	void exitWhilestatement(@NotNull GrammarParser.WhilestatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#forstatement}.
	 * @param ctx the parse tree
	 */
	void enterForstatement(@NotNull GrammarParser.ForstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#forstatement}.
	 * @param ctx the parse tree
	 */
	void exitForstatement(@NotNull GrammarParser.ForstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(@NotNull GrammarParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(@NotNull GrammarParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#forinit}.
	 * @param ctx the parse tree
	 */
	void enterForinit(@NotNull GrammarParser.ForinitContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#forinit}.
	 * @param ctx the parse tree
	 */
	void exitForinit(@NotNull GrammarParser.ForinitContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#varibleDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVaribleDeclaration(@NotNull GrammarParser.VaribleDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#varibleDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVaribleDeclaration(@NotNull GrammarParser.VaribleDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#emptyexpression}.
	 * @param ctx the parse tree
	 */
	void enterEmptyexpression(@NotNull GrammarParser.EmptyexpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#emptyexpression}.
	 * @param ctx the parse tree
	 */
	void exitEmptyexpression(@NotNull GrammarParser.EmptyexpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull GrammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull GrammarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#expression1}.
	 * @param ctx the parse tree
	 */
	void enterExpression1(@NotNull GrammarParser.Expression1Context ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#expression1}.
	 * @param ctx the parse tree
	 */
	void exitExpression1(@NotNull GrammarParser.Expression1Context ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(@NotNull GrammarParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(@NotNull GrammarParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(@NotNull GrammarParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(@NotNull GrammarParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#ioFunctions}.
	 * @param ctx the parse tree
	 */
	void enterIoFunctions(@NotNull GrammarParser.IoFunctionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#ioFunctions}.
	 * @param ctx the parse tree
	 */
	void exitIoFunctions(@NotNull GrammarParser.IoFunctionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(@NotNull GrammarParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(@NotNull GrammarParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(@NotNull GrammarParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(@NotNull GrammarParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(@NotNull GrammarParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(@NotNull GrammarParser.LiteralContext ctx);
}