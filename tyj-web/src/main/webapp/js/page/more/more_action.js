$(function () {
    $('#type').combobox({
        data : [
            {
                text: "小时预警",
                value: "init_team",
                selected: "selected"
            },{
                text: "公里预警",
                value: "init_km"
            }
        ],
        valueField: 'value',
        textField: 'text',
        panelHeight:'auto',
        onChange: function (newValue) {
            if ('init_time' == newValue) {
                $('#startDate').my97('setValue', '');
                $('#endDate').my97('setValue', '');
                $('#startDate').my97('options').dateFmt = 'yyyy-MM-dd';
                $('#endDate').my97('options').dateFmt = 'yyyy-MM-dd';
            } else {
                $('#startDate').my97('setValue', '');
                $('#endDate').my97('setValue', '');
                $('#startDate').my97('options').dateFmt = 'yyyy-MM-dd HH:mm';
                $('#endDate').my97('options').dateFmt = 'yyyy-MM-dd HH:mm';
            }
            $('#oneIframe').attr("src", newValue);
        }
    });

    $('#oneIframe').attr("src", $('#type').combobox('getValue'));

    $('#team').combobox({
        data : [
            {
                text: "神州团队",
                value: "10048,10049,10050,10051,10053,10055,10056,10057,10059,10060",
                selected: "selected"
            },{
                text: "抚顺团队",
                value: "10063,10064,10065,10066"
            },{
                text: "龙口团队",
                value: "10303"
            }
        ],
        valueField: 'value',
        textField: 'text',
        panelHeight:'auto'
    });
});

function doSearch() {
    var type = $('#type').combobox('getValue');
    self.frames[0].doSearch();
}

function doDownload() {
    self.frames[0].doDownload();
}

function getParams() {
    var data = {
        deviceId: $('#deviceId').val(),
        startDate: $('#startDate').val(),
        endDate: $('#endDate').val(),
        team: $('#team').combobox('getValue'),
        teamName: $('#team').combobox('getText')
    };
    return data;
}