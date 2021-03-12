package de.ktskoeln.inf.calculantlr;

public class CalculantlrVisitorImpl extends CalculantlrBaseVisitor<Integer> implements CalculantlrVisitor<Integer> {
    @Override
    public Integer visitAddition(CalculantlrParser.AdditionContext ctx) {
        int left = visit(ctx.left);
        int right = visit(ctx.right);

        return left + right;
    }

    @Override
    public Integer visitSubtraction(CalculantlrParser.SubtractionContext ctx) {
        int left = visit(ctx.left);
        int right = visit(ctx.right);

        return left - right;
    }

    @Override
    public Integer visitMultiplication(CalculantlrParser.MultiplicationContext ctx) {
        int left = visit(ctx.left);
        int right = visit(ctx.right);

        return left * right;
    }

    @Override
    public Integer visitDivision(CalculantlrParser.DivisionContext ctx) {
        int left = visit(ctx.left);
        int right = visit(ctx.right);

        return left / right;
    }

    @Override
    public Integer visitNumber(CalculantlrParser.NumberContext ctx) {
        return Integer.parseInt(ctx.getText());
    }

    @Override
    public Integer visitParentheses(CalculantlrParser.ParenthesesContext ctx) {
        return visit(ctx.inner);
    }

    @Override
    public Integer visitPower(CalculantlrParser.PowerContext ctx) {
        int left = visit(ctx.left);
        int right = visit(ctx.right);

        return (int) Math.pow(left, right);
    }
}
