$(function () {
    $('#list').datagrid({
        loader: listLoader,
        title: '团队列表',
        loadMsg: '数据加载中...',
        fitColumns: true,
        singleSelect: true,
        pagination: true,
        columns: colModel,
        toolbar: '#toolbar'
    });
});

function listLoader(param, success, error) {
    var params = {
        teamName: $("#teamName").val(),
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
    $('#f').form('clear');
    openWindow($('#a'));
}

function doASearchTeamMember(value) {
    openWindow($('#ad'));
    $('#ad_no_choice_list').datagrid({
        loader: noAChoiceListLoader,
        title: '未选择成员列表',
        loadMsg: '数据加载中...',
        fitColumns: true,
        pagination: true,
        columns: deviceColModel
    });
}

function noAChoiceListLoader(param, success, error) {
    var params = {
        limit: param.rows,
        currentPage: param.page
    };
    page_list('../deviceInfo/page/list_team_member', params, success, error);
}

function doESearchTeamMember(value) {
    openWindow($('#ed'));
    $('#ed_choice_list').datagrid({
        loader: eChoiceListLoader,
        title: '已选择成员列表',
        loadMsg: '数据加载中...',
        fitColumns: true,
        pagination: true,
        columns: deviceColModel
    });
    $('#ed_no_choice_list').datagrid({
        loader: noEChoiceListLoader,
        title: '未选择成员列表',
        loadMsg: '数据加载中...',
        fitColumns: true,
        pagination: true,
        columns: deviceColModel
    });
}

function eChoiceListLoader(param, success, error) {
    var params = {
        teamId: $('#eTeamId').val(),
        no: 1,
        limit: param.rows,
        currentPage: param.page
    };
    page_list('../deviceInfo/page/list_team_member', params, success, error);
}

function noEChoiceListLoader(param, success, error) {
    var params = {
        teamId: $('#eTeamId').val(),
        limit: param.rows,
        currentPage: param.page
    };
    page_list('../deviceInfo/page/list_team_member', params, success, error);
}

function doEdit() {
    var row = $('#list').datagrid('getSelected');
    if (row) {
        openWindow($('#e'));
        $('#ef').form('load', {
            id: row.id,
            teamName: row.teamName
        });
    } else {
        $.messager.alert('温馨提示', '请选择团队信息!');
    }
}

function aSubmitMembers() {
    var rows = $('#ad_no_choice_list').datagrid('getChecked');
    if (!rows || rows.length == 0) {
        $.messager.alert('温馨提示', '请选择需要添加成员信息!');
        return;
    }
    var members = [];
    for (var i = 0; i < rows.length; i++) {
        members.push(rows[i].id);
    }
    $('#aMembers').searchbox('setValue', members);
    closeWindow($('#ad'));
}

function eSubmitMembers() {
    var rows = $('#ed_no_choice_list').datagrid('getChecked');
    if (!rows || rows.length == 0) {
        $.messager.alert('温馨提示', '请选择需要添加成员信息!');
        return;
    }
    var members = [];
    for (var i = 0; i < rows.length; i++) {
        members.push(rows[i].id);
    }
    $('#eMembers').searchbox('setValue', members);
    closeWindow($('#ed'));
}

function eRemoveMembers() {
    var rows = $('#ed_choice_list').datagrid('getChecked');
    if (!rows || rows.length == 0) {
        $.messager.alert('温馨提示', '请选择需要移除成员信息!');
        return;
    }
    var members = [];
    for (var i = 0; i < rows.length; i++) {
        members.push(rows[i].id);
    }
    var data = {
        id: $('#eTeamId').val(),
        members: members.toString()
    };
    $.ajax({
        url: 'remove_member',
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