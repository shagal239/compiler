// Generated from /home/arkady/Documents/devcompiler/compiler/src/main/java/Grammar.g4 by ANTLR 4.5
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull GrammarParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#methodtype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodtype(@NotNull GrammarParser.MethodtypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(@NotNull GrammarParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(@NotNull GrammarParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(@NotNull GrammarParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull GrammarParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(@NotNull GrammarParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull GrammarParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#ifstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstatement(@NotNull GrammarParser.IfstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#whilestatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhilestatement(@NotNull GrammarParser.WhilestatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#forstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForstatement(@NotNull GrammarParser.ForstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(@NotNull GrammarParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#forinit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForinit(@NotNull GrammarParser.ForinitContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#varibleDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVaribleDeclaration(@NotNull GrammarParser.VaribleDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#emptyexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyexpression(@NotNull GrammarParser.EmptyexpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull GrammarParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#expression1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression1(@NotNull GrammarParser.Expression1Context ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(@NotNull GrammarParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(@NotNull GrammarParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#ioFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIoFunctions(@NotNull GrammarParser.IoFunctionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(@NotNull GrammarParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(@NotNull GrammarParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(@NotNull GrammarParser.LiteralContext ctx);
}