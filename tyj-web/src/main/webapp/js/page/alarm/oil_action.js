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
            text: '平均每百公里油耗(升/百公里)统计表'
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
                data: ['驾驶时长', '行驶里程', '平均每百公里油耗']
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
                data: [0, 0, 0]
            }
        ]
    };
    myChart.setOption(option);
}

function doSearch() {
    if (!$('#queryForm').form("validate")) {
        return;
    }
    var deviceId = $('#deviceId').val();
    var oil = $('#oil').val();
    var startDate = $('#startDate').val();
    var endDate = $('#endDate').val();
    $.ajax({
       type: "post",
        async: false,
        url: "getAlarmOil",
        data: {deviceId: deviceId, oil: oil, startDate: startDate, endDate: endDate},
        dataType: "json",
        success: function (result) {
            if (success(result)) {
                var ds = deviceId.split(",");
                option.legend.data = legend(ds);
                option.series = series(ds, 'bar', result.data);
                myChart.setOption(option, true);
            }
        },
        error: function (errorMsg) {
            error(errorMsg)
        }
    });
}

function doDownload() {
    var queryForm = $('#queryForm');
    if (!queryForm.form("validate")) {
        return;
    }
    var deviceId = $('#deviceId').val();
    var oil = $('#oil').val();
    var startDate = $('#startDate').val();
    var endDate = $('#endDate').val();
    queryForm.form('submit', {
        url: "downloadAlarmOil",
        onSubmit: function(param) {
            param.deviceId = deviceId;
            param.startDate = startDate;
            param.endDate = endDate;
            param.oil = oil;
        }
    });
}