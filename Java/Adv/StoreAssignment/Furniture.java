/**************
Ruben Bautista
CS 56 (Java)
Project 3
October 4, 2021
***************/
package storeassignment;

import java.util.Objects;

public abstract class Furniture {
    
    public String name;
    public int modelNr;
    public double price;

    @Override
    public int hashCode() {
        int hash = 9;
        hash = 31 * hash + Objects.hashCode(this.name);
        hash = 31 * hash + this.modelNr;
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
        final Furniture other = (Furniture) obj;
        if (this.modelNr != other.modelNr) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    
}
