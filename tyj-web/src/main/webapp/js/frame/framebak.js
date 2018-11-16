$(function () {
    var formLogin = $("#formLogin");
    formLogin.dialog({
        modal: true,
        closable: false,
        buttons: [{
            text: "登录",
            handler: function () {
                if (!formLogin.form("validate")) {
                    return;
                }
                var username = $("#username").val().trim();
                var password = $("#password").val().trim();
                $.getJSON('user/login', {username: username, password: password}, function(json) {
                    if (success(json)) {
                        $('#tt').tree({
                            data: json.dataList,
                            onClick: function(node){
                                if (!isNullOrEmpty(node.url)) {
                                    if ($('#tabs').tabs('exists', node.text)) {
                                        $('#tabs').tabs('select', node.text);
                                    } else {
                                        $('#tabs').tabs('add', {
                                            title: node.text,
                                            content: cf(node.url),
                                            closable: true
                                        });
                                    }
                                }
                            }
                        });
                        $.messager.alert("提示", "登录成功", "info");
                        formLogin.dialog("close");
                        $("#userNameShow").text(username);
                    }
                });
            }
        }]
    });

    $("#loginOut").click(function () {
        $.messager.confirm("系统提示", "您确定要退出本次登录吗?", function (r) {
            if (r) {
                delCookie("userName");
                delCookie("id");
                window.location.reload();
            }
        });
    });
});

function cf(u) {
    return '<iframe scrolling="auto" frameborder="0"  src="' + u + '" style="width:100%;height:100%;"></iframe>';
}