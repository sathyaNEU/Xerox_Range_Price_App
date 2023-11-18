/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.Supplier;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class SupplierDirectory {
    ArrayList<Supplier> supplierList;

    public SupplierDirectory(){
        supplierList = new ArrayList();
    }
    public Supplier newSupplier(String n){
        Supplier supplier = new Supplier(n);
        supplierList.add(supplier);
        return supplier;

    }
    public Supplier findSupplier(String id){
        
        for (Supplier supplier: supplierList){
            
            if(supplier.getName().equals(id)) return supplier;
        }
        return null;
        }
    public ArrayList<Supplier> getSuplierList(){
        return supplierList;
    }
    
}