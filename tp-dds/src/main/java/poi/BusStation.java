package poi;

import domain.Address;
import domain.Coordinate;
import org.apache.http.client.ClientProtocolException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.IOException;

@Entity
@Table(name = "busStation")
public class BusStation extends Poi {

    public BusStation() {
    }


    @Column(name = "numberBusStation")
    private Integer numberBusStation;

    public BusStation(String name, Address address, Coordinate coordinate, Integer aNumberBusStation) {
        super(name, address, coordinate);
        numberBusStation = aNumberBusStation;
        icon = "bus";


        this.type = this.getClass().getSimpleName();
        this.getData().add(name);
        this.getData().add(numberBusStation.toString());
        // this.getData().add(address.getMainStreet());
        this.getData().add("bus");
    }

    public Integer getNumberBusStation() {
        return numberBusStation;
    }

    public void setNumberBusStation(Integer numberBusStation) {
        this.numberBusStation = numberBusStation;
    }

    @Override
    public boolean isNearby(Coordinate coordinate) throws ClientProtocolException, IOException {
        double distance = this.getGoogleService().getDistance(coordinate, this.getCoordinate());
        return distance < 100;
    }

    @Override
    public String getType() {
        return "BusStation";
    }

    @Override
    public int getNumber() {
        return this.numberBusStation;
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

}
