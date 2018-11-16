var colModel = [[
    {
        field: 'ck',
        checkbox: true
    },
    {
        field: 'id',
        title: '用户编号',
        width: 50,
        hidden: true
    },
    {
        field: 'name',
        title: '姓名',
        width: 100
    },
    {
        field: 'age',
        title: '年龄',
        width: 50
    },
    {
        field: 'drivingLicense',
        title: '驾照类型',
        width: 50,
        formatter: function (value, row, index) {
            if (value == '1') {
                return 'A照';
            } else if (value == '2') {
                return 'B照';
            } else if (value == '3') {
                return 'C照';
            } else {
                return value;
            }
        }
    },
    {
        field: 'carType',
        title: '车型',
        width: 80,
        formatter: function (value, row, index) {
            if (value == '1') {
                return '私家车';
            } else if (value == '2') {
                return '集团车';
            } else {
                return value;
            }
        }
    },
    {
        field: 'plateNo',
        title: '车牌号',
        width: 100
    },
    {
        field: 'weixinAccount',
        title: '微信账号',
        width: 100
    },
    {
        field: 'deviceId',
        title: '设备编号',
        width: 100
    },
    {
        field: 'createTime',
        title: '录入时间',
        width: 100
    },
    {
        field: 'distance',
        title: '停运时间（h）',
        width: 150,
        formatter: function (value, row, index) {
            if (isNullOrEmpty(value)) {
                return value;
            }
            return '<span style="color:red">' + value + '</span>';
        }
    }
]];