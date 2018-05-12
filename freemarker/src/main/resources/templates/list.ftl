<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>list 标签</title>
</head>
<body>

<ul>
       <#list citys as city>
           <li>
                ${city_index}    ${city}
           </li>
       </#list>
</ul>

    <#include "footer.ftl">

</body>
</html>