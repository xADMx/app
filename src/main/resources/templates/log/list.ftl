<#import '../index.ftl' as i>

<@i.page>
  <table border="1">
   <caption>Лог</caption>
   <tr>
    <th>ИД</th>
    <th>Название метрики</th>
    <th>Значение (сек.)</th>
    <th>Параметры</th>
    <th>Дата</th>
   </tr>
   <#list logs as log>
       <tr>
       <td>${log.id}</td>
       <td>${log.name}</td>
        <td>${log.value}</td>
       <td>${log.parametrs}</td>
       <td>${log.getEvent_timestampToString()}</td>
       </tr>
   <#else>
        <tr><td colspan="3"> Нет данных. </td></tr>
   </#list>
  </table>
</@i.page>