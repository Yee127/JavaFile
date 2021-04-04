package com.transaction.service;

import com.transaction.dao.TranDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TranService {
    @Autowired
    private TranDao tranDao;

    public void accountMoney(){
        tranDao.reduce();
        try {
            int a = 10/0;
        } catch (Exception e) {
            System.out.println("出现异常！");
        }
        tranDao.increase();
    }
}
