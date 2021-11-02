package com.example.youban.Services;

import com.example.youban.bean.MineInformation;

public class Service {
    private MineInformation mineInformation;
    private ServiceDB serviceDB;
    public void BymineGetMineInformation(MineInformation mineInformation){
            serviceDB.ToServiceDB(mineInformation);
    }
}
