//树 初始加载,点击某节点
$("#nav").tree({
    data: temp,
    onClick: function (node) {
        if (node.attributes.url != '' && node.attributes.url != 'undefined') {
            if (node.attributes.target != '_blank') {

                window.addTabsFrame(node.text, node.attributes.url, "icon${icon}");

            } else {
                window.top.open(node.attributes.url, "_blank");
            }
        }

    },
    onLoadSuccess: function (node, data) {
        var nodeid;
        if (data.length != 0) {
            $(".tree-title").each(function (i, obj) {

                if ($(obj).html() == openmenu) {
                    nodeid = $(obj).parent(".tree-node").attr("node-id")
                }
            });
            if (nodeid != '') {
                var node = $('#nav').tree('find', nodeid);
                //$('#nav').tree('select');
                var node1 = $('#nav').tree('getParent', node.target);
                $('#nav').tree('expand', node1.target);
                node.target.click();
            }
        }
    }
});