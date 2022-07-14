package com.cts.driverms1.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="DRIVERMS1ENTITY")
public class Driverms1Entity {
    
        @Id 
        //@GeneratedValue
	private String licensenumber;
	private String name;
        private int age;
	private String vehicletype;

    public String getLicensenumber() {
        return licensenumber;
    }

    public void setLicensenumber(String licensenumber) {
        this.licensenumber = licensenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getVehicletype() {
        return vehicletype;
    }

    public void setVehicletype(String vehicletype) {
        this.vehicletype = vehicletype;
    }

   
	
}

   