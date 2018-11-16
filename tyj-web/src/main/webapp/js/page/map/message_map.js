$(function () {
    $('#msgType').combobox({
        data : [
            {
                text: "左车道偏离",
                value: "1"
            },{
                text: "右车道偏离",
                value: "2"
            },{
                text: "车距监测",
                value: "3"
            },{
                text: "限速警示",
                value: "4",
                selected: "selected"
            },{
                text: "城市前碰撞",
                value: "5"
            },{
                text: "车辆前部碰撞",
                value: "6"
            },{
                text: "汽车启动",
                value: "7"
            },{
                text: "汽车熄火",
                value: "8"
            },{
                text: "定位信息",
                value: "9"
            },{
                text: "急加速",
                value: "13"
            },{
                text: "急减速",
                value: "14"
            },{
                text: "行人前部碰撞",
                value: "17"
            },{
                text: "超速警示",
                value: "22"
            }
        ],
        valueField: 'value',
        textField: 'text',
        panelHeight:'auto'
    });
    $('#type').combobox({
        data : [
            {
                text: "告警信息",
                value: "message_window",
                selected: "selected"
            },{
                text: "实时路况信息",
                value: "message_traffic"
            }
        ],
        valueField: 'value',
        textField: 'text',
        panelHeight:'auto',
        onChange: function (newValue) {
            if ('message_traffic' == newValue) {
                $('#deviceId').textbox('options').required = false;
                $('#startDate').my97('options').required = false;
                $('#endDate').my97('options').required = false;
                $('#city').textbox('options').required = true;
                $('#cityTd').css('display', 'block');
                $('#windowTd').css('display', 'none');
            } else if ('message_window' == newValue) {
                $('#deviceId').textbox('options').required = true;
                $('#startDate').my97('options').required = true;
                $('#endDate').my97('options').required = true;
                $('#city').textbox('options').required = false;
                $('#cityTd').css('display', 'none');
                $('#windowTd').css('display', 'block');
            }
            $('#oneIframe').attr("src", newValue);
        }
    });

    $('#oneIframe').attr("src", $('#type').combobox('getValue'));
});

function doSearch() {
    self.frames[0].doSearch();
}

function doDownload() {
    self.frames[0].doDownload();
}