package edu.umss.storeservice;
/**
 * @author: Jose Iriarte
 */
import edu.umss.storeservice.model.*;
import edu.umss.storeservice.repository.BuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private BuyRepository buyRepository;

    public DevBootstrap(BuyRepository buyRepository) {
        this.buyRepository = buyRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        /*Bill bill = new Bill();
        bill.setBillCode("bill1");
        bill.setNit("111122223333");
        bill.setDeleted(false);
        bill.setTotalPay(100);
        billRepository.save(bill);
        */

        List<Buy> buyList = buyRepository.findAll();

        Buy buyItem = buyRepository.findById(1L);
        buyItem.getCode();

        Boolean isDeleted = buyRepository.deleteById(3L);
        if(isDeleted){
            System.out.println("Buy deleted");
        }
    }

}
