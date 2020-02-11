<#import '../index.ftl' as i>

<@i.page>
  <table border="1">
   <caption>Список школ</caption>
   <tr>
    <th>ИД</th>
    <th>Название школы</th>
    <th>Действие</th>
   </tr>
   <#list schools as school>
       <tr>
       <td>${school.id}</td>
       <td>${school.nameSchool}</td>
       <td><a href="/school/delete/${school.id}"> Удалить </a></td>
       </tr>
   <#else>
        <tr><td colspan="3"> Нет данных. </td></tr>
   </#list>
  </table>
</@i.page>