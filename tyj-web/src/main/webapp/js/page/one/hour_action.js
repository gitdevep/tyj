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
            text: '平均每小时告警量统计表'
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
    var data = parent.getParams(arrays);
    var dates = data['dates'].split(',');
    $.ajax({
        type: "post",
        async: false,
        url: "../alarm/getAlarmHour",
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
        url: "../alarm/downloadAlarmHour",
        onSubmit: function(param) {
            param.deviceId = data['deviceId'];
            param.dates = data['dates'];
            param.startDates = data['startDates'];
            param.endDates = data['endDates'];
        }
    });
}