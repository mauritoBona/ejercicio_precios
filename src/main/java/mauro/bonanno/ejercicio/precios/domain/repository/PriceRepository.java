package mauro.bonanno.ejercicio.precios.domain.repository;

import mauro.bonanno.ejercicio.precios.domain.model.Prices;
import mauro.bonanno.ejercicio.precios.domain.model.PricesID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Prices, PricesID> {

}
