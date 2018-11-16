$(function () {
    $('#type').combobox({
        data : [
            {
                text: "小时预警",
                value: "init_hour",
                selected: "selected"
            },{
                text: "公里预警",
                value: "init_km"
            },{
                text: "速度预警",
                value: "init_speed"
            },{
                text: "时间预警",
                value: "init_time"
            },{
                text: "超速时长",
                value: "over_time_length"
            },{
                text: "最大超速值",
                value: "max_over_value"
            },{
                text: "限速值",
                value: "limit_value"
            },{
                text: "超速次数",
                value: "over_count"
            },{
                text: "行人碰撞",
                value: "person_collide_speed"
            },{
                text: "车辆碰撞",
                value: "car_collide_speed"
            }
        ],
        valueField: 'value',
        textField: 'text',
        panelHeight:'auto',
        onChange: function (newValue) {
            $('#oneIframe').attr("src", newValue);
        }
    });

    $('#oneIframe').attr("src", $('#type').combobox('getValue'));
});

function doSearch() {
    var type = $('#type').combobox('getValue');
    var text = $('#type').combobox('getText');
    if ('init_km' == type) {
//        self.frames[0].getMap();
//        return;
    } else if(('init_speed' == type || 'init_time' == type) && arrays.length != 1) {
        $.messager.alert("提示", text + "-只能有一个时间段！", "info");
        return;
    }
    if (arrays.length == 0) {
        $.messager.alert("提示", "请先添加时间段！", "info");
        return;
    }
    self.frames[0].doSearch(arrays);
}

function doDownload() {
    if (arrays.length == 0) {
        $.messager.alert("提示", "请先添加时间段！", "info");
        return;
    }
    self.frames[0].doDownload(arrays);
}

var index = 0;
var arrays = [];
function doAddTime() {
    var conditionDiv = $('#conditionDiv');
    var startDateId = 'startDate' + index;
    var endDateId = 'endDate' + index;
    var dateDiv = 'dateDiv' + index;
    var targetObj = $('<div id="' + dateDiv + '" style="float: left;">&nbsp;<b>时间段' + index + ':</b>&nbsp;<input class="easyui-my97" data-options="required:true" id="' + startDateId + '"> - <input class="easyui-my97" data-options="required:true" id="' + endDateId + '"></div>');
    conditionDiv.append(targetObj);
    $.parser.parse(targetObj);
    $('#' + startDateId).my97('options').dateFmt = 'yyyy-MM-dd HH:mm';
    $('#' + startDateId).my97('options').skin = 'whyGreen';
    $('#' + endDateId).my97('options').dateFmt = 'yyyy-MM-dd HH:mm';
    $('#' + endDateId).my97('options').skin = 'whyGreen';
    arrays.push(index);
    index++;
}

function doDelTime() {
    index--;
    var dateDiv = '#dateDiv' + index;
    var conditionDiv = $(dateDiv);
    conditionDiv.remove();
    arrays.pop();
}

function getParams(arrays) {
    var deviceId = $('#deviceId').val();
    var data = {
        deviceId: deviceId
    };
    var dates = [];
    var startDates = [];
    var endDates = [];
    for (var i = 0; i < arrays.length; i++) {
        dates.push('时间段' + arrays[i]);
        startDates.push($('#startDate' + arrays[i]).val());
        endDates.push($('#endDate' + arrays[i]).val());
    }
    data['dates'] = dates.toString();
    data['startDates'] = startDates.toString();
    data['endDates'] = endDates.toString();
    return data;
}
