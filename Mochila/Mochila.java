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

    public Objeto[] getObjetos() {
        return objetos;
    }

    public void setObjetos(Objeto[] objetos) {
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
    public void limpiar(){
        limpiarRecursivo(0);
        this.peso = 0;
        this.valor = 0;
    }
    private void limpiarRecursivo(int index){
        if (index >= this.objetos.length){
            return;
    }
    this.objetos[index] = null;
    limpiarRecursivo(index + 1);
}


    public void eliminarObjeto(Objeto objeto){
        eliminarObjetoRecursivo(objeto, 0);
    }

    private void eliminarObjetoRecursivo(Objeto objeto, int index){
        if(index >= this.objetos.length){
            return;
        }
        if(this.objetos[index] != null && this.objetos[index].equals(objeto)){
            this.objetos[index] = null;
            this.peso -= objeto.getPeso();
            this.valor -= objeto.getValor();
    }
    else{
        eliminarObjetoRecursivo(objeto, index+1);
    }
}

    public boolean existeObjeto(Objeto objeto){
        return existeObjetoRecursivo(objeto, 0);
    }

    private boolean existeObjetoRecursivo(Objeto objeto, int index){
        if(index >= this.objetos.length){
            return false;
        }
        if(this.objetos[index] != null && this.objetos[index].equals(objeto)){
            return true;
        }
        else{
            return existeObjetoRecursivo(objeto, index + 1);
        }
    }

    public String toString(){
        StringBuilder cadena = new StringBuilder();
        toStringRecursivo(0, cadena);
        cadena.append("La mejor solución es: \n");
        cadena.append("Peso: ").append(getPeso()).append("\n");
        cadena.append("Valor: ").append(getValor()).append("\n");
        return cadena.toString();
    }

    private void toStringRecursivo(int index, StringBuilder cadena){
        if(index >= this.objetos.length){
            return;
        }
        if(this.objetos[index] != null){
            cadena.append(objetos[index]).append("\n");
        }
        toStringRecursivo(index+1, cadena);
    }
}