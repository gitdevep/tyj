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
    myChart = ec.init(document.getElementById('speedDayCount'));
    option = {
        title: {
            text: '每日车速统计表'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['速度']
        },
        toolbox: {
            show: true,
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
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
                    formatter: '{value} km/h'
                }
            }
        ],
        series: [
            {
                name: '速度',
                type: 'line',
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
    var date = $('#dt').val();
    var queryForm = $('#queryForm');
    if (!queryForm.form("validate")) {
        return;
    }
    $.ajax({
        type: "post",
        async: false,
        url: "getDaySpeed",
        data: {deviceId: deviceId, date: date},
        dataType: "json",
        success: function (result) {
            if (success(result)) {
                option.xAxis[0].data = result.data.CAT;
                option.series[0].data = result.data.DATA;
                myChart.setOption(option, true);
            }
        },
        error: function (errorMsg) {
            error(errorMsg)
        }
    });
}