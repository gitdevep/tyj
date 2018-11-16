$(function () {
    $('#list').datagrid({
        loader: listLoader,
        title: '用户列表',
        loadMsg: '数据加载中...',
        fitColumns: true,
        pagination: true,
        columns: colModel,
        toolbar: '#toolbar'
    });
    $.getJSON('../kv/hint?module=10', function(json) {
        var data = [{
            text: "全部",
            value: 0
        }];
        $.each(json.dataList, function() {
            data.push(this);
        });
        $('#status').combobox({
            data : data,
            valueField: 'value',
            textField: 'text',
            panelHeight:'auto'
        });
    });
});

function listLoader(param, success, error) {
    var params = {
        name: $("#name").val(),
        status: $('#status').combobox('getValue'),
        limit: param.rows,
        currentPage: param.page
    };
    page_list('../user/page/list', params, success, error);
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
}

function doEdit() {
    var row = $('#list').datagrid('getSelected');
    if (row) {
        openWindow($('#e'));
        $('#ef').form('load', {
            id: row.id,
            name: row.name,
            authId: row.authId,
            password: row.password
        });
        $.getJSON('../kv/hint?module=10&defaultValue=' + row.status, function(json) {
            $('#estatus').combobox({
                data : json.dataList,
                valueField: 'value',
                textField: 'text',
                panelHeight:'auto'
            });
        });
    } else {
        $.messager.alert('温馨提示', '请选择用户信息!');
    }
}

function doRemove() {
    var row = $('#list').datagrid('getChecked');
    if (row && row.length != 0) {
        var ids = [];
        $.each(row, function() {
            ids.push(this.id);
        });
        var data = {
            ids: ids.toString()
        };
        $.ajax({
            type: "post",
            url: "../user/remove_user",
            data: data,
            dataType: "json",
            success: function (result) {
                if (success(result)) {
                    doSearch();
                }
            },
            error: function (errorMsg) {
                error(errorMsg)
            }
        });
    } else {
        $.messager.alert('温馨提示', '请选择用户信息!');
    }
}

function doASearchCars() {
    openWindow($('#ad'));
    $('#ad_no_choice_list').datagrid({
        loader: noAChoiceListCarsLoader,
        title: '未选择车辆列表',
        loadMsg: '数据加载中...',
        fitColumns: true,
        pagination: true,
        columns: deviceColModel
    });
}

function noAChoiceListCarsLoader(param, success, error) {
    var params = {
        limit: param.rows,
        currentPage: param.page
    };
    page_list('../user/page/list_cars', params, success, error);
}

function aSubmitCars() {
    var rows = $('#ad_no_choice_list').datagrid('getChecked');
    if (!rows || rows.length == 0) {
        $.messager.alert('温馨提示', '请选择需要添加车辆信息!');
        return;
    }
    var members = [];
    for (var i = 0; i < rows.length; i++) {
        members.push(rows[i].id);
    }
    $('#acar').searchbox('setValue', members);
    closeWindow($('#ad'));
}

function doESearchCarsMember() {
    openWindow($('#ed'));
    $('#ed_choice_list').datagrid({
        loader: eChoiceListLoader,
        title: '已选择车辆列表',
        loadMsg: '数据加载中...',
        fitColumns: true,
        pagination: true,
        columns: deviceColModel
    });
    $('#ed_no_choice_list').datagrid({
        loader: noEChoiceListLoader,
        title: '未选择车辆列表',
        loadMsg: '数据加载中...',
        fitColumns: true,
        pagination: true,
        columns: deviceColModel
    });
}

function eChoiceListLoader(param, success, error) {
    var params = {
        userId: $('#eUserId').val(),
        no: 1,
        limit: param.rows,
        currentPage: param.page
    };
    page_list('../user/page/list_cars', params, success, error);
}

function noEChoiceListLoader(param, success, error) {
    var params = {
        userId: $('#eUserId').val(),
        limit: param.rows,
        currentPage: param.page
    };
    page_list('../user/page/list_cars', params, success, error);
}

function eSubmitCars() {
    var rows = $('#ed_no_choice_list').datagrid('getChecked');
    if (!rows || rows.length == 0) {
        $.messager.alert('温馨提示', '请选择需要添加车辆信息!');
        return;
    }
    var members = [];
    for (var i = 0; i < rows.length; i++) {
        members.push(rows[i].id);
    }
    $('#ecars').searchbox('setValue', members);
    closeWindow($('#ed'));
}

function eRemoveCars() {
    var rows = $('#ed_choice_list').datagrid('getChecked');
    if (!rows || rows.length == 0) {
        $.messager.alert('温馨提示', '请选择需要移除车辆信息!');
        return;
    }
    var members = [];
    for (var i = 0; i < rows.length; i++) {
        members.push(rows[i].id);
    }
    var data = {
        id: $('#eUserId').val(),
        members: members.toString()
    };
    $.ajax({
        url: '../user/remove_cars',
        dataType: 'json',
        data: data,
        success: function(json) {
            $('#ed_choice_list').datagrid('reload');
            $('#ed_no_choice_list').datagrid('reload');
            $('#list').datagrid('reload');
        },
        error: function() {
            error.apply(this, arguments);
        }
    });
}

function doASearchTeams() {
    openWindow($('#adt'));
    $('#ad_no_choice_team_list').datagrid({
        loader: noAChoiceListTeamsLoader,
        title: '未选择团队列表',
        loadMsg: '数据加载中...',
        fitColumns: true,
        pagination: true,
        columns: userTeamColModel
    });
}

function aSubmitTeams() {
    var rows = $('#ad_no_choice_team_list').datagrid('getChecked');
    if (!rows || rows.length == 0) {
        $.messager.alert('温馨提示', '请选择需要添加团队信息!');
        return;
    }
    var members = [];
    for (var i = 0; i < rows.length; i++) {
        members.push(rows[i].id);
    }
    $('#ateam').searchbox('setValue', members);
    closeWindow($('#adt'));
}

function noAChoiceListTeamsLoader(param, success, error) {
    var params = {
        limit: param.rows,
        currentPage: param.page
    };
    page_list('../user/page/list_teams', params, success, error);
}

function doESearchTeamsMember() {
    openWindow($('#edt'));
    $('#ed_choice_team_list').datagrid({
        loader: eChoiceTeamListLoader,
        title: '已选择团队列表',
        loadMsg: '数据加载中...',
        fitColumns: true,
        pagination: true,
        columns: userTeamColModel
    });
    $('#ed_no_choice_team_list').datagrid({
        loader: noEChoiceTeamListLoader,
        title: '未选择团队列表',
        loadMsg: '数据加载中...',
        fitColumns: true,
        pagination: true,
        columns: userTeamColModel
    });
}

function eChoiceTeamListLoader(param, success, error) {
    var params = {
        userId: $('#eUserId').val(),
        no: 1,
        limit: param.rows,
        currentPage: param.page
    };
    page_list('../user/page/list_teams', params, success, error);
}

function noEChoiceTeamListLoader(param, success, error) {
    var params = {
        userId: $('#eUserId').val(),
        limit: param.rows,
        currentPage: param.page
    };
    page_list('../user/page/list_teams', params, success, error);
}

function eSubmitTeams() {
    var rows = $('#ed_no_choice_team_list').datagrid('getChecked');
    if (!rows || rows.length == 0) {
        $.messager.alert('温馨提示', '请选择需要添加团队信息!');
        return;
    }
    var members = [];
    for (var i = 0; i < rows.length; i++) {
        members.push(rows[i].id);
    }
    $('#eteams').searchbox('setValue', members);
    closeWindow($('#edt'));
}

function eRemoveTeams() {
    var rows = $('#ed_choice_team_list').datagrid('getChecked');
    if (!rows || rows.length == 0) {
        $.messager.alert('温馨提示', '请选择需要移除团队信息!');
        return;
    }
    var members = [];
    for (var i = 0; i < rows.length; i++) {
        members.push(rows[i].id);
    }
    var data = {
        id: $('#eUserId').val(),
        members: members.toString()
    };
    $.ajax({
        url: '../user/remove_teams',
        dataType: 'json',
        data: data,
        success: function(json) {
            $('#ed_choice_team_list').datagrid('reload');
            $('#ed_no_choice_team_list').datagrid('reload');
            $('#list').datagrid('reload');
        },
        error: function() {
            error.apply(this, arguments);
        }
    });
}