
/**
 * Write a description of class MiHashMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiHashMap
{
    private String[] keys;
    private int[] values;

    /**
     * Constructor de la clase MiHashMap
     */
    public MiHashMap(){
        keys = new String[0];
        values = new int[0];
    }

    /**
     * Asocia el valor especificado con la clave especificada. Si la clave existía, 
     * entonces sobreescribe su valor y devuelve el valor antiguo. Si no existía devuelve -1.
     */
    public int put(String clave, int valor){
        int antiguo = -1;

        String[] aString2 = keys;
        int[] aInt2 = values;
        keys = new String[aString2.length + 1];
        values = new int[aInt2.length + 1];
        boolean contieneClave = false;
        int index = 0;
        for (int count = 0; count < aString2.length; count++)
        {
            index = count;
            if(clave.equals(aString2[count])){
                contieneClave = true;
                antiguo = aInt2[count];
            }
            else{
                keys[count] = aString2[count];
                values[count] = aInt2[count];
            }
        }
        if(contieneClave == false){
            keys[aString2.length] = clave;
            values[aInt2.length] = valor;
        }
        else{
            keys = new String[keys.length - 1];
            values = new int[values.length - 1];
            for (int count = 0; count < aString2.length; count++)
            {
                keys[count] = aString2[count];
                values[count] = aInt2[count];
            }
            keys[index] = clave;
            values[index] = valor;
        }

        return antiguo;
    }
    
    /**
     * Devuelve el valor asociado con la clave especificada o -1 en caso de que la clave no exista.
     */
    public int get(String clave){
        int value = -1;
        int index = 0;
        boolean encontrado = false;
        while (!encontrado && index < keys.length){
            if(clave.equals(keys[index])){
             encontrado = true;
             value = values[index];
            }
            else{
                index++;
            }
        }
        return value;
    }
    
    /**
     * devuelve true si el mapa no contiene elementos.
     */
    public boolean isEmpty(){
        return keys.length == 0;
    }
    
        /**
     * devuelve el número de elementos del mapa.
     */
    public int size(){
        return keys.length;
    }
    

    
}

