/**************
Ruben Bautista
CS 56 (Java)
Project 3
October 4, 2021
***************/
package storeassignment;

import java.util.Objects;

public class Customer {
    
    public int id;
    public String name;
    public String address;
    
    public void setID(int cID){
        this.id = cID;
    }
    public int getID(){
        return this.id;
    }
    public void setName(String cName){
        this.name = cName;
    }
    public String getName(){
        return this.name;
    }
    public void setAddress(String cAddress){
        this.address = cAddress;
    }
    public String getAddress(){
        return this.address;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id;
        hash = 31 * hash + Objects.hashCode(this.name);
        hash = 31 * hash + Objects.hashCode(this.address);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return true;
    }
    
}