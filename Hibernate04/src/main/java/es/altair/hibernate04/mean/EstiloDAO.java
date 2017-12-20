package es.altair.hibernate04.mean;

import es.altair.hibernate03.bean.Estilo;

public interface EstiloDAO {

	public boolean insertar(Estilo e);
	public void listarEstilos();
}
