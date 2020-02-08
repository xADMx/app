<#import '../index.ftl' as i>

<@i.page>
 <form method="POST">
  ФИО:<br><input type="text" name="fio"><br>
  Дата рождения:<br><input type="date" name="birthday"><br>
  Выберите школу:<br>
  <select name="school">
       <#list schools as school>
            <option value="${school.id}">${school.nameSchool}</option>
       </#list>
  </select><br>
  <p><input type="submit"></p>
 </form>
</@i.page>