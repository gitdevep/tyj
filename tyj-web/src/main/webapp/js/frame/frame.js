var menus = {
    "children": [
        {"id": "0", "icon": "icon-sys", "text": "帐户管理",
            "children": [
                {"id": "00", "text": "账户列表", "icon": "icon-nav", "url": "user/user_init"}
            ]
        },
        {"id": "1", "icon": "icon-sys", "text": "用户数据",
            "children": [
                {"id": "00", "text": "车辆列表", "icon": "icon-nav", "url": "deviceInfo/device_info"},
                {"id": "00", "text": "团队列表", "icon": "icon-nav", "url": "team/team_init"},
                {"id": "00", "text": "路线列表", "icon": "icon-nav", "url": "route/route_init"}
            ]
        },
        {"id": "2", "icon": "icon-sys", "text": "数据统计",
            "children": [
                {"id": "00", "text": "每天预警", "icon": "icon-nav", "url": "alarm/day_alarm"},
                {"id": "00", "text": "时段预警", "icon": "icon-nav", "url": "alarm/alarm_interval"},
                {"id": "00", "text": "每日车速", "icon": "icon-nav", "url": "daySpeed/day_speed"},
                {"id": "00", "text": "驾车时长", "icon": "icon-nav", "url": "driverTime/drive_time"},
                {"id": "00", "text": "用户评分", "icon": "icon-nav", "url": "userScore/user_score"}
            ]
        },
        {"id": "4", "icon": "icon-sys", "text": "单车统计",
            "children": [
//                {"id": "00", "text": "小时预警", "icon": "icon-nav", "url": "alarm/init_hour"},
//                {"id": "00", "text": "公里预警", "icon": "icon-nav", "url": "alarm/init_km"},
//                {"id": "00", "text": "速度预警", "icon": "icon-nav", "url": "alarm/init_speed"},
//                {"id": "00", "text": "时间预警", "icon": "icon-nav", "url": "alarm/init_time"},
//                {"id": "00", "text": "油耗预警", "icon": "icon-nav", "url": "alarm/init_oil"},
                {"id": "00", "text": "超速分析", "icon": "icon-nav", "url": "alarm/init_over_speed"},
//                {"id": "00", "text": "碰撞分析", "icon": "icon-nav", "url": "alarm/init_total_alarm"},
                {"id": "00", "text": "限速预警", "icon": "icon-nav", "url": "alarm/init_limit_speed"},
                {"id": "00", "text": "月告警总量", "icon": "icon-nav", "url": "alarm/init_total_alarm"},
                {"id": "00", "text": "平均告警统计", "icon": "icon-nav", "url": "one/one_alarm"}
            ]
        },
        {"id": "5", "icon": "icon-sys", "text": "对比统计",
            "children": [
//                {"id": "00", "text": "路段预警", "icon": "icon-nav", "url": "alarm/init_limit_speed"},
//                {"id": "00", "text": "团队预警", "icon": "icon-nav", "url": "alarm/init_team"},
                {"id": "00", "text": "团队告警对比", "icon": "icon-nav", "url": "more/more_alarm"}
            ]
        },
        {"id": "6", "icon": "icon-sys", "text": "地图标记",
            "children": [
                {"id": "00", "text": "路况查询", "icon": "icon-nav", "url": "map/message_traffic"},
                {"id": "00", "text": "报警位置统计", "icon": "icon-nav", "url": "map/message_window"}
            ]
        }
    ]
};
$(function () {
    ilm();
    var formLogin = $("#formLogin");
    var username = getCookie("userName");
    if (username == null) {
        formLogin.dialog({
            modal: true,
            closable: false,
            buttons: [{
                text: "登录",
                handler: function () {
                    if (!formLogin.form("validate")) {
                        return;
                    }
                    username = $("#username").val().trim();
                    var password = $("#password").val().trim();
                    $.post("user/login", {username: username, password: password},
                        function (data) {
                            if (data.message == null || data.message == "null") {
                                setCookie("userName", username);
                                $.messager.alert("提示", "登录成功", "info");
                                formLogin.dialog("close");
                                $("#userNameShow").text(username);
                            } else {
                                $.messager.alert("提示", "账户或密码错误！", "info");
                            }
                        });
                }}]
        });
    } else {
        $("#userNameShow").text(username);
    }
    ilo();
});

function ilo() {
    $("#loginOut").click(function () {
        $.messager.confirm("系统提示", "您确定要退出本次登录吗?", function (r) {
            if (r) {
                delCookie("userName");
                delCookie("username");
                window.location.reload();
            }
        });
    });
}

function ilm() {
    $("#nav").empty();
    var ml = "";
    $.each(menus.children, function (i, n) {
        ml += "<div title='" + n.text + "' icon='" + n.icon + "' style='overflow:auto;'><ul>";
        $.each(n.children, function (j, o) {
            ml += "<li><div><a ref='" + o.id + "' href='#' rel='" + o.url
                + "' ><span class='icon " + o.icon + "' >&nbsp;</span><span class='nav'>" + o.text
                + "</span></a></div></li> ";
        });
        ml += "</ul></div>";
    });
    $("#nav").append(ml);
    $("#nav").accordion();
    $("#nav li a").click(function () {
        var t = $(this).children(".nav").text();
        var u = $(this).attr("rel");
        var id = $(this).attr("ref");
        var i = gi(id);
        ad(t, u, i);
        $("#nav li div").removeClass("selected");
        $(this).parent().addClass("selected");
    }).hover(function () {
        $(this).parent().addClass("hover");
    }, function () {
        $(this).parent().removeClass("hover");
    });
}

function gi(id) {
    var i = 'icon ';
    $.each(menus.children, function (i, n) {
        $.each(n.children, function (j, o) {
            if (o.id == id) {
                i += o.icon;
            }
        });
    });
    return i;
}

function ad(s, u, i) {
    if ($('#tabs').tabs('exists', s)) {
        $('#tabs').tabs('select', s);
    } else {
        $('#tabs').tabs('add', {
            title: s,
            content: cf(u),
            closable: true,
            icon: i
        });
    }
    tc();
}

function cf(u) {
    return '<iframe scrolling="auto" frameborder="0"  src="' + u + '" style="width:100%;height:100%;"></iframe>';
}

function tc() {
    $(".tabs-inner").dblclick(function () {
        var t = $(this).children(".tabs-closable").text();
        $('#tabs').tabs('close', t);
    });
    $(".tabs-inner").bind('contextmenu', function (e) {
        $('#mm').menu('show', {
            left: e.pageX,
            top: e.pageY
        });
        var t = $(this).children(".tabs-closable").text();
        $('#mm').data("currtab", t);
        $('#tabs').tabs('select', t);
        return false;
    });
}