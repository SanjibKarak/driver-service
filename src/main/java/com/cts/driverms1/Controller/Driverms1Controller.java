package com.cts.driverms1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.driverms1.Entity.Driverms1Entity;
import com.cts.driverms1.Entity.JwtResponse;
import com.cts.driverms1.Exception.TokenValidationFailedException;
import com.cts.driverms1.Feign.Driverms1Feign;
import com.cts.driverms1.Repo.Driverms1Repo;
import com.cts.driverms1.Service.Driverms1ServiceImplementation;

@RestController
@CrossOrigin("*")
public class Driverms1Controller {

    @Autowired
    private Driverms1ServiceImplementation dms;
    @Autowired
    private Driverms1Repo repo;
    @Autowired
    private Driverms1Feign driverms1Feign;

    @GetMapping("/Drivers")
    public ResponseEntity<List<Driverms1Entity>> getDrivers(
            @RequestHeader(name = "authorization" , required = true) String token){
            JwtResponse jwtResponse = driverms1Feign.verifyToken(token);
            List<Driverms1Entity> list = dms.getAllDrivers();
            
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            
        }
        try{
            if(jwtResponse.isValid()) {
                return ResponseEntity.status(HttpStatus.CREATED).body(list);
            }
        } catch (Exception e){
            // TODO: handle exception
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    @GetMapping("/DriversByVehicleType/{vehicleType}")
    public ResponseEntity<List<String>> getDriver(
            @RequestHeader(name= "authorization", required = true) String token,
            @PathVariable("vehicleType")String vehicleType) {
        JwtResponse jwtResponse = driverms1Feign.verifyToken(token);
        
        List<String> list =null;
        try{
            if(jwtResponse.isValid()) {
            
            if (vehicleType.equals("Sedan")) {
            list = dms.getDriversByVehicleTypeSedan();

        } else if (vehicleType.equals("SUV")) {
            list = dms.getDriversByVehicleTypeSedan();

        } else if (vehicleType.equals("Van")) {
            list = dms.getDriversByVehicleTypeSedan();
        }

        if (list == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().body(list);
            }

    } catch (TokenValidationFailedException t) {
			// TODO: handle exception
			throw new TokenValidationFailedException("token expired");
		}
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/AddDriver")
    public ResponseEntity<Driverms1Entity> addDriver(
            @RequestHeader(name="authorization" ,required = true) String token, @RequestBody Driverms1Entity driverms1Entity) {
        JwtResponse jwtResponse = driverms1Feign.verifyToken(token);
        try {
                 if(jwtResponse.isValid()){
                	 repo.save(driverms1Entity);
                	 //d = (Driverms1Entity) dms.addDriver(d);
                                 //System.out.println(driverms1Entity);
                                 return ResponseEntity.status(HttpStatus.CREATED).build();
                      }
        } catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
         return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @DeleteMapping("/deleteDriver/{licenseNumber}")
    public ResponseEntity<Void> deleteDriver(
            @RequestHeader(name = "authorization", required = true) String token,
            @PathVariable("licenseNumber")String licenseNumber) {
        JwtResponse jwtResponse = driverms1Feign.verifyToken(token);
        try {
            if (jwtResponse.isValid()) {
            dms.deleteDriver(licenseNumber);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        } catch (Exception e) {
            // TODO: handle exception

            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		// dms.deleteDriver(licenseNumber);
	}



    

}
