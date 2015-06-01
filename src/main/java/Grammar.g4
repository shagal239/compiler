grammar Grammar;

@parser::header {
    import java.util.*;
    import java.io.*;
}

@parser::members {
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
}
type returns [Type result]:
    'int' {$result = Type.IntegerType;} |
    'string' {$result = Type.StringType;} |
    'boolean' {$result = Type.BooleanType;} |
    'function' {$result = Type.FunctionType;}
    ;

methodtype returns [Type result]:
    type {$result = $type.result;} | 
    'void' {$result = Type.VoidType;}
    ;

start returns [List<String> result]: {code.clear();openScope();} body {$result = new ArrayList<String>(code);code.clear();};

body: methodDeclaration* EOF;

methodDeclaration returns [Function func]:
    m=methodtype Identifier LPAREN (a=parameters)? RPAREN
    {List<Variable> args = new ArrayList<Variable>();
    if (((MethodDeclarationContext)_localctx).a != null) {
        args = $a.vars;
    }
    Function func = registerFunction($Identifier.text, $methodtype.result, args);
    $func = func;
    }
    block {
        endFunction();
        code.add("back");
    }
    ;

block :
    LBRACE blockStatement* RBRACE
    ;

blockStatement: declaration | statement;

statement:
    ';' |
    expression ';' |
    ifstatement |
    forstatement |
    whilestatement |
    block |
    'break;' {code.add("goto" + getLoopEnd());}|
    'continue;' {code.add("goto " + getLoopStart()); }|
    'return ' e=expression?
    {
        Variable variable = ((StatementContext)_localctx).e == null ? (new Variable(Type.VoidType, "void")) : $e.var;
        Variable returnVariable = getReturnVariable();
        if (returnVariable == null) {
            return null;
        }
        if (returnVariable.getType() != $e.var.getType()) {
            return null;
        }

        code.add("*" + returnVariable.getId() + " = " + $e.var.getId());
        code.add("back");
    }
        ';'
    ;

ifstatement:
    'if' {openScope();}
    LPAREN
    a=expression {Variable v = $a.var; String label = label(); code.add("!if " + v.getId() + " goto " + label);}
    RPAREN LBRACE
    s=statement { code.add(label +":"); } RBRACE
    ('else'
    {String labelF = label(); code.add("if " + v.getId() + " goto " + labelF);}
    LBRACE
    statement {code.add(labelF+ ":"); closeScope();} RBRACE )?
    ;

whilestatement:
    'while' {openLoop();}
    LPAREN
    e=expression {Variable v = $e.var; code.add("!if " + v.getId() + " goto " + getLoopEnd()); }
    RPAREN
    s=statement { code.add("goto " + getLoopStart()); closeLoop(); }
    ;

forstatement:
    'for'
    LPAREN
    forinit ';'
    { openLoop(); }
    e=expression
    { Variable v = $e.var; code.add("!if " + v.getId() + " goto " + getLoopEnd()); } ';'
    {List<String> save = code;
    code = new ArrayList<String>();
    }
    expressionList
    { List<String> temp = save;
    save = code;
    code = temp;
    }
    RPAREN
    statement
    {code.addAll(save);
    code.add("goto " + getLoopStart());
    closeLoop();
    }
    ;

declaration:
    type varibleDeclaration[$type.result](', ' varibleDeclaration[$type.result])*
    ;

forinit:
    declaration | expressionList
    ;

varibleDeclaration [Type t]:
    Identifier { createVariable($Identifier.text, t); }|
    Identifier '=' expression
    {
        Variable a = createVariable($Identifier.text, t);
        Variable b = $expression.var;
        code.add(a.getId() + " = " + b.getId());
    }
    ;

expression returns [Variable var]:
    id=Identifier {Variable left = resolveVariable($id.text);}
    op=('='|'+=') r=expression1
    {
        Variable right = $r.var;
        if ($op.text.equals("+=")) {
            code.add(left.getId() + " = " + left.getId() + " + " + right.getId());
        } else {
            code.add(left.getId() + " = " + right.getId());
        }
    }
    |
    r=expression1 {$var = $r.var;}
    ;

expression1 returns [Variable var]:
    primary {$var = $primary.var;}|
    op=('-' | '!' | '~') a=expression1
    {
        Variable v = $a.var;
        code.add(v.getId() + " = " + $op.text + " " + v.getId());
        $var = v;
    }
    |
    a=expression1 op=('*' | '/' | '%') b=expression1
    {
        Variable x = $a.var;
        Variable y = $b.var;
        Variable v = createTempVariable(x.getType());
        code.add(v.getId() + " = " + x.getId() + " " + $op.text + " " + y.getId());
        $var = v;
    }
    |
    a=expression1 op=('+'|'-') b=expression1
    {
        Variable x = $a.var;
        Variable y = $b.var;
        Variable v = createTempVariable(x.getType());
        code.add(v.getId() + " = " + x.getId() + " " + $op.text + " " + y.getId());
        $var = v;
    }
    |
    a=expression1 op=('=='|'!='|'<'|'>'|'<='|'>=') b=expression1
    {
        Variable x = $a.var;
        Variable y = $b.var;
        Variable v = createTempVariable(Type.BooleanType);
        code.add(v.getId() + " = " + x.getId() + " " + $op.text + " " + y.getId());
        $var = v;
    }
    |
    a=expression1 '&&' b=expression1
    {
            Variable x = $a.var;
            Variable y = $b.var;
            Variable v = createTempVariable(Type.BooleanType);
            code.add(v.getId() + " = " + x.getId() + " && " + y.getId());
            $var = v;
     }
    |
    a=expression1 '||' b=expression1
    {
        Variable x = $a.var;
        Variable y = $b.var;
        Variable v = createTempVariable(Type.BooleanType);
        code.add(v.getId() + " = " + x.getId() + " || " + y.getId());
        $var = v;
    }
    ;

primary returns [Variable var]:
    Identifier {$var = resolveVariable($Identifier.text);}|
    '(' expression ')' {$var = $expression.var;}|
    Identifier '(' expressionList ')' {$var = callFunction($Identifier.text, $expressionList.vars); }
    |
    ioFunctions {$var = $ioFunctions.var;}|
    literal { Variable t = createTempVariable($literal.result); code.add(t.getId() + " = " + $literal.text); $var = t;}
    ;
expressionList returns [List<Variable> vars]:
    {$vars = new ArrayList<Variable>();}|{  $vars = new ArrayList<Variable>(); }
    a=expression {$vars.add($a.var);} (',' b=expression{$vars.add($b.var);})*
    ;

ioFunctions returns [Variable var]:
     'read' '('')' { $var = callFunction("read"); } |
     'write' '(' expression ')' { $var = callFunction("write", $expression.var); }
    ;
parameters returns [List<Variable> vars]:
    {$vars = new ArrayList<Variable>();}
    a=parameter {$vars.add($a.var);}
    (', 'b = parameter {$vars.add($b.var);})*
    ;
parameter returns [Variable var]:
    type Identifier {$var = new Variable($type.result, $Identifier.text);} |
    'function<' t=type '>' i=Identifier LPAREN p=parameters RPAREN
    {
        List<Type> args = new ArrayList<Type>();
        for (Variable v : $p.vars) {
            args.add(v.getType());
        }
        Type type = Type.FunctionType;
        type.returnType = $t.result;
        type.args = args;
        Variable v = new FunctionVariable($i.text, type);
        $var = v;
    }
    ;
literal returns [Type result]:
    IntegerLiteral {$result = Type.IntegerType;}|
    StringLiteral {$result = Type.StringType;}|
    BooleanLiteral {$result = Type.BooleanType;}
    ;
// White-spaces and comments
WS : [ \t\r\n] -> skip;
COMMENT : '/*' .*? '*/' -> skip;
LINE_COMMENT: '//' ~[\r\n]* -> skip;

// Separators
LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';
COMMA: ',';
SEMI: ';';

// Identifier
Identifier: [a-zA-Z$_] [a-zA-Z0-9$_]*;

IntegerLiteral: [1-9][0-9]* | '0';
StringLiteral: '"' ~["\\]* '"';
BooleanLiteral: 'true' | 'false';
