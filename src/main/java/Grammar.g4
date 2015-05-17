grammar Grammar;

type returns [Type result]:
    'int' {$result = Type.IntegerType;} |
    'string' {$result = Type.StringType;} |
    'boolean' {$result = Type.BooleanType;}
    ;

methodtype returns [Type result]:
    type {$result = $type.result;} | 
    'void' {$result = Type.VoidType;}
    ;

start: body;

body: methodDeclaration* EOF;

methodDeclaration: 
    methodtype Identifier LPAREN parameters? RPAREN block
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
    'break;' |
    'continue;'|
    'return ' expression? ';'
    ;

ifstatement:
    'if' LPAREN expression RPAREN LBRACE statement RBRACE
    ('else' LBRACE statement RBRACE )?
    ;

whilestatement:
    'while' LPAREN expression RPAREN statement
    ;

forstatement:
    'for' LPAREN forinit ';' emptyexpression ';' expressionList RPAREN
    statement
    ;

declaration:
    type varibleDeclaration(', ' varibleDeclaration)* ';'
    ;

forinit:
    declaration | expressionList
    ;

varibleDeclaration:
    Identifier |
    Identifier '=' expression;

emptyexpression:
    |
    expression
    ;

expression:
    Identifier Operators=('='|'+=') expression1 |
    expression1
    ;

expression1:
    primary |
    op=('-' | '!' | '~') expression1 |
    expression1 op=('*' | '/' | '%') expression1 |
    expression1 op=('+'|'-') expression1 |
    expression1 op=('=='|'!='|'<'|'>'|'<='|'>=') expression1 |
    expression1 '&&' expression1 |
    expression1 '||' expression1
    ;

primary:
    Identifier |
    '(' expression ')' |
    Identifier '(' expressionList ')' |
    ioFunctions |
    literal
    ;
expressionList:
    |
    expression (',' expression)*
    ;

ioFunctions:
     'read' '(' Identifier ')' |
     'write' '(' expression ')'
    ;
parameters returns [List<Variable> vars]:
    {$vars = new ArrayList<Variable>();}
    a=parameter {$vars.add($a.var);}
    (', 'b = parameter {$vars.add($b.var);})*
    ;
parameter returns [Variable var]:
    type Identifier {$var = new Variable($type.result, $Identifier.text);}
    ;
literal:
    IntegerLiteral |
    StringLiteral |
    BooleanLiteral
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
