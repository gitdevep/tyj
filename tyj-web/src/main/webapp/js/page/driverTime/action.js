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
        'echarts/chart/bar'
    ],
    DrawEChart
);

function DrawEChart(ec) {
    myChart = ec.init(document.getElementById('driveTimeCount'));
    option = {
        title: {
            text: '每日驾驶时长统计'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['驾驶时长']
        },
        toolbox: {
            show: true,
            feature: {
                dataView: {show: true, readOnly: false},
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                data: [0]
            }
        ],
        yAxis: [
            {
                type: 'value',
                axisLabel: {
                    formatter: '{value} min'
                }
            }
        ],
        series: [
            {
                name: '驾驶时长',
                type: 'bar',
                data: [0],
                markPoint: {
                    data: [
                        {type: 'max', name: '最大值'},
                        {type: 'min', name: '最小值'}
                    ]
                },
                markLine: {
                    data: [
                        {type: 'average', name: '平均值'}
                    ]
                }
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
        url: "getDriverTime",
        data: {deviceId: deviceId, startDate: startDate, endDate: endDate},
        dataType: "json",
        success: function (result) {
            if (success(result)) {
                option.xAxis[0].data = result.data.CAT;
                option.series[0].data = result.data.DATA;
                myChart.setOption(option,true);
            }
        },
        error: function (errorMsg) {
            error(errorMsg)
        }
    });
}