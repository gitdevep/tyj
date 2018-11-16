$(function () {
    $('#type').combobox({
        data : [
            {
                text: "超速时长",
                value: "over_time_length",
                selected: "selected"
            },{
                text: "最大超速值",
                value: "max_over_value"
            },{
                text: "限速值",
                value: "limit_value"
            },{
                text: "超速次数",
                value: "over_count"
            }
        ],
        valueField: 'value',
        textField: 'text',
        panelHeight:'auto',
        onChange: function (newValue) {
            $('#oneIframe').attr("src", newValue);
        }
    });

    $('#oneIframe').attr("src", $('#type').combobox('getValue'));
});

function doSearch() {
    self.frames[0].doSearch();
}

function doDownload() {
    self.frames[0].doDownload();
}