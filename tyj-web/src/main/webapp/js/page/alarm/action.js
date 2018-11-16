var myChart;
var option;

require.config({
    paths: {
        echarts: '../js/echarts/build/dist'
    }
});

require(
    [
        'echarts',
        'echarts/chart/line'
    ],
    DrawEChart
);

function DrawEChart(ec) {
    myChart = ec.init(document.getElementById('alarmIntervalCount'));
    option = {
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['车辆前碰撞', '限速警示', '左车道偏离', '城市前碰撞', '车距监测', '右车道偏离']
        },
        toolbox: {
            show: true,
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                boundaryGap: false,
                data: [0]
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: '车辆前碰撞',
                type: 'line',
                stack: '总量',
                itemStyle: {normal: {label: {show: true, position: 'inside'}}},
                data: [0]
            },
            {
                name: '限速警示',
                type: 'line',
                stack: '总量',
                itemStyle: {normal: {label: {show: true, position: 'inside'}}},
                data: [0]
            },
            {
                name: '左车道偏离',
                type: 'line',
                stack: '总量',
                itemStyle: {normal: {label: {show: true, position: 'inside'}}},
                data: [0]
            },
            {
                name: '城市前碰撞',
                type: 'line',
                stack: '总量',
                itemStyle: {normal: {label: {show: true, position: 'inside'}}},
                data: [0]
            },
            {
                name: '车距监测',
                type: 'line',
                stack: '总量',
                itemStyle: {normal: {label: {show: true, position: 'inside'}}},
                data: [0]
            },
            {
                name: '右车道偏离',
                type: 'line',
                stack: '总量',
                itemStyle: {normal: {label: {show: true, position: 'inside'}}},
                data: [0]
            }
        ]
    };
    myChart.setOption(option);
}

function doSearch() {
    var deviceId = $('#deviceId').val();
    var startDate = $('#startDate').val();
    var endDate = $('#endDate').val();
    var queryForm = $('#queryForm');
    if (!queryForm.form("validate")) {
        return;
    }
    $.ajax({
        type: "post",
        async: false,
        url: "getAlarmInterval",
        data: {deviceId: deviceId, startDate: startDate, endDate: endDate},
        dataType: "json",
        success: function (result) {
            if (success(result)) {
                option.xAxis[0].data = result.data.CAT;
                option.series[0].data = result.data.M1;
                option.series[1].data = result.data.M2;
                option.series[2].data = result.data.M3;
                option.series[3].data = result.data.M4;
                option.series[4].data = result.data.M5;
                option.series[5].data = result.data.M6;
            }
            myChart.setOption(option, true);
        },
        error: function (errorMsg) {
            error(errorMsg)
        }
    });
}