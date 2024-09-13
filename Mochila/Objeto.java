public class Objeto {

    private int peso;
    private int valor;

    public Objeto(int peso, int valor) {
        this.peso = peso;
        this.valor = valor;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + valor;
        result = prime * result + peso;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final Objeto other = (Objeto) obj;
        if (this.peso != other.peso) {
            return false;
        }

        if (this.valor != other.valor) {
            return false;
        }

        return true;
    }

    public String toString() {
        return "Peso: " + peso + ", " + "beneficio: " + valor;
    }
}
