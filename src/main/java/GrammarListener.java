// Generated from Grammar.g4 by ANTLR 4.5

    import java.util.*;
    import java.io.*;

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
	void enterType(GrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(GrammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#methodtype}.
	 * @param ctx the parse tree
	 */
	void enterMethodtype(GrammarParser.MethodtypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#methodtype}.
	 * @param ctx the parse tree
	 */
	void exitMethodtype(GrammarParser.MethodtypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(GrammarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(GrammarParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(GrammarParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(GrammarParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(GrammarParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(GrammarParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(GrammarParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(GrammarParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(GrammarParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(GrammarParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(GrammarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(GrammarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void enterIfstatement(GrammarParser.IfstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void exitIfstatement(GrammarParser.IfstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#whilestatement}.
	 * @param ctx the parse tree
	 */
	void enterWhilestatement(GrammarParser.WhilestatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#whilestatement}.
	 * @param ctx the parse tree
	 */
	void exitWhilestatement(GrammarParser.WhilestatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#forstatement}.
	 * @param ctx the parse tree
	 */
	void enterForstatement(GrammarParser.ForstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#forstatement}.
	 * @param ctx the parse tree
	 */
	void exitForstatement(GrammarParser.ForstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(GrammarParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(GrammarParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#forinit}.
	 * @param ctx the parse tree
	 */
	void enterForinit(GrammarParser.ForinitContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#forinit}.
	 * @param ctx the parse tree
	 */
	void exitForinit(GrammarParser.ForinitContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#varibleDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVaribleDeclaration(GrammarParser.VaribleDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#varibleDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVaribleDeclaration(GrammarParser.VaribleDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(GrammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(GrammarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#expression1}.
	 * @param ctx the parse tree
	 */
	void enterExpression1(GrammarParser.Expression1Context ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#expression1}.
	 * @param ctx the parse tree
	 */
	void exitExpression1(GrammarParser.Expression1Context ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(GrammarParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(GrammarParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(GrammarParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(GrammarParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#ioFunctions}.
	 * @param ctx the parse tree
	 */
	void enterIoFunctions(GrammarParser.IoFunctionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#ioFunctions}.
	 * @param ctx the parse tree
	 */
	void exitIoFunctions(GrammarParser.IoFunctionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(GrammarParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(GrammarParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(GrammarParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(GrammarParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(GrammarParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(GrammarParser.LiteralContext ctx);
}