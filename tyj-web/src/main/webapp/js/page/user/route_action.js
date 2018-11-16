$(function () {
    $('#list').datagrid({
        loader: listLoader,
        title: '路线列表',
        loadMsg: '数据加载中...',
        fitColumns: true,
        singleSelect: true,
        pagination: true,
        columns: colModel,
        toolbar: '#toolbar'
    });

    $('#aStartLocation').textbox({
        onChange: function (newValue, oldValue) {
//            aLocal.search(newValue);
            aTransit.search($('#aStartLocation').textbox('getText'), $('#aEndLocation').textbox('getText'));
        }
    });

    $('#aEndLocation').textbox({
        onChange: function (newValue, oldValue) {
//            aLocal.search(newValue);
            aTransit.search($('#aStartLocation').textbox('getText'), $('#aEndLocation').textbox('getText'));
        }
    });

    $('#eStartLocation').textbox({
        onChange: function (newValue, oldValue) {
//            eLocal.search(newValue);
            eTransit.search($('#eStartLocation').textbox('getText'), $('#eEndLocation').textbox('getText'));
        }
    });

    $('#eEndLocation').textbox({
        onChange: function (newValue, oldValue) {
//            eLocal.search(newValue);
            eTransit.search($('#eStartLocation').textbox('getText'), $('#eEndLocation').textbox('getText'));
        }
    });
});

function listLoader(param, success, error) {
    var params = {
        routeName: $("#routeName").val(),
        limit: param.rows,
        currentPage: param.page
    };
    page_list('page/list', params, success, error);
}

function doSearch() {
    $('#list').datagrid('reload');
}

function submitForm(f, url, w) {
    if (!f.form("validate")) {
        return;
    }
    f.form('submit', {
        url: url,
        success: function(result) {
            if (successJsonToObject(result)) {
                f.form('clear');
                closeWindow(w);
                $('#list').datagrid('reload');
            }
        }
    });
}

function doAdd() {
    openWindow($('#a'));
    var mk = new BMap.Marker(startPoint);
    aMap.addOverlay(mk);
    aMap.panTo(startPoint);
    $('#aStartLocation').textbox('setText', startAddress);
    $('#aStartLocation').textbox('setValue', startAddress);
    $('#aStartLng').val(startPoint.lng);
    $('#aStartLat').val(startPoint.lat);
}

function doEdit() {
    var row = $('#list').datagrid('getSelected');
    if (row) {
        openWindow($('#e'));
        $('#ef').form('load', row);
        eTransit.search(new BMap.Point(row.startLng, row.startLat), new BMap.Point(row.endLng, row.endLat));
    } else {
        $.messager.alert('温馨提示', '请选择路线信息!');
    }
}

var startAddress;
var startPoint;

// 初始化定位信息
var geolocation = new BMap.Geolocation();
var gc = new BMap.Geocoder();
geolocation.getCurrentPosition(function (r) {
    if (geolocation.getStatus() == BMAP_STATUS_SUCCESS) {
        startPoint = r.point;
        gc.getLocation(r.point, function (rs) {
            startAddress = rs.address;
        });
    } else {
        alert('failed' + geolocation.getStatus());
    }
}, {
    enableHighAccuracy: true
});

var aMap = new BMap.Map("aallmap");
aMap.centerAndZoom(new BMap.Point(116.404, 39.915), 12);
aMap.enableScrollWheelZoom(true);

//var aLocal = new BMap.LocalSearch(aMap, {
//    renderOptions: {
//        map: aMap,
//        panel: "ar-result"
//    },
//    pageCapacity: 3
//});

var aTransit = new BMap.DrivingRoute(aMap, {
    renderOptions: {
        map: aMap,
        autoViewport: true,
        enableDragging : true // 可进行拖拽
    },
    onSearchComplete: function (results) {
        if (aTransit.getStatus() != BMAP_STATUS_SUCCESS) {
            return ;
        }
        var plan = results.getPlan(0);
        var distance = plan.getDistance(false) / 1000;
        $('#akm').textbox('setValue', distance);
        var start = results.getStart();
        $('#aStartLng').val(start.point.lng);
        $('#aStartLat').val(start.point.lat);
        var end = results.getEnd();
        $('#aEndLng').val(end.point.lng);
        $('#aEndLat').val(end.point.lat);
    }
});

var eMap = new BMap.Map("eallmap");
eMap.centerAndZoom(new BMap.Point(116.404, 39.915), 12);
eMap.enableScrollWheelZoom(true);

var eTransit = new BMap.DrivingRoute(eMap, {
    renderOptions: {
        map: eMap,
        autoViewport: true,
        enableDragging : true // 可进行拖拽
    },
    onSearchComplete: function (results) {
        if (eTransit.getStatus() != BMAP_STATUS_SUCCESS) {
            return ;
        }
        var plan = results.getPlan(0);
        var distance = plan.getDistance(false) / 1000;
        $('#ekm').textbox('setValue', distance);
        var start = results.getStart();
        $('#eStartLng').val(start.point.lng);
        $('#eStartLat').val(start.point.lat);
        var end = results.getEnd();
        $('#eEndLng').val(end.point.lng);
        $('#eEndLat').val(end.point.lat);
    }
});

//var eLocal = new BMap.LocalSearch(eMap, {
//    renderOptions: {
//        map: eMap,
//        panel: "er-result"
//    },
//    pageCapacity: 3
//});