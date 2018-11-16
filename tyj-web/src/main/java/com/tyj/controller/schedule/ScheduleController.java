package com.tyj.controller.schedule;

import cn.vansky.framework.common.util.DateUtil;
import cn.vansky.framework.core.util.JsonResp;
import com.tyj.dao.demo.deviceGpsInfos.bo.DeviceGpsInfos;
import com.tyj.dao.jhpt.deviceGpsInfos.bo.MsgType;
import com.tyj.service.demo.deviceGpsInfos.service.DeviceGpsInfosService;
import com.tyj.service.schedule.ExportDataLocalSchedule;
import com.tyj.service.schedule.ExportDataSchedule;
import com.tyj.service.schedule.ExportOldDataSchedule;
import com.tyj.service.schedule.WeatherHistorySchedule;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2015/12/22
 */
@Controller
@RequestMapping(value = "/schedule")
public class ScheduleController {
    @Resource(name = "exportDataSchedule")
    ExportDataSchedule exportDataSchedule;

    @Resource(name = "exportOldDataSchedule")
    ExportOldDataSchedule exportOldDataSchedule;

    @Resource(name = "deviceGpsInfosService")
    DeviceGpsInfosService deviceGpsInfosService;

    @Resource(name = "weatherHistorySchedule")
    WeatherHistorySchedule weatherHistorySchedule;

    @Resource(name = "exportDataLocalSchedule")
    ExportDataLocalSchedule exportDataLocalSchedule;

    @ResponseBody
    @RequestMapping(value = "/exportWeather")
    public String exportTest() {
        weatherHistorySchedule.export();
        return JsonResp.asEmpty().toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/exportTest")
    public String exportTest(@RequestParam("date") String date) {
        exportDataSchedule.export(date);
        return JsonResp.asEmpty().toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/exportBatchTest")
    public String exportBatchTest(@RequestParam("startDate") String startDate,
                              @RequestParam("endDate") String endDate) {
        return export(startDate, endDate, new CallBack() {
            @Override
            public void e(String date) {
                exportDataSchedule.export(date);
            }
        });
    }

    @ResponseBody
    @RequestMapping(value = "/exportOldTest")
    public String exportOldTest(@RequestParam("date") String date, @RequestParam("ds") String ds) {
        exportOldDataSchedule.export(date, ds.split(","));
        return JsonResp.asEmpty().toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/exportOldBatchTest")
    public String exportOldBatchTest(@RequestParam("startDate") String startDate,
                                     @RequestParam("endDate") String endDate,
                                     @RequestParam("ds") final String ds) {
        return export(startDate, endDate, new CallBack() {
            @Override
            public void e(String date) {
                exportOldDataSchedule.export(date, ds.split(","));
            }
        });
    }

    @ResponseBody
    @RequestMapping(value = "/exportLocalTest")
    public String exportLocalBatchTest(@RequestParam("date") String date) {
        exportDataLocalSchedule.export(date);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/exportLocalBatchTest")
    public String exportLocalBatchTest(@RequestParam("startDate") String startDate,
                                  @RequestParam("endDate") String endDate) {
        return export(startDate, endDate, new CallBack() {
            @Override
            public void e(String date) {
                exportDataLocalSchedule.export(date);
            }
        });
    }

    private String export(String startDate, String endDate, CallBack c) {
        Date start = DateUtil.parse(DateUtil.yyyy_MM_dd, startDate);
        long day = DateUtil.getBetweenDiff(start, DateUtil.parse(DateUtil.yyyy_MM_dd, endDate), DateUtil.DAY_TIME);
        for (int i = 0; i <= day; i++) {
            c.e(DateUtil.getDateStr(start, DateUtil.yyyy_MM_dd, Calendar.DATE, i));
        }
        return JsonResp.asEmpty().toJson();
    }

    public static interface CallBack {
        void e(String date);
    }

    @RequestMapping(value = "/f")
    public ModelAndView f() {
        return new ModelAndView("file/upload_file");
    }

//    @ResponseBody
//    @RequestMapping(value = "/upload")
//    public String upload(@RequestParam("file") MultipartFile file) {
//        CSVRead<DeviceGpsInfos> csvReaderUtils = new CSVRead<DeviceGpsInfos>();
//        InputStream inputStream = null;
//        try {
//            inputStream = file.getInputStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        csvReaderUtils.read(inputStream, new DefaultCSVReaderDeal<DeviceGpsInfos>() {
//            @Override
//            public DeviceGpsInfos dealBean(String[] arr) {
//                DeviceGpsInfos d = new DeviceGpsInfos();
//                d.setDeviceId(Integer.valueOf(arr[0]));
//                d.setMsgId(Integer.valueOf(arr[1]));
//                d.setEventTime(DateUtil.parse(DateUtil.yyyy_MM_dd_HH_mm_ss, arr[2].replaceAll("/", "-") + ":00"));
//                d.setLongitude(Double.valueOf(arr[4]));
//                d.setLatitude(Double.valueOf(arr[5]));
//                d.setSpeed(Integer.valueOf(arr[6]));
//                d.setMsgType((byte) MsgType.getMsgType(arr[8]));
//                d.setFlashState((byte) 0);
//                d.setUploadTime(DateUtil.parse(DateUtil.yyyy_MM_dd_HH_mm_ss, arr[3].replaceAll("/", "-") + ":00"));
//                return d;
//            }
//
//            @Override
//            public void dealBatchBean(List<DeviceGpsInfos> list) {
//                deviceGpsInfosService.saveBatch(list);
//            }
//        });
//        return JsonResp.asEmpty().toJson();
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/uploadXls")
//    public String uploadXLs(@RequestParam("file") MultipartFile file) {
//        ExcelRead<DeviceGpsInfos> excelRead = new ExcelRead<DeviceGpsInfos>();
//        InputStream inputStream = null;
//        try {
//            inputStream = file.getInputStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        excelRead.read(inputStream, file.getOriginalFilename(), new DefaultExcelReadDeal<DeviceGpsInfos>() {
//            @Override
//            public DeviceGpsInfos dealBean(Row row) {
//                DeviceGpsInfos d = new DeviceGpsInfos();
//                if (null == row.getCell(0) || null == row.getCell(1)
//                        || null == row.getCell(2) || null == row.getCell(3)
//                        || null == row.getCell(6)) {
//                    return null;
//                }
//                d.setDeviceId((int) row.getCell(0).getNumericCellValue());
//                d.setMsgId((int) row.getCell(1).getNumericCellValue());
//                d.setEventTime(row.getCell(2).getDateCellValue());
//                d.setUploadTime(row.getCell(3).getDateCellValue());
//                d.setSpeed((int) row.getCell(4).getNumericCellValue());
//                d.setMsgType((byte) MsgType.getMsgType(row.getCell(6).getStringCellValue()));
//                return d;
//            }
//
//            @Override
//            public void dealBatchBean(List<DeviceGpsInfos> list) {
//                deviceGpsInfosService.saveBatch(list);
//            }
//        });
//        return JsonResp.asEmpty().toJson();
//    }
}
