/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Do not execute this Program anywhere in the application

package UserInterface.Main;

import MarketingManagement.MarketingPersonDirectory;
import MarketingManagement.MarketingPersonProfile;
import TheBusiness.Business.Business;
import TheBusiness.ConfigureBusiness;
import TheBusiness.CustomerManagement.CustomerDirectory;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.MarketModel.Channel;
import TheBusiness.MarketModel.ChannelCatalog;
import TheBusiness.MarketModel.Market;
import TheBusiness.MarketModel.MarketCatalog;
import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.MarketModel.MarketChannelComboCatalog;
import TheBusiness.MarketModel.SolutionOffer;
import TheBusiness.MarketModel.SolutionOfferCatalog;
import TheBusiness.OrderManagement.MasterOrderList;
import TheBusiness.OrderManagement.Order;
import TheBusiness.OrderManagement.OrderItem;
import TheBusiness.Personnel.Person;
import TheBusiness.Personnel.PersonDirectory;
import TheBusiness.ProductManagement.Product;
import TheBusiness.ProductManagement.ProductCatalog;
import TheBusiness.ProductManagement.ProductSummary;
import TheBusiness.SalesManagement.SalesPersonDirectory;
import TheBusiness.SalesManagement.SalesPersonProfile;
import TheBusiness.SolutionOrders.MasterSolutionOrderList;
import TheBusiness.SolutionOrders.SolutionOrder;
import TheBusiness.Supplier.Supplier;
import TheBusiness.Supplier.SupplierDirectory;
import TheBusiness.UserAccountManagement.UserAccount;
import TheBusiness.UserAccountManagement.UserAccountDirectory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kal bugrara
 */
class ConfigureABusiness {

    public static Business initialize() {
 Business business = new Business("Xerox");

// Create Persons
        PersonDirectory persondirectory = business.getPersonDirectory();
        CustomerDirectory customerdirectory = business.getCustomerDirectory();
        SalesPersonDirectory salespersondirectory = business.getSalesPersonDirectory();
        MarketingPersonDirectory marketingpersondirectory = business.getMarketingPersonDirectory();
        SupplierDirectory suplierdirectory = business.getSupplierDirectory();


        
// person representing sales organization        
        Person xeroxsalesperson001 = persondirectory.newPerson("Xerox sales");
        Person xeroxmarketingperson001 = persondirectory.newPerson("Xerox marketing");
        Person xeroxadminperson001 = persondirectory.newPerson("Xerox admin");

// Create person objects to represent customer organizations. 
        String file_path="src//ALL_CSV//CUSTOMERS.csv";
        BufferedReader file_content = null;
        String currentLine="";
        try{
            file_content = new BufferedReader(new FileReader(file_path));
            while((currentLine = file_content.readLine())!=null){
                String[] split_str = currentLine.split(",");
                for(String split_str_index : split_str){
                    Person customer_person = persondirectory.newPerson(split_str_index);
                    customerdirectory.newCustomerProfile(customer_person);
                    System.out.println("Person created : "+persondirectory.findPerson(split_str_index).getPersonId());
                    System.out.println("Profile created : "+customerdirectory.findCustomer(split_str_index));
                    System.out.println("");
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                file_content.close();
            } catch (IOException ex) {
                Logger.getLogger(ConfigureBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                
        
       
//        Person person005 = persondirectory.newPerson("Dell");
//        Person person006 = persondirectory.newPerson("Microsoft");
//        Person person007 = persondirectory.newPerson("Google");
//        Person person008 = persondirectory.newPerson("JP Morgan");
//        Person person009 = persondirectory.newPerson("State street"); //we use this as customer

// Create Customers
//        CustomerProfile customerprofile1 = customedirectory.newCustomerProfile(person005);
//        CustomerProfile customerprofile2 = customedirectory.newCustomerProfile(person006);
//        CustomerProfile customerprofile3 = customedirectory.newCustomerProfile(person007);
//        CustomerProfile customerprofile4 = customedirectory.newCustomerProfile(person008);
//        CustomerProfile customerprofile5 = customedirectory.newCustomerProfile(person009);

// Create Sales people
        SalesPersonProfile salespersonprofile = salespersondirectory.newSalesPersonProfile(xeroxsalesperson001);

// Create Marketing people
        MarketingPersonProfile marketingpersonprofile0 = marketingpersondirectory.newMarketingPersonProfile(xeroxmarketingperson001);

// Create Admins to manage the business
//        EmployeeDirectory employeedirectory = business.getEmployeeDirectory();
//        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(xeroxadminperson001);

        Supplier supplier1 = suplierdirectory.newSupplier("Lenovo");
        ProductCatalog productcatalog = supplier1.getProductCatalog();
        file_path = "src//ALL_CSV//LENEVO_products.csv";
        currentLine="";
        String n;
        int fp; 
        int cp; 
        int tp;
        try{
            file_content = new BufferedReader(new FileReader(file_path));
            while((currentLine=file_content.readLine())!=null){
                String[] split_str = currentLine.split(",");
                n=split_str[0];
                fp=Integer.parseInt(split_str[1]);
                cp=Integer.parseInt(split_str[2]);
                tp=Integer.parseInt(split_str[3]);
                productcatalog.newProduct(n, fp, cp, tp);
                System.out.println(productcatalog.findProductByProductName(n)+" <-> "+supplier1.getName());
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                file_content.close();
            } catch (IOException ex) {
                Logger.getLogger(ConfigureBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        Product products1p1 = productcatalog.newProduct("Scanner 3  1", 2000, 16500, 10000);
//        Product products1p2 = productcatalog.newProduct("Scanner 4", 10000, 25000, 16500);
//        Product products1p3 = productcatalog.newProduct("Printer 2", 22000, 40000, 36500);
//        Product products1p4 = productcatalog.newProduct("Photocopier 2 ", 30000, 70000, 50000);
//        Product products1p5 = productcatalog.newProduct("Scanner  5", 19000, 36500, 25000);
//        Product products1p6 = productcatalog.newProduct("Scanner 6", 90000, 125000, 105000);
//        Product products1p7 = productcatalog.newProduct("Printer 3", 22000, 60000, 36500);
//        Product products1p8 = productcatalog.newProduct("Photocopier 3", 30000, 70000, 50000);

        //       SupplierDirectory suplierdirectory = business.getSupplierDirectory();
        
        System.out.println("");
        
        Supplier supplier2 = suplierdirectory.newSupplier("Epson");
        productcatalog = supplier2.getProductCatalog();
        file_path = "src//ALL_CSV//EPSON_products.csv";
        currentLine="";
        try{
            file_content = new BufferedReader(new FileReader(file_path));
            while((currentLine=file_content.readLine())!=null){
                String[] split_str = currentLine.split(",");
                n=split_str[0];
                fp=Integer.parseInt(split_str[1]);
                cp=Integer.parseInt(split_str[2]);
                tp=Integer.parseInt(split_str[3]);
                productcatalog.newProduct(n, fp, cp, tp);
                System.out.println(productcatalog.findProductByProductName(n)+" <-> "+supplier2.getName());
            }         
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                file_content.close();
            } catch (IOException ex) {
                Logger.getLogger(ConfigureBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        Product products2p1 = productcatalog.newProduct("Scanner 13  1", 12000, 26000, 18500);
//        Product products2p2 = productcatalog.newProduct("Scanner 14", 90000, 165000, 125000);
//        Product products2p3 = productcatalog.newProduct("Color Printer 112", 422000, 540000, 495000);
//        Product products2p4 = productcatalog.newProduct("Photocopier 922 ", 430000, 890000, 550000);
//        Product products2p5 = productcatalog.newProduct("Low toner Scanner  102", 195000, 500100, 365102);
//        Product products2p6 = productcatalog.newProduct("Speedy color Scanner 611", 900000, 125000, 1650000);
//        Product products2p7 = productcatalog.newProduct("Premier Printer 300", 322000, 470000, 736500);
//        Product products2p8 = productcatalog.newProduct("Color Photocopier 500", 350000, 580000, 780000);

// Create User accounts that link to specific profiles
        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        UserAccount ua1 = uadirectory.newUserAccount(salespersonprofile, "Sales", "XXXX"); /// order products for one of the customers and performed by a sales person
        UserAccount ua2 = uadirectory.newUserAccount(marketingpersonprofile0, "Marketing", "XXXX"); /// order products for one of the customers and performed by a sales person
//        UserAccount ua3 = uadirectory.newUserAccount(employeeprofile0, "Admin", "XXXX"); /// order products for one of the customers and performed by a sales person

// Process Orders on behalf of sales person and customer
        MasterOrderList masterorderlist = business.getMasterOrderList();
        CustomerProfile customerprofile4 = customerdirectory.findCustomer("Google");
        Order order1 = masterorderlist.newOrder(customerprofile4, salespersonprofile);
        file_path="src//ALL_CSV//order1.csv";
        Product p = null;
        currentLine="";
        int paidprice;
        int q;      
        try{
            file_content = new BufferedReader(new FileReader(file_path));
            while((currentLine=file_content.readLine())!=null){
                String[] spl_str = currentLine.split(",");
                String prod_name = spl_str[0];
                paidprice = Integer.parseInt(spl_str[1]);
                q = Integer.parseInt(spl_str[2]);
                p = getProductFromProductName(suplierdirectory, prod_name);
            if(p!=null)
                order1.newOrderItem(p, paidprice, q);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                file_content.close();
            } catch (IOException ex) {
                Logger.getLogger(ConfigureBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        OrderItem oi1 = order1.newOrderItem(products1p1, 18000, 1);
//        OrderItem oi2 = order1.newOrderItem(products1p2, 19500, 4);
//        OrderItem oi3 = order1.newOrderItem(products1p3, 36500, 10);
//        OrderItem oi4 = order1.newOrderItem(products1p4, 50000, 1);
//        OrderItem oi5 = order1.newOrderItem(products1p5, 25000, 3);
//        OrderItem oi6 = order1.newOrderItem(products1p6, 105000, 2);
//        OrderItem oi7 = order1.newOrderItem(products1p7, 36500, 3);
//        OrderItem oi8 = order1.newOrderItem(products1p8, 50000, 2);

       Order order12 = masterorderlist.newOrder(customerprofile4, salespersonprofile);
       file_path="src//ALL_CSV//order2.csv";
       p = null;
       currentLine="";     
       try{
            file_content = new BufferedReader(new FileReader(file_path));
            while((currentLine=file_content.readLine())!=null){
                String[] spl_str = currentLine.split(",");
                String prod_name = spl_str[0];
                paidprice = Integer.parseInt(spl_str[1]);
                q = Integer.parseInt(spl_str[2]);
                p = getProductFromProductName(suplierdirectory, prod_name);
            if(p!=null)
                order12.newOrderItem(p, paidprice, q);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                file_content.close();
            } catch (IOException ex) {
                Logger.getLogger(ConfigureBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        OrderItem oi112 = order1.newOrderItem(products1p1, 17000, 1);
//        OrderItem oi12 = order1.newOrderItem(products1p2, 9500, 4);
//        OrderItem oi13 = order1.newOrderItem(products1p3, 29500, 10);
//        OrderItem oi14 = order1.newOrderItem(products1p4, 30000, 1);
//        OrderItem oi15 = order1.newOrderItem(products1p5, 2000, 3);
//        OrderItem oi16 = order1.newOrderItem(products1p6, 95000, 2);
//        OrderItem oi17 = order1.newOrderItem(products1p7, 26500, 3);
//        OrderItem oi18 = order1.newOrderItem(products1p8, 40000, 2);

        Order order13 = masterorderlist.newOrder(customerprofile4, salespersonprofile);
        file_path="src//ALL_CSV//order3.csv";
        p = null;
        currentLine="";     
        try{
            file_content = new BufferedReader(new FileReader(file_path));
            while((currentLine=file_content.readLine())!=null){
                String[] spl_str = currentLine.split(",");
                String prod_name = spl_str[0];
                paidprice = Integer.parseInt(spl_str[1]);
                q = Integer.parseInt(spl_str[2]);
                p = getProductFromProductName(suplierdirectory, prod_name);
            if(p!=null)
                order13.newOrderItem(p, paidprice, q);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                file_content.close();
            } catch (IOException ex) {
                Logger.getLogger(ConfigureBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        oi112 = order13.newOrderItem(products1p1, 19000, 1);
//        oi12 = order13.newOrderItem(products1p2, 10500, 4);
//        oi13 = order13.newOrderItem(products1p3, 20500, 10);
//        oi14 = order13.newOrderItem(products1p4, 40000, 1);
//        oi15 = order13.newOrderItem(products1p5, 4000, 3);
//        oi16 = order13.newOrderItem(products1p6, 105000, 2);
//        oi17 = order13.newOrderItem(products1p7, 36500, 3);
//        oi18 = order13.newOrderItem(products1p8, 550000, 1);

        Product prod_summ = getProductFromProductName(suplierdirectory, "Photocopier 3");

        ProductSummary ps = new ProductSummary(prod_summ);

        System.out.println("Stats==========================");
        System.out.println("Sales Volume:  " + ps.getSalesRevenues());
        System.out.println("Profit Margin:  " + ps.getProductPricePerformance());
        System.out.println("Frequency above target:  " + ps.getNumberAboveTarget());
        System.out.println("Frequency Below:  " + ps.getNumberBelowTarget());
//===============================

        MarketCatalog mc = business.getMarketCatalog();
        ChannelCatalog channelCatalog = business.getChannelCatalog();
        MarketChannelComboCatalog mccc = business.getMarketChannelComboCatalog();
        
        //=============== Define markets and channels...

        Market teenmarket = mc.newMarket("Teenagers");
        Market teenmarket2 = mc.newMarket("College Grads");
        Market teenmarket3 = mc.newMarket("Millennial");
        Market teenmarket4 = mc.newMarket("Seniors");
        Market teenmarket5 = mc.newMarket("Z Generation");

        Channel tvchannel = channelCatalog.newChannel("TV");
        Channel webchannel = channelCatalog.newChannel("Internet");
         Channel mobilechannel = channelCatalog.newChannel("Mobile App");
        Channel radiochannel = channelCatalog.newChannel("Radio");

        teenmarket.addValidChannel(webchannel);
        teenmarket.addValidChannel(tvchannel);


        MarketChannelAssignment tvchannelteenmarket = mccc.newMarketChannelCombo(teenmarket, tvchannel);
        MarketChannelAssignment webchannelteenmarket = mccc.newMarketChannelCombo(teenmarket, webchannel);

        SolutionOfferCatalog solutionoffercatalog = business.getSolutionOfferCatalog();

        SolutionOffer solutiontvteen = solutionoffercatalog.newSolutionOffer(tvchannelteenmarket);
        
        Product products2p1 = getProductFromProductName(suplierdirectory, "Scanner 13  1");
        Product products2p2 = getProductFromProductName(suplierdirectory, "Scanner 14");
        
        solutiontvteen.addProduct(products2p2);
        solutiontvteen.addProduct(products2p1);
        solutiontvteen.setTotalPrice(1000);

        SolutionOffer solutionwebteen = solutionoffercatalog.newSolutionOffer(webchannelteenmarket);
        solutionwebteen.addProduct(products2p2);
        solutionwebteen.addProduct(products2p1);
        solutionwebteen.setTotalPrice(500);

        MasterSolutionOrderList msol = business.getMasterSolutionOrderList();
        SolutionOrder so = msol.newSolutionOrder(solutiontvteen, tvchannelteenmarket, customerprofile4 );
        
        SolutionOrder so2 = msol.newSolutionOrder(solutionwebteen, webchannelteenmarket, customerprofile4);
        
        System.out.println("Revenue By Market Channel Combo :"+ msol.getRevenueByMarketChannelCombo(tvchannelteenmarket));
        System.out.println("Revenue By Channel : "+ msol.getRevenueByChannel(tvchannel));

        return business;

    }

    /*static Business initializeMarkets() {
        Business business = new Business("Xerox");

// Create Persons
        PersonDirectory persondirectory = business.getPersonDirectory();
// person representing sales organization        
        Person xeroxsalesperson001 = persondirectory.newPerson("Xerox sales");
        Person xeroxmarketingperson001 = persondirectory.newPerson("Xerox marketing");

// Create Customers
        CustomerDirectory customedirectory = business.getCustomerDirectory();
        CustomerProfile customerprofile1
                = customedirectory.newCustomerProfile(xeroxsalesperson001);

// Create Sales people
        SalesPersonDirectory salespersondirectory = business.getSalesPersonDirectory();
        SalesPersonProfile salespersonprofile = salespersondirectory.newSalesPersonProfile(xeroxsalesperson001);

        // Create Marketing people
        MarketingPersonDirectory marketingpersondirectory = business.getMarketingPersonDirectory();
        MarketingPersonProfile marketingpersonprofile0 = marketingpersondirectory.newMarketingPersonProfile(xeroxmarketingperson001);

        SupplierDirectory suplierdirectory = business.getSupplierDirectory();

        Supplier supplier1 = suplierdirectory.newSupplier("Lenovo");
        ProductCatalog productcatalog = supplier1.getProductCatalog();
        Product products1p1 = productcatalog.newProduct("Scanner 3  1", 2000, 16500, 10000);
        Product products1p2 = productcatalog.newProduct("Scanner 4", 10000, 25000, 16500);
        Product products1p3 = productcatalog.newProduct("Printer 2", 22000, 40000, 36500);
        Product products1p4 = productcatalog.newProduct("Photocopier 2 ", 30000, 70000, 50000);
        Product products1p5 = productcatalog.newProduct("Scanner  5", 19000, 36500, 25000);
        Product products1p6 = productcatalog.newProduct("Scanner 6", 90000, 125000, 105000);
        Product products1p7 = productcatalog.newProduct("Printer 3", 22000, 60000, 36500);
        Product products1p8 = productcatalog.newProduct("Photocopier 3", 30000, 70000, 50000);

        //       SupplierDirectory suplierdirectory = business.getSupplierDirectory();
        Supplier supplier2 = suplierdirectory.newSupplier("Epson");
        productcatalog = supplier2.getProductCatalog();
        Product products2p1 = productcatalog.newProduct("Scanner 13  1", 12000, 26000, 18500);
        Product products2p2 = productcatalog.newProduct("Scanner 14", 90000, 165000, 125000);
        Product products2p3 = productcatalog.newProduct("Color Printer 112", 422000, 540000, 495000);
        Product products2p4 = productcatalog.newProduct("Photocopier 922 ", 430000, 890000, 550000);
        Product products2p5 = productcatalog.newProduct("Low toner Scanner  102", 195000, 500100, 365102);
        Product products2p6 = productcatalog.newProduct("Speedy color Scanner 611", 900000, 125000, 1650000);
        Product products2p7 = productcatalog.newProduct("Premier Printer 300", 322000, 470000, 736500);
        Product products2p8 = productcatalog.newProduct("Color Photocopier 500", 350000, 580000, 780000);

//=============== Define markets and channels...

        MarketCatalog mc = business.getMarketCatalog();
        Market teenmarket = mc.newMarket("Teenagers");
        Market teenmarket2 = mc.newMarket("College Grads");

        ChannelCatalog channelCatalog = business.getChannelCatalog();

        Channel tvchannel = channelCatalog.newChannel("tv");
        Channel webchannel = channelCatalog.newChannel("web");

        teenmarket.addValidChannel(webchannel);
        teenmarket.addValidChannel(tvchannel);

        MarketChannelComboCatalog mccc = business.getMarketChannelComboCatalog();

        MarketChannelAssignment tvchannelteenmarket = mccc.newMarketChannelCombo(teenmarket, tvchannel);
        MarketChannelAssignment webchannelteenmarket = mccc.newMarketChannelCombo(teenmarket, webchannel);

        SolutionOfferCatalog solutionoffercatalog = business.getSolutionOfferCatalog();

        SolutionOffer solutiontvteen = solutionoffercatalog.newSolutionOffer(tvchannelteenmarket);
        solutiontvteen.addProduct(products2p2);
        solutiontvteen.addProduct(products2p1);
        solutiontvteen.setTotalPrice(1000);

        SolutionOffer solutionwebteen = solutionoffercatalog.newSolutionOffer(webchannelteenmarket);
        solutionwebteen.addProduct(products2p2);
        solutionwebteen.addProduct(products2p1);
        solutionwebteen.setTotalPrice(500);

        MasterSolutionOrderList msol = business.getMasterSolutionOrderList();

        SolutionOrder so = msol.newSolutionOrder(solutiontvteen, tvchannelteenmarket);
        
        SolutionOrder so2 = msol.newSolutionOrder(solutionwebteen, webchannelteenmarket);
        
        System.out.println("Revenue By Market Channel Combo :"+ msol.getRevenueByMarketChannelCombo(tvchannelteenmarket));
        System.out.println("Revenue By Channel : "+ msol.getRevenueByChannel(tvchannel));

       return business;

    }*/

    private static Product getProductFromProductName(SupplierDirectory suplierdirectory, String name) {
        String product_name = name; 
        for(Supplier supplier : suplierdirectory.getSuplierList()){
            Product returnedProduct = supplier.getProductCatalog().findProductByProductName(name);
            if(returnedProduct!=null){
                return returnedProduct;
            }
        }
        return null;
    }

}
