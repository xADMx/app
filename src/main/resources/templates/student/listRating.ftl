<#import '../index.ftl' as i>

<@i.page>
  <table border="1">
   <caption>Рейтинг студентов дата формирования: ${rating.getLocalDateTimeToString()}</caption>
   <tr>
    <th>ИД</th>
    <th>ФИО студента</th>
    <th>Дата рождения</th>
    <th>Школа</th>
    <th>Рейтинг</th>
    <th>Действие</th>
   </tr>
   <#list rating.students as student>
       <tr>
           <td>${student.id}</td>
           <td>${student.fio}</td>
           <td>${student.getBirthdayToString()}</td>
           <td>${student.school.nameSchool}</td>
           <td>${student.ratingAlo}</td>
           <td><a href="/student/delete/${student.id}"> Удалить </a></td>
       </tr>
   <#else>
        <tr><td colspan="6"> Нет данных. </td></tr>
   </#list>
  </table>
</@i.page>