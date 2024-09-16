public class Prueba{

    public static void main(String[] args) {
        Objeto[] objetos = {
            new Objeto(12, 4),
            new Objeto(1, 2),
            new Objeto(4, 10),  // (peso,beneficio)
            new Objeto(1, 1),
            new Objeto(2, 2)
        };
 
        Mochila m_base = new Mochila(15, objetos.length);
        Mochila m_opt = new Mochila(15, objetos.length);
 
        llenarMochila(m_base, objetos, false, m_opt, 0);
 
        System.out.println(m_opt);
    }
    
    public static void llenarMochila(Mochila m_base, Objeto[] objetos, boolean llena, Mochila m_opt, int indice){
        //si está llena
        if (llena){
            //compruebo si tiene más beneficio que otra
            if (m_base.getValor() > m_opt.getValor()){
                Objeto[] objetosMochBase = m_base.getObjetos();
                m_opt.limpiar();
 
                //metemos los objetos
                aniadirObjetosRecursivo(m_opt, objetosMochBase, 0);
            }
        }
        else{
            //Recorre los objetos de forma recursiva
            if (indice < objetos.length){
                //si existe el objeto
                if (!m_base.existeObjeto(objetos[indice])){
                    //Si el peso de la mochila se supera, indicamos que está llena
                    if (m_base.getCapacidadM() > m_base.getPeso() + objetos[indice].getPeso()){
                        m_base.addObjeto(objetos[indice]); //añadimos
                        llenarMochila(m_base, objetos, false, m_opt, indice + 1);
                        m_base.eliminarObjeto(objetos[indice]); // lo eliminamos
                    }
                    else{
                        llenarMochila(m_base, objetos, true, m_opt, indice + 1);
                    }
                }
                // Llamada recursiva para avanzar en el array de objetos
                llenarMochila(m_base, objetos, llena, m_opt, indice + 1);
            }
        }
    }
    
    // Método auxiliar para añadir objetos de forma recursiva
    public static void aniadirObjetosRecursivo(Mochila m_opt, Objeto[] objetos, int indice){
        if (indice < objetos.length){
            if (objetos[indice] != null){
                m_opt.addObjeto(objetos[indice]);
            }
            aniadirObjetosRecursivo(m_opt, objetos, indice + 1);
        }
    }
}
