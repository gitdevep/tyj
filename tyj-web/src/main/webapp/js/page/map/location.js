$(function () {
    $('#msgType').combobox({
        data : [
            {
                text: "实时位置",
                value: "1",
                selected: "selected"
            }
        ],
        valueField: 'value',
        textField: 'text',
        panelHeight:'auto'
    });
});

// 百度地图API功能
var map = new BMap.Map("allmap");
map.centerAndZoom("北京");
map.enableScrollWheelZoom(true);

var markerAll = {};

var data_info = {
    "dataList": []
};

var desc = {
    "deviceId": "设备号:",
    "plateNo": "车牌号:",
    "eventTime": "采集时间:",
    "longitude": "经度:",
    "latitude": "纬度:",
    "speed": "速度:"
};

each(data_info);

var opts = {
    enableMessage: false //设置允许信息窗发送短息
};

/**
 * 遍历
 * @param data 数据
 * @param markers 单个车的所有标注
 */
function each(data, markers) {
    $.each(data, function (i, o) {
        // GPS 坐标
        var gpsPoint = new BMap.Point(o.longitude, o.latitude);
        // GPS坐标转换百度坐标，并回调
        var convertor = new BMap.Convertor();
        var pointArr = [];
        pointArr.push(gpsPoint);
        convertor.translate(pointArr, 1, 5, function (data) {
            if (data.status === 0) {
                var point = data.points[0];
                map.setCenter(point);
                var icon = new BMap.Icon(getUrl(o.icon), new BMap.Size(20, 20));
                icon.setImageSize(new BMap.Size(18, 18));
                // 创建标注
                var marker = new BMap.Marker(point, {icon:icon});
                var opts = {
                    position : point,    // 指定文本标注所在的地理位置
                    offset   : new BMap.Size(30, -30)    //设置文本偏移量
                };
                var label = new BMap.Label(o.deviceInfoName, opts);  // 创建文本标注对象
                label.setStyle({
                    color : "red",
                    fontSize : "12px",
                    height : "20px",
                    lineHeight : "20px",
                    fontFamily:"微软雅黑"
                });
                marker.setLabel(label);
                // 将标注添加到地图中
                map.addOverlay(marker);
                // 生成相应的内容
                var v = "<table>";
                $.each(desc, function (key, value) {
                    v += "<tr><td width='80' style='font-size:12px;font-weight:bold;'>" + value + "</td><td style='font-size:12px;'>" + o[key] + "</td></tr>";
                });
                v += "</table>";
                // 注册点击事件
                addClickHandler("<span style='font-size:12px;font-weight:bold;'>" + o.id + "</span><hr/>", v, marker);
                markers.push(marker);
            }
        });
    });
}

/**
 * 添加点击事件
 * @param title 标题
 * @param content 内容
 * @param marker
 */
function addClickHandler(title, content, marker) {
    marker.addEventListener("click", function (e) {
            openInfo(title, content, e)
        }
    );
}

/**
 * 打开窗口
 * @param title 标题
 * @param content 内容
 * @param e
 */
function openInfo(title, content, e) {
    var p = e.target.getPosition();
    var point = new BMap.Point(p.lng, p.lat);
    opts.title = title;
    var infoWindow = new BMap.InfoWindow(content, opts);  // 创建信息窗口对象
    map.openInfoWindow(infoWindow, point); //开启信息窗口
}

function doSearch() {
    var deviceId = $('#deviceId').val();
    var queryForm = $('#queryForm');
    if (!queryForm.form("validate")) {
        return;
    }
    var data = {
        deviceIds: deviceId
    };
    $.ajax({
        type: "post",
        url: "geographyLocation",
        data: data,
        dataType: "json",
        success: function (result) {
            if (success(result)) {
                map.clearOverlays();
                var markers = [];
                each(result.dataList, markers);
            }
        },
        error: function (errorMsg) {
            error(errorMsg)
        }
    });
}