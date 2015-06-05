package p20150605;

import java.io.File;
import java.util.Date;

public abstract class AudioPista {

	private static final int DURACION_MAXIMA = 120;

	public abstract int ExportaAFormatoDAW(Object objeto_daw);

	protected abstract int compruebaMeta();

	public abstract void setMetaDatos(String producto, String anunciante);

	/**
	 * @param archivo Manejador del archivo que contiene el audio en formato .mp3
	 * @param duracion Duraci�n del audio en segundos
	 * @param producto Nombre del producto que se anunciar�
	 * @param anunciante Nombre de la empresa que anuncia el producto
	 */
	protected File archivo;
	protected int duracion;
	public String lasterrormsg;

	public AudioPista() {
		super();
	}

	/**
	 * M�todo que establece la duraci�n del anuncio.
	 * 
	 * @param duracion La duraci�n del anuncio
	 * @throws IllegalArgumentException Excepci�n que muestra un error si dura demasiado
	 */
	public void setDuracion(int duracion) throws IllegalArgumentException {
	    if (duracion<0)
	        duracion=0;
	    else if (duracion>DURACION_MAXIMA)
	        throw new IllegalArgumentException ("Duraci�n demasiado larga");
	    this.duracion = duracion;
	}

	/**
	 * Vincula el fichero de audio que se utilizar�.
	 * 
	 * @param nombre_archivo Nombre del archivo a utilizar
	 * @return Devuelve true si el archivo existe.
	 */
	public Boolean setArchivo(String nombre_archivo) {
	    this.archivo = new File(nombre_archivo);
	    return this.archivo.exists();
	}

	/**
	 * Pone en la cola de reproducci�n el anuncio.
	 * 
	 * Si el anuncio no est� listo, es decir, le falta algo de lo necesario
	 * no lo pondr� en cola
	 * 
	 * @param cola_reproduccion La cola de reproducci�n donde se introducir� la cu�a
	 * @param fecha TODO
	 * @return Devuelve la cola de reproducci�n con la cu�a introducida
	 */
	public int ProgramaEnCola(Object cola_reproduccion, Date fecha) {
	    // comprobamos previamente que no falte nada
	    int resultado = compruebaMeta();
	    
	    // si todo va bien, programamos
	    if (resultado==0)
	    {
	        try
	        {
	            // falta por implementar la programaci�n en la cola_reproducci�n
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

}