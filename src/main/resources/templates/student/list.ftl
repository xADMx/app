<#import '../index.ftl' as i>

<@i.page>
  <table border="1">
   <caption>Список студентов</caption>
   <tr>
    <th>ИД</th>
    <th>ФИО студента</th>
    <th>Дата рождения</th>
    <th>Школа</th>
    <th>Действие</th>
   </tr>
   <#list students as student>
       <tr>
           <td>${student.id}</td>
           <td>${student.fio}</td>
           <td>${student.getBirthdayToString()}</td>
           <td>${student.school.nameSchool}</td>
           <td><a href="/student/delete/${student.id}"> Удалить </a></td>
       </tr>
   <#else>
        <tr><td colspan="6"> Нет данных. </td></tr>
   </#list>
  </table>
</@i.page>