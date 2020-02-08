<#import 'index.ftl' as i>

<@i.page>
<div><h1>Произошла ошибка: ${errorMgs!""}</h1></div>
<#list errors as filed, msg>
  <p>${filed}: ${msg}
</#list>
<p><a href="${url}"> Повторить </a></p>
</@i.page>