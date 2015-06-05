package p20150605;

import java.io.File;

/**
 * Clase destinada a gestionar cuñas publicitarias
 * 
 * 
 * @author Sergio Padilla
 * @version 1.0.1
 */
public class AudioSpot
{
	
	/**
	 * @param archivo Manejador del archivo que contiene el audio en formato .mp3
	 * @param duracion Duración del audio en segundos
	 * @param producto Nombre del producto que se anunciará
	 * @param anunciante Nombre de la empresa que anuncia el producto
	 */
    private File archivo;       // manejador para el archivo que contiene el audio (.mp3)
    private int duracion;       // duración del audio, en segundos
    private String producto;    // nombre del producto anunciado
    private String anunciante;  // nombre de la empresa anunciante
    
    public String lasterrormsg;
    
    public AudioSpot ()
    {
        this.archivo = null;
        this.duracion = 0;
        this.producto = "";
        this.anunciante = "";
        this.lasterrormsg = "";
    }
    
    /**
     * Método que establece los metadatos del anuncio.
     * 
     * @param producto Nombre del producto sobre el que se realiza el anuncio
     * @param anunciante Nombre del anunciante que realiza el anuncio
     */
    public void setMetaDatos (String producto, String anunciante)
    {
        this.producto = producto;
        this.anunciante = anunciante;
    }
    
    /**
     * Método que establece la duración del anuncio.
     * 
     * @param duracion La duración del anuncio
     * @throws IllegalArgumentException Excepción que muestra un error si dura demasiado
     */
    public void setDuracion(int duracion) throws IllegalArgumentException
    {
        if (duracion<0)
            duracion=0;
        else if (duracion>120)
            throw new IllegalArgumentException ("Duración demasiado larga");
        this.duracion = duracion;
    }
    
    /**
     * Vincula el fichero de audio que se utilizará.
     * 
     * @param nombre_archivo Nombre del archivo a utilizar
     * @return Devuelve true si el archivo existe.
     */
    public Boolean setArchivo(String nombre_archivo)
    {
        this.archivo = new File(nombre_archivo);
        return this.archivo.exists();
    }
    
    /**
     * Pone en la cola de reproducción el anuncio.
     * 
     * Si el anuncio no está listo, es decir, le falta algo de lo necesario
     * no lo pondrá en cola
     * 
     * @param cola_reproduccion La cola de reproducción donde se introducirá la cuña
     * @return Devuelve la cola de reproducción con la cuña introducida
     */
    public int ProgramaEnCola(Object cola_reproduccion)
    {
        // comprobamos previamente que no falte nada
        int resultado = 0;
        if (this.duracion==0)
        {
            lasterrormsg = "No se ha establecido duración alguna.";
            resultado = -1;
        }
        else if (this.producto.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre del producto anunciado.";
            resultado = -2;
        }
        else if (this.anunciante.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre de la empresa anunciante.";
            resultado = -3;
        }
        else if (this.archivo==null)
        {
            lasterrormsg = "No se ha establecido el archivo de audio.";
            resultado = -4;
        }
        
        // si todo va bien, programamos
        if (resultado==0)
        {
            try
            {
                // falta por implementar la programación en la cola_reproducción
                lasterrormsg = "";
                return this.duracion;
            }
            catch (Exception ex)
            {
                lasterrormsg = ex.getMessage();
                return -5;
            }     
        }
        else
            return resultado;
    }
    
    /**
     * Exporta el archivo a formato DAW.
     * 
     * Solo se exportará si el archivo contiene todos los metadatos
     * 
     * @param objeto_daw El objeto formato DAW que se obtendrá
     * @return Dato a exportar
     */
    public int ExportaAFormatoDAW(Object objeto_daw)
    {
        // comprobamos previamente que no falte nada
        int resultado = 0;
        if (this.duracion==0)
        {
            lasterrormsg = "No se ha establecido duración alguna.";
            resultado = -1;
        }
        else if (this.producto.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre del producto anunciado.";
            resultado = -2;
        }
        else if (this.anunciante.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre de la empresa anunciante.";
            resultado = -3;
        }
        else if (this.archivo==null)
        {
            lasterrormsg = "No se ha establecido el archivo de audio.";
            resultado = -4;
        }
        
        // si todo va bien, exportamos
        if (resultado==0)
        {
            try
            {
                // falta por implementar la exportación del audio
                lasterrormsg = "";
                return 0;
            }
            catch (Exception ex)
            {
                lasterrormsg = ex.getMessage();
                return -5;
            }
        }
        else
            return resultado;
    }
    
}
