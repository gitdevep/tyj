var myChart, option;

require.config({
    paths: {
        echarts: '../js/echarts/build/dist'
    }
});

require(
    [
        'echarts',
        'echarts/chart/bar'
    ],
    DrawEChart
);

function DrawEChart(ec) {
    myChart = ec.init(document.getElementById('alarm'));
    option = {
        title: {
            text: '平均每百公里告警量统计表'
        },
        legend: {
            data:['10000']
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {// 坐标轴指示器，坐标轴触发有效
                type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            },
            formatter: function (params) {
                var res = params[0].name + '<br/>';
                for (var i = 0; i < params.length; i++) {
                    var tar = params[i];
                    res += tar.seriesName + ' : ' + tar.value + '<br/>';
                }
                return res;
            }
        },
        xAxis: [
            {
                type: 'category',
                data: ['左车道偏离', '右车道偏离', '车距监测', '限速警示', '城市前碰撞', '车辆前部碰撞', '急加速', '急减速', '行人前部碰撞']
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: '数量',
                type: 'bar',
                itemStyle: {normal: {label: {show: true, position: 'inside'}}},
                data: [0, 0, 0, 0, 0, 0, 0, 0, 0]
            }
        ]
    };
    myChart.setOption(option);
}

function doSearch(arrays) {
    if (!parent.$('#queryForm').form("validate")) {
        return;
    }
//    closeWindow($('#a'));
    var data = parent.getParams(arrays);
    var dates = data['dates'].split(',');
    $.ajax({
       type: "post",
        async: false,
        url: "../alarm/getAlarmKm",
        data: data,
        dataType: "json",
        success: function (result) {
            if (success(result)) {
                option.legend.data = legend(dates);
                option.series = series(dates, 'bar', result.data);
                myChart.setOption(option, true);
            }
        },
        error: function (errorMsg) {
            error(errorMsg)
        }
    });
}

function doDownload(arrays) {
    var queryForm = parent.$('#queryForm');
    if (!queryForm.form("validate")) {
        return;
    }
    var data = parent.getParams(arrays);
    queryForm.form('submit', {
        url: "../alarm/downloadAlarmKm",
        onSubmit: function(param) {
            param.deviceId = data['deviceId'];
            param.dates = data['dates'];
            param.startDates = data['startDates'];
            param.endDates = data['endDates'];
        }
    });
}


//function getMap() {
//    var deviceId = parent.$('#deviceId').val();
//    var startDate = parent.$('#startDate').val();
//    var endDate = parent.$('#endDate').val();
//    var queryForm = parent.$('#queryForm');
//    if (!queryForm.form("validate")) {
//        return;
//    }
//    $.ajax({
//        type: "post",
//        url: "../map/getMessageWindow",
//        data: {deviceId: deviceId, startDate: startDate, endDate: endDate, flag: 1},
//        dataType: "json",
//        success: function (result) {
//            if (success(result)) {
//                setDriving(result.data[deviceId]);
//            }
//        },
//        error: function (errorMsg) {
//            error(errorMsg)
//        }
//    });
//}
//
//var map = new BMap.Map("allmap");
//map.centerAndZoom(new BMap.Point(116.404, 39.915), 12);
//
//var transit = new BMap.DrivingRoute(map, {
//    renderOptions: {
//        map: map,
//        autoViewport: true,
//        enableDragging : true // 可进行拖拽
//    },
//    onSearchComplete: function (results) {
//        if (transit.getStatus() != BMAP_STATUS_SUCCESS) {
//            return ;
//        }
//        var plan = results.getPlan(0);
//        var distance = plan.getDistance(false) / 1000;
//        $('#kmSon').val(distance);
//        $('#kmSon').textbox('setText', distance);
//    }
//});
//
//function setDriving(data) {
//    openWindow($('#a'));
//    var points = [];
//    var tmpPoints = [];
//    for (var i = 0; i < data.length; i++) {
//        transPoint(data[i], points, tmpPoints, data.length)
//    }
//}
//
//function transPoint(o, points, tmpPoints, pointsLength) {
//    // GPS 坐标
//    var gpsPoint = new BMap.Point(o.longitude, o.latitude);
//    // GPS坐标转换百度坐标，并回调
//    var convertor = new BMap.Convertor();
//    var pointArr = [];
//    pointArr.push(gpsPoint);
//    convertor.translate(pointArr, 1, 5, function (data) {
//        if (data.status === 0) {
//            points.push(data.points[0]);
//            if (points.length != 1 || points.length != 10) {
//                tmpPoints.push(data.points[0]);
//            }
//        }
//        if (points.length == pointsLength) {
//            transit.search(points[0], points[points.length - 1], {
//                waypoints: tmpPoints
//            });
//        }
//    });
//}
