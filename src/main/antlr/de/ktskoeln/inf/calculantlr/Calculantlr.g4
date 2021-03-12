grammar Calculantlr;

/*
 * Tokens (terminal)
 */
POW: '^';
MUL: '*';
DIV: '/';
ADD: '+';
SUB: '-';
NUMBER: [0-9]+;
WHITESPACE: [ \r\n\t]+ -> skip;

expression
   : NUMBER                                # Number
   | '(' inner=expression ')'              # Parentheses
   | left=expression POW right=expression  # Power
   | left=expression MUL right=expression  # Multiplication
   | left=expression DIV right=expression  # Division
   | left=expression ADD right=expression  # Addition
   | left=expression SUB right=expression  # Subtraction
   ;