package com.cts.driverms1.Repo;

import com.cts.driverms1.Entity.Driverms1Entity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Driverms1Repo extends CrudRepository<Driverms1Entity, String> {

    @Query("SELECT name FROM Driverms1Entity WHERE vehicletype = 'Sedan'")
    public List<String> findDriversByVehicleTypeSedan();
    
     @Query("SELECT name FROM Driverms1Entity WHERE vehicletype = 'Sedan' OR vehicletype='SUV'")
    public List<String> findDriversByVehicleTypeSUV();
    
     @Query("SELECT name FROM Driverms1Entity")
    public List<String> findDriversByVehicleTypeVan();

    //@Override
    //public com.cts.driverms1.Entity.Driverms1Entity save(com.cts.driverms1.Entity.Driverms1Entity d);
}
