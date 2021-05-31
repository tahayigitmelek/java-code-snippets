import java.io.PrintStream;

class Print {

    public static void main(String[] args) throws Exception {

        System.class.getField("out").getType()
                    .getMethod("println", String.class)
                    .invoke(new PrintStream(System.err), "Hello World!");

        System.class.getField("out").getType()
                    .getMethod("println", String.class)
                    .invoke(new PrintStream(System.out), "Hello World!");
    
    }
}