package com.tyj.dao.demo.vo;

import com.tyj.dao.demo.deviceGpsInfos.bo.DeviceGpsInfos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static cn.vansky.framework.common.util.DateUtil.getBetweenDiff;
import static cn.vansky.framework.common.util.DateUtil.MINUTE_TIME;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2016/1/9
 */
public abstract class AbsDeviceGpsInfos {
    /**
     * 启动
     */
    protected DeviceGpsInfos carStart;
    /**
     * 熄火
     */
    protected DeviceGpsInfos carEnd;

    protected List<DeviceGpsInfos> list = new ArrayList<DeviceGpsInfos>();

    public DeviceGpsInfos getCarStart() {
        return carStart;
    }

    public void setCarStart(DeviceGpsInfos carStart) {
        this.carStart = carStart;
    }

    public DeviceGpsInfos getCarEnd() {
        return carEnd;
    }

    public void setCarEnd(DeviceGpsInfos carEnd) {
        this.carEnd = carEnd;
    }

    public int size() {
        return this.list != null ? this.list.size() : 0;
    }

    public List<DeviceGpsInfos> getList() {
        return list;
    }

    public void setList(List<DeviceGpsInfos> list) {
        this.list = list;
    }

    public void addDeviceGpsInfos(DeviceGpsInfos d) {
        list.add(d);
    }

    public void addDeviceGpsInfos(List<DeviceGpsInfos> d) {
        list.addAll(d);
    }

    public List<DeviceGpsInfos> getAll() {
        if (getList() == null) {
            return null;
        }
        List<DeviceGpsInfos> all = new ArrayList<DeviceGpsInfos>(getList().size() + 2);
        all.add(getCarStart());
        all.addAll(getList());
        all.add(getCarEnd());
        return all;
    }

    public int diffTimeByStartAndEnd() {
        if (null != carStart && null != carEnd) {
            Date start = carStart.getEventTime();
            Date end = carEnd.getEventTime();
            return (int) getBetweenDiff(start, end, MINUTE_TIME);
        }
        return 0;
    }
}
