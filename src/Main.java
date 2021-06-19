import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Lexer lexer = new Lexer();
        LinkedList<Token> tokens = lexer.lex("a = 10; b = 7; x = 6; y = 9; l new List; l.add(18); l.add(6-9); l.add(666); s new Set; s.add(6); s.add(9); x = l.get(1); if(y < 5){y = y + 1;}  while (a > b) {a = 0;}");
        Poliz.setTokens(tokens);
        System.out.println("\n"+"Tokens:");
        for (int i = 0; i < tokens.size(); i++)
        {
            System.out.println("[" + tokens.get(i) + "]");
        }
        Parser parser = new Parser();
        try {
            parser.createAST(new ArrayList<>(tokens));
            parser.CheckTokens();
            parser.print();
        }catch (Exception ex)
        { System.err.println(ex);
            System.exit(1);
        }

        int j = 0;
        for (Token token : Poliz.poliz) {
            System.out.println(j + " " + "[" + token +  "]");
            j++;
        }

        System.out.println("\n"+"Variable table:");
        CalcPoliz.calculate(Poliz.poliz);
    }
}