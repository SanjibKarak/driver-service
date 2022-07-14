/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cts.driverms1.Service;

import com.cts.driverms1.Entity.Driverms1Entity;
import com.cts.driverms1.Repo.Driverms1Repo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aakash
 */
@Service
@Transactional
public class Driverms1ServiceImplementation implements Driverms1Service{

    @Autowired
    private Driverms1Repo driverms1Repo;

    @Override
    public List<Driverms1Entity> getAllDrivers() {
        List<Driverms1Entity> list;
        list = (List<Driverms1Entity>) driverms1Repo.findAll();
        return list;

    }

    @Override
    public List<String> getDriversByVehicleTypeSedan() {

        List<String> sedan = driverms1Repo.findDriversByVehicleTypeSedan();
        return sedan;
    }
    
    @Override
    public List<String> getDriversByVehicleTypeSUV() {

        List<String> suv = driverms1Repo.findDriversByVehicleTypeSedan();
        return suv;
    }
    
    @Override
    public List<String> getDriversByVehicleTypeVan() {

        List<String> van = driverms1Repo.findDriversByVehicleTypeSedan();
        return van;
    }

    @Override
    public Driverms1Entity addDriver(Driverms1Entity d) {
        // list.add(d);
        Driverms1Entity result = driverms1Repo.save(d);
        return result;
    }

    @Override
    @Modifying
    public void deleteDriver(String srNo) {
        driverms1Repo.deleteById(srNo);

    }

}