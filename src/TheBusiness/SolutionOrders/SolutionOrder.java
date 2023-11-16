/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.SolutionOrders;

import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.MarketModel.SolutionOffer;

/**
 *
 * @author kal bugrara
 */

public class SolutionOrder {
    
    SolutionOffer selectedsolutionoffer;
    CustomerProfile customerprofile;
    MarketChannelAssignment marketChannelAssignment; 
    public SolutionOrder(SolutionOffer so,  MarketChannelAssignment mca, CustomerProfile customerProfile){
        selectedsolutionoffer = so;
        marketChannelAssignment = mca;
        this.customerprofile = customerProfile;

    }
    
    public int getSolutionPrice(){
        return selectedsolutionoffer.getSolutionPrice();
    }
    public MarketChannelAssignment getMarketChannelCombo(){
        
        return marketChannelAssignment;
                
    }

   
}
