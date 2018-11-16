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
});

function listLoader(param, success, error) {
    var params = {
        type: $('#type').combobox('getValue'),
        deviceId: $("#deviceId").val(),
        oil: $("#oil").val(),
        startDate: $("#startDate").val(),
        endDate: $("#endDate").val(),
        limit: param.rows,
        currentPage: param.page
    };
    page_list('../general/page/list', params, success, error);
}

function doSearch() {
    var type = $('#type').combobox('getValue');
    if (type == 2 && !$('#queryForm').form("validate")) {
        return;
    }
    $('#list').datagrid('reload');
}
