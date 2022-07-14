package com.cts.driverms1.Service;

import com.cts.driverms1.Entity.Driverms1Entity;
import java.util.List;


public interface Driverms1Service {

    public List<Driverms1Entity> getAllDrivers();

    public Driverms1Entity addDriver(Driverms1Entity d);

    public void deleteDriver(String srNo);

    public List<String> getDriversByVehicleTypeSedan();

    public List<String> getDriversByVehicleTypeSUV();

    public List<String> getDriversByVehicleTypeVan();
}
