<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>数据丢失情况处理</title>
</head>
<body>

<#--  数据模型经常会有可选的变量(有时存在、有时不存在)
      FreeMarker 不能容忍引用不存在的变量或者null值
-->

<#-- 1.1、用！判断变量是否为null，为null时将不会进行任何处理   -->
<h4>
    ${key!}
</h4>

<#-- 1.2、用！判断变量是否为null，并且设置一个为null时的默认值   -->
<h4>
    ${key!"this if default value"}
</h4>


<h4>
<#-- 2、用??判断Freemarker中变量是否存在     -->
        <#if key??>
            key值不为null
        <#else>
            key值为null
        </#if>
</h4>


</body>
</html>