var myChart1;
var option1;
var myChart2;
var option2;

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
    myChart1 = ec.init(document.getElementById('alarmDayCount'));
    option1 = {
        title: {
            text: '一天预警信息统计表'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {// 坐标轴指示器，坐标轴触发有效
                type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            },
            formatter: function (params) {
                var tar = params[0];
                return tar.name + '<br/>' + tar.seriesName + ' : ' + tar.value;
            }
        },
        toolbox: {
            show: true,
            feature: {
                mark: {show: true},
                saveAsImage: {show: true}
            }
        },
        xAxis: [
            {
                type: 'category',
                splitLine: {show: false},
                data: ['预警总数', '车辆前碰撞(高)', '车辆前碰撞(低)', '限速警示', '车道偏离', '城市前碰撞', '车距监测', '行人前部碰撞', '急加速', '急减速']
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
                data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
            }
        ]
    };
    myChart1.setOption(option1);
    myChart2 = ec.init(document.getElementById('alarmWeekCount'));
    option2 = {
        title: {
            text: '一周预警信息统计表'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {// 坐标轴指示器，坐标轴触发有效
                type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            data: ['车辆前碰撞(高)', '车辆前碰撞(低)', '限速警示', '车道偏离', '城市前碰撞', '车距监测', '行人前部碰撞', '急加速', '急减速']
        },
        toolbox: {
            show: true,
            feature: {
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        xAxis: [
            {
                type: 'value'
            }
        ],
        yAxis: [
            {
                type: 'category',
                data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
            }
        ],
        series: [
            {
                name: '车辆前碰撞(高)',
                type: 'bar',
                stack: '总量',
                itemStyle: {normal: {label: {show: true, position: 'insideRight'}}},
                data: [0, 0, 0, 0, 0, 0, 0]
            },
            {
                name: '车辆前碰撞(低)',
                type: 'bar',
                stack: '总量',
                itemStyle: {normal: {label: {show: true, position: 'insideRight'}}},
                data: [0, 0, 0, 0, 0, 0, 0]
            },
            {
                name: '限速警示',
                type: 'bar',
                stack: '总量',
                itemStyle: {normal: {label: {show: true, position: 'insideRight'}}},
                data: [0, 0, 0, 0, 0, 0, 0]
            },
            {
                name: '车道偏离',
                type: 'bar',
                stack: '总量',
                itemStyle: {normal: {label: {show: true, position: 'insideRight'}}},
                data: [0, 0, 0, 0, 0, 0, 0]
            },
            {
                name: '城市前碰撞',
                type: 'bar',
                stack: '总量',
                itemStyle: {normal: {label: {show: true, position: 'insideRight'}}},
                data: [0, 0, 0, 0, 0, 0, 0]
            },
            {
                name: '车距监测',
                type: 'bar',
                stack: '总量',
                itemStyle: {normal: {label: {show: true, position: 'insideRight'}}},
                data: [0, 0, 0, 0, 0, 0, 0]
            },
            {
                name: '行人前部碰撞',
                type: 'bar',
                stack: '总量',
                itemStyle: {normal: {label: {show: true, position: 'insideRight'}}},
                data: [0, 0, 0, 0, 0, 0, 0]
            },
            {
                name: '急加速',
                type: 'bar',
                stack: '总量',
                itemStyle: {normal: {label: {show: true, position: 'insideRight'}}},
                data: [0, 0, 0, 0, 0, 0, 0]
            },
            {
                name: '急减速',
                type: 'bar',
                stack: '总量',
                itemStyle: {normal: {label: {show: true, position: 'insideRight'}}},
                data: [0, 0, 0, 0, 0, 0, 0]
            }
        ]
    };
    myChart2.setOption(option2);
}

function doSearch() {
    var deviceId = $('#deviceId').val();
    var date = $('#dt').val();
    var queryForm = $('#queryForm');
    if (!queryForm.form("validate")) {
        return;
    }
    $.ajax({
        type: "post",
        async: false,
        url: "getDayAlarm",
        data: {deviceId: deviceId, date: date},
        dataType: "json",
        success: function (result) {
            if (success(result)) {
                option1.series[0].data = result.data.MSG;
                option2.series[0].data = result.data.M1;
                option2.series[1].data = result.data.M2;
                option2.series[2].data = result.data.M3;
                option2.series[3].data = result.data.M4;
                option2.series[4].data = result.data.M5;
                option2.series[5].data = result.data.M6;
                option2.series[6].data = result.data.M7;
                option2.series[7].data = result.data.M8;
                option2.series[8].data = result.data.M9;
                myChart1.setOption(option1,true);
                myChart2.setOption(option2,true);
            }
        },
        error: function (errorMsg) {
            error(errorMsg)
        }
    });
}