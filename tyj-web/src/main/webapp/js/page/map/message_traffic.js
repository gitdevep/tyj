var map = new BMap.Map("allmap");
map.centerAndZoom("北京");
map.enableScrollWheelZoom(true);
var ctrl = new BMapLib.TrafficControl();
map.addControl(ctrl);

function doSearch() {
    var city = parent.$('#city').val();
    map.centerAndZoom(city);
    map.enableScrollWheelZoom(true);
    ctrl = new BMapLib.TrafficControl();
    map.addControl(ctrl);
}