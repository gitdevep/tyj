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
            text: '速度段-平均每小时告警量统计表'
        },
        legend: {
            data:['左车道偏离', '右车道偏离', '车距监测', '限速警示', '城市前碰撞', '车辆前部碰撞', '急加速', '急减速', '行人前部碰撞']
        },
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
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
        xAxis : [
            {
                type : 'category',
                data : ['<0,20>','<20,40>','<40,60>','<60,80>','<80,*>']
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'左车道偏离',
                type:'bar',
                itemStyle: {normal: {label: {show: true, position: 'inside'}}},
                data:[0, 0, 0, 0, 0]
            },
            {
                name:'右车道偏离',
                type:'bar',
                itemStyle: {normal: {label: {show: true, position: 'inside'}}},
                data:[0, 0, 0, 0, 0]
            },
            {
                name:'车距监测',
                type:'bar',
                itemStyle: {normal: {label: {show: true, position: 'inside'}}},
                data:[0, 0, 0, 0, 0]
            },
            {
                name:'限速警示',
                type:'bar',
                itemStyle: {normal: {label: {show: true, position: 'inside'}}},
                data:[0, 0, 0, 0, 0]
            },
            {
                name:'城市前碰撞',
                type:'bar',
                itemStyle: {normal: {label: {show: true, position: 'inside'}}},
                data:[0, 0, 0, 0, 0]
            },
            {
                name:'车辆前部碰撞',
                type:'bar',
                itemStyle: {normal: {label: {show: true, position: 'inside'}}},
                data:[0, 0, 0, 0, 0]
            },
            {
                name:'急加速',
                type:'bar',
                itemStyle: {normal: {label: {show: true, position: 'inside'}}},
                data:[0, 0, 0, 0, 0]
            },
            {
                name:'急减速',
                type:'bar',
                itemStyle: {normal: {label: {show: true, position: 'inside'}}},
                data:[0, 0, 0, 0, 0]
            },
            {
                name:'行人前部碰撞',
                type:'bar',
                itemStyle: {normal: {label: {show: true, position: 'inside'}}},
                data:[0, 0, 0, 0, 0]
            }
        ]
    };
    myChart.setOption(option);
}

function doSearch(arrays) {
    if (!parent.$('#queryForm').form("validate")) {
        return;
    }
    var data = getParams(arrays);
    $.ajax({
        type: "post",
        async: false,
        url: "../alarm/getAlarmSpeed",
        data: data,
        dataType: "json",
        success: function (result) {
            if (success(result)) {
                option.series[0].data = result.data.M1;
                option.series[1].data = result.data.M2;
                option.series[2].data = result.data.M3;
                option.series[3].data = result.data.M4;
                option.series[4].data = result.data.M5;
                option.series[5].data = result.data.M6;
                option.series[6].data = result.data.M7;
                option.series[7].data = result.data.M8;
                option.series[8].data = result.data.M9;
            }
            myChart.setOption(option, true);
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
    var data = getParams(arrays);
    queryForm.form('submit', {
        url: "../alarm/downloadAlarmSpeed",
        onSubmit: function(param) {
            param.deviceId = data['deviceId'];
            param.startDate = data['startDate'];
            param.endDate = data['endDate'];
        }
    });
}

function getParams(arrays) {
    var data = {
        deviceId : parent.$('#deviceId').val(),
        startDate : parent.$('#startDate0').val(),
        endDate : parent.$('#endDate0').val()
    };
    return data;
}
