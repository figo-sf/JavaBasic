My name is ${name}, i want to say ${message}
<#assign user={"name":"hailang", "sex":"man"}>
<#assign keys=user?keys>
<#list keys as key>
${key}:${user[key]?capitalize}
</#list>
<#assign nums=[1,2,3,4,5,77,8,99]/>
${nums?size},${nums?first },${nums?last}
<#list nums?reverse  as x>
${x}
</#list>
<#list nums?sort  as x>
${x}
</#list>
<#list ["一","二","三"] + ["四","五","六"] as x>
${x}
</#list>
${"strstrstrstr"?substring(5)}
${"strstrstrstr"?substring(5,9)}
${"strstrstrstr"?cap_first}
${"string"?ends_with("ing")?string}
<#assign date1="2009-10-12"?date("yyyy-MM-dd")>
<#assign date2="9:28:20"?time("HH:mm:ss")>
<#assign date3="2009-10-12 9:28:20"?time("yyyy-MM-dd HH:mm:ss")>
${date1}
${date2}
${date3}
${date3?string('yyyy/MM/dd HH-mm-ss-S')}
4.操作数字
${123?c}
<#assign tempNum=20>

${tempNum}

${tempNum?string.number}或${tempNum?string("number")}

${tempNum?string.currency}或${tempNum?string("currency")}

${tempNum?string. percent}或${tempNum?string("percent")}

5.操作布尔值
${true?string("yes","no")}

<#assign x = 6>
<#if x gt 5 >
x > 5
</#if>

<#assign x = 4>
<#if (x<5) >
x < 5
</#if>


