package p20150605;


/**
 * Clase destinada a gestionar cuñas publicitarias
 * 
 * 
 * @author Sergio Padilla
 * @version 1.0.1
 */
public class AudioAnuncio extends AudioPista
{
	
	private String producto;    // nombre del producto anunciado
    private String anunciante;  // nombre de la empresa anunciante
    
    public AudioAnuncio ()
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
    @Override
	public void setMetaDatos (String producto, String anunciante)
    {
        this.producto = producto;
        this.anunciante = anunciante;
    }
    
    @Override
	protected int compruebaMeta() {
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
    @Override
	public int ExportaAFormatoDAW(Object objeto_daw)
    {
        int resultado = compruebaMeta();
        
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
