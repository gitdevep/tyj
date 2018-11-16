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
            text: '团队平均每百公里告警量统计表'
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

function doSearch() {
    if (!parent.$('#queryForm').form("validate")) {
        return;
    }
    var data = parent.getParams();
    $.ajax({
       type: "post",
        async: false,
        url: "../alarm/getAlarmKmTeam",
        data: data,
        dataType: "json",
        success: function (result) {
            if (success(result)) {
                var dd = data['deviceId'].split(",");
                var ds = [];
                ds.push(data['teamName']);
                for (var i = 0; i < dd.length; i++) {
                    ds.push(dd[i]);
                }
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
    var queryForm = parent.$('#queryForm');
    if (!queryForm.form("validate")) {
        return;
    }
    var data = parent.getParams();
    queryForm.form('submit', {
        url: "../alarm/downloadAlarmKmTeam",
        onSubmit: function(param) {
            param.deviceId = data['deviceId'];
            param.startDate = data['startDate'];
            param.endDate = data['endDate'];
            param.team = data['team'];
            param.teamName = data['teamName'];
        }
    });
}
