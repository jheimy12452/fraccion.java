public class Main {
    public static void main(String[] args) {
        Fraccion paraSimplificar = new Fraccion(new Fraccion(2, 4));
        System.out.println("Simplificar la fracción " + paraSimplificar + " = " + paraSimplificar.simplifica());
        Fraccion paraSlificarimp = new Fraccion(new Fraccion(1, 2));
        System.out.println("Simplificar la fracción " + paraSlificarimp + " = " + paraSlificarimp.simplifica());
    }

}
