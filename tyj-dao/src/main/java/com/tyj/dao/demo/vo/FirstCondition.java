package com.tyj.dao.demo.vo;

import com.tyj.dao.demo.deviceGpsInfos.bo.DeviceGpsInfos;
import com.tyj.dao.jhpt.deviceGpsInfos.bo.MsgType;

import java.util.ArrayList;
import java.util.List;

import static cn.vansky.framework.common.util.DateUtil.MINUTE_TIME;
import static cn.vansky.framework.common.util.DateUtil.getBetweenDiff;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2016/1/9
 */
public class FirstCondition extends AbsDeviceGpsInfos {

    private FirstCondition pre;

    private FirstCondition next;

    public List<DeviceGpsInfos> deal() {
        if (one()) {
            return null;
        }
        if (getList() == null) {
            return null;
        }
//        five();
        two();
        six();
        return getAll();
    }

    public boolean one() {
        if (null == getList()) {
            carEnd = carStart = null;
            return true;
        }

        int i = 0;
        List<DeviceGpsInfos> tmp = new ArrayList<DeviceGpsInfos>();
        for (DeviceGpsInfos d : list) {
            if (MsgType.LOCATION_MESSAGE.getMsgType() == d.getMsgType().intValue()
                    && d.getSpeed() == 0) {
                tmp.add(d);
                ++i;
            }
        }
        if (size() == i) {
            carEnd = carStart = null;
            list = null;
            return true;
        }
        list.removeAll(tmp);
        return false;
    }

    /**
     * 短时间内5分钟，出现连续汽车启动、定位，如果消息ID连贯，可考虑删除该区间
     */
    public void two() {
        List<ActiveRange> activeRangeList = new ArrayList<ActiveRange>();
        for (int i = 0; i < size(); i++) {
            DeviceGpsInfos d = getList().get(i);
            if ((MsgType.CAR_START.getMsgType() == d.getMsgType().intValue())
                    || (MsgType.CAR_END.getMsgType() == d.getMsgType().intValue())) {
                if (activeRangeList.isEmpty()) {
                    ActiveRange activeRange = new ActiveRange();
                    activeRange.setStart(i);
                    activeRange.setEnd(i);
                    activeRangeList.add(activeRange);
                } else {
                    activeRangeList.get(activeRangeList.size() - 1).setEnd(i);
                }
                ActiveRange activeRange = new ActiveRange();
                activeRangeList.add(activeRange);
            } else if (activeRangeList.isEmpty()) {
                ActiveRange activeRange = new ActiveRange();
                activeRange.setStart(i);
                activeRangeList.add(activeRange);
            } else {
                activeRangeList.get(activeRangeList.size() - 1).setEnd(i);
            }
        }
        for (int j = 0; j < activeRangeList.size() - 1; j++) {
            ActiveRange activeRange = activeRangeList.get(j);
            for (int i = activeRange.getStart(); i <= activeRange.getEnd(); i++) {
                list.get(i).setFlag((byte) 1);
            }
        }
    }

    /**
     * 两个连续汽车启动，或中间有少于3条的信息丢失，或间隔时间小于5分钟，则保留后一条汽车启动
     * @return boolean
     */
    public List<DeviceGpsInfos> five(List<DeviceGpsInfos> list) {
        List<DeviceGpsInfos> lists = new ArrayList<DeviceGpsInfos>();
        if (!list.isEmpty()) {
            int diff = (int) getBetweenDiff(list.get(0).getEventTime(), list.get(list.size() - 1)
                    .getEventTime(), MINUTE_TIME);
            if (5 < diff) {
                return list;
            }
        }
        return lists;
    }

    /**
     * 如果存在信息丢失，剩余的也无法形成有效行车区间，且时间间隔小于30分钟，则可不予考虑
     */
    public void six() {
        if (null == getCarEnd()) {
            DeviceGpsInfos current = getCarStart();
            DeviceGpsInfos end = getList().get(getList().size() - 1);
            int diff = (int) getBetweenDiff(current.getEventTime(), end.getEventTime(), MINUTE_TIME);
            // 最后的区间，如果存在信息丢失，剩余的也无法形成有效行车区间，且时间间隔小于30分钟，则可不予考虑
            // 大于30分钟报警加入前一个区间
            if (diff >= 30) {
                getPre().addDeviceGpsInfos(getList());
                getList().removeAll(getList());
            }
        }
    }

    public FirstCondition getPre() {
        return pre;
    }

    public void setPre(FirstCondition pre) {
        this.pre = pre;
    }

    public FirstCondition getNext() {
        return next;
    }

    public void setNext(FirstCondition next) {
        this.next = next;
    }
}
