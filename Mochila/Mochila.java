public class Mochila {
    private int capacidadM;
    private Objeto[] objetos;
    private int peso;
    private int valor;

    public Mochila (int capacidadM, int numObjetos){
        this.capacidadM = capacidadM;
        this.objetos = new Objeto[numObjetos];
        this.peso = 0;
        this.valor = 0;
    }

    public int getCapacidadM() {
        return capacidadM;
    }

    public void setCapacidadM(int capacidadM) {
        this.capacidadM = capacidadM;
    }

    public Objeto[] getElementos() {
        return objetos;
    }

    public void setElementos(Objeto[] objetos) {
        this.objetos = objetos;
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
    
    public void addObjeto(Objeto objeto){
        addObjetoRecursivo(objeto, 0);
    }

    public void addObjetoRecursivo(Objeto objeto, int index){
        if (index >= this.objetos.length){
            return;
    }
        if(this.objetos[index]==null){
            this.objetos[index] = objeto;
            this.peso += objeto.getPeso();
            this.valor += objeto.getValor();
        }
        else{
            addObjetoRecursivo(objeto, index + 1);
        }
}
    public void clear(){
        limpiarRecursivo(0);
        this.peso = 0;
        this.valor = 0;
    }
}