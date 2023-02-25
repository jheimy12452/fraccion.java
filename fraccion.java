# fraccion.java
import java.util.Objects;

public class Fraccion {
        private int numerador, denominador;

        // Constructores

        public Fraccion() {
            this.numerador = 1;
            this.denominador = 1;
        }

        public Fraccion(int numerador) {
            this.numerador = numerador;
            this.denominador = 1;
        }

        public Fraccion(int numerador, int denominador) {
            this.numerador = numerador;
            // Llamar al setter para que se haga la validación del denominador
            this.setDenominador(denominador);
        }

        public Fraccion(Fraccion f) {
            this.numerador = f.getNumerador();
            this.denominador = f.getDenominador();
        }
        // Getters y setters

        public int getNumerador() {
            return this.numerador;
        }

        public int getDenominador() {
            return this.denominador;
        }

        public void setNumerador(int numerador) {
            this.numerador = numerador;
        }

        public void setDenominador(int denominador) {
            if (denominador == 0) {
                throw new IllegalArgumentException("Denominador debe ser distinto de 0");
            }
            this.denominador = denominador;
        }

        // Métodos ayudantes

        private int mcm(int a, int b) {
            return (a * b) / this.maximoComunDivisor(a, b);
        }

        public int maximoComunDivisor(int a, int b) {
            int temporal;//Para no perder b
            while (b != 0) {
                temporal = b;
                b = a % b;
                a = temporal;
            }
            return a;
        }

        // Métodos principales
        public Fraccion suma(Fraccion otra) {
            int mcm = this.mcm(this.getDenominador(), otra.getDenominador());
            int diferenciaFraccionActual = mcm / this.getDenominador();
            int diferenciaOtraFraccion = mcm / otra.getDenominador();
            Fraccion resultado = new Fraccion();
            resultado.setNumerador(
                    (diferenciaFraccionActual * this.getNumerador()) + (diferenciaOtraFraccion * otra.getNumerador()));
            resultado.setDenominador(mcm);
            return resultado;
        }


        public Fraccion producto(Fraccion otra) {
            return new Fraccion(this.getNumerador() * otra.getNumerador(), this.getDenominador() * otra.getDenominador());
        }

        public Fraccion cociente(Fraccion otra) {
            return new Fraccion(this.getNumerador() * otra.getDenominador(), this.getDenominador() * otra.getNumerador());
        }

        public Fraccion inversa() {
            return new Fraccion(this.getDenominador(), this.getNumerador());
        }

        public Fraccion potencia(int exponente) {
            return new Fraccion((int) Math.pow(this.getNumerador(), exponente), (int) Math.pow(this.getDenominador(), exponente));
        }

        public Fraccion simplifica() {
            int mcd = this.maximoComunDivisor(this.getNumerador(), this.getDenominador());
            return new Fraccion(this.getNumerador() / mcd, this.getDenominador() / mcd);
        }

        // Heredados
        @Override
        public String toString() {
            return String.valueOf(this.getNumerador()).concat("/").concat(String.valueOf(this.getDenominador()));
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Fraccion fraccion = (Fraccion) o;
            return numerador == fraccion.numerador && denominador == fraccion.denominador;
        }

        @Override
        public int hashCode() {
            return Objects.hash(numerador, denominador);
        }
    }





