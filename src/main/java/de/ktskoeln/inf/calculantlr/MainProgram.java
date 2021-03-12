package de.ktskoeln.inf.calculantlr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class MainProgram {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to CalculANTLR! " +
                "Please enter a simple mathematical expression followed by CTRL+D");

        CharStream input = CharStreams.fromStream(System.in);
        System.out.println("You entered: " + input.toString().trim());

        CalculantlrLexer lexer = new CalculantlrLexer(input);
        TokenStream tokens = new CommonTokenStream(lexer);
        CalculantlrParser parser = new CalculantlrParser(tokens);

        ParseTree tree = parser.expression();

        CalculantlrVisitor<Integer> calculator = new CalculantlrVisitorImpl();
        Number evaluationResult = calculator.visit(tree);

        System.out.println("The result is: " + evaluationResult);
    }
}
