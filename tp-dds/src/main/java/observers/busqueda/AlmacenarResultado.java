package observers.busqueda;

import internalService.ReportService;
import org.apache.commons.lang3.StringUtils;
import java.util.List;

public class AlmacenarResultado implements ObserverBusqueda {
	
	private ReportService reportService=ReportService.getInstance();




	@Override
	public void update(List<String> palabraBuscada, String nombreTerminal, int cantPoisBusqueda, int segundosQueTardo) {
		reportService.addReporte(nombreTerminal, StringUtils.join(palabraBuscada,","), cantPoisBusqueda);
	}

}
