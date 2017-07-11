//带变量查询
$('#dg').datagrid({
    url:"<c:url value='/nnmis/wxunn/getAllFLBL.tg'/>",
    queryParams: {
        "flblQo['orgNum']": root.id,
        "flblQo['stationId']": $("#linestacombotree2").combotree("getValue"),
        "flblQo['circuitType']": $("#circuitType").combotree("getValue"),
        //"flblQo['orgNum']": root.id,
        "flblQo['status']": $(".status").combobox("getValue"),
        "flblQo['exchangeStatus']": $(":radio[name='flblQo.exchangeStatus']:checked").val(),
        "flblQo['sectionName']": $("#sectionName").textbox("getValue")
    },
    rowStyler: function (index, row) {
        if (row.exchangeStatus == 0 && (isduan() || isjsk())) {
            return 'display:none';
        }
    }
});
//单选框选中
$(":radio[name='flbl.testType'][value='1']").prop("checked", "checked");


//js属性名中带'.'号的怎么读取
for (items in data) {
    if (items = 'flbl.circuitType') {

    }
}

// easyui save 例子
function saveItem() {

    $.messager.progress({
        title: '正在处理',
        text: '正在处理.......'
    });
    $('#myform').form('submit', {
        url: '<c:url value="/nnmis/wxunn/saveFLBL.tg"/>',
        onSubmit: function () {
            var isValid = $('#myform').form('validate');
            if (!isValid) {
                $.messager.progress('close');
            }
            return isValid;
        },
        success: function (data) {
            $.messager.progress('close');
            data = eval('(' + data + ')');
            if (data.success) {
                $('#dg').datagrid('reload');
                $.messager.show({
                    title: '提示',
                    msg: '操作成功！',
                    showType: 'slide'
                });
                //$('#dlg').dialog('close');
            } else {
                var messsage = '操作失败！';
                if (data.message != null) {
                    message = data.message;
                }
                $.messager.alert('提示', message, 'error');
            }
            if (data.error) {
                var messsage = '操作失败！';
                if (data.message != null) {
                    message = data.message;
                }
                $.messager.alert('提示', message, 'error');
            }
        }
    });
}

// easyui deletery 例子
function deletery() {
    var row = $('#dg').datagrid('getSelections');
    if (row == null || row.length == 0) {
        $.messager.alert('提示', '请选择要删除的记录！', 'error');
        return;
    }
    var ids = "";
    for (var i = 0; i < row.length; i++) {
        ids = ids + "'" + row[i].id + "',";

    }
    ids = ids.substr(0, ids.length - 1);
    $.messager.confirm('警告', '您确认要删除吗？', function (bt) {
        if (bt) {
            $.messager.progress({
                title: '正在处理',
                text: '正在处理.......'
            });
            $.ajax({
                url: '<c:url value="/nnmis/wxunn/deleteryFLBL.tg?ids=' + ids+'" />',
                datatype: 'json',
                success: function (data) {
                    $.messager.progress('close');
                    data = eval('(' + data + ')');
                    if (data.success) {
                        var message = '操作成功！';
                        if (data.message) {
                            message = data.message;
                        }
                        $.messager.show({
                            title: '提示',
                            msg: message,
                            showType: 'slide'
                        });
                        $('#dg').datagrid('reload');
                    } else {
                        var message = '操作失败！';
                        if (data.message) {
                            message = data.message;
                        }
                        $.messager.alert('提示', message, 'error');

                    }
                }
            });
        }
    });
}
//confirm 是否确认例子
$.messager.confirm('警告', '您确认' + message + '吗？', function (bt) {
    if (bt) {
        $.messager.progress({
            title: '正在处理',
            text: '正在处理.......'
        });
        $.ajax({
            url: '<c:url value="/nnmis/wxunn/updateStatusFLBL.tg"/>?id=' + id + '&value=' + value,
            datatype: 'json',
            success: function (data) {
                data = eval('(' + data
                    + ')');
                if (data.success) {
                    var message = '操作成功！';
                    if (data.message) {
                        message = data.message;
                    }
                    $.messager.show({
                        title: '提示',
                        msg: message,
                        showType: 'slide'
                    });
                    $('#dg').datagrid(
                        'reload');
                } else {
                    var message = '操作失败！';
                    if (data.message) {
                        message = data.message;
                    }
                    $.messager.alert('提示',
                        message,
                        'error');
                }
            }
        });
    }
});
