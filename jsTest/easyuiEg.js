/**
 * Created by 50245 on 2017/10/20.
 */
/*禁用datetimebox*/
$('#xfsj').datetimebox({disabled: true,required: false, value:null});
/*启用datetimebox*/
$('#xfsj').datetimebox({disabled: false});

/****
 * 下拉树的写法
 */
$('#alarmContentCombotree').combotree({
    disabled: false,
    editable: true,
    multiple: true,
    onlyLeafCheck: true,
    url: "<c:url value='/dttj/findArmContentComALARMALL.tg?alarmQo.csmType'/>",
    valueField: 'id',
    textField: 'text',
    lines: true,
    onLoadSuccess: function () {
        $("#alarmContentCombotree").combotree('tree').tree("collapseAll");
    }
});

//阻止深度序列化参数对象
$.ajaxSettings.traditional = true;