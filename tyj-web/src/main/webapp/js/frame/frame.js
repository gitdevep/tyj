$(function () {
    var json = JSON.parse($('#message').val());
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
    }
});

function cf(u) {
    return '<iframe scrolling="auto" frameborder="0"  src="../' + u + '" style="width:100%;height:100%;"></iframe>';
}