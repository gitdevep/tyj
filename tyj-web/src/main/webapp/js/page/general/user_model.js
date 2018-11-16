var colModel = [[
    {
        field: 'ck',
        checkbox: true,
        singleSelect: true
    },
    {
        field: 'id',
        title: '编号',
        width: '10%'
    },
    {
        field: 'name',
        title: '用户名',
        width: '20%'
    },
    {
        field: 'createTime',
        title: '创建时间',
        width: '40%'
    },
    {
        field: 'status',
        title: '状态',
        width: '5%',
        formatter: function (value, row, index) {
            if (value == '1') {
                return '可用';
            } else if (value == '2') {
                return '禁用';
            } else {
                return value;
            }
        }
    }
]];